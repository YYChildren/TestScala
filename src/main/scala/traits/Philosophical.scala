package traits

trait Philosophical{
  def philosophize() {
    println("I consume memeory, therefor I am!")
  }
}
                // or with
class Frog extends Philosophical{
  override def toString="gree"
}

