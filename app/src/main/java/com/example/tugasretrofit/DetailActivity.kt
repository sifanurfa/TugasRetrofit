package com.example.tugasretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugasretrofit.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val avatar = intent.getStringExtra("avatar")
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        with(binding) {
            tvName.text = name
            tvEmail.text = email
            Picasso.get().load(avatar).into(imgProfile)
        }
    }
}