package com.curso.android.app.practica.proyectofinal


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel(){

    val result get() = _result
    private lateinit var  _resultString:String
    private var _result = MutableLiveData(ResultString(""))


    fun compareStrings(string1:String, string2:String ){

       if(string1=="" || string2==""){
           _resultString = "Uno o mas cuadros de texto vacios"
       }else if(string1 == string2){
           _resultString = "Las cadenas son iguales"
       }else{
           _resultString= "Las cadenas son distintas"
       }

        updateResult(_resultString)
    }
    private fun updateResult(sResult: String){
        _result.value= ResultString(sResult)
    }



}