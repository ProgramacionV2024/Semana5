package com.jalfaro.semana52024.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jalfaro.semana52024.databinding.ContactoRowLayoutBinding
import com.jalfaro.semana52024.model.Contacto

class ContactoAdapter(val contactos: ArrayList<Contacto>): RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {
    class ContactoViewHolder(val binding: ContactoRowLayoutBinding ):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder =
        ContactoViewHolder(ContactoRowLayoutBinding.inflate(LayoutInflater.from(parent.context)))


    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
       holder.binding.txtNombre.text = contactos[position].nombre
       holder.binding.txtTelefono.text = contactos[position].telefono
       holder.binding.txtSexo.text = if (contactos[position].sexo) "Femenino" else "Masculino"
    }

    fun showNewData(newContactos: List<Contacto>) {
        contactos.clear()
        contactos.addAll(newContactos)s
    }
}