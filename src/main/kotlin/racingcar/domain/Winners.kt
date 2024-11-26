package racingcar.domain

class Winners private constructor(val values: Cars) {
    companion object {
        fun from(carRacingGameResults: List<Cars>): Winners {
            val maxPosition = carRacingGameResults.last().maxPosition()
            val winners =
                carRacingGameResults.last()
                    .currentCars()
                    .filter { it.position.value == maxPosition }
            return Winners(Cars(winners))
        }
    }
}
