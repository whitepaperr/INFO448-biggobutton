package edu.uw.ischool.haeun.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    private var count = 0
    private var isAnimationRunning = false
    private lateinit var animation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_in_out)

        button.setOnClickListener {
            count++
            button.text = resources.getString(if (count == 1) R.string.pushed_once else R.string.pushed_multiple, count)

            val rnd = java.util.Random()
            val bColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            var tColor: Int
            do {
                tColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            } while (tColor == bColor)
            button.setBackgroundColor(bColor)
            button.setTextColor(tColor)

            if (!isAnimationRunning) {
                button.startAnimation(animation)
                isAnimationRunning = true
            } else {
                button.clearAnimation()
                isAnimationRunning = false
            }
        }
    }
}