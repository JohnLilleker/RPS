import RPS._

class Human(override val name: String) extends Player {
  override def play: Play = {
    var input = ""
    do {
      input = getInput.toUpperCase
    } while(!validate(input))
    RPS.withName(input)
  }

  def getInput: String = {
    scala.io.StdIn.readLine("Rock, paper or scissors? ")
  }

  def validate(input: String): Boolean = try {
    RPS.withName(input)
    true
  }
  catch {
    case _: java.util.NoSuchElementException => false
  }
}
