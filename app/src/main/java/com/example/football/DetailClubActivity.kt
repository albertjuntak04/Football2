package com.example.football

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClubActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = intent.getParcelableExtra<DataClub>(MainUIActivity.PARCELABLE_ITEM_DATA)
        DetailUI(items).setContentView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected( item: MenuItem?): Boolean {
         if (item?.itemId == android.R.id.home){
            finish()
            return true
        }else{
             return super.onOptionsItemSelected(item)
        }

    }

    class DetailUI(val items:DataClub):AnkoComponent<DetailClubActivity> {

        companion object {
            val id_view = 1
            val id_image = 2
            val id_name = 3
            val id_desc = 4
            val description = 5
        }

        override fun createView(ui: AnkoContext<DetailClubActivity>) = with(ui) {
            scrollView {
                lparams(wrapContent, wrapContent)
                relativeLayout {
                    lparams(wrapContent, wrapContent)

                    imageView {
                        id = id_view
                        setBackgroundColor(Color.rgb(0, 255, 8))
                        Glide.with(this).load(items.image).into(this)
                    }.lparams(matchParent, dip(150))


                    imageView {
                        id = id_image
                        Glide.with(this).load(items.image).into(this)
                    }.lparams(dip(100), dip(100)) {
                        left
                        topMargin = dip(100)
                    }

                    textView {
                        id = id_name
                        text = items.nama
                        textSize = 24f
                        setTypeface(null, Typeface.BOLD)
                    }.lparams {
                        below(id_image)
                        topMargin = dip(15)
                    }

                    textView{
                        text = "Description"
                        textSize = 24f
                        setTypeface(null, Typeface.BOLD)
                        id = description
                    }.lparams(wrapContent, wrapContent){
                        below(id_name)
                        topMargin = dip(20)
                    }

                    textView {
                        id = id_desc
                        text = items.desc
                        textSize = 15f
                    }.lparams(wrapContent, wrapContent) {
                        below(description)
                        topMargin = 20
                    }

                }
            }

        }
    }
}