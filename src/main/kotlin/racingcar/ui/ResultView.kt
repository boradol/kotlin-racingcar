package racingcar.ui

import racingcar.domain.Car

private const val DASH_SYMBOL = "-"

fun printAllResults(raceResult: List<List<Car>>) {
    raceResult.forEach { round ->
        printRoundResult(round)
        println()
    }
}

private fun printRoundResult(round: List<Car>) {
    round.forEach { car ->
        println(DASH_SYMBOL.repeat(car.position.point))
    }
}
