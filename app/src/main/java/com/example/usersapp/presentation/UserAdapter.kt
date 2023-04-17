package com.example.usersapp.presentation

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.databinding.ItemUserBinding
import com.example.usersapp.domain.models.User
import java.util.*
import java.util.stream.Collectors

class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder>() {

    private var listUser: ArrayList<User> = ArrayList()
    private var listUserOrigin: ArrayList<User> = ArrayList()

    fun setData(listUser: List<User>) {
        this.listUser.clear()
        this.listUser.addAll(listUser)
        listUserOrigin.clear()
        listUserOrigin.addAll(listUser)
        notifyDataSetChanged()
    }

    /**
     * Filters the list of users [listUser] based on the provided [queryText].
     * If [queryText] is an empty string, the list [listUser] is restored to its original state [listUserOrigin].
     * Otherwise, the list [listUser] is searched for all [User] objects whose name contains [queryText] (ignoring case).
     * The result is saved in a new list named "collection".
     *
     * If the SDK version is lower than N, the search is performed through a "for" loop over the [listUserOrigin] list and matching elements are added to the [listUser] list.
     * Otherwise, the search is performed using the Stream API.
     *
     * The [notifyDataSetChanged()] method is called after updating the [listUser] list to reflect the changes in the corresponding view.
     *
     * @param queryText Text string used to filter the list of users.
     */
    fun filter(queryText: String) {
        val lengthText = queryText.length
        if (lengthText == 0) {
            listUser.clear()
            listUser.addAll(listUserOrigin)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val collection: List<User> = listUser.stream()
                    .filter { user ->
                        user.name.lowercase()
                            .contains(queryText.lowercase(Locale.getDefault()))
                    }
                    .collect(Collectors.toList())
                listUser.clear()
                listUser.addAll(collection)
            } else {
                for (user in listUserOrigin) {
                    if (user.name.lowercase()
                            .contains(queryText.lowercase(Locale.getDefault()))
                    ) {
                        listUser.add(user)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.tvNameInitial.text = user.name.subSequence(0, 1)
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
        return listUser.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = listUser[position]
        holder.bind(item)
    }

}