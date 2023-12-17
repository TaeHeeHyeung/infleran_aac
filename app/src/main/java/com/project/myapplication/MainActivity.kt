package com.project.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.project.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setContentView(binding.root)

        val factory = MyViewModelFactory(0, this)
        val myViewModel: MyViewModel by viewModels<MyViewModel> { factory }
        binding.viewmodel = myViewModel;
        binding.lifecycleOwner = this;

        binding.btnPlus.setOnClickListener {
            myViewModel.liveCounter.value = myViewModel.liveCounter.value?.plus(1)
        }

        myViewModel.modifiedCounter.observe(this) { counter ->
            binding.tvCount.text = counter.toString()
        }

    }//end onCreate
}