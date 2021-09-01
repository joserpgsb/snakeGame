package snake

object Snake extends SnakeInterface {
  type Position=(Int,Int)
  type Board=Array[Array[Boolean]]
  type BodySnake=Seq[Position]
  type Path=List[Char]
  val movements= Seq('L','R','D','U')

  /**
   * Fill the board with the position of the snake in true
   * @param board board to fill
   * @param bodySnake snake positions
   * @return board with the position of the snake in true
   */
  def boardInitiation(board:Board,bodySnake:BodySnake): Board={
    for (i <- 0 to board.length - 1) {
      for (j <- 0 to board(0).length - 1) {
        board(i)(j) = bodySnake contains(i, j);
      }
    }
    board
  }

  /**
   * @param board
   * @param snake snake positions
   * @param depth path lenght
   * @return number of distinct valid paths can the snake make on the board
   */
  def numberOfAvailableDifferentPaths(board:Board, snake:BodySnake, depth:Int):Int={
    differentPaths(board,snake,depth).length
  }

  /**
   * This recursive function uses for-comprehensions to solve the problem
   * @param board
   * @param snake snake positions
   * @param depth path lenght
   * @return sequence of distinct valid paths can the snake make on the board
   */
  def differentPaths(board:Board, snake:BodySnake, depth:Int):Seq[Path]={
    def differentPathsAux(board:Board, bodySnake:BodySnake, depth:Int, movements:Seq[Char]):Seq[Path]={
      if (depth <= 0) {
        List(Nil)
      } else {
      for (x <- movements if !prohibitedMovement(x,bodySnake,board);
           y <- differentPathsAux(board, snakeMovement(x,bodySnake), depth-1, movements:Seq[Char])) yield {x :: y}
      }
    }
    differentPathsAux(board, snake, depth, movements)
  }

  /**
   * Print board
   * @param board fill board
   * @param bodySnake snake positions
   */
  def printInitiation(board:Board,bodySnake:BodySnake)={
    for (i <- 0 to board.length - 1) {
      for (j <- 0 to board(0).length - 1) {
        print(" " + board(i)(j));
      }
      println();
    }
  }

  /**
   * @param direction new position of the snake's head
   * @param bodySnake old snake positions
   * @return new snake positions
   */
  def snakeMovement (direction:Char, bodySnake:BodySnake): BodySnake ={
    val position=square(direction,bodySnake)
    position+:bodySnake.dropRight(1)
  }

  /**
   * Detects invalid movements
   * @param direction possible new position of the serpent's head
   * @param bodySnake snake positions
   * @param board
   * @return true if is prohibited movement
   */
  def prohibitedMovement(direction:Char, bodySnake:BodySnake,board: Board): Boolean= {
    val position:Position=square(direction,bodySnake)
    val newSnake=bodySnake.dropRight(1)
    if (position._1 == board.length || position._2 == board(0).length
    ||  position._1 == -1 || position._2 == -1 || newSnake.contains(position)) true
    else false
  }

  /**
   * This function translates the letters to numerical coordinates
   * @param direction letter indicating the direction
   * @param bodySnake current position snake
   * @return coordinates snake's head
   */
  def square(direction:Char, bodySnake:BodySnake): Position = direction match {
    case 'R'=>(bodySnake.head._1+1,bodySnake.head._2)
    case 'L'=>(bodySnake.head._1-1,bodySnake.head._2)
    case 'U'=>(bodySnake.head._1,bodySnake.head._2+1)
    case 'D'=>(bodySnake.head._1,bodySnake.head._2-1)
    case _ => throw new Exception("wrong direction")
  }

}

