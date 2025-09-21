package com.vdp.voz_do_povo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.vdp.shared.ApiClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        lifecycleScope.launch {
            try {
                val answer = ApiClient.api.getAnswer()
                val answerText  = answer.string()
                textView.text = answerText
                println(answerText)
            } catch (e: Exception) {
                Log.e("ApiError", e.toString())
            }
        }
    }
}
