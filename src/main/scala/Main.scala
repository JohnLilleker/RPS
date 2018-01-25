object Main {
  def main(args: Array[String]): Unit = {

    val name = scala.io.StdIn.readLine("What is your name? ")
    val winner = Game.play(new SmarterAI(balance = 0.75), new Human(name))
    println(s"$winner has won!")

    // AI vs AI
    println(Game.play(new SmarterAI("Skynet", 0.25), new SmarterAI("Deep Thought", 0.45), 1000))
  }
}
