package com.talip.odev5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.talip.odev5.databinding.FragmentHomeBinding

 class Home : Fragment() {
    private lateinit var tasarim: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        tasarim = FragmentHomeBinding.inflate(inflater, container, false)


            var ilkDeger = 0
            var ilkDegerDouble = 0.0
            var ikinciDeger = 0
            var ikinciDegerDouble = 0.0
            var giris = ""

            var sonuc = 0
            var sonucDouble = 0.0
            var islem = ""
            var firstTime = true




        tasarim.sonuc.text = "0"
        fun giris(deger: String) {

            giris += deger


            tasarim.sonuc.text = giris


        }

        fun toplama() {
            if (firstTime || ilkDeger == 0) {
                ilkDeger = giris.toInt()
                firstTime = false
                giris = ""
            } else {
                ikinciDeger = giris.toInt()
                sonuc = ilkDeger + ikinciDeger
                tasarim.sonuc.text = sonuc.toString()
                ilkDeger = sonuc
                giris = ""

            }

            islem = "0"


        }

        fun cikarma() {
            if (firstTime || ilkDeger == 0) {
                ilkDeger = giris.toInt()
                giris = ""
                firstTime = false

            } else {
                ikinciDeger = giris.toInt()
                sonuc = ilkDeger - ikinciDeger
                tasarim.sonuc.text = sonuc.toString()
                ilkDeger = sonuc
                giris = ""

            }

            islem = "1"


        }

        fun reset() {

            tasarim.sonuc.text = "0"
            ilkDeger = 0
            ikinciDeger = 0

            sonuc = 0
            islem = ""
            firstTime = true
            giris = ""
            sonuc = 0
            sonucDouble = 0.0
            ikinciDegerDouble = 0.0
            ilkDegerDouble = 0.0
        }

        fun carp() {
            if (firstTime || ilkDeger == 0) {
                ilkDeger = giris.toInt()
                firstTime = false
                giris = ""
            } else {
                ikinciDeger = giris.toInt()
                sonuc = ilkDeger * ikinciDeger
                tasarim.sonuc.text = sonuc.toString()
                ilkDeger = sonuc
                giris = ""

            }

            islem = "3"
        }

        fun bol(it: View) {
            if (firstTime || ilkDegerDouble == 0.0) {
                ilkDegerDouble = giris.toDouble()
                giris = ""
                firstTime = false

            } else {
                ikinciDegerDouble = giris.toDouble()
                if (ikinciDegerDouble != 0.0) {
                    sonucDouble = (ilkDegerDouble / ikinciDegerDouble)
                    tasarim.sonuc.text = sonucDouble.toString()
                    ilkDegerDouble = sonucDouble
                    giris = ""

                } else {
                    Snackbar.make(
                        it,
                        "$ilkDegerDouble sayısı sıfıra bölünemez",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    reset()
                }


            }

            islem = "4"


        }





        tasarim.textButton0.setOnClickListener {
            giris(tasarim.textButton0.text as String)
        }
        tasarim.textButton1.setOnClickListener {
            giris(tasarim.textButton1.text as String)
        }
        tasarim.textButton2.setOnClickListener {
            giris(tasarim.textButton2.text as String)
        }
        tasarim.textButton3.setOnClickListener {
            giris(tasarim.textButton3.text as String)
        }
        tasarim.textButton4.setOnClickListener {
            giris(tasarim.textButton4.text as String)
        }
        tasarim.textButton5.setOnClickListener {
            giris(tasarim.textButton5.text as String)
        }
        tasarim.textButton6.setOnClickListener {
            giris(tasarim.textButton6.text as String)
        }
        tasarim.textButton7.setOnClickListener {
            giris(tasarim.textButton7.text as String)
        }
        tasarim.textButton8.setOnClickListener {
            giris(tasarim.textButton8.text as String)
        }
        tasarim.textButton9.setOnClickListener {
            giris(tasarim.textButton9.text as String)
        }
        tasarim.textButtonAC.setOnClickListener {
            reset()
        }
        tasarim.textButtonEsit.setOnClickListener {
            when (islem) {
                "0" -> {
                    toplama()
                    firstTime = true
                    giris = sonuc.toString()
                    tasarim.sonuc.text = sonuc.toString()
                }
                "1" -> {
                    cikarma()
                    firstTime = true
                    giris = sonuc.toString()
                    tasarim.sonuc.text = sonuc.toString()
                }
                "3" -> {
                    carp()
                    firstTime = true
                    giris = sonuc.toString()
                    tasarim.sonuc.text = sonuc.toString()
                }
                "4" -> {
                    bol(it)
                    firstTime = true
                    giris = sonucDouble.toString()
                    tasarim.sonuc.text = sonucDouble.toString()
                }
            }


        }
        tasarim.buttonTop.setOnClickListener {
            toplama()


        }
        tasarim.buttonCik.setOnClickListener {
            cikarma()


        }
        tasarim.buttonCarp.setOnClickListener {
            carp()
        }
        tasarim.buttonBol.setOnClickListener {
            bol(it)
        }







        return tasarim.root

    }


}