package com.example.football

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ClubUI:AnkoComponent<ViewGroup> {

    companion object{
        val club_image = 1
        val club_name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>)= with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView{
                id = club_image
            }.lparams(width = 150, height = 150)

            textView{
                id = club_name
            }.lparams(wrapContent, wrapContent){
                gravity = Gravity.CENTER_VERTICAL
                leftMargin = dip(35)
            }
        }
    }
}