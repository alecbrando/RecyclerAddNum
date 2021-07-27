package com.alecbrando.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alecbrando.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.clickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.data.observe(this) { data ->

            val adapter = Adapter(this)
            binding.recycler.layoutManager = LinearLayoutManager(this)
            binding.recycler.adapter = adapter
            adapter.submitList(data)
            binding.fab.setOnClickListener {
                viewModel.addNum()
            }
        }

    }

    override fun itemClicked(num: Int) {
        Toast.makeText(this, "$num was clicked", Toast.LENGTH_SHORT).show()
    }


}