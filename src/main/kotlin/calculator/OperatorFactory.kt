package calculator

import calculator.operator.Operator
import calculator.operator.OperatorType

object OperatorFactory {
    fun from(symbol: String): Operator {
        return OperatorType.entries.find { it.symbol == symbol }
            ?: throw IllegalArgumentException("Invalid operator: $symbol")
    }
}
