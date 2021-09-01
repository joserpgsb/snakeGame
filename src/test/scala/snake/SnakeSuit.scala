package snake

import org.junit._
import org.junit.Assert.assertEquals


class SnakeSuit {
  import Snake._

  @Test def `test1`: Unit = {
    val board:Board= Array.ofDim[Boolean](4, 3)
    val bodySnake:BodySnake=Seq((2, 2), (3, 2), (3, 1),( 3, 0), (2, 0), (1, 0), (0, 0))
    val depth=3
    assertEquals(7, numberOfAvailableDifferentPaths(board,bodySnake,depth))
  }

  @Test def `test2`: Unit ={
    val board2:Board= Array.ofDim[Boolean](2, 3)
    val bodySnake2:BodySnake=Seq((0,2), (0,1), (0,0), (1,0), (1,1), (1,2))
    val depth2=10
    assertEquals(1, numberOfAvailableDifferentPaths(board2,bodySnake2,depth2))
  }


  @Test def `test3`: Unit = {
    val board3:Board= Array.ofDim[Boolean](10, 10)
    val bodySnake3:BodySnake=Seq((5,5), (5,4), (4,4), (4,5))
    val depth3=4
    assertEquals(81, numberOfAvailableDifferentPaths(board3,bodySnake3,depth3))
  }

  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)

}
