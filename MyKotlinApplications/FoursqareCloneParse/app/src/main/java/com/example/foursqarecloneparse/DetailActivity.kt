package com.example.foursqarecloneparse

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), OnMapReadyCallback {

    var choosenPlace = ""




    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val intent = intent
        choosenPlace = intent.getStringExtra("name")


    }
    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0!!

        val query = ParseQuery<ParseObject>("Locations")
        query.whereEqualTo("name",choosenPlace)
        query.findInBackground { objects, e ->

            if(e != null){
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
            }else{
                if(objects.size > 0){
                    for (parseObject in objects){
                        val image  = parseObject.get("image") as ParseFile
                        image.getDataInBackground { data, e ->
                            if(e != null){
                                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
                            }else{
                                val bitmap = BitmapFactory.decodeByteArray(data,0,data.size)
                                detailImageView.setImageBitmap(bitmap)
                                val name = parseObject.get("name") as String
                                val latitude = parseObject.get("latitude") as String
                                val longitude = parseObject.get("longitude") as String
                                val type = parseObject.get("type") as String
                                val atm = parseObject.get("atmosphere") as String


                                nameTextView.text = name
                                typeTextView.text  = type
                                atmTextView.text = atm

                                val latitudeDouble = latitude.toDouble()
                                val longitudeDouble = longitude.toDouble()
                                val choosenLocation = LatLng(latitudeDouble,longitudeDouble)
                                mMap.addMarker(MarkerOptions().position(choosenLocation).title(name))
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(choosenLocation,14f))
                            }
                        }
                    }
                }

            }
        }

    }
}
