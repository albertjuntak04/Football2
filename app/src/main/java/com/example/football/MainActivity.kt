package com.example.football

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.football.MainUIActivity.Companion.PARCELABLE_ITEM_DATA
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(){
    companion object{
        public  val PARCELABLE_ITEM_DATA = "item data"
    }
    var  items: MutableList<DataClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        MainUIActivity(items).setContentView(this)
    }



    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_desc)
        items.clear()
        for (i in name.indices){
            items.add(DataClub(image.getResourceId(i, 0)
            , name[i], description[i]))
        }
        image.recycle()
    }
}
