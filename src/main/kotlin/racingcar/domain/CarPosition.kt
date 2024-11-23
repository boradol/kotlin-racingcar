package racingcar.domain

data class CarPosition(val value: Int = DEFAULT_POSITION) {
    init {
        require(value >= DEFAULT_POSITION) { "위치는 음수일 수 없습니다." }
    }

    fun move(): CarPosition {
        return copy(value = value + 1)
    }

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
