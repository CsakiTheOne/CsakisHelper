package com.csakitheone.csakishelperlibrary

import android.content.Context
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class FCMLegacyAPI(private val serverKey: String) {

    fun sendData(context: Context, targetTopic: String, data: JSONObject) {
        val topic = "/topics/$targetTopic"
        val api = "https://fcm.googleapis.com/fcm/send"

        val outerData = JSONObject("""{"to": "$topic"}""")

        outerData.put("data", data)

        val jsonObjectRequest = object: JsonObjectRequest(Method.POST, api, outerData, { }, { }) {
            override fun getHeaders(): MutableMap<String, String> {
                return mutableMapOf(
                    "Authorization" to "key=$serverKey",
                    "Content-Type" to "application/json"
                )
            }
        }

        Volley.newRequestQueue(context).add(jsonObjectRequest)
    }

    fun sendNotification(context: Context, targetTopic: String, title: String, body: String? = null) {
        val topic = "/topics/$targetTopic"
        val api = "https://fcm.googleapis.com/fcm/send"

        val notificationData = mutableMapOf(
            "title" to title,
        )
        if (!body.isNullOrEmpty()) notificationData["body"] = body

        val outerData = JSONObject("""{"to": "$topic"}""")
        outerData.put("notification", notificationData)

        val jsonObjectRequest = object: JsonObjectRequest(Method.POST, api, outerData, { }, { }) {
            override fun getHeaders(): MutableMap<String, String> {
                return mutableMapOf(
                    "Authorization" to "key=$serverKey",
                    "Content-Type" to "application/json"
                )
            }
        }

        Volley.newRequestQueue(context).add(jsonObjectRequest)
    }

}