package se.embuc._50to100

import se.embuc.Task

// Counting rectangles
class Task85:Task {
	override fun solve(): Any {
		var area = 1
		var min = 2000000
		for (x in 1..2000){
			for (y in 1..2000){
				val count = (((x + 1) * x) * ((y + 1) * y)) / 4
				if (Math.abs(count - 2000000) < min){
					min = Math.abs(count - 2000000)
					area = x * y
				}
			}
		}
		return area
	}


}