package com.example.aulakotlin3ex3e4

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Encontra o botão pelo id
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)

        // valida o click do botão
        btnCalcular.setOnClickListener{
            calcularPreco(it)
        }

    }

        //Calcula o valor do real x o dolar e inclui o nome
        fun calcularPreco(view: View){
            val real = real.text.toString()
            val dolar = dolar.text.toString()
            val nome = nome.text.toString()

            val validarCampos = validarCampos(real, dolar, nome)

            if(validarCampos){
                calcularValor(real, dolar)
            } else{
                textoResult.text = "Preencha os campos primeiro!"
            }
        }

        fun calcularValor(real : String, dolar: String){

            val nome = nome.text.toString()

            //Transforma os valores em Double
            val valorReal = real.toDouble()
            val valorDolar = dolar.toDouble()

            //divide o valor do real pelo dólar
            val resultadoPreco = valorReal / valorDolar

            textoResult.text = nome + ", o valor convertido é: " + resultadoPreco + " dólares"
        }

        fun validarCampos(real: String, dolar: String, nome: String): Boolean {
            var camposValidados: Boolean = true

            //Valida se os campos estao preenchidos
            if(real == null || real == "") {
                camposValidados = false
            } else if(dolar == null || dolar == ""){
                camposValidados = false
            } else if(nome == null || nome == ""){
                camposValidados = false
            }
            return camposValidados
        }
    
}