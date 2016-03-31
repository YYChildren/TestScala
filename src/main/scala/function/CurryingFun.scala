package function

/**
 * 柯里化是把接受多个参数的函数变换成
 * 接受一个单一参数（最初函数的第一个参数）的函数，
 * 并且返回接受余下的参数而且返回结果的新函数的技术。
 */

object CurryingFun{
  def plainOldSum(x:Int,y:Int) = x + y
  
  // 柯里化
  def curriedSum(x:Int)(y:Int) = x + y
  
  def main(args: Array[String]): Unit = {
    plainOldSum(1,2)
    /*
     * 当你调用 curriedSum (1)(2)时，
     * 实际上是依次调用两个普通函数（非柯里化函数），
     * 第一次调用使用一个参数 x，返回一个函数类型的值，
     * 第二次使用参数y调用这个函数类型的值，
     */
    curriedSum (1)(2)
    
    
    // 模拟
    def first(x:Int) = (y:Int) => x + y
    val second=first(1)
    second(2)
    
    // 过程
     val onePlus = curriedSum(1)_
     onePlus(2)
    val twoPlus = curriedSum(2)_
     twoPlus(2)
  }
}