package org.lvcp.csci.lvcpcas.cas

abstract class Expr {
	def substitute(substitutions: (Var, Expr)*): Expr
}

case class Sum(addends: Expr*) extends Expr {
	override def substitute(substitutions: (Var, Expr)*) =
		Sum(addends.map{ _.substitute(substitutions:_*) })
}

case class Product(factors: Expr*) extends Expr {
	override def substitute(substitutions: (Var, Expr)*) =
		Product(factors.map{ _.substitute(substitutions:_*) })
}

case class Power(base: Expr, exponent: Expr) extends Expr {
	override def substitute(substitutions: (Var, Expr)*) =
		Power(base.substitute(substitutions:_*), exponent.substitute(substitutions:_*))
}

case class ScalarConst(value: ComplexNum) extends Expr {
	override def substitute(substitutions: (Var, Expr)*) = this
}

case class Var(name: String) extends Expr {
	override def substitute(substitutions: (Var, Expr)*) =
		substitutions.toMap.getOrElse(this, this)
}

