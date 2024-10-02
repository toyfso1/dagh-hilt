package com.example.dagh_hilt.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dagh_hilt.R
import com.example.dagh_hilt.adapter.UserAdapter
import com.example.dagh_hilt.databinding.ActivityMainBinding
import com.example.dagh_hilt.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter
    private lateinit var binding: ActivityMainBinding // Khai báo biến ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Khởi tạo ViewBinding
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Quan sát dữ liệu từ ViewModel
        userViewModel.users.observe(this, { users ->
            userAdapter = UserAdapter(users)
            binding.recyclerView.adapter = userAdapter // Sử dụng ViewBinding
        })
    }
}