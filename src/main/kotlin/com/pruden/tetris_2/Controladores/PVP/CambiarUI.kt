package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin

fun cambairUIaPVP(pvp : Boolean){
    cPrin.pvp.isDisable = pvp
    cPrin.clan.isDisable = pvp
    cPrin.custom_B.isDisable = pvp
    cPrin.modos.isDisable = pvp

    if(pvp){
        cPrin.nuevaPartidaB.text = "Abandonar partida"

    }else{
        cPrin.nuevaPartidaB.text = "Nueva partida"
    }


    cPrin.panePVP.isVisible = pvp
    cPrin.paneSinglePlayer.isVisible = !pvp
    ControladorPrincipal.partidaPVPenCurso = pvp

}