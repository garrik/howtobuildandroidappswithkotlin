package it.garrik.howtobuildandroidappswithkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.create_color)?.setOnClickListener {
            val red = findViewById<TextInputEditText>(R.id.red_channel_text)?.text.toString()
            val green = findViewById<TextInputEditText>(R.id.green_channel_text)?.text.toString()
            val blue = findViewById<TextInputEditText>(R.id.blue_channel_text)?.text.toString()

            val alpha = "#"
            val colorHex = alpha.plus(red).plus(green).plus(blue)

            if (colorHex.length == 7) {
                Toast.makeText(this,
                    "color code is ".plus(colorHex), Toast.LENGTH_SHORT).show()
                val c = Color.parseColor(colorHex)
                findViewById<TextView>(R.id.color_panel_view)?.setBackgroundColor(c)
            }
            else {
                Toast.makeText(this,
                    "insert two digit for each channel, please", Toast.LENGTH_SHORT).show()
            }
        }
    }
}