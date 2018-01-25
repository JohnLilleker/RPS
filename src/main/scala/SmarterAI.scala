import RPS._

// higher balance means more reliant on move history
class SmarterAI(override val name: String = "better RPS bot", val balance: Double = 1) extends AI {

  var previous = List.empty[Play]

  override def play: Play = {
    if (previous.isEmpty || scala.util.Random.nextDouble() > balance) super.play
    else {
      val counts = previous.groupBy(identity).mapValues(_.size)
      val mostCommon = counts.maxBy(_._2)
      mostCommon match {
        case (ROCK, _) => PAPER
        case (PAPER, _) => SCISSORS
        case (SCISSORS, _) => ROCK
      }
    }
  }

  override def observe(move: Play): Unit = {
    previous = previous :+ move
  }
}
