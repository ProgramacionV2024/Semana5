package com.jalfaro.semana52024.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jalfaro.semana52024.model.Contacto

class MainViewModel: ViewModel() {

    private val _listaContactos = MutableLiveData<ArrayList<Contacto>>(arrayListOf())
    val listaContactos : LiveData<ArrayList<Contacto>> = _listaContactos

    fun getContactos() {
        val lista: List<Contacto> = listOf(
            Contacto("Julio Alfaro", "55553333", false),
            Contacto("Maria Perez", "44449999", true),
            Contacto("Pedro Suarez", "66669999", false),
            Contacto("Rosa Gomez", "66669999", true),
            Contacto("Juan Juarez", "66669999", false)
        )
        _listaContactos.value?.clear()
        _listaContactos.value?.addAll(lista.toTypedArray())
    }
}