package racingcar

import racingcar.strategy.MoveStrategy

class Car(val position: Int = 0) {
    fun move(moveStrategy: MoveStrategy): Car {
        return if (moveStrategy.move()) {
            Car(position + 1) // 새로운 객체 반환
        } else {
            this
        }
    }
}
