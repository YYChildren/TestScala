package combineinherit.Element

class ArrayElement(conts: Array[String]) extends Element{
  // 实现方法
  def contents: Array[String] = conts
  
  /*
   * 和 Java 稍有不同的一点是，
   * Scala 中成员函数和成员变量地位几乎相同，
   * 而且也处在同一个命名空间
   */
  // val contents: Array[String] = conts
  
  /*
   * Scala 支持的两个命名空间如下：
   * -- 值（字段，方法，包还有单例对象）
   * -- 类型（类和Trait名）
   * Scala 把字段和方法放进同一个命名空间的理由很清楚，
   * 因为这样你就可以使用 val 重载无参数的方法
   */
}

                              // 定义了不可变变量contents，同时也是重写
class ArrayElement2(val contents: Array[String]) 
  extends Element {
}

class Cat {
  val dangerous =false
}

// 是下面代码的缩写
class Tiger (override val dangerous: Boolean,private var age: Int) extends Cat
/*class Tiger(param1: Boolean, param2: Int) extends Cat { 
    override val dangerous = param1 
    private var age = param2 
}   */