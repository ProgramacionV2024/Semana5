package com.jalfaro.semana52024.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jalfaro.semana52024.R
import com.jalfaro.semana52024.adapter.ContactoAdapter
import com.jalfaro.semana52024.databinding.ActivityMainBinding
import com.jalfaro.semana52024.model.Contacto
import com.jalfaro.semana52024.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: ContactoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        adapter = ContactoAdapter(arrayListOf())
        binding.rvContactos.adapter = adapter
        binding.rvContactos.layoutManager = LinearLayoutManager(this)
        binding.rvContactos.setHasFixedSize(true)
        viewModel.listaContactos.observe(this) {
           adapter.showNewData(it)
        }
        viewModel.getContactos()
        setContentView(binding.root)
    }
}