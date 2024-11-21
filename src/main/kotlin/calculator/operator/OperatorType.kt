package calculator.operator

enum class OperatorType(val symbol: String, private val operator: Operator) : Operator {
    PLUS(
        "+",
        Operator { leftOperand, rightOperand -> leftOperand + rightOperand },
    ),
    SUBTRACTION(
        "-",
        Operator { leftOperand, rightOperand -> leftOperand - rightOperand },
    ),
    MULTIPLICATION(
        "*",
        Operator { leftOperand, rightOperand -> leftOperand * rightOperand },
    ),
    DIVISION(
        "/",
        Operator { leftOperand, rightOperand ->
            require(rightOperand != 0) { "Cannot divide by zero" }
            leftOperand / rightOperand
        },
    ),
    ;

    override fun apply(
        leftOperand: Int,
        rightOperand: Int,
    ): Int = operator.apply(leftOperand, rightOperand)
}
