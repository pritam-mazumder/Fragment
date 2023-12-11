package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFrag(FragmentA(), 0)

        binding.btnFrag1.setOnClickListener {
            loadFrag(FragmentA(), 1)
        }

        binding.btnFrag2.setOnClickListener {
            loadFrag(FragmentB(), 1)
        }

        binding.btnFrag3.setOnClickListener {
            loadFrag(FragmentC(), 1)
        }
    }

    private fun loadFrag(fragments: Fragment, flag: Int) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        if (flag == 0) ft.add(R.id.container, fragments)
        else ft.replace(R.id.container, fragments)

        ft.commit()
    }
}