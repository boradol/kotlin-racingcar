package racingcar.domain

import racingcar.strategy.MoveStrategy

data class Car(val name: CarName, val position: CarPosition = CarPosition()) {
    fun move(moveStrategy: MoveStrategy): Car {
        return if (moveStrategy.move()) {
            val movedPosition = position.move()
            Car(name, movedPosition)
        } else {
            this
        }
    }

    companion object {
        fun from(carName: String): Car {
            return Car(CarName(carName))
        }
    }
}
