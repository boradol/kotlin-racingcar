package racingcar.ui

fun readNumberOfCars(): Int {
    println("자동차 대수는 몇 대인가요?")
    return readln().toInt()
}

fun readCarNames(): String {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    return readln()
}

fun readTries(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readln().toInt()
}
