package com.kadir.dersuygulama

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Sonuçları göstermek için bir TextView tanımlıyoruz.
    private lateinit var resultTextView: TextView

    // İlk ve ikinci sayıların tutulacağı değişkenler.
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0

    // Mevcut işlemin tutulacağı değişken.
    private var currentOperation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sonuç TextView'ini layout'tan alıyoruz.
        resultTextView = findViewById(R.id.sonuc)

        // Butonları bir liste olarak tanımlıyoruz.
        val buttons = listOf(
            findViewById<Button>(R.id.bir),
            findViewById<Button>(R.id.iki),
            findViewById<Button>(R.id.uc),
            findViewById<Button>(R.id.dort),
            findViewById<Button>(R.id.bes),
            findViewById<Button>(R.id.altı),
            findViewById<Button>(R.id.yedi),
            findViewById<Button>(R.id.sekiz),
            findViewById<Button>(R.id.dokuz),
            findViewById<Button>(R.id.sifir),
            findViewById<Button>(R.id.arti),
            findViewById<Button>(R.id.eksi),
            findViewById<Button>(R.id.carpi),
            findViewById<Button>(R.id.bolu),
            findViewById<Button>(R.id.esittir),
            findViewById<Button>(R.id.ac)
        )

        // Butonlara tıklama olaylarını ekliyoruz.
        buttons.forEach { button ->
            button.setOnClickListener { onButtonClick(it) }
        }
    }

    // Buton tıklandığında çağrılan fonksiyon.
    private fun onButtonClick(view: View) {
        when (view.id) {
            // Sayı butonları
            R.id.bir -> appendToResult("1")
            R.id.iki -> appendToResult("2")
            R.id.uc -> appendToResult("3")
            R.id.dort -> appendToResult("4")
            R.id.bes -> appendToResult("5")
            R.id.altı -> appendToResult("6")
            R.id.yedi -> appendToResult("7")
            R.id.sekiz -> appendToResult("8")
            R.id.dokuz -> appendToResult("9")
            R.id.sifir -> appendToResult("0")
            // İşlem butonları
            R.id.arti -> setOperation("+")
            R.id.eksi -> setOperation("-")
            R.id.carpi -> setOperation("*")
            R.id.bolu -> setOperation("/")
            // Eşittir butonu
            R.id.esittir -> calculateResult()
            // Temizleme butonu
            R.id.ac -> clearResult()
        }
    }

    // Sonucu TextView'e ekleyen fonksiyon.
    private fun appendToResult(value: String) {
        resultTextView.text = (resultTextView.text.toString() + value)
    }

    // Mevcut işlemi ve ilk sayıyı ayarlayan fonksiyon.
    private fun setOperation(operation: String) {
        // Mevcut sonucu firstNumber'a atıyoruz.
        firstNumber = resultTextView.text.toString().toDoubleOrNull() ?: 0.0
        currentOperation = operation // Mevcut işlemi ayarla
        resultTextView.text = "" // Sonucu temizle
    }

    // Hesaplama yapan fonksiyon.
    private fun calculateResult() {
        // Kullanıcının girdiği ikinci sayıyı alıyoruz.
        secondNumber = resultTextView.text.toString().toDoubleOrNull() ?: 0.0
        val result = when (currentOperation) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> if (secondNumber != 0.0) firstNumber / secondNumber else "Hata"
            else -> 0.0
        }
        // Sonucu TextView'e yaz
        resultTextView.text = result.toString()
        currentOperation = null // İşlemi sıfırla
    }

    // Sonucu ve değişkenleri temizleyen fonksiyon.
    private fun clearResult() {
        resultTextView.text = "" // Sonucu temizle
        firstNumber = 0.0 // İlk sayıyı sıfırla
        secondNumber = 0.0 // İkinci sayıyı sıfırla
        currentOperation = null // İşlemi sıfırla
    }
}