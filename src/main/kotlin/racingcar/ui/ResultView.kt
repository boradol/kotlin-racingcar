package racingcar.ui

import racingcar.domain.Cars

object ResultView {
    private const val DASH_SYMBOL = "-"

    fun printWinners(winners: Cars) {
        println("${winners.currentCars().joinToString(", ") { it.name.value }}가 최종 우승했습니다.")
    }

    fun printAllResults(raceResult: List<Cars>) {
        println("\n실행결과\n")
        raceResult.forEach { round ->
            printRoundResult(round)
            println()
        }
    }

    private fun printRoundResult(round: Cars) {
        round.currentCars().forEach { car ->
            println("${car.name.value} : ${DASH_SYMBOL.repeat(car.position.value)}")
        }
    }
}
