package snake

import org.junit._
import org.junit.Assert.assertEquals

class SnakeSuit {
  import Snake._
  var board:Board= Array.ofDim[Boolean](4, 3)
  val bodySnake:BodySnake=Seq((2, 2), (3, 2), (3, 1),( 3, 0), (2, 0), (1, 0), (0, 0))
  val depth=3

  @Test def `test1`: Unit =
    assertEquals(7, numberOfAvailableDifferentPaths(board,bodySnake,depth))

  var board2:Board= Array.ofDim[Boolean](2, 3)
  val bodySnake2:BodySnake=Seq((0,2), (0,1), (0,0), (1,0), (1,1), (1,2))
  val depth2=10

  @Test def `test2`: Unit =
    assertEquals(1, numberOfAvailableDifferentPaths(board2,bodySnake2,depth2))

  var board3:Board= Array.ofDim[Boolean](10, 10)
  val bodySnake3:BodySnake=Seq((5,5), (5,4), (4,4), (4,5))
  val depth3=4

  @Test def `test3`: Unit =
    assertEquals(81, numberOfAvailableDifferentPaths(board3,bodySnake3,depth3))



}
