package mchehab.com.assetsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView);
        val listCountries = readCountries()
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                listCountries)
        listView.adapter = arrayAdapter
    }

    private fun readCountries(): List<String> {
        val list = mutableListOf<String>()
//        try catch is optional, but if the file does not exist the application crashes
        try{
            assets.open("countries.txt")
                    .bufferedReader()
                    .useLines { lines -> lines.forEach { list.add(it) } }
        }catch (exception: IOException){
            exception.printStackTrace()
        }
        return list
    }
}