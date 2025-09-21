package com.vdp.shared

import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiServiceRetrofit {
    @GET("/voz-do-povo/email")
    suspend fun getAnswer(): ResponseBody
}