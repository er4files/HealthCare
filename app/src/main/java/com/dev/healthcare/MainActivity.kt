// java\com\dev\healthcare\MainActivity.kt
package com.dev.healthcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Mendeklarasikan usernameEditText dan passwordEditText di tingkat kelas
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menginisialisasi usernameEditText dan passwordEditText
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)

        // Mencari tampilan untuk loginButton dan signUpText
        val loginButton: Button = findViewById(R.id.loginButton)
        val signUpText: TextView = findViewById(R.id.signUpText)

        // Menetapkan listener klik untuk loginButton
        loginButton.setOnClickListener {
            // Mendapatkan username dan password dari bidang EditText
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Memeriksa apakah login valid
            if (isValidLogin(username, password)) {
                // Jika login berhasil, pindah ke HomeActivity
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivityForResult(intent, REGISTER_REQUEST_CODE)
            } else {
                // Jika login gagal, tampilkan pesan toast
                Toast.makeText(this@MainActivity, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }

        // Menetapkan listener klik untuk signUpText
        signUpText.setOnClickListener {
            // Jika teks SignUp diklik, pindah ke MainActivity2 (Register)
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivityForResult(intent, REGISTER_REQUEST_CODE)
        }
    }

    // Fungsi otentikasi
    private fun isValidLogin(username: String, password: String): Boolean {
        return username == "user" && password == "123"
    }

    // Konstanta untuk kode permintaan pendaftaran
    companion object {
        const val REGISTER_REQUEST_CODE = 1
    }

    // Metode ini akan dipanggil setelah mendaftar dari MainActivity2 (Register)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REGISTER_REQUEST_CODE && resultCode == RESULT_OK) {
            // Pendaftaran berhasil, dapatkan data yang dibutuhkan (jika ada)
            val registeredUsername = data?.getStringExtra(MainActivity2.EXTRA_USERNAME)
            val registeredEmail = data?.getStringExtra(MainActivity2.EXTRA_EMAIL)
            val registeredPassword = data?.getStringExtra(MainActivity2.EXTRA_PASSWORD)

            // Gunakan data yang didaftarkan, misalnya untuk mengisi formulir login
            usernameEditText.setText(registeredUsername)
            passwordEditText.setText(registeredPassword)

            // Tampilkan pesan ke pengguna atau lakukan tindakan lain yang diinginkan
            Toast.makeText(this, "Pendaftaran berhasil! Anda sekarang dapat login.", Toast.LENGTH_SHORT).show()
        }
    }
}
