object Main {
  def main(args: Array[String]): Unit = {

    val name = scala.io.StdIn.readLine("What is your name? ")
    val winner = Game.play(new SmarterAI(balance = 0.65), new Human(name), 10)
    println(s"$winner has won!")

    // AI vs AI
    //println(Game.play(new SmarterAI("Skynet", 0.35), new SmarterAI("Deep Thought", 0.65), 10000))
  }
}
