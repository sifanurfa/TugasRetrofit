package com.example.tugasretrofit

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugasretrofit.databinding.ActivityMainBinding
import com.example.tugasretrofit.model.Data
import com.example.tugasretrofit.model.User
import com.example.tugasretrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()

        response.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.body() != null) {
                    val users = response.body()!!.data
                    val adapter = UserAdapter(this@MainActivity, users)
                    binding.lvNama.adapter = adapter
                } else {
                    Toast.makeText(this@MainActivity, "Data not found", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error", Toast.LENGTH_LONG).show()
            }
        })
    }
}