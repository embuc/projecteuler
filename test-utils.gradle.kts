import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestResult

// Define a reusable extension function
fun Test.addColoredSummary() {
	addTestListener(object : org.gradle.api.tasks.testing.TestListener {
		override fun beforeSuite(suite: TestDescriptor) {
			// No-op
		}

		override fun afterSuite(suite: TestDescriptor, result: TestResult) {
			if (suite.parent == null) { // Only log for the root suite
				val green = "\u001B[32m"
				val red = "\u001B[31m"
				val yellow = "\u001B[33m"
				val reset = "\u001B[0m"

				println(
					"Total: ${result.testCount} tests executed, " +
							"${green}${result.successfulTestCount} passed${reset}, " +
							"${red}${result.failedTestCount} failed${reset}, " +
							"${yellow}${result.skippedTestCount} skipped${reset}."
				)
			}
		}

		override fun beforeTest(testDescriptor: TestDescriptor) {
			// No-op
		}

		override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
			// No-op
		}
	})
}
