package com.example.maps.fragments

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maps.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    //private lateinit var map: GoogleMap
    //val mapFragment = view?.findViewById<MapView>(R.id.map)
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        /*val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = view.findViewById<MapView>(R.id.map)
        mapFragment.onCreate(savedInstanceState)
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {

        googleMap = map

        if (map != null) {


            // Mover la cámara a una ubicación específica (por ejemplo, latitud y longitud)
            val location = LatLng(2.482846578974007, -76.56253853293643)
            googleMap.addMarker(MarkerOptions().position(location).title("Sena"))

            /*
            // Agregar más marcadores según sea necesario
            val location1 = LatLng(2.4449261743007327, -76.6001259041013)
            googleMap.addMarker(MarkerOptions().position(location1).title("Morro"))

            val location2 = LatLng(2.442081779401729, -76.60630609060665)
            googleMap.addMarker(MarkerOptions().position(location2).title("Parque Caldas"))

            val location3 = LatLng(2.463822551573852, -76.58082320410134)
            googleMap.addMarker(MarkerOptions().position(location3).title("Club Campestre"))

            val location4 = LatLng(2.4384226765104264, -76.61884846132872)
            googleMap.addMarker(MarkerOptions().position(location4).title("Hospital Susana López de Valencia"))*/

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 18f))
        }
    }

    fun setLatLogn(lat: Double, long: Double, title: String){

        //googleMap = map

        // Mover la cámara a una ubicación específica (por ejemplo, latitud y longitud)
        val location = LatLng(lat, long)
        googleMap.addMarker(MarkerOptions().position(location).title(title))

    }
}