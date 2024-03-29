package com.example.foursqarecloneparse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.parse.Parse
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.android.synthetic.main.activity_locations.*

class LocationsActivity : AppCompatActivity() {

    var namesArray = ArrayList<String>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_location,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add_location){
            val intent = Intent(applicationContext,placeNameActivity::class.java)
            startActivity(intent)



        }



        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locations)

        getParseData()

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailActivity::class.java)
            intent.putExtra("name",namesArray[position])
            startActivity(intent)
        }

    }
    fun getParseData(){
        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,namesArray)
        listView.adapter = arrayAdapter

        val query  = ParseQuery.getQuery<ParseObject>("Locations")
        query.findInBackground { objects, e ->
            if(e != null){
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()

            }
            else{
                if(objects.size > 0){
                    for(parseObject in objects){
                        val name = parseObject.get("name") as String
                        namesArray.add(name)

                    }
                    arrayAdapter.notifyDataSetChanged()
                }
            }
        }

    }
}
