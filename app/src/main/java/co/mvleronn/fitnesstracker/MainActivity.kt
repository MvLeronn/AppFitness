package co.mvleronn.fitnesstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter()
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)

        // classe para administrar a recyclerview e suas celulas (os sues layouts de itens)
        // Adapter ->
    }

    private inner class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
        // Qual é o layout XML da celula especifica(item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        // método disparado toda vez que houver uma rolagem na tela e for
        // necessário trocar o conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        }
        // quantas celulas essa listagem terá
        override fun getItemCount(): Int {
            return 15
        }

    }

    // é a classe da célula em si
    private class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }
}