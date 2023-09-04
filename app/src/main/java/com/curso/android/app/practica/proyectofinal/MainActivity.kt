package com.curso.android.app.practica.proyectofinal
//Función de la aplicación
//Cuando el usuario hace clic en el botón “comparar” debe comparar la entrada
// de ambos cuadros de texto y escribir en el texto (TextView) si ambas cadenas de caracteres son iguales o no.
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.practica.proyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.result.observe(this){
            binding.tvResultado.text = it.Text
        }
        binding.btnComparar.setOnClickListener(){
            mainViewModel.compareStrings(binding.etext1.getText().toString(), binding.etext2.getText().toString())
        }
    }
}