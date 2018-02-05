import RPS._
import scala.util.Random

// higher balance means more reliant on move history
class SmarterAI(override val name: String = "better RPS bot", val balance: Double = 1) extends AI {

  var previous = List.empty[Play]
  var reliability = 0.5

  override def play: Play = {
    var choice: Play = null
    if (previous.isEmpty || Random.nextDouble() > balance) choice = super.play
    else {
      val counts = previous.groupBy(identity).mapValues(_.size)
      val mostCommon = counts.maxBy(_._2)
      mostCommon match {
        case (ROCK, _) => choice = PAPER
        case (PAPER, _) => choice = SCISSORS
        case (SCISSORS, _) => choice = ROCK
      }
    }
    println(s"I will pick ${ if (Random.nextDouble() < reliability) choice else super.play }")
    reliability *= 0.85
    choice
  }

  override def observe(move: Play): Unit = {
    previous = previous :+ move
    if (previous.length > 250)
      previous = previous.tail
  }

  override def toString: String = {
    super.toString + f" with ${(1 - balance) * 100}%.1f%% randomness"
  }
}
