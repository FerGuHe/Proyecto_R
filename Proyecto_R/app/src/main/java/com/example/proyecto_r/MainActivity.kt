package com.example.proyecto_r

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    val fd by lazy {
        assets.openFd("Mr. Beat.mp3")
    }
    val mp by lazy{
        val m = MediaPlayer()
        m.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        fd.close()
        m.prepare()
        m
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp.start()
    }
}
fun main(){
    println("Prueba de reproduccion de audio")
}