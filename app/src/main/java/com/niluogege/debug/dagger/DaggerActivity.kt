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
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Provider

class DaggerActivity : AppCompatActivity() {
    @Inject
    lateinit var car:Lazy<Car>

    @Inject
    lateinit var car2:Provider<Car>

    @Inject
    lateinit var car3:Provider<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerDemoComponent.builder().demoModule(DemoModule(application)).build()
        component.inject(this)

        val binding = DataBindingUtil.setContentView<ActivityDaggerBinding>(this, R.layout.activity_dagger)

        binding.tv.setOnClickListener {
        }

        binding.btn.setOnClickListener {
            val get = car.get()
            get.print()
            get.speak()

            println("1= ${car.get()} 2= ${car2.get()} 3= ${car3.get()}")
        }
    }
}