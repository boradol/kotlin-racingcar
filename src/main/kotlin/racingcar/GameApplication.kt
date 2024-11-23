package racingcar

import racingcar.domain.Winners
import racingcar.strategy.RandomMoveStrategy
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val carNames = InputView.readCarNames()
    val round = InputView.readTries()

    val game = CarRacingGame.create(carNames, round)
    val raceResults = game.play(RandomMoveStrategy())
    val winners = Winners.from(raceResults).values

    ResultView.printAllResults(raceResults)
    ResultView.printWinners(winners)
}
