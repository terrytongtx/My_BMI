package my.edu.tarc.mybmi

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaration of variables

        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHight: EditText = findViewById(R.id.editTextHeight)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val imageViewBMI: ImageView = findViewById(R.id.imageView)
        val buttonCal: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonCal.setOnClickListener {
            if (editTextWeight.text.isEmpty()) {
                editTextWeight.setError(getString(R.string.error_input))
                return@setOnClickListener //terminate program execution
            }
            if (editTextHight.text.isEmpty()) {
                editTextHight.setError(getString(R.string.error_input))
                return@setOnClickListener
            }

            val weight: Float = editTextWeight.text.toString().toFloat()
            val hight: Float = editTextHight.text.toString().toFloat()
            val bmi = weight / (hight / 100).pow(2)

            if (bmi <= 18.5) {
                imageViewBMI.setImageResource(R.drawable.under)
                textViewStatus.text = String.format("%s", getString(R.string.under))

            } else if (bmi <= 24.9) {
                imageViewBMI.setImageResource(R.drawable.normal)
                textViewStatus.text = String.format("%s", getString(R.string.normal))
            } else {
                imageViewBMI.setImageResource(R.drawable.over)
                textViewStatus.text = String.format("%s", getString(R.string.over))


            }


            textViewBMI.text = String.format("%s: %.2f", getString(R.string.bmi), bmi) //BMI : 18.45

        }

        buttonReset.setOnClickListener {
            textViewBMI.text = String.format("%s", getString(R.string.bmi)) //BMI : 18.45
            textViewStatus.text = String.format("%s", getString(R.string.status)) //BMI : 18.45

            editTextHight.text.clear()
            editTextWeight.text.clear()
            imageViewBMI.setImageResource(R.drawable.empty)


        }

    }
}