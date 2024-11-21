package racingcar

import racingcar.strategy.RandomMoveStrategy
import racingcar.ui.printAllResults
import racingcar.ui.readCarNames
import racingcar.ui.readTries

fun main() {
    val carNames = readCarNames()
    val round = readTries()
    val raceResults = CarRacingGame.create(carNames, round).play(RandomMoveStrategy())
    printAllResults(raceResults)
}
