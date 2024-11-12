package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    val stringCalculator = StringCalculator()

    "덧셈" {
        val input = "1 + 2"
        stringCalculator.calculate(input) shouldBe 3
    }

    "뺄셈" {
        val input = "5 - 2"
        stringCalculator.calculate(input) shouldBe 3
    }

    "곱셈" {
        val input = "2 * 3"
        stringCalculator.calculate(input) shouldBe 6
    }

    "나눗셈" {
        val input = "6 / 2"
        stringCalculator.calculate(input) shouldBe 3
    }
})

class StringCalculator() {
    fun calculate(input: String): Int {
        val strings = input.split(" ")
        val a = strings[0].toInt()
        val b = strings[2].toInt()
        val operator = strings[1]
        if (operator == "+") {
            return a + b
        } else if (operator == "-") {
            return a - b
        } else if (operator == "*") {
            return a * b
        } else if (operator == "/") {
            return a / b
        } else {
            return 0
        }
    }
}
