abstract class Player {
  val name: String
  def play: RPS.Play

  override def toString: String = name

  def observe(move: RPS.Play): Unit = {}
}
