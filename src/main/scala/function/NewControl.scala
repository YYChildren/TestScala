package function
import java.io._

class NewControl {
  def twice(op: Double => Double, x: Double) = op(op(x))
  val twiceImpl = twice(_ + 1, 5)

  def common() = {
    def withPrintWriter(file: File, op: PrintWriter => Unit) {
      val writer = new PrintWriter(file)
      try {
        op(writer)
      } finally {
        writer.close()
      }
    }
    withPrintWriter(
      new File("date.txt"),
      writer => writer.println(new java.util.Date))

    println("Hello,World")
    println { "Hello,world" } //只适用只有一个参数
  }

  def curryCommon() = {
    def withPrintWriter(file: File)(op: PrintWriter => Unit) {
      val writer = new PrintWriter(file)
      try {
        op(writer)
      } finally {
        writer.close()
      }
    }

    // 看起来像Scala内置的控制结构语法
    val file = new File("date.txt")
    withPrintWriter(file) {
      writer => writer.println(new java.util.Date)
    }
  }

  // 传名参数
  def namePara() = {
    var assertionsEnabled = true
    def myAssert(predicate: () => Boolean) =
      if (assertionsEnabled && !predicate())
        throw new AssertionError
    myAssert(() => 5 > 3) // 别扭

    def myNameAssert(predicate: => Boolean) =
      if (assertionsEnabled && !predicate)
        throw new AssertionError
    myNameAssert(5 > 3)  //传入的是返回Boolean的函数，并不是Boolean
    
    def withHelloWorld ( op: => Unit) {
      op   
      println("Hello,world")
    }
    withHelloWorld {
      println ("Hello,Guidebee")
    } 
    
  }

}