package snake

object Snake extends SnakeInterface {
  type Position=(Int,Int)
  type Board=Array[Array[Boolean]]
  type BodySnake=Seq[Position]
  type Path=List[Char]
  val movements= Seq('L','R','D','U')

  def boardInitiation(board:Board,bodySnake:BodySnake): Board={
    for (i <- 0 to board.length - 1) {
      for (j <- 0 to board(0).length - 1) {
        board(i)(j) = bodySnake contains(i, j);
      }
    }
    board
  }

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


  def printInitiation(board:Board,bodySnake:BodySnake)={
    for (i <- 0 to board.length - 1) {
      for (j <- 0 to board(0).length - 1) {
        print(" " + board(i)(j));
      }
      println();
    }
  }

  def snakeMovement (direction:Char, bodySnake:BodySnake): BodySnake ={
    val position=square(direction,bodySnake)
    position+:bodySnake.dropRight(1)
  }

  def prohibitedMovement(direction:Char, bodySnake:BodySnake,board: Board): Boolean= {
    val position:Position=square(direction,bodySnake)
    val newSnake=bodySnake.dropRight(1)
    if (position._1 == board.length || position._2 == board(0).length
    ||  position._1 == -1 || position._2 == -1 || newSnake.contains(position)) true
    else false
  }

  def square(direction:Char, bodySnake:BodySnake): Position = direction match {
    case 'R'=>(bodySnake.head._1+1,bodySnake.head._2)
    case 'L'=>(bodySnake.head._1-1,bodySnake.head._2)
    case 'U'=>(bodySnake.head._1,bodySnake.head._2+1)
    case 'D'=>(bodySnake.head._1,bodySnake.head._2-1)
    case _ => throw new Exception("wrong direction")
  }

}

