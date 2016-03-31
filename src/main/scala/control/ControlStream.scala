package control

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import java.net.URL
import java.net.MalformedURLException
import scala.util.control.Breaks._
import java.io._

class ControlStream {
  def testIf(args: Array[String]): Unit = {
    var filename = "default.txt"
    if (!args.isEmpty)
      filename = args(0)
    filename =
      if (!args.isEmpty) args(0)
      else "default.txt"
  }
  def testWhile(): Unit = {
    def gcdLoop(x: Long, y: Long): Long = {
      var a = x
      var b = y
      while (a != 0) {
        var temp = a
        a = b % a
        b = temp
      }
      b
    }
    var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    } while (line != "")
    while ((line = readLine()) != "") //错误，原因是 = 是表达式，返回Unit
      println("Read: " + line)
  }

  def testFor(): Unit = {
    def for1(): Unit = {
      val filesHere = (new java.io.File(".")).listFiles
      for (file <- filesHere)
        println(file)
    }
    def for2(): Unit = {
      val filesHere = (new java.io.File(".")).listFiles
      for (
        file <- filesHere if file.getName.endsWith(".scala")
      ) println(file)
    }
    def for3(): Unit = {
      val filesHere = (new java.io.File(".")).listFiles
      for (
        file <- filesHere if file.isFile if file.getName.endsWith(".scala")
      ) println(file)
    }

    def for4(): Unit = {
      val filesHere = (new java.io.File(".")).listFiles
      def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file).getLines().toList
      def grep(pattern: String) =
        for (
          file <- filesHere if file.getName.endsWith(".scala");
          line <- fileLines(file) if line.trim.matches(pattern)
        ) println(file + ":" + line.trim)
      grep(".*gcd.*")
    }

    def for5(): Unit = {
      val filesHere = (new java.io.File(".")).listFiles
      def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file).getLines().toList
      def grep(pattern: String) =
        for {
          file <- filesHere
          if file.getName.endsWith(".scala")
          line <- fileLines(file)
          if line.trim.matches(pattern)
        } println(file + ":" + line.trim)
      grep(".*gcd.*")

    }

    def for6(): Unit = {
      val filesHere = (new java.io.File(".")).listFiles
      def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file).getLines().toList
      def grep(pattern: String) =
        for {
          file <- filesHere
          if file.getName.endsWith(".scala")
          line <- fileLines(file)
          trimmed = line.trim
          if trimmed.matches(pattern)
        } println(file + ":" + trimmed)
      grep(".*gcd.*")
    }

    def for7(): Unit = {
      val filesHere = (new java.io.File(".")).listFiles
      def scalaFiles =
        for {
          file <- filesHere
          if file.getName.endsWith(".scala")
        } yield file

    }
  }

  def testTry(): Unit = {
    var f: FileReader = null
    try {
      f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => //handle missing file
      case ex: IOException => //handle other I/O error
    } finally {
      if (f != null) {
        f.close()
      }
    }

    def urlFor(path: String) =
      try {
        new URL(path)
      } catch {
        case e: MalformedURLException =>
          new URL("http://www.scala-lang.org")
      }
  }
  def testBreakContinue(args: Array[String]) = {
    def searchFrom(i: Int): Int =
      if (i >= args.length) -1
      else if (args(i).startsWith("-")) searchFrom(i + 1)
      else if (args(i).endsWith(".scala")) i
      else searchFrom(i + 1)
    val i = searchFrom(0)
  }

  val in = new BufferedReader(new InputStreamReader(System.in))
  breakable {
    while (true) {
      println("? ")
      if (in.readLine() == "") break
    }
  }
}