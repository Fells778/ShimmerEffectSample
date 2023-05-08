package com.example.shimmereffectsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shimmereffectsample.databinding.ActivityMainBinding
import com.example.shimmereffectsample.helpers.Dummy

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMain: AdapterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        handleShimmerEffect()

    }

    private fun handleShimmerEffect() {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            binding.apply {
                recyclerViewMain.isVisible = true
                shimmerFrameLayout.isVisible = false
            }
        }, 2000)
    }

    private fun initRecyclerView() {
        adapterMain = AdapterMainActivity(Dummy.charactersList, applicationContext)
        binding.recyclerViewMain.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            adapter = adapterMain
        }
    }
}