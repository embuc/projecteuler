package se.embuc._1to50

import se.embuc.Task

// Counting Sundays
/*
	1 Jan 1900 was a Monday.
	Thirty days has September,
	April, June and November.
	All the rest have thirty-one,
	Saving February alone,
	Which has twenty-eight, rain or shine.
	And on leap years, twenty-nine.
	A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
	How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/
class Task19: Task {
	private val monthsInNonLeapYear = listOf(31,28,31,30,31,30,31,31,30,31,30,31)
	private val monthsInLeapYear = listOf(31,29,31,30,31,30,31,31,30,31,30,31)
	private val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

	override fun solve(): Any {
		var dayIndex = (monthsInNonLeapYear.sum() + 1) % 7 // 1 Jan 1901 was a Tuesday, hence '+ 1'
		var sundayCounter = 0

		for (year in 1901..2000) {
			val isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
			val monthsInYear = if (isLeap) monthsInLeapYear else monthsInNonLeapYear
			for (daysInMonth in monthsInYear) {
				if(days[dayIndex] == "Sunday") {
					sundayCounter++
				}
				dayIndex = (dayIndex + daysInMonth) % 7
			}
		}
		return sundayCounter
	}
}