import RPS._

object Game {
  // game continues until a player wins the given number of matches
  def play(p1: Player, p2: Player, win: Int = 3): Player = {
    var (score1, score2) = (0, 0)

    println("Rock Paper Scissors")
    println(s"First to $win")

    while (score1 < win && score2 < win) {

      println(s"${p1.name} : $score1 | ${p2.name} : $score2")

      val move1 = p1.play
      val move2 = p2.play

      println(s"$move1 vs $move2")

      // AI observing moves
      p1.observe(move2)
      p2.observe(move1)

      val winner = checkWinner(move1, move2)

      winner match {
        case Some(p) =>
          if (p == move1) {
            println(s"${p1.name} wins")
            score1 += 1
          }
          else {
            println(s"${p2.name} wins")
            score2 += 1
          }
        case None =>
          println("Its a draw")
      }
    }

    if (score1 > score2) p1 else p2
  }

  def checkWinner(move1: Play, move2: Play): Option[Play] = (move1, move2) match {
    case (x, y) if x == y => None
    case (ROCK, PAPER) => Some(PAPER)
    case (ROCK, SCISSORS) => Some(ROCK)
    case (PAPER, ROCK) => Some(PAPER)
    case (PAPER, SCISSORS) => Some(SCISSORS)
    case (SCISSORS, ROCK) => Some(ROCK)
    case (SCISSORS, PAPER) => Some(SCISSORS)
  }
}
