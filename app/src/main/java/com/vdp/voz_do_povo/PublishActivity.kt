package com.vdp.voz_do_povo

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PublishActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_publish)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonCancel = findViewById<TextView>(R.id.cancelBtn) // Exemplo

        buttonCancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val myCheckBox = findViewById<CheckBox>(R.id.cb_anon)
        val myEditText = findViewById<EditText>(R.id.name)

        // Set a listener for when the CheckBox's checked state changes
        myCheckBox.setOnCheckedChangeListener { _, isChecked ->
            // Enable or disable the EditText based on the CheckBox's state
            myEditText.isEnabled = false
            
        }

        /*Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/xib0rdtx_expires_30_days.png").into(findViewById(R.id.rnppf8l5mhv))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/hti0f4tn_expires_30_days.png").into(findViewById(R.id.rcj9f96khujj))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/MPmXvsjEUU/5ox6pii1_expires_30_days.png").into(findViewById(R.id.r1ltraq09agb))
         */

        // Exemplo em Kotlin
        val editText = findViewById<EditText>(R.id.edtTextField)
        val contadorTextView = findViewById<TextView>(R.id.textCount)

        editText.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Não é necessário fazer nada antes da mudança
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Nada a fazer aqui
            }

            override fun afterTextChanged(s: Editable?) {
                // Atualiza o TextView com a contagem de caracteres
                val count = s?.length ?: 0 // Obtém o comprimento da string, 0 se for nulo
                contadorTextView.text = "$count/250"
            }

        })

        val spinner = findViewById<Spinner>(R.id.selectionT)
        ArrayAdapter.createFromResource(
            this,
            R.array.themes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.setSelection(0, true)
        val view: View = spinner.getSelectedView()
        (view as TextView).setTextColor(Color.parseColor("#555555"))

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                // Change the selected item's text color
                (view as TextView).setTextColor(Color.parseColor("#555555"))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })

    }
}