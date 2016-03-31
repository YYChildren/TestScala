package combineinherit.Element

                                       //调用基类构造函数
                                        //... extends ArrayElement(Array(s)) ...
class LineElement(s:String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
  //重载非抽象一定要override
}


class UniformElement (ch :Char,
  override val width:Int,
  override val height:Int
) extends Element{
  private val line=ch.toString * width
  def contents = Array.fill(height)(line)
}

class AboveElement(val contents: Array[String]) extends Element{
  def above(that: Element) :Element =
    new ArrayElement(this.contents ++ that.contents)
  def beside(that: Element) :Element = {
    val contents = new Array[String](this.contents.length)
    for(i <- 0 until this.contents.length)
      contents(i)=this.contents(i) + that.contents(i)
    new ArrayElement(contents)
  }
  def beside2(that: Element) :Element = {
    new ArrayElement(
      for(
        (line1,line2) <- this.contents zip that.contents
      ) yield line1+line2
    )
  }
  
  def beside3(that: Element) :Element = {
    new ArrayElement(
        (this.contents zip that.contents).map { x => x._1 + x._2 }
    )
  }
  
  
}
