package com.niluogege.debug.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.niluogege.debug.R
import com.niluogege.debug.databinding.ActivityPagingBinding

class PagingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityPagingBinding>(this, R.layout.activity_paging)

        val viewModel=PagingViewModel()

        binding.rv.layoutManager=LinearLayoutManager(this)

        val adapter = PagingAdapter()

        binding.rv.adapter=adapter

        viewModel.getPagingData().observe(this, Observer {
            lifecycleScope.launchWhenCreated {
                adapter.submitData(it)
            }
        })

    }

}