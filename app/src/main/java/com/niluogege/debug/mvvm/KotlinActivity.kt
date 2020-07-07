package com.niluogege.debug.mvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.niluogege.debug.R
import com.niluogege.debug.databinding.ActivityKotlinBinding
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityKotlinBinding>(this, R.layout.activity_kotlin)
        val vm = KotlinVm(this)
        binding.viewModel = vm
        vm.text.set("wawaaww")
    }


}