package com.br.apptopicos.manager

import android.content.Context
import com.br.apptopicos.model.Usuario
import org.json.JSONArray

/**
 * Created by Mateus Marquezini on 28/10/2016.
 */
class JsonManager constructor(val context: Context) {

    fun carregaUsuario(jsonFile: String): MutableList<Usuario> {

        val listaUsuarios: MutableList<Usuario> = mutableListOf(Usuario())

        try {

            val jsonUsuario = JSONArray(jsonFile)
            for ((indice, elemento) in jsonFile.withIndex()) {
                val jsonObject = jsonUsuario.getJSONObject(indice)
                val usuario = Usuario()
                usuario.nome = jsonObject.getString("NomeUsuario")
                usuario.senha = jsonObject.getInt("Senha")

                listaUsuarios.add(usuario)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return listaUsuarios
    }
}