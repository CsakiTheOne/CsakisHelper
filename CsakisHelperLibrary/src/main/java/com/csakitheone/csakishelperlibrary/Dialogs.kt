package com.csakitheone.csakishelperlibrary

import android.content.Context
import android.content.DialogInterface
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Dialogs {
    companion object {

        /** Shows a simple dialog with a message. */
        fun showMessage(context: Context, message: String, hasOkButton: Boolean = true, callback: (isOkPressed: Boolean) -> Unit) {
            MaterialAlertDialogBuilder(context)
                .setMessage(message)
                .setOnCancelListener { callback(false) }
                .setPositiveButton("Ok") { _, _ -> callback(true) }
                .create().show()
        }

    }
}