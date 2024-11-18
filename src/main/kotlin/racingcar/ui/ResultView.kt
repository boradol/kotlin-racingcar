package racingcar.ui

import racingcar.domain.Car

fun printAllResults(raceResult: List<List<Car>>) {
    raceResult.forEach { round ->
        printRoundResult(round)
        println()
    }
}

private fun printRoundResult(round: List<Car>) {
    round.forEach { car ->
        println("-".repeat(car.position.point))
    }
}
