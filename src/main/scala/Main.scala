object Main {
  def main(args: Array[String]): Unit = {
    import scala.io.StdIn.readLine

    val game = readLine("Do you want to play (Y) or watch 2 AIs fight (N)? ")

    if (game.head.toUpper == 'Y') {
      val name = readLine("What is your name? ")
      val games = readLine("How many wins? ")
      val ai = readLine("Which AI? 1 : Random, 2 : 0.65 Random, 3 : 0.35 Random ")
      var comp = new AI
      if (ai == "2") comp = new SmarterAI(balance = 0.35)
      if (ai == "3") comp = new SmarterAI(balance = 0.65)

      val winner = Game.play(comp, new Human(name), games.toInt)
      println(s"$winner has won!")
    }
    else {
      // AI vs AI
      val games = readLine("How many wins? ")
      println(Game.play(new SmarterAI("Skynet", 0.35), new SmarterAI("Deep Thought", 0.65), games.toInt))
    }

  }
}
