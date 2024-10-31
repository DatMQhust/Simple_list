package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val ed1 = findViewById<EditText>(R.id.input_n)
        val even = findViewById<RadioButton>(R.id.even)
        val odd = findViewById<RadioButton>(R.id.odd)
        val cp = findViewById<RadioButton>(R.id.cp)
        val btn = findViewById<Button>(R.id.btn)
        val listview = findViewById<ListView>(R.id.list_item)
        val item = mutableListOf<Int>()
        var n : Int
        var input = ed1.text.toString()
        val res = findViewById<TextView>(R.id.result)


        val adapter : ArrayAdapter<Int> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            item
        )
        btn.setOnClickListener {
            try {
                n = if (ed1.text.toString() != "")
                    ed1.text.toString().toInt()
                else -1
                if (n == -1) res.setText("Vui lòng nhâp số hợp lệ")
                else {
                    item.clear()
                    if (even.isChecked) {
                        for (i in 0..n) {
                            if (i % 2 == 0) item.add(i)
                        }
                    } else if (odd.isChecked) {
                        for (i in 1..n)
                            if (i % 2 != 0) item.add(i)
                    } else if (cp.isChecked) {
                        var i = 0;
                        while (i * i < n) {
                            item.add(i * i);
                            i++
                        }
                    }
                }
                adapter.notifyDataSetChanged()
            } catch(e: NumberFormatException){
                item.clear()
                res.setText("Vui long nhập số hơp lệ")
            }
        }

        listview.adapter = adapter




    }
}