package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class StringCalculatorTest : StringSpec({
    "덧셈" {
        val input = InputValue.from("1 + 2")
        StringCalculator.calculate(input) shouldBe 3
    }

    "뺄셈" {
        val input = InputValue.from("5 - 2")
        StringCalculator.calculate(input) shouldBe 3
    }

    "곱셈" {
        val input = InputValue.from("2 * 3")
        StringCalculator.calculate(input) shouldBe 6
    }

    "나눗셈" {
        val input = InputValue.from("6 / 2")
        StringCalculator.calculate(input) shouldBe 3
    }

    "사칙연산" {
        val input = InputValue.from("2 + 3 * 4 / 2")
        StringCalculator.calculate(input) shouldBe 10
    }

    "입력이 null 또는 빈 문자열이 올 경우 예외 발생" {
        listOf(null, "", "   ").forEach { input ->
            shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate(InputValue.from(input))
            }.message shouldBe "Input cannot be null or blank"
        }
    }

    "잘못된 연산자가 포함된 경우 예외 발생" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate(InputValue.from("2 + 3 & 4"))
        }.message shouldContain "Invalid operator"
    }

    "0으로 나눌 경우 예외 발생" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate(InputValue.from("4 / 0"))
        }.message shouldBe "Cannot divide by zero"
    }
})