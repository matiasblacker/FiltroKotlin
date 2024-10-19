package com.example.eje9_filtro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Listados de datos
    private val numbersList = listOf("one", "five", "two", "three", "four")
    private val instanceList = listOf(null, 1, "two", 3.0, "four")
    private val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    private val unsortedList = listOf(7, 8, 5, 3, 2, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones y el TextView
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val buttonFilter1 = findViewById<Button>(R.id.buttonFilter1)
        val buttonFilter2 = findViewById<Button>(R.id.buttonFilter2)
        val buttonFilter3 = findViewById<Button>(R.id.buttonFilter3)

        // Filtro 1: Mostrar solo los números de la lista numbersList que tengan 3 letras
        buttonFilter1.setOnClickListener {
            val filtered = numbersList.filter { it.length > 3  }
            textViewResult.text = filtered.joinToString(", ")
        }

        // Filtro 2: Mostrar solo los valores no nulos de instanceList
        buttonFilter2.setOnClickListener {
            val filtered = instanceList.filterNotNull()
            textViewResult.text = filtered.joinToString(", ")
        }

        // Filtro 3: Mostrar los valores del mapa numbersMap con una clave que comience con "key1"
        buttonFilter3.setOnClickListener {
            val filtered = numbersMap.filterKeys { it.startsWith("key1") }
            textViewResult.text = filtered.entries.joinToString(", ") { "${it.key}: ${it.value}" }
        }
    }
}