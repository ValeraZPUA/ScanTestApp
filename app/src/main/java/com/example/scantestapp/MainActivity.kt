package com.example.scantestapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val view = findViewById<View>(R.id.layout_content)

        view.post {
            val location = IntArray(2)
            view.getLocationOnScreen(location)

            val viewBottomY = location[1] + view.height

            val screenHeight = resources.displayMetrics.heightPixels

            val distanceFromBottom = screenHeight - viewBottomY

            val bottomSheet: FrameLayout = findViewById(R.id.bottom_sheet)
            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            bottomSheetBehavior.peekHeight = distanceFromBottom
/*

            val maxDesiredHeight =
                (resources.displayMetrics.heightPixels * 0.8).toInt()
            if (bottomSheet.height > maxDesiredHeight) {
                val bottomSheetLayoutParams = bottomSheet.layoutParams
                bottomSheetLayoutParams.height = maxDesiredHeight
                bottomSheet.layoutParams = bottomSheetLayoutParams
            }*/

        }



    }
}