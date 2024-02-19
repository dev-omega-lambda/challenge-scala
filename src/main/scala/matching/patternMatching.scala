package matching

@main def patternMatching(): Unit = {
  println("testing")
  val v = Var("x")
  val op = Binop("+", Num(1), v)
  val nOp = op.copy(operator = "-")
  println(s"""
    |case Var: $v
    |case Binop: $op
    |"==" case ${op.right == Var("x")}
    |new case copy op $nOp
  """.stripMargin)
} 

trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class Unop(operator: String, arg: Expr) extends Expr
case class Binop(operator: String, left: Expr, right: Expr) extends Expr

