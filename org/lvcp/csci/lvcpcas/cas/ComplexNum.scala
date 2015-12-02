package org.lvcp.csci.lvcpcas.cas

class ComplexNum(real: BigInt, imaginary: BigInt){
	def re = real
	def im = imaginary
	override def toString(){
		if (im!=0)
			return ""+re+(if (im<0) "" else "+") + im + "i"
		else
			return ""+re
	}
}