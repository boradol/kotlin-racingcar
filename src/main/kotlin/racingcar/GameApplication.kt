package racingcar

import racingcar.strategy.RandomMoveStrategy
import racingcar.ui.printAllResults
import racingcar.ui.readCarNames
import racingcar.ui.readNumberOfCars
import racingcar.ui.readTries

fun main() {
    val carNames = readCarNames()
    println("carNames = $carNames")

    val carCount = readNumberOfCars()
    val round = readTries()
    val raceResults = CarRacingGame(carCount, round).play(RandomMoveStrategy())
    printAllResults(raceResults)
}
