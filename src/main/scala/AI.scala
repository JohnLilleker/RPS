
class AI(override val name: String = "RPS bot") extends Player {
  override def play: RPS.Play = RPS(scala.util.Random.nextInt(RPS.maxId))
}
