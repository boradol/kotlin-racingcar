package racingcar.ui

import racingcar.domain.Cars

private const val DASH_SYMBOL = "-"

fun printAllResults(raceResult: List<Cars>) {
    println("\n실행결과")
    raceResult.forEach { round ->
        printRoundResult(round)
        println()
    }
}

private fun printRoundResult(round: Cars) {
    round.getPositions().forEach { position ->
        println(DASH_SYMBOL.repeat(position))
    }
}
