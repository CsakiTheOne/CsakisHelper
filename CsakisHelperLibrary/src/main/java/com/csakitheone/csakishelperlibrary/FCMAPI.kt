package com.csakitheone.csakishelperlibrary

import android.content.Context
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class FCMAPI(private val firebaseProjectId: String, oauthToken: String) {

    private val token = if (oauthToken.startsWith("Bearer")) oauthToken
    else "Bearer $oauthToken"

    fun sendData(context: Context, targetTopic: String, data: Map<String, Any>) {
        val api = "https://fcm.googleapis.com/v1/projects/$firebaseProjectId/messages:send"

        val outerData = JSONObject(mapOf("message" to mapOf(
            "topic" to targetTopic,
            "data" to data,
        )))

        val jsonObjectRequest = object: JsonObjectRequest(Method.POST, api, outerData, { }, { }) {
            override fun getHeaders(): MutableMap<String, String> {
                return mutableMapOf(
                    "Authorization" to "key=$token",
                    "Content-Type" to "application/json"
                )
            }
        }

        Volley.newRequestQueue(context).add(jsonObjectRequest)
    }

    fun sendNotification(context: Context, targetTopic: String, data: Map<String, Any>, title: String, body: String? = null) {
        val api = "https://fcm.googleapis.com/v1/projects/$firebaseProjectId/messages:send"

        val notificationData = mutableMapOf(
            "title" to title,
        )
        if (!body.isNullOrEmpty()) notificationData["body"] = body

        val outerData = JSONObject(mapOf("message" to mapOf(
            "topic" to targetTopic,
            "notification" to notificationData,
        )))

        val jsonObjectRequest = object: JsonObjectRequest(Method.POST, api, outerData, { }, { }) {
            override fun getHeaders(): MutableMap<String, String> {
                return mutableMapOf(
                    "Authorization" to "key=$token",
                    "Content-Type" to "application/json"
                )
            }
        }

        Volley.newRequestQueue(context).add(jsonObjectRequest)
    }

}