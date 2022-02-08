package com.csakitheone.csakishelperlibrary

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class QuickSetup {
    companion object {

        /** Helps you setup a new project. */
        fun showDialog(context: Context) {
            MaterialAlertDialogBuilder(context)
                .setTitle("Step 1: viewBinding")
                .setMessage("Enable viewBinding:\nbuildFeatures {\n\tviewBinding true\n}")
                .setPositiveButton("Next") { _,_ -> step2(context) }
                .setCancelable(false)
                .create().show()
        }

        private fun step2(context: Context) {
            MaterialAlertDialogBuilder(context)
                .setTitle("Step 2: Main bind")
                .setMessage("lateinit var binding: ActivityMainBinding\n\nbinding = ActivityMainBinding.inflate(layoutInflater)")
                .setPositiveButton("Next") { _,_ -> step3(context) }
                .setCancelable(false)
                .create().show()
        }

        private fun step3(context: Context) {
            MaterialAlertDialogBuilder(context)
                .setTitle("Step 3: Theme")
                .setMessage("Material3")
                .setPositiveButton("Next") { _,_ -> end(context) }
                .setCancelable(false)
                .create().show()
        }

        private fun end(context: Context) {
            MaterialAlertDialogBuilder(context)
                .setTitle("Setup done")
                .setMessage("Remove the helper line from the code and rebuild the app.")
                .setCancelable(false)
                .create().show()
        }

    }
}