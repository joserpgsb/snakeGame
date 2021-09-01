package snake
import Snake._
object main extends App {
  var board:Board= Array.ofDim[Boolean](10, 10)
  val bodySnake:BodySnake=Seq((5,5), (5,4), (4,4), (4,5))
  val depth:Int = 4
  boardInitiation(board,bodySnake)
  println(numberOfAvailableDifferentPaths(board,bodySnake,depth))
}