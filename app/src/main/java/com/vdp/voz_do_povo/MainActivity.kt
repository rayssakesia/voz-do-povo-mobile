package com.vdp.voz_do_povo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.vdp.shared.ApiClient
import com.vdp.shared.utils.extractValue
import kotlinx.coroutines.launch
class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        lifecycleScope.launch {
            try {
                val jsonElement = ApiClient.api.getAnswer()
                val username: String? = jsonElement.extractValue("userRequest", "name")
                if (username != null) {
                    textView.text = "Olá, $username!"
                } else {
                    textView.text = "Nome de usuário não encontrado"
                }
            } catch (e: Exception) {
                Log.e("ApiError", e.toString())
                textView.text = "Ocorreu um erro: ${e.message}"
            }
        }
    }
}
