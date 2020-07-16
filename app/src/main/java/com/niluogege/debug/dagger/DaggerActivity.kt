package com.niluogege.debug.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.niluogege.debug.App
import com.niluogege.debug.R
import com.niluogege.debug.databinding.ActivityDaggerBinding
import com.niluogege.debug.di.Car
import com.niluogege.debug.di.DaggerDemoComponent
import com.niluogege.debug.di.DemoModule
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerDemoComponent.builder().build()
        component.inject(this)

        val binding = DataBindingUtil.setContentView<ActivityDaggerBinding>(this, R.layout.activity_dagger)

        binding.tv.setOnClickListener {
        }

        binding.btn.setOnClickListener {
            car.print()
        }
    }
}