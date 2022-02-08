package com.csakitheone.csakishelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.Toast
import androidx.core.view.setPadding
import com.csakitheone.csakishelper.databinding.ActivityMainBinding
import com.csakitheone.csakishelperlibrary.Dialogs
import com.csakitheone.csakishelperlibrary.Helper
import com.csakitheone.csakishelperlibrary.Helper.Companion.asDp
import com.csakitheone.csakishelperlibrary.Helper.Companion.toEditable

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onBtnDialogMessageIsMiuiClick(view: View) {
        Dialogs.showMessage(this, "> isMiui()\n< ${Helper.isMiui()}") {}
    }

    fun onBtnAsDpClick(view: View) {
        var padding = binding.mainEditAsDp.text.toString().toIntOrNull() ?: 0
        if (padding > 64) {
            padding = 64
            binding.mainEditAsDp.text = "64".toEditable()
        }
        binding.mainLayoutAsDp.setPadding(padding.asDp)
    }
}