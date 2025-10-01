package com.vdp.shared

import kotlinx.serialization.json.JsonElement
import retrofit2.http.GET

interface ApiServiceRetrofit {
    @GET("/voz-do-povo/email")
    suspend fun getAnswer(): JsonElement
}