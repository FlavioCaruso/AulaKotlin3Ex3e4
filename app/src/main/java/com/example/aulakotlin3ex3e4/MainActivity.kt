package com.example.aulakotlin3ex3e4

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.widget.Button
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

        //Calcula o valor dos combustíveis
        fun calcularPreco(view: View){
            val precoAlcool = valorAlcool.text.toString()
            val precoGasolina = valorGasolina.text.toString()

            val validarCampos = validarCampos(precoAlcool, precoGasolina)

            if(validarCampos){
                calcularMelhorPreco(precoAlcool, precoGasolina)
            } else{
                textoResult.text = "Preencha os preços primeiro!"
            }
        }

        fun calcularMelhorPreco(precoAlcool : String, precoGasolina: String){

            //Transforma os valores em Double
            val valorAlcool = precoAlcool.toDouble()
            val valorGasolina = precoGasolina.toDouble()

            //Divide o valor do alcool pela gasolina
            val resultadoPreco = valorAlcool / valorGasolina

            //Verifica se o resultado for maior que o valor proposto e retorna um resultado para o texto
            if(resultadoPreco >= 0.7){
                textoResult.text = "Melhor utilizar Gasolina"
            } else{
                textoResult.text = "Melhor utilizar Alcool"
            }
        }

        fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
            var camposValidados: Boolean = true

            //Valida se os campos estao preenchidos
            if(precoAlcool == null || precoAlcool == "") {
                camposValidados = false
            } else if(precoGasolina == null || precoGasolina == ""){
                camposValidados = false
            }
            return camposValidados
        }




}