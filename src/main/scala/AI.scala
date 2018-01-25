
class AI(override val name: String = "RPS bot") extends Player {
  override def play: RPS.Play = {
    val choice = scala.util.Random.nextInt(RPS.maxId)
    RPS(choice)
  }
}
