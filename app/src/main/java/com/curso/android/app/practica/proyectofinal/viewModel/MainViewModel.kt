package com.curso.android.app.practica.proyectofinal.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.proyectofinal.model.Resultado


class MainViewModel: ViewModel(){

    val result: LiveData<Resultado> get() = _result
    private lateinit var  _resultString:String
    private var _result = MutableLiveData(Resultado(""))


    fun compareStrings(string1:String, string2:String ){

       if(string1 == string2){
           _resultString = "Las cadenas son iguales"
       }else {
           _resultString = "Las cadenas son distintas"
       }
        updateResult(_resultString)
    }
    private fun updateResult(sResult: String){
        _result.value=Resultado(sResult)
    }



}