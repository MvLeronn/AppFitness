package co.mvleronn.fitnesstracker

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.doubles.plusOrMinus

class ImcCalculatorTest : StringSpec({

    "deve calcular imc corretamente" {
        val result = ImcCalculator.calculateImc(70, 170)
        result shouldBe 24.22.plusOrMinus(0.01)
    }

    "deve retornar Severely Low para imc < 15.0" {
        ImcCalculator.imcResponse(14.9) shouldBe ImcCategory.SEVERELY_LOW
    }

    "deve retornar Very Low para imc entre 15.0 e 16.0" {
        ImcCalculator.imcResponse(15.5) shouldBe ImcCategory.VERY_LOW
    }

    "deve retornar Low para imc entre 16.0 e 18.5" {
        ImcCalculator.imcResponse(17.0) shouldBe ImcCategory.LOW
    }

    "deve retornar Normal para imc entre 18.5 e 25.0" {
        ImcCalculator.imcResponse(22.0) shouldBe ImcCategory.NORMAL
    }

    "deve retornar High para imc entre 25.0 e 30.0" {
        ImcCalculator.imcResponse(27.0) shouldBe ImcCategory.HIGH
    }

    "deve retornar Very High para imc entre 30.0 e 35.0" {
        ImcCalculator.imcResponse(32.0) shouldBe ImcCategory.VERY_HIGH
    }

    "deve retornar Severely High para imc entre 35.0 e 40.0" {
        ImcCalculator.imcResponse(37.0) shouldBe ImcCategory.SEVERELY_HIGH
    }

    "deve retornar Extreme para imc >= 40.0" {
        ImcCalculator.imcResponse(42.0) shouldBe ImcCategory.EXTREME
    }

    "deve lançar IllegalArgumentException quando altura(height) for 0" {
        val exception = shouldThrow<IllegalArgumentException> {
            ImcCalculator.calculateImc(70, 0)
        }
        exception.message shouldBe "A altura deve ser um valor positivo."
    }

    "deve lançar IllegalArgumentException quando peso(weight) for 0" {
        val exception = shouldThrow<IllegalArgumentException> {
            ImcCalculator.calculateImc(0, 170)
        }
        exception.message shouldBe "O peso deve ser um valor positivo."
    }

    "deve lançar IllegalArgumentException quando altura(height) for negativa" {
        val exception = shouldThrow<IllegalArgumentException> {
            ImcCalculator.calculateImc(70, -10)
        }
        exception.message shouldBe "A altura deve ser um valor positivo."
    }

    "deve lançar IllegalArgumentException quando peso(weight) for negativo" {
        val exception = shouldThrow<IllegalArgumentException> {
            ImcCalculator.calculateImc(-5, 170)
        }
        exception.message shouldBe "O peso deve ser um valor positivo."
    }
})
