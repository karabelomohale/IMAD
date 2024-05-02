package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    private var btnHunger = 100
    private var btnClean = 10
    private var btnHappy = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main2)
        // Get the bottons and text views
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnClean2 = findViewById<Button>(R.id.btnClean)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val txtHunger = findViewById<EditText>(R.id.petHunger)
        val txtClean = findViewById<EditText>(R.id.petCleanliness)
        val txtHappy = findViewById<EditText>(R.id.petHappy)
        val petImage = findViewById<ImageView>(R.id.petImage)

        // Set the initial text values
        txtHunger.setText(btnHunger.toString())
        txtClean.setText(btnClean.toString())
        txtHappy.setText(btnHappy.toString())

        // Handle button clicks
        btnFeed.setOnClickListener {
            btnHunger -= 10
            btnHappy += 0
            btnHunger += 5
            txtHunger.setText(btnHunger.toString())
            animateImagechange(petImage, R.drawable.img_20240424_wa0013)
        }

        btnClean2.setOnClickListener {
            btnClean += 10
            btnHappy += 0

            txtClean.setText(btnClean.toString())
            animateImagechange(petImage, R.drawable.img_20240424_wa0007)
        }

        btnPlay.setOnClickListener {
            btnHappy += 10
            btnHunger -= 2
            btnClean -= 0
            txtHappy.setText(btnHappy.toString())
            animateImagechange(petImage, R.drawable.img_20240424_wa0006)
        }
    }

    private fun animateImagechange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
    
}