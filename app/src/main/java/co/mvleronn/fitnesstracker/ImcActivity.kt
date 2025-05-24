package co.mvleronn.fitnesstracker

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import co.mvleronn.fitnesstracker.extensions.toStringRes


class ImcActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        editWeight = findViewById(R.id.edit_imc_weight)
        editHeight = findViewById(R.id.edit_imc_height)

        val btnSend: Button = findViewById(R.id.btn_imc_send)
        btnSend.setOnClickListener {
            handleCalculateClick()
        }
    }

    private fun handleCalculateClick() {
        if (!validate()) {
            Toast.makeText(this, R.string.fields_message, Toast.LENGTH_SHORT).show()
            return
        }

        val weight = editWeight.text.toString().toInt()
        val height = editHeight.text.toString().toInt()

        val result = ImcCalculator.calculateImc(weight, height)
        val imcCategory = ImcCalculator.imcResponse(result)

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.imc_response, result))
            .setMessage(getString(imcCategory.toStringRes()))
            .setPositiveButton(android.R.string.ok, null)
            .create()
            .show()

        hideKeyboard()
    }

    private fun validate(): Boolean {
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && editWeight.text.toString() != "0"
                && editHeight.text.toString() != "0")
    }

    private fun hideKeyboard() {
        val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}
