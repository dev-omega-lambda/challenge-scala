package matching

@main def patternMatching(): Unit = {
  println("testing")
  val v = Var("x")
  val op = Binop("+", Num(1), v)
  val opTest = Binop("+", Num(2), Num(0))
  val nOp = op.copy(operator = "-")
  println(s"""
    |case Var: $v
    |case Binop: $op
    |"==" case ${op.right == Var("x")}
    |new case copy op $nOp
  """.stripMargin)

  val expTest = symplifyTop(opTest)
  println(s"Patter matching test = $expTest")

  println(s"""
    |Number is ${describe(5)}
    |Expression is ${describe(true)} 
    |How do you say ${describe("Hello")}
    |This list is ${describe(Nil)}
    |There is ${describe(Option)}
  """.stripMargin)
}

trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class Unop(operator: String, arg: Expr) extends Expr
case class Binop(operator: String, left: Expr, right: Expr) extends Expr

def symplifyTop(expr: Expr): Expr =
  expr match
    case Unop("-", Unop("-", e)) => e
    case Binop("+", e, Num(0))   => e
    case Binop("*", e, Num(1))   => e
    case _                       => expr
end symplifyTop

def describe(x: Any): String =
  x match
    case 5 => "Five"
    case true => "Truth!"
    case "Hello" => "Hi!"
    case Nil => "Empty list"
    case _ => "something else"
end describe