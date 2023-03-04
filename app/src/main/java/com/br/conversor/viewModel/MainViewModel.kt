package com.br.conversor.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.br.conversor.model.ConversorTemperatura
import com.br.conversor.model.Medida

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var _valueOut = MutableLiveData<Medida>()
    var valueOut: LiveData<Medida> = _valueOut

    /*
    fun result():LiveData<Medida>{
        return valueOut
    }

     */

    fun Calculate(valueIn: String){
        val med = Medida(valueIn.toDouble())
        _valueOut.value = ConversorTemperatura().convert(med)
    }

}