package com.example.tugasretrofit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tugasretrofit.model.User
import com.squareup.picasso.Picasso

class UserAdapter(private val context: Context, private val users: List<User>) : BaseAdapter() {

    override fun getCount(): Int = users.size

    override fun getItem(position: Int): Any = users[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val user = users[position]

        val imgProfile = view.findViewById<ImageView>(R.id.img_profile)
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvEmail = view.findViewById<TextView>(R.id.tv_email)

        tvName.text = "Name: ${user.firstName} ${user.lastName}"
        tvEmail.text = "Email: ${user.email}"

        Picasso.get()
            .load(user.avatar)
            .into(imgProfile)

        view.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("avatar", user.avatar)
            intent.putExtra("name", "${user.firstName} ${user.lastName}")
            intent.putExtra("email", user.email)
            context.startActivity(intent)
        }

        return view
    }
}
