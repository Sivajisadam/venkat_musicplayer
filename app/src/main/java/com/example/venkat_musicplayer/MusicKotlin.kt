package com.example.venkat_musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity

class MusicKotlin : AppCompatActivity() {


    lateinit var seekBar: SeekBar
    lateinit var pause: Button
    lateinit var play: Button
    lateinit var stop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_kotlin)
        val mediaPlayer = MediaPlayer.create(this, R.raw.hindi)
        mediaPlayer.start()
        pause = findViewById(R.id.pause)
        play = findViewById<Button>(R.id.play)
        stop = findViewById<Button>(R.id.stop)
        seekBar = findViewById(R.id.seekbar)

        seekBar.apply {
            max = mediaPlayer.duration


        }
        seekBar.max = mediaPlayer.duration

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mediaPlayer.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        pause.setOnClickListener { v: View? -> mediaPlayer.pause() }

        play.setOnClickListener { v: View? -> mediaPlayer.start() }

        stop.setOnClickListener { v: View? -> mediaPlayer.stop() }


    }



}