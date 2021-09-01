package snake

trait SnakeInterface {
  def boardInitiation(board:Array[Array[Boolean]],bodySnake:Seq[(Int,Int)]): Array[Array[Boolean]]
  def numberOfAvailableDifferentPaths(board:Array[Array[Boolean]], snake:Seq[(Int,Int)], depth:Int):Int
  def differentPaths(board:Array[Array[Boolean]], snake:Seq[(Int,Int)], depth:Int):Seq[List[Char]]
  def snakeMovement(direction:Char, bodySnake:Seq[(Int,Int)]): Seq[(Int,Int)]
  def prohibitedMovement(direction:Char, bodySnake:Seq[(Int,Int)],board: Array[Array[Boolean]]): Boolean
  def square(direction:Char, bodySnake:Seq[(Int,Int)]): (Int,Int)
}

