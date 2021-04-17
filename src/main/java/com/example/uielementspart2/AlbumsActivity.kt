package com.example.uielementspart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class AlbumsActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var gridView: GridView? = null
    private var arrayList: ArrayList<Album>? = null
    private var adapter: AlbumAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        gridView = findViewById(R.id.grid_view)
        arrayList = ArrayList()
        arrayList = setDataList()
        adapter = AlbumAdapter(applicationContext, arrayList!!)
        gridView?.adapter = adapter
        gridView?.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val album: Album = arrayList!!.get(position)
            val intent = Intent(this, AlbumDetailsActivity::class.java)
            intent.putExtra("albums", album.name)
            intent.putExtra("icons", album.icons)
            intent.putExtra("songs", album.songs)
            startActivity(intent)
        }

    }

    private fun setDataList(): ArrayList<Album>{
        val arrayList: ArrayList<Album> = ArrayList()

        val csgoSongs: ArrayList<String> = arrayListOf("Mortal Reminder", "Deathfire Grasp", "Lightbringer", "The Bloodthirster",
            "Orb of Winter", "Edge of Infinity", "Frozen Heart", "Tear of the Goddess", "Blade of the Ruined King", "Last Whisper")
        val kdaSongs: ArrayList<String> = arrayListOf("Pop/Stars", "The Baddest", "More", "Villain", "Drum Go Dum", "I'll Show You")
        val pubgSongs: ArrayList<String> = arrayListOf("Rise", "Phoenix", "Take Over", "Legends Never Die")
        val dota2Songs: ArrayList<String> = arrayListOf("Giants")
        val valSongs: ArrayList<String> = arrayListOf("Piercing Light", "Edge of Infinity", "PROJECT: YI", "Worlds Collide", "The Boy Who Shattered Time")

        arrayList.add(Album(R.drawable.csgo, "CSGO", csgoSongs))
        arrayList.add(Album(R.drawable.pubg, "PUBG",pubgSongs))
        arrayList.add(Album(R.drawable.dota2, "DOTA ll", dota2Songs))
        arrayList.add(Album(R.drawable.kda, "K/DA", kdaSongs))
        arrayList.add(Album(R.drawable.valorant, "Valorant" , valSongs))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }


}