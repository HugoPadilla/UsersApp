package com.example.usersapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.databinding.ActivityMainBinding
import com.example.usersapp.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter = UserAdapter()
        val linearlayout = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = linearlayout
        binding.recycler.adapter = adapter


        viewModel.users.observe(this) {
            adapter.setData(it)
        }

    }
}