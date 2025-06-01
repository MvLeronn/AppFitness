package co.mvleronn.fitnesstracker

class ImcCalculator {
    companion object {
        fun calculateImc(weight: Int, height: Int): Double {
            // Verifica entradas numéricas inválidas
            if (height <= 0) {
                throw IllegalArgumentException("A altura deve ser um valor positivo.")
            }
            if (weight <= 0) {
                throw IllegalArgumentException("O peso deve ser um valor positivo.")
            }

            return weight / ((height / 100.0) * (height / 100.0))
        }

        fun imcResponse(imc: Double): ImcCategory {
            return when {
                imc < 15.0 -> ImcCategory.SEVERELY_LOW
                imc < 16.0 -> ImcCategory.VERY_LOW
                imc < 18.5 -> ImcCategory.LOW
                imc < 25.0 -> ImcCategory.NORMAL
                imc < 30.0 -> ImcCategory.HIGH
                imc < 35.0 -> ImcCategory.VERY_HIGH
                imc < 40.0 -> ImcCategory.SEVERELY_HIGH
                else -> ImcCategory.EXTREME
            }
        }
    }
}

enum class ImcCategory {
    SEVERELY_LOW,
    VERY_LOW,
    LOW,
    NORMAL,
    HIGH,
    VERY_HIGH,
    SEVERELY_HIGH,
    EXTREME
}