package com.asyifafahra.listdanbuku.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asyifafahra.listdanbuku.DetailBuah
import com.asyifafahra.listdanbuku.R
import com.asyifafahra.listdanbuku.RecycleMovieActivity
import com.asyifafahra.listdanbuku.model.ModelMovie

class MovieAdapter(
    val itemList: ArrayList<ModelMovie>,
    val getActivity: RecycleMovieActivity

): RecyclerView.Adapter<MovieAdapter.MyViewHolder>(){
    class MyViewHolder (itemView : View):RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemNama : TextView

        init {
            itemImage =itemView.findViewById(R.id.gambar1) as ImageView
            itemNama =itemView.findViewById(R.id.nama) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_recyclemovie, parent, false)
        return com.asyifafahra.listdanbuku.adapter.MovieAdapter.MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //set data ke widget
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemNama.setText(itemList[position].nama)

        //kita intent
        holder.itemView.setOnClickListener(){
            //inten
            //context atau this --> getActivity
            val intent = Intent(getActivity, DetailBuah::class.java)
            //kita put data untuk kita passed ke detail
            intent.putExtra("image",itemList[position].image)
            intent.putExtra("nama",itemList[position].nama)
            //passed ke detail
            getActivity.startActivity(intent)
        }
    }


}