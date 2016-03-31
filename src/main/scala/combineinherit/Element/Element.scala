package combineinherit.Element

abstract class Element {
  
  // 抽象方法
  def contents: Array[String]
  
  // 这两者定义的是方法，并不预计算
  def height: Int = contents.length 
  def width: Int = if (height == 0) 0 else contents(0).length 
  
  // 这两者定义的是成员变量，会预计算
  // val height = contents.length 
  // val width = if (height == 0) 0 else contents(0).length 

  /*
   *  特别是如果类的字段变成了访问函数，且访问函数是纯函数的，
   *  就是说它没有副作用并且不依赖于可变状态
   *  这称为统一访问原则： uniform access principle， 
   *  就是说客户代码不应受通过字段还是方法实现属性的决定的影响。
  */
  //原则上 Scala 的函数调用中可以省略所有的空括号
  // 这两行合法，分别执行的是toString() 和 length() 放啊
   Array(1, 2, 3).toString 
  "abc".length
  
  "hello".length // 没有副作用，所以无须() 
  println() // 最好别省略()
  
  /*
   * Scala 里定义不带参数也没有副作用的方法为无参数方法，
   * 也就是说，省略空的括号，是鼓励的风格。
   * 另一方面，永远不要定义没有括号的带副作用的方法，
   * 因为那样的话方法调用看上去会像选择一个字段。
   */
}


object Element {
  def elem(contents: Array[String]):Element =
   new ArrayElement(contents)
  def elem(chr:Char, width:Int, height:Int) :Element =
    new UniformElement(chr,width,height)
  def elem(line:String) :Element =
    new LineElement(line)
}