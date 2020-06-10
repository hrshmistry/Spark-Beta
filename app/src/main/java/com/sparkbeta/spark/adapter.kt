package com.sparkbeta.spark

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class adapter(data:ArrayList<app>, internal var context:Context):RecyclerView.Adapter<adapter.ViewHolder>() {

    internal var data: List<app>
    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.image.setImageResource(data[position].image)
        holder.card.setOnClickListener{
            if(position==0){
                val intent = Intent(context, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
            else if(position==1){
                val intent = Intent(context, football::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
            else if(position==2){
                val intent = Intent(context, kho_kho::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
            else if(position==3){
                val intent = Intent(context, badminton::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
            else if(position==4){
                val intent = Intent(context, kabaddi::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
            else if(position==5){
                val intent = Intent(context, volleyball::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
            else if(position==6){
                val intent = Intent(context, hockey::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        internal var name: TextView
        internal var image: ImageView
        internal var card:CardView

        init {
            name = itemview.findViewById(R.id.cr_id)
            image = itemview.findViewById(R.id.profile_image)
            card=itemview.findViewById(R.id.card_view)
        }
    }
}