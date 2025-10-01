package com.vdp.shared

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiClient {

    //private const val BASE_URL = "http://10.0.2.2:8080/" //execução local
    private const val BASE_URL = "http://192.168.1.232:8080/" //execução no celular ->IP-pc:server-port

    private val json = Json { ignoreUnknownKeys = true }

    val api: ApiServiceRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        // Adiciona o conversor para que o Retrofit saiba como criar o objeto Answer
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(ApiServiceRetrofit::class.java)
}