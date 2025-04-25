package com.example.qta2

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class quitarFragmentoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quitar_fragmento, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSaludo = view.findViewById<TextView>(R.id.mensajeSaludo3)

        val correo = arguments?.getString("Correo") ?: ""
        tvSaludo.text = getString(R.string.hola2, correo)

        val instruccionesText = getString(R.string.quitar_fragmento)
        view.findViewById<TextView>(R.id.instrucciones3TextView).text =  Html.fromHtml(instruccionesText, Html.FROM_HTML_MODE_COMPACT)

        fun navigateWithCorreo(destinationId: Int, correo: String) {
            when (destinationId) {
                R.id.dosMitadesFragment -> {
                    findNavController().navigate(
                        R.id.dosMitadesFragment,
                        bundleOf("Correo" to correo)
                    )
                }
                R.id.dosPalabrasFragment -> {
                    findNavController().navigate(
                        R.id.dosPalabrasFragment,
                        bundleOf("Correo" to correo)
                    )
                }
                R.id.quitarFragmentoFragment -> {
                    findNavController().navigate(
                        R.id.quitarFragmentoFragment,
                        bundleOf("Correo" to correo)
                    )
                }

            }
        }

        view.findViewById<BottomNavigationView>(R.id.bottom_navigation).apply {
            selectedItemId = R.id.quitarFragmentoNav

            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.dosMitadesNav -> {
                        navigateWithCorreo(R.id.dosMitadesFragment, correo)
                        true
                    }
                    R.id.dosPalabrasNav -> {
                        navigateWithCorreo(R.id.dosPalabrasFragment, correo)
                        true
                    }
                    R.id.quitarFragmentoNav -> {
                        navigateWithCorreo(R.id.quitarFragmentoFragment, correo)
                        true
                    }
                    else -> false
                }
            }
        }

        view.findViewById<MaterialToolbar>(R.id.topAppBarQuitarFragmento).setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.close -> {
                    findNavController().navigate(R.id.action_quitarFragmentoFragment_to_iniciarSesionFragment)
                    true
                }
                else -> false
            }
        }
    }

}