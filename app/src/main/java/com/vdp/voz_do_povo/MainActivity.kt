package com.vdp.voz_do_povo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.graphics.Insets
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.vdp.shared.ApiClient
import kotlinx.coroutines.launch
import android.widget.ImageView
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.localizacao)

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonPublish = findViewById<LinearLayout>(R.id.layout_sugestion) // Exemplo

        buttonPublish.setOnClickListener {
            val intent = Intent(this, PublishActivity::class.java)
            startActivity(intent)
        }


        // Carregamento de imagens com Glide
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/bfl7llc9_expires_30_days.png")
            .into(findViewById(R.id.lupa))

        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/ifb659i8_expires_30_days.png")
            .into(findViewById(R.id.pin_location))

        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/oj1sqjui_expires_30_days.png")
            .into(findViewById(R.id.cardview_service))

        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/pvjaofmo_expires_30_days.png")
            .into(findViewById(R.id.cardview_av))

        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/nk003wvl_expires_30_days.png")
            .into(findViewById(R.id.cardview_publish))

        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/4t2dmn8z_expires_30_days.png")
            .into(findViewById(R.id.cardview_questions))



    }
}
