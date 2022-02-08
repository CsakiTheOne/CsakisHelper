package com.csakitheone.csakishelperlibrary

import android.content.res.Resources.getSystem
import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Helper {
    companion object {
        /** Converts a *px* value to *dp*. */
        val Int.asDp: Int get() = (this * getSystem().displayMetrics.density).toInt()

        /** Checks if the running device has a MIUI based system. */
        fun isMiUi(): Boolean {
            return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"))
        }

        private fun getSystemProperty(propName: String): String? {
            val line: String
            var input: BufferedReader? = null
            try {
                val p = Runtime.getRuntime().exec("getprop $propName")
                input = BufferedReader(InputStreamReader(p.inputStream), 1024)
                line = input.readLine()
                input.close()
            } catch (ex: IOException) {
                return null
            } finally {
                if (input != null) {
                    try {
                        input.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
            return line
        }
    }
}