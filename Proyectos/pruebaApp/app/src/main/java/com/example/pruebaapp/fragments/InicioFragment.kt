package com.example.pruebaapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pruebaapp.R

/* Copilot
¡Por supuesto! Aquí tienes un paso a paso para crear un diálogo personalizado en Android Studio utilizando Kotlin:

Crea un nuevo proyecto en Android Studio:
Abre Android Studio y crea un nuevo proyecto vacío o utiliza uno existente.
Diseña tu diálogo personalizado:
Crea un archivo XML para el diseño de tu diálogo. Puedes hacerlo seleccionando File > New > Layout Resource File.
Diseña la interfaz de usuario del diálogo según tus necesidades. Agrega botones, campos de texto u otros elementos que desees mostrar en el diálogo.
Crea una clase para tu DialogFragment:
Crea una nueva clase Kotlin que extienda DialogFragment. Por ejemplo:
Kotlin

class MyDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_dialog, container, false)
    }
}
Código generado por IA. Revisar y usar cuidadosamente. Más información sobre preguntas frecuentes.
Muestra el diálogo cuando sea necesario:
En tu actividad o fragmento, crea una instancia de MyDialogFragment y muestra el diálogo utilizando el FragmentManager.
Por ejemplo, puedes mostrar el diálogo cuando se hace clic en un botón:
Kotlin

val dialogFragment = MyDialogFragment()
dialogFragment.show(supportFragmentManager, "my_dialog")
Código generado por IA. Revisar y usar cuidadosamente. Más información sobre preguntas frecuentes.
Agrega lógica a los botones del diálogo:
En la clase MyDialogFragment, puedes agregar lógica a los botones del diálogo.
Por ejemplo, para manejar el clic en el botón “Aceptar”:
Kotlin

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val acceptButton = view.findViewById<Button>(R.id.acceptButton)
    acceptButton.setOnClickListener {
        // Acción cuando se hace clic en Aceptar
        dismiss() // Cierra el diálogo
    }
}
Código generado por IA. Revisar y usar cuidadosamente. Más información sobre preguntas frecuentes.
Personaliza el estilo del diálogo (opcional):
Puedes personalizar el estilo del diálogo utilizando temas y estilos en tu archivo styles.xml.
Infla el diseño en el archivo XML del diálogo:
En el archivo XML del diálogo (fragment_my_dialog.xml en este ejemplo), agrega los elementos de diseño que creaste en el paso 2.
¡Y eso es todo! Ahora tendrás un diálogo personalizado en tu aplicación Android. ¡Buena suerte con tu desarrollo! 🚀
    */
class InicioFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }
}