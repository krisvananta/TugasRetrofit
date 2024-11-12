package com.example.authorslist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.authorslist.databinding.ActivityMainBinding
import com.example.authorslist.model.Authors
import com.example.authorslist.model.DayOff
import com.example.authorslist.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val responseAuthors = client.getAllDayOff()
        val dayOffList = ArrayList<String>()

        responseAuthors.enqueue(object : Callback<List<DayOff>> {
            override fun onResponse(p0: Call<List<DayOff>>, p1: Response<List<DayOff>>) {
                for (i in p1.body()!!) {
                    dayOffList.add(i.tanggal)
                    dayOffList.add(i.keterangan)
                    dayOffList.add(i.isiCuti.toString())
                }
                val listAdapter = ArrayAdapter(
                    this@MainActivity, android.R.layout.simple_list_item_1, dayOffList
                )
                binding.lvNama.adapter = listAdapter
            }

            override fun onFailure(p0: Call<List<DayOff>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error", Toast.LENGTH_SHORT).show()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}