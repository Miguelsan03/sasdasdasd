package com.example.qta2

import android.os.Bundle
import android.graphics.Color
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
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class DosPalabrasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dos_palabras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSaludo = view.findViewById<TextView>(R.id.mensajeSaludo2)

        val correo = arguments?.getString("Correo") ?: ""
        tvSaludo.text = getString(R.string.hola2, correo)


        view.findViewById<MaterialToolbar>(R.id.topAppBarDosPalabras).setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.close -> {
                    findNavController().navigate(R.id.action_dosPalabrasFragment_to_iniciarSesionFragment2)
                    true
                }
                else -> false
            }
        }

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
            selectedItemId = R.id.dosPalabrasNav

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


        val instruccionesText = getString(R.string.instrucciones_dos_palabras)
        view.findViewById<TextView>(R.id.instrucciones2TextView).text =  Html.fromHtml(instruccionesText, Html.FROM_HTML_MODE_COMPACT)

        val inputEditText = view.findViewById<TextInputEditText>(R.id.cadenaDosPalabrasEditText)
        val resultTextView = view.findViewById<TextView>(R.id.textViewResultadoDosPalabras)
        val validarButton = view.findViewById<MaterialButton>(R.id.btnSolucionarDosPalabras)

        validarButton.setOnClickListener {
            val input = inputEditText.text.toString().trim()

            if (input.isEmpty()) {
                resultTextView.visibility = View.VISIBLE

                resultTextView.text = getString(R.string.ups_algo_sali_mal_revisa_tu_cadena)
                resultTextView.setTextColor(Color.RED)

                return@setOnClickListener
            }

            val words = input.split(" ")
            if (words.size != 2) {
                resultTextView.visibility = View.VISIBLE
                resultTextView.text = getString(R.string.ups_algo_sali_mal_revisa_tu_cadena)
                resultTextView.setTextColor(Color.RED)
                return@setOnClickListener
            }

            val resultado = "${words[1]} ${words[0]}"
            resultTextView.visibility = View.VISIBLE
            resultTextView.text = resultado
            resultTextView.setTextColor(Color.BLACK)
            }
        }





}

