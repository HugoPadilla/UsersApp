package com.example.usersapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.databinding.ItemUserBinding
import com.example.usersapp.domain.models.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder>() {

    private var listUserOrigin: ArrayList<User> = ArrayList()

    fun setData(listUser: List<User>) {
        listUserOrigin.clear()
        listUserOrigin.addAll(listUser)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.tvName.text = user.name
            binding.tvUserName.text = user.username
            binding.tvEmail.text = user.email
            binding.tvPhone.text = user.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listUserOrigin.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = listUserOrigin[position]
        holder.bind(item)
    }

}