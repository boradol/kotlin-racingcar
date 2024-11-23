package racingcar.domain

class Winners(val values: Cars) {
    companion object {
        fun from(results: List<Cars>): Winners {
            val winners = results.last().maxPositionCars()
            return Winners(winners)
        }
    }
}
