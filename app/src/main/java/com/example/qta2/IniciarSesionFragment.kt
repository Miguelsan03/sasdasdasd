package com.example.qta2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText


class IniciarSesionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usuarioEditText = view.findViewById<TextInputEditText>(R.id.usuarioEditText)
        val textoIngresado = usuarioEditText.text.toString()

        view.findViewById<Button>(R.id.btnIniciarSesion).setOnClickListener {
            val bundle = bundleOf("Correo" to textoIngresado)
            findNavController().navigate(
                R.id.action_iniciarSesionFragment2_to_dosMitadesFragment,
                bundle
            )

        }
        view.findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}