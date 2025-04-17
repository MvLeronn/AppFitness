package co.mvleronn.fitnesstracker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_sunny_24,
                textStringId = R.string.imc,
                color = Color.WHITE
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.baseline_accessibility_24,
                textStringId = R.string.tmb,
                color = Color.WHITE
            ),
        )

        val adapter = MainAdapter(mainItems)
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 2)

        // classe para administrar a recyclerview e suas celulas (os sues layouts de itens)
        // Adapter ->
    }

    private inner class MainAdapter(private val mainItems: List<MainItem>): RecyclerView.Adapter<MainViewHolder>() {
        // Qual é o layout XML da celula especifica(item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        // método disparado toda vez que houver uma rolagem na tela e for
        // necessário trocar o conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)

        }
        // quantas celulas essa listagem terá
        override fun getItemCount(): Int {
            return mainItems.size
        }

    }

    // é a classe da célula em si
    private class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: MainItem){
            val img: ImageView = itemView.findViewById(R.id.item_img_icon)
            val name: TextView = itemView.findViewById(R.id.item_txt_name)
            val container: LinearLayout = itemView.findViewById(R.id.item_container)

            img.setImageResource(item.drawableId)
            name.setText(item.textStringId)
            container.setBackgroundColor(item.color)

        }
    }
}