package com.example.uielementspart2

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var songsArray: Array<String>
    var songs = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songsArray = arrayOf("Mortal Reminder", "Deathfire Grasp", "Lightbringer", "The Bloodthirster", "Drum Go Dum", "I'll Show You",
            "Pop/Stars", "The Baddest", "More", "The Boy Who Shattered Time", "Villain", "Rise", "Worlds Collide", "Phoenix", "Take Over", "Legends Never Die", "Edge of Infinity",
            "Giants", "Orb of Winter", "Edge of Infinity", "Frozen Heart", "Tear of the Goddess", "Blade of the Ruined King", "Last Whisper",
            "Piercing Light", "PROJECT: YI")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songsListView = findViewById<ListView>(R.id.songsListView)
        songsListView.adapter = adapter
        registerForContextMenu(songsListView)


    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.songs_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.queue_option -> {
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                val listPosition = info.position
                val song = songsArray[listPosition]
                songs.add(song)

                val snackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Song added to queue", Snackbar.LENGTH_LONG)
                snackbar.setAction("Go to queue", View.OnClickListener{
                    val intent = Intent(applicationContext, QueueActivity::class.java)
                    intent.putExtra("Song", songs)
                    startActivity(intent)
                })
                snackbar.show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_albums_page -> {
                startActivity(Intent(this, AlbumsActivity::class.java))
                true
            }R.id.go_to_queue_page -> {
                val intent = Intent(this, QueueActivity::class.java)
                intent.putExtra("Song", songs)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}