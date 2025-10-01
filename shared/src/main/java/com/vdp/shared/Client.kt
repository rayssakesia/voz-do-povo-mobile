package com.vdp.shared

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiClient {

    //private const val BASE_URL = "http://10.0.2.2:8080/" //execução local
    private const val BASE_URL = "http://(IP-do-pc):8080/" //execução no celular ->IP-pc:server-port
    private val json = Json { ignoreUnknownKeys = true }

    val api: ApiServiceRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(ApiServiceRetrofit::class.java)
}