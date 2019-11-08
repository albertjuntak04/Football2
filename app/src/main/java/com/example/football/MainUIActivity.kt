package com.example.football

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainUIActivity(val items: List<DataClub>): AnkoComponent<MainActivity> {
    companion object{
        public const val PARCELABLE_ITEM_DATA = "item data"
    }
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout{
            lparams(matchParent, matchParent)

            recyclerView {
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, 1))
                adapter = ClubAdapter(items){
                    startActivity<DetailClubActivity>(PARCELABLE_ITEM_DATA to it)
                }
            }
        }
    }
}