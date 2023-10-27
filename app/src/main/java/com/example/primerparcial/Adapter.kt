package com.example.primerparcial
import android.content.Context
import android.media.tv.TvContract.Channels.Logo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context): ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Receta) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private val nombre: TextView = view.findViewById(R.id.tvNombre)
        private val dificultad: TextView = view.findViewById(R.id.tvDificultad)
        private val pais: TextView = view.findViewById(R.id.tvPais)
        private val bandera: ImageView = view.findViewById(R.id.ivBandera)
        private val imgPlato: ImageView = view.findViewById(R.id.ivPlato)

        fun bind (receta: Receta){
            nombre.text = receta.nombre
            dificultad.text = "Dificultad: " + receta.dificultad.toString()
            pais.text = receta.pais.toString()

            val imagen = when (receta.pais){
                Pais.ARGENTINA -> R.drawable.argentina
                Pais.BRASIL -> R.drawable.brasil
                Pais.ECUADOR -> R.drawable.ecuador
                Pais.MEXICO -> R.drawable.mexico
                Pais.COLOMBIA -> R.drawable.colombia
                else -> {R.drawable.paraguay}
            }
            bandera.setImageResource(imagen)
            Glide.with(context).load(receta.plato).centerCrop().into(imgPlato)

            view.setOnClickListener{
                onItemClickListener(receta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }

    }
}