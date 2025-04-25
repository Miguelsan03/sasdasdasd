package com.example.qta2

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class DosMitadesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dos_mitades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSaludo = view.findViewById<TextView>(R.id.mensajeSaludo)

        val correo = arguments?.getString("Correo") ?: ""
        tvSaludo.text = getString(R.string.hola2, correo)


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
            selectedItemId = R.id.dosMitadesNav

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


        val instruccionesText = getString(R.string.instrucciones_mitades)
        view.findViewById<TextView>(R.id.instruccionesTextView).text =  Html.fromHtml(instruccionesText, Html.FROM_HTML_MODE_COMPACT)

        val inputEditText = view.findViewById<TextInputEditText>(R.id.cadenaDosMitadesEditText)
        val resultTextView = view.findViewById<TextView>(R.id.textViewResultadoDosMitades)
        val validarButton = view.findViewById<MaterialButton>(R.id.btnSolucionarDosMitades)

        validarButton.setOnClickListener {
            val input = inputEditText.text.toString()

            if (input.isEmpty()) {
                resultTextView.visibility = View.VISIBLE
                resultTextView.text = getString(R.string.ups_algo_sali_mal_revisa_tu_cadena)
                resultTextView.setTextColor(Color.RED)
            } else {
                val mitad = (input.length + 1) / 2
                val primeraMitad = input.substring(0, mitad)
                val segundaMitad = input.substring(mitad)
                resultTextView.text = segundaMitad + primeraMitad
                resultTextView.visibility = View.VISIBLE
                resultTextView.setTextColor(Color.BLACK)
            }
        }


        view.findViewById<MaterialToolbar>(R.id.topAppBarDosMitades).setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.close -> {
                    findNavController().navigate(R.id.action_dosMitadesFragment_to_iniciarSesionFragment2)
                    true
                }
                else -> false
            }
        }

    }



}


