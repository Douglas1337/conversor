package com.br.conversor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.br.conversor.R
import com.br.conversor.databinding.ActivityMainBinding
import com.br.conversor.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityMainBinding

    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.Calculate.setOnClickListener(this)

        setObserver()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.Calculate){
            val valueIn = binding.edtValueIn.text.toString()
            viewModel.Calculate(valueIn)
        }
    }

    private fun setObserver() {
        viewModel.valueOut.observe(this, Observer {
            binding.edtValueOut.text = it.valor.toString()
        })
    }
}
