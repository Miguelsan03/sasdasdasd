package com.example.qta2

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.navArgs


class DosMitadesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvSaludo = view.findViewById<TextView>(R.id.tvSaludo)

        val correo = arguments?.getString("Correo") ?: ""

        tvSaludo.text = "Hola $correo"

        val instruccionesText = getString(R.string.instrucciones_mitades)
        view.findViewById<TextView>(R.id.instruccionesTextView).text =  Html.fromHtml(instruccionesText, Html.FROM_HTML_MODE_COMPACT)
    }
}


