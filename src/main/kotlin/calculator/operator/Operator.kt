package calculator.operator

fun interface Operator {
    fun apply(
        leftOperand: Int,
        rightOperand: Int,
    ): Int
}
