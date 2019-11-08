package com.example.football


import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class ClubAdapter(private val items:List<DataClub>, private  val listener:(DataClub) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private  val name = view.findViewById<TextView>(ClubUI.club_name)
        private  val image = view.findViewById<ImageView>(ClubUI.club_image)

        fun bindItem(items: DataClub, listener: (DataClub) -> Unit){
            name.text = items.nama
            items.image.let {
                Picasso.get().load(it).fit().into(image)
            }

            itemView.setOnClickListener {
                listener(items)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(ClubUI().createView(AnkoContext.create(parent.context,parent)))
    }

    override fun getItemCount() : Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ClubAdapter.ViewHolder, position: Int) {
       holder.bindItem(items[position], listener)
    }
}