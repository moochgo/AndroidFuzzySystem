package com.ai.fuzzy.fuzzysystemlampcontroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    internal var indoor: Double = 0.toDouble()
    internal var outdoor: Double = 0.toDouble()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val seekBarDalam = findViewById<SeekBar>(R.id.seekBarDalam)
        val seekBarLuar = findViewById<SeekBar>(R.id.seekBarLuar)
        val proses = findViewById<Button>(R.id.process)
        val getValueLuar = findViewById<TextView>(R.id.getValueLuar)
        val getValueDalam = findViewById<TextView>(R.id.getValueDalam)
        val outGelap = findViewById<TextView>(R.id.outGelap)
        val outRemang = findViewById<TextView>(R.id.outRemang)
        val outAgakTerang = findViewById<TextView>(R.id.outAgakTerang)
        val outTerang = findViewById<TextView>(R.id.outTerang)
        val outSangatTerang = findViewById<TextView>(R.id.outSangatTerang)
        val inGelap = findViewById<TextView>(R.id.inGelap)
        val inAgakGelap = findViewById<TextView>(R.id.inAgakGelap)
        val inRemang = findViewById<TextView>(R.id.inRemang)
        val inNormal = findViewById<TextView>(R.id.inNormal)
        val inTerang = findViewById<TextView>(R.id.inTerang)
        val hasilPadam = findViewById<TextView>(R.id.hasilPadam)
        val hasilRedup = findViewById<TextView>(R.id.hasilRedup)
        val hasilNormal = findViewById<TextView>(R.id.hasilNormal)
        val hasilTerang = findViewById<TextView>(R.id.hasilTerang)
        val hasilMamdani = findViewById<TextView>(R.id.hasilMamdani)
        val lampOn = findViewById<ImageView>(R.id.lampOn)

        seekBarDalam.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                indoor = seekBarDalam.progress.toDouble() / 10
                getValueDalam.text = String.format(Locale.getDefault(), "%.2f", indoor)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        seekBarLuar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                outdoor = seekBarLuar.progress.toDouble() / 10
                getValueLuar.text = String.format(Locale.getDefault(), "%.2f", outdoor)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        proses.setOnClickListener {
            val fuzzy = Fuzzy()
            fuzzy.setFuzzyfikasi(indoor, outdoor)
            fuzzy.getInferensi()
            fuzzy.setCentroidMethod()
            outGelap.text = String.format(Locale.getDefault(), "%.2f", fuzzy.outGelap)
            outRemang.text = String.format(Locale.getDefault(), "%.2f", fuzzy.outRemang)
            outAgakTerang.text = String.format(Locale.getDefault(), "%.2f", fuzzy.outAgakTerang)
            outTerang.text = String.format(Locale.getDefault(), "%.2f", fuzzy.outTerang)
            outSangatTerang.text = String.format(Locale.getDefault(), "%.2f", fuzzy.outSangatTerang)
            inGelap.text = String.format(Locale.getDefault(), "%.2f", fuzzy.inGelap)
            inAgakGelap.text = String.format(Locale.getDefault(), "%.2f", fuzzy.inAgakGelap)
            inRemang.text = String.format(Locale.getDefault(), "%.2f", fuzzy.inRemang)
            inNormal.text = String.format(Locale.getDefault(), "%.2f", fuzzy.inNormal)
            inTerang.text = String.format(Locale.getDefault(), "%.2f", fuzzy.inTerang)
            hasilPadam.text = String.format(Locale.getDefault(), "%.2f", fuzzy.maxPadam)
            hasilRedup.text = String.format(Locale.getDefault(), "%.2f", fuzzy.maxRedup)
            hasilNormal.text = String.format(Locale.getDefault(), "%.2f", fuzzy.maxNormal)
            hasilTerang.text = String.format(Locale.getDefault(), "%.2f", fuzzy.maxTerang)
            hasilMamdani.text = String.format(Locale.getDefault(), "%.2f", fuzzy.hasil())
            val setLampu = fuzzy.hasil() / 100
            lampOn.alpha = setLampu.toFloat()
        }
    }
}
