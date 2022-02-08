package com.csakitheone.csakishelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csakitheone.csakishelperlibrary.Helper.Companion.asDp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        16.asDp
    }
}