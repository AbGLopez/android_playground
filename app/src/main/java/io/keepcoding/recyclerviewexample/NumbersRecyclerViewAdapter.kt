package io.keepcoding.recyclerviewexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class NumbersRecyclerViewAdapter(val numbers: List<Int>) : RecyclerView.Adapter<NumbersRecyclerViewAdapter.NumberViewHolder>() {

    var buttonListener: ButtonListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NumberViewHolder {
        // Creamos la vista plantilla que más tarde se rellenará con el número en cuestión que se quiera mostrar
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.cell_number, parent, false)

        // Le decimos a la vista de este ViewHolder a quién llamar cuando se le pulse
        val viewHolder = NumberViewHolder(view)
        viewHolder.buttonListener = buttonListener

        return viewHolder
    }

    override fun getItemCount(): Int {
        return numbers.count()
    }

    override fun onBindViewHolder(holder: NumberViewHolder?, position: Int) {
        // Le decimos al ViewHolder (la "fila") que "pinte" el número en ella, eso lo hacemos con la llamada a bindNumber
        holder?.bindNumber(numbers[position])
    }


    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textNumber = itemView.findViewById<TextView>(R.id.text_number)
        val button1 = itemView.findViewById<Button>(R.id.button1)
        val button2 = itemView.findViewById<Button>(R.id.button2)
        var buttonListener: ButtonListener? = null

        fun bindNumber(number: Int) {
            textNumber.text = number.toString()
            button1.setOnClickListener {
                buttonListener?.button1Pressed(number)
            }
            button2.setOnClickListener {
                buttonListener?.button2Pressed(number)
            }
        }

    }

    interface ButtonListener {
        fun button1Pressed(number: Int)
        fun button2Pressed(number: Int)
    }
}