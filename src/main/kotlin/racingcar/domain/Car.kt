package racingcar.domain

import racingcar.strategy.MoveStrategy

class Car(val name: String, val position: CarPosition = CarPosition()) {
    fun move(moveStrategy: MoveStrategy): Car {
        return if (moveStrategy.move()) {
            val movedPosition = position.move()
            Car(name, movedPosition)
        } else {
            this
        }
    }
}
