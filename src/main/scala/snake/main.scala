package snake
import Snake._
object main extends App {
  //var board:Board= Array.ofDim[Boolean](4, 3)
  //val bodySnake:BodySnake=Seq((2, 2), (3, 2), (3, 1),( 3, 0), (2, 0), (1, 0), (0, 0))
  //var board:Board= Array.ofDim[Boolean](2, 3)
  //val bodySnake:BodySnake=Seq((0,2), (0,1), (0,0), (1,0), (1,1), (1,2))
  var board:Board= Array.ofDim[Boolean](10, 10)
  val bodySnake:BodySnake=Seq((5,5), (5,4), (4,4), (4,5))
  val depth:Int = 4
  boardInitiation(board,bodySnake)
  println(differentPaths(board,bodySnake,depth).length)
}