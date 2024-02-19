package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.calculateTotientSum

// Counting fractions
class Task72:Task {
	override fun solve(): Any {
		return calculateTotientSum(1000000);
	}
}