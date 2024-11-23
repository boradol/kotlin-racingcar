package racingcar.domain

data class CarName(val value: String) {
    init {
        require(value.isNotBlank()) { "이름은 공백일 수 없습니다." }
        require(value.length <= NAME_MAX_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다. name = $value" }
    }

    companion object {
        private const val NAME_MAX_LENGTH = 5
    }
}
