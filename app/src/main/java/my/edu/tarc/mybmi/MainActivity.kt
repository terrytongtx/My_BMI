package my.edu.tarc.mybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val textviewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val imageViewBMI: ImageView = findViewById(R.id.imageView)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {
            textviewBMI.text = getString(R.string.under)
            if (editTextWeight.text.trim().isEmpty()) {
                editTextWeight.setError(getString(R.string.error_input))
                return@setOnClickListener
            }
            if (editTextHeight.text.isEmpty()) {
                editTextHeight.setError(getString(R.string.error_input))
                return@setOnClickListener
            }
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height: Float = editTextHeight.text.toString().toFloat() / 100
            val bmi: Float = weight / height.pow(2)
            if (bmi < 18.5) {
                textviewBMI.text = String.format("%s: %.2f", getString(R.string.bmi), bmi)
                textViewStatus.text = getString((R.string.under))
                imageViewBMI.setImageResource(R.drawable.under)
            }

        }

        buttonReset.setOnClickListener {
            editTextHeight.text.clear()
            editTextWeight.text.clear()
            textViewStatus.text = getString(R.string.status)
            textviewBMI.text = getString(R.string.bmi)
            imageViewBMI.setImageResource(R.drawable.empty)
        }
    }
}