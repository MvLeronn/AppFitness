package co.mvleronn.fitnesstracker.extensions

import co.mvleronn.fitnesstracker.ImcCategory
import co.mvleronn.fitnesstracker.R

fun ImcCategory.toStringRes(): Int {
    return when (this) {
        ImcCategory.SEVERELY_LOW -> R.string.imc_severely_low_weight
        ImcCategory.VERY_LOW -> R.string.imc_very_low_weight
        ImcCategory.LOW -> R.string.imc_low_weight
        ImcCategory.NORMAL -> R.string.normal
        ImcCategory.HIGH -> R.string.imc_high_weight
        ImcCategory.VERY_HIGH -> R.string.imc_so_high_weight
        ImcCategory.SEVERELY_HIGH -> R.string.imc_severely_high_weight
        ImcCategory.EXTREME -> R.string.imc_extreme_weight
    }
}
