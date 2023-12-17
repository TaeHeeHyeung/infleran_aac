package com.project.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.project.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val factory = MyViewModelFactory(100, this)
        val myViewModel: MyViewModel by viewModels<MyViewModel> { factory }
        binding.tvCount.text = myViewModel.counter.toString()

        binding.btnPlus.setOnClickListener {
            myViewModel.counter += 1
            myViewModel.saveState()
            binding.tvCount.text = myViewModel.counter.toString()
        }

//        MyViewModelFactory
    }
}