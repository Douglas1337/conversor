package com.br.conversor.model

class ConversorTemperatura:Conversor {

    override fun convert(medidaIn: Medida): Medida {

        val tempFah = (medidaIn.valor * 9/5) + 32

        return Medida(tempFah)
    }

}