package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.digits

//Square Digit Chains
class Task92() : Task {

	override fun solve(): Any {
		//how many under 10000000 end in 89

		val endIn89 = mutableSetOf(89)
		val endIn1 = mutableSetOf(1)
		for(i in 2 until 10000000){
			val chain = mutableListOf(i)
			var current = i
			while(current !in endIn89 && current !in endIn1){
				val next = current.digits().sumOf { it * it }
				chain.add(next)
				current = next
			}
			if(current in endIn89){
				endIn89.addAll(chain)
			}else{
				endIn1.addAll(chain)
			}
		}

		return endIn89.size
	}
}