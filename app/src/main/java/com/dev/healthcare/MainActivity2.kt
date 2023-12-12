package com.dev.healthcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Inisialisasi elemen-elemen UI dari layout
        val registerUsername: EditText = findViewById(R.id.registerUsername)
        val registerEmail: EditText = findViewById(R.id.registerEmail)
        val registerPassword: EditText = findViewById(R.id.registerPassword)
        val registerButton: Button = findViewById(R.id.registerButton)

        // Menetapkan listener klik untuk tombol pendaftaran
        registerButton.setOnClickListener {
            // Ambil data dari formulir pendaftaran
            val username = registerUsername.text.toString()
            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()

            // Kirim data hasil pendaftaran ke MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_USERNAME, username)
            resultIntent.putExtra(EXTRA_EMAIL, email)
            resultIntent.putExtra(EXTRA_PASSWORD, password)

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    companion object {
        // Konstanta untuk kunci data yang dikirimkan kembali ke MainActivity
        const val EXTRA_USERNAME = "EXTRA_USERNAME"
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
        const val EXTRA_PASSWORD = "EXTRA_PASSWORD"
    }
}
