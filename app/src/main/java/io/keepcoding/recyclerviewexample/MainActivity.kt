package io.keepcoding.recyclerviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Le decimos su LayoutManager
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Le decimos cómo se anima
        recycler_view.itemAnimator = DefaultItemAnimator()

        // Creamos el modelo
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)

        // Creamos el adapter
        val adapter = NumbersRecyclerViewAdapter(numberList)

        // Le decimos qué pasa cuando se pulsa un elemento del adapter
        adapter.buttonListener = object : NumbersRecyclerViewAdapter.ButtonListener {
            override fun button1Pressed(number: Int) {
                Toast.makeText(this@MainActivity, "Han pulsado el botón 1 del número $number", Toast.LENGTH_SHORT)
                        .show()
            }

            override fun button2Pressed(number: Int) {
                Toast.makeText(this@MainActivity, "Han pulsado el botón 2 del número $number", Toast.LENGTH_SHORT)
                        .show()
            }

        }


        // Le decimos su adapter
        recycler_view.adapter = adapter
    }
}
