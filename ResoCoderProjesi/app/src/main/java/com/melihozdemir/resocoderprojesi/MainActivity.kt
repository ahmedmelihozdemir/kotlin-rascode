package com.melihozdemir.resocoderprojesi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textView.translationY
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = progress.toString()

                val translationDistance = (initialTextViewTranslationY +
                         progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textView.animate().translationY(translationDistance)

                if (!fromUser)
                    textView.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        button.setOnClickListener { v ->
            seekBar.progress = 0


        }




    }
}