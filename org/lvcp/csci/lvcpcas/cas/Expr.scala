package org.lvcp.csci.lvcpcas.cas

abstract class Expr

case class Sum(addends: Expr*) extends Expr
case class Product(factors: Expr*) extends Expr
case class Power(base: Expr, exponent: Expr) extends Expr
case class ScalarConst(value: BigInt) extends Expr
case class Var(name: String) extends Expr

