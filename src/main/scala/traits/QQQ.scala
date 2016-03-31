package traits

import scala.collection.mutable.ArrayBuffer
abstract class IntQueue {
  def get():Int
  def put(x:Int)
}
class BasicIntQueue extends IntQueue{
  private val buf =new ArrayBuffer[Int]
  def get()= buf.remove(0)
  def put(x:Int) { buf += x }
}


trait Doubling extends IntQueue{
  abstract override def put(x:Int) { super.put(2*x)}
}

trait Incrementing extends IntQueue{
  abstract override def put(x:Int) { super.put(x+1)}
}

trait Filtering extends IntQueue{
  abstract override def put (x:Int){
    if(x>=0) super.put(x)
  }
}

object QQQ{
 def main(args: Array[String]): Unit = {
   val queue = new BasicIntQueue with Doubling
    queue.put(10)
     queue.get()
 }
 /**
  * 
    scala> val queue1 = new BasicIntQueue with Doubling with Incrementing
    queue1: BasicIntQueue with Doubling with Incrementing = $anon$1@18c1c9eb

    scala> queue1.put(10)
    
    scala> queue1.get
    res21: Int = 22
    
    scala> val queue2 = new BasicIntQueue with Incrementing  with Doubling
    queue2: BasicIntQueue with Incrementing with Doubling = $anon$1@6abacdd3
    
    scala> queue2.put(10)
    
    scala> queue2.get
    res23: Int = 21
  * 
  */
}