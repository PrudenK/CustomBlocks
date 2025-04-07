package com.pruden.tetris_2.Metodos.RankingVistaDatos

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.Rankings.ControladorPartidasRankings.Companion.cRanking
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosRanking(){
    CoroutineScope(Dispatchers.IO).launch {
        with(cRanking){
            cRanking.datosRanking.clear()
            val jRanking = ApiCustom.partidaService.getMejoresPartidas(comboPais.value, comboModo.value)

            println(jRanking)
            for (r in jRanking){
                cRanking.datosRanking.add(r)
            }

        }
    }
}