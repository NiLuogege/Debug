package com.niluogege.debug.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.niluogege.debug.App
import com.niluogege.debug.R
import com.niluogege.debug.databinding.ActivityDaggerBinding
import com.niluogege.debug.di.*
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class DaggerActivity : AppCompatActivity() {
    @Named("Car2")
    @Inject
    lateinit var car:Lazy<Car>

    @Named("Car1")
    @Inject
    lateinit var car2:Provider<Car>

    @Named("Car1")
    @Inject
    lateinit var car3:Provider<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val manC = DaggerManComponent.builder().build()
        val sonComponent = manC.sonComponent().build()
        val son=Son()
        sonComponent.inject(son)



        App.build.inject(this)

        val binding = DataBindingUtil.setContentView<ActivityDaggerBinding>(this, R.layout.activity_dagger)

        binding.tv.setOnClickListener {
        }

        binding.btn.setOnClickListener {

            son.bike.go()
            son.car.speak()

        }
    }
}