package com.alecbrando.recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alecbrando.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.clickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private var layoutstyle = 1

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_layout_style -> {
                if(layoutstyle == 0){
                    item.title = "Grid"
                    binding.recycler.layoutManager = LinearLayoutManager(this)
                    layoutstyle = 1
                } else {
                    item.title = "Linear"
                    binding.recycler.layoutManager = GridLayoutManager(this, 2)
                    layoutstyle = 0
                }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun itemClicked(num: Int) {
        Toast.makeText(this, "$num was clicked", Toast.LENGTH_SHORT).show()
    }


}