package com.example.maps

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.maps.databinding.ActivityMainBinding
import com.example.maps.fragments.MapsFragment
import com.google.android.gms.maps.MapFragment

/*Subir link o repositorio del proyecto realizado de Mapas.

Debe tener interfaz de Morro, Parque Caldas, Sena.

Al presionar clic sobre cada uno debe motrar una interfaz con su titulo, descripción, imagen, sonido y boton de ubicación
(Al presionar el botón de ubicación debe llevarlo al mapa ), cuando se presione el botón guardar se deben insertar las coordenadas del lugar y el nombre del lugar.*/

class MainActivity : AppCompatActivity() {
    //DataBinding
    /* Obligatorio para que funcione en build.gradle.kts(Module :app)
        viewBinding {

            enable = true

        }

     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Importar mapsFragment
        val mapsFragment = MapsFragment()

        //setContentView(R.layout.activity_main)

        val arrayAdapter : ArrayAdapter<*>
        val lugares = mutableListOf("Sena","Club Campestre","El Morro","Parque Caldas","Hospital Susana López de Valencia")
        val des = binding.descripcion
        val img = binding.imageView
        val latitud = binding.latitud
        val longitud = binding.longitud
        val boton = binding.button
        val lvDatos = binding.lvDatos

        //img.layoutParams.height = 400
        img.layoutParams.width = 450

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lugares)
        lvDatos.adapter = arrayAdapter

        des.text = "El SENA, es un establecimiento público del orden nacional, con personería jurídica, patrimonio propio e independiente, y autonomía administrativa; adscrito al Ministerio del Trabajo, de Colombia. SENA una entidad de formación profesional al alcance de todos."
        //Configuración de Glide
        val imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4osuOdXdusmE9tNn4OthpsmZEZfICDYgKUJp6qAfWYJM3A7QjeiLtxQAeCosqzQzWhUI&usqp=CAU"
        Glide.with(this)
            .load(imgUrl)
            .into(img)

        //mapsFragment.setLatLogn(2.482846578974007, -76.56253853293643, "Sena")
        latitud.text = "2.482846578974007"
        longitud.text = "-76.56253853293643"

        Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show()

        /*setContent {
            MapsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Tagpa")
                }
            }
        }*/

        //Implementacion de click listener en un ListView
        lvDatos.setOnItemClickListener(){ parent, view, position, id ->

            when(position){
                0 -> {
                    des.text = "El SENA, es un establecimiento público del orden nacional, con personería jurídica, patrimonio propio e independiente, y autonomía administrativa; adscrito al Ministerio del Trabajo, de Colombia. SENA una entidad de formación profesional al alcance de todos."
                    //Configuración de Glide
                    val imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4osuOdXdusmE9tNn4OthpsmZEZfICDYgKUJp6qAfWYJM3A7QjeiLtxQAeCosqzQzWhUI&usqp=CAU"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    //mapsFragment.setLatLogn(2.482846578974007, -76.56253853293643, "Sena")
                    latitud.text = "2.482846578974007"
                    longitud.text = "-76.56253853293643"
                }
                1 -> {
                    des.text = "Corporación Club Campestre de Popayán es un espectacular espacio para la celebración de todo tipo de eventos sociales. Su intención es hacer que cualquier pareja pueda hacer de su matrimonio el mejor día de sus vidas. Todo lo que siempre han soñado se convertirá en realidad y superará sus expectativas."
                    //Configuración de Glide
                    val imgUrl = "data:image/jpeg;base64,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"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    //mapsFragment.setLatLogn(2.4449261743007327, -76.6001259041013, "Club Campestre")
                    latitud.text = "2.4449261743007327"
                    longitud.text = "-76.6001259041013"
                }
                2 -> {
                    des.text = "El Morro del Tulcán o Pirámide de Tucán es el principal sitio arqueológico de Popayán. Este consiste en una pequeña loma no natural en forma de pirámide truncada, en la cual se encontraron elementos de la época precolombina, aproximadamente entre los años 500 – 1600 a."
                    //Configuración de Glide
                    val imgUrl = "https://www.twoscotsabroad.com/wp-content/uploads/2017/01/El-morro-del-tulcan-Popayan-Colombia.jpg"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    //mapsFragment.setLatLogn(2.4457300673893245, -76.60016887826262, "El Morro")
                    latitud.text = "2.4457300673893245"
                    longitud.text = "-76.60016887826262"
                }
                3 -> {
                    des.text = "El Parque Caldas es la plaza principal de la ciudad de Popayán, Colombia. Se encuentra ubicado en el Centro Histórico de la Ciudad, lugar donde convergen todos los edificios principales y representativos de la ciudad."
                    //Configuración de Glide
                    val imgUrl = "https://scontent.fclo1-4.fna.fbcdn.net/v/t1.6435-9/67921979_2390392741204648_3219123996041674752_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=dd63ad&_nc_ohc=1-A3bsrWHOcAX800t_a&_nc_ht=scontent.fclo1-4.fna&oh=00_AfAbShr_LoUoh6OkRwsXMB9IcbEeQC2yA033FZacq1CyIA&oe=65F145B2"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    //mapsFragment.setLatLogn(2.442081779401729, -76.60630609060665, "Parque Caldas")
                    latitud.text = "2.442081779401729"
                    longitud.text = "-76.60630609060665"
                }
                4 -> {
                    des.text = "El Hospital Susana López de Valencia fue construido a partir de 1957 e inició prestación de servicios como Hospital de Vías Respiratorias, a finales de 1964; en 1977 inician la atención en consulta externa conservando el carácter de Institución dedicada a la atención de pacientes tuberculosos."
                    //Configuración de Glide
                    val imgUrl = "https://www.proclamadelcauca.com/wp-content/uploads/2018/12/Hospital-Susana-L%C3%B3pez.jpg"
                    Glide.with(this)
                        .load(imgUrl)
                        .into(img)

                    //mapsFragment.setLatLogn(2.4384226765104264, -76.61884846132872, "Hospital Susana López")
                    latitud.text = "2.4384226765104264"
                    longitud.text = "-76.61884846132872"
                }
                else -> {
                    Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show()
                }
            }

            Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()

        }

        /*Importante implementar los servicios de maps (Normalmente al crear un mapFragment los implementa automáticamente,
        pero sin las autorizaciones para tener acceso a internet)*/
    }
}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MapsTheme {
        Greeting("Tagpa")
    }
}*/