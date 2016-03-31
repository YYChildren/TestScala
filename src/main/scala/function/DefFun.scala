package function

class DefFun {
  var increase = (x: Int) => x + 1
  def test() = {
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
    someNumbers.foreach((x: Int) => println(x))
  }
  def simplfy() = {
    (x: Int) =>
      x + 1
      // (x) => x +1
      // x => x +1
      val someNumbers = List(-11, -10, -5, 0, 5, 10)
      someNumbers.filter(_ > 0)
      val f = (_: Int) + (_: Int)
    //val f = _ + _
  }
  def partFun() = {
    def sum = (_: Int) + (_: Int) + (_: Int)
    sum(1, 2, 3)
    val b = sum(1, _: Int, 3)
    b(2)
    val c = sum(_: Int, 2, _: Int)
    
    val someNumbers = 1 to 10
    someNumbers.foreach(println _)
    someNumbers.foreach(println)
  }
  
  def ClosureFun() = {
    var more =1
    (x:Int) => x + more
    val addMore = (x:Int) => x + more
     addMore (100)
    more = 9999
    addMore(10)
    
    val someNumbers = List ( -11, -10, -5, 0, 5, 10)
    var sum =0
    someNumbers.foreach ( sum += _)
    sum
    
    
    def makeIncreaser(more:Int) = (x:Int) => x + more
    val inc1=makeIncreaser(1)    
    val inc9999=makeIncreaser(9999)
    inc1(10)
    inc9999(10)
  }
  
  def ParaFun() ={
    //重复参数
    def echo (args: String *) = for (arg <- args) println(arg)
    echo()
    echo("One")
    val arr= Array("What's","up","doc?")
    //echo (arr)//失败
    echo (arr: _*)
    
    // 命名参数
    def  speed(distance: Float, time:Float) :Float = distance/time
    speed(100,10)
    speed( time=10,distance=100)
    speed(distance=100,time=10)
    
    // 缺省参数值
     def printTime(out:java.io.PrintStream = Console.out, divisor:Int =1 ) =
        out.println("time = " + System.currentTimeMillis()/divisor)
     printTime()
     printTime(divisor=1000)
  }
  
  def tailRecusionFun() ={
    // 非尾递归
    def boom(x:Int):Int=
      if(x==0) throw new Exception("boom!") else boom(x-1) + 1
      
    // 尾递归，同一调用栈
    def bang(x:Int):Int=
      if(x==0) throw new Exception("boom!") else bang(x-1)
      
    // 尾递归编译为循环，取消尾递归： -g:notailcalls
    
    // 局限，间接递归不是尾递归
    def isEven(x:Int): Boolean =
      if(x==0) true else isOdd(x-1)
    def isOdd(x:Int): Boolean=
      if(x==0) false else isEven(x-1)
  }

}