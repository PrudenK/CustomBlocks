package com.pruden.tetris_2.Metodos.BolsaPiezas


import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaPVPenCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.puedeHoldear
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.rotacionesActuales
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Piezas.*
import java.util.*

val copiaEnPVP: ArrayList<Pieza> = ArrayList()
val siguientePieza: ArrayList<Pieza> = ArrayList()
val piezasBolsa: ArrayList<Pieza> = ArrayList()
private val random = Random()

fun devolverPiezaAleatoria(): Pieza {
    if(partidaPVPenCurso){
      if(siguientePieza.size < 4){
          siguientePieza.addAll(copiaEnPVP.map { it.clonar() })
      }
    }else{
        while (siguientePieza.size < 4){
            generarPieza()
        }
    }

    if(LIMITE_ROTACIONES_B) rotacionesActuales = LIMITE_ROTACIONES

    dibujarPiezasSiguientes(0)
    puedeHoldear = true

    return siguientePieza.removeAt(0)
}


private fun generarPieza(){
    guardarPiezaSiBolsaVacia()
    val piezaAsacar = random.nextInt(piezasBolsa.size)
    siguientePieza.add(piezasBolsa.removeAt(piezaAsacar))
}

private fun guardarPiezaSiBolsaVacia(){
    if (piezasBolsa.isEmpty()){
        cargarLista()
    }
}


private fun cargarLista(){
    val columnaInicial = Globales.COLUMNAS /2
    val bolsaTemp: ArrayList<Pieza> = ArrayList()
    val piezasAgregar : ArrayList<Boolean> = listaPiezasSeleccionadas

    if (piezasAgregar.isNotEmpty() && !piezasAgregar.stream().allMatch { b: Boolean? -> !b!! }) {
        val arrayBooleanos = BooleanArray(piezasAgregar.size)
        for (i in piezasAgregar.indices) {
            arrayBooleanos[i] = piezasAgregar[i]
        }
        if (arrayBooleanos[0]) bolsaTemp.add(Pieza_O(0, columnaInicial))
        if (arrayBooleanos[1]) bolsaTemp.add(Pieza_I(0, columnaInicial))
        if (arrayBooleanos[2]) bolsaTemp.add(Pieza_L(0, columnaInicial))
        if (arrayBooleanos[3]) bolsaTemp.add(Pieza_Z(0, columnaInicial))
        if (arrayBooleanos[4]) bolsaTemp.add(Pieza_J(0, columnaInicial))
        if (arrayBooleanos[5]) bolsaTemp.add(Pieza_S(0, columnaInicial))
        if (arrayBooleanos[6]) bolsaTemp.add(Pieza_T(0, columnaInicial))
        if (arrayBooleanos[7]) bolsaTemp.add(Pieza_P(0, columnaInicial))
        if (arrayBooleanos[8]) bolsaTemp.add(Pieza_X(0, columnaInicial))
        if (arrayBooleanos[9]) bolsaTemp.add(Pieza_U(0, columnaInicial))
        if (arrayBooleanos[10]) bolsaTemp.add(Pieza_L_v2(0, columnaInicial))
        if (arrayBooleanos[11]) bolsaTemp.add(Pieza_W(0, columnaInicial))
        if (arrayBooleanos[12]) bolsaTemp.add(Pieza_T_v2(0, columnaInicial))
        if (arrayBooleanos[13]) bolsaTemp.add(Pieza_Z_v2(0, columnaInicial))
        if (arrayBooleanos[14]) bolsaTemp.add(Pieza_X_v2(0, columnaInicial))
        if (arrayBooleanos[15]) bolsaTemp.add(Pieza_L_v3(0, columnaInicial))
        if (arrayBooleanos[16]) bolsaTemp.add(Pieza_F(0, columnaInicial))
        if (arrayBooleanos[17]) bolsaTemp.add(Pieza_O_v2(0, columnaInicial))
        if (arrayBooleanos[18]) bolsaTemp.add(Pieza_S_v2(0, columnaInicial))
        if (arrayBooleanos[19]) bolsaTemp.add(Pieza_B(0, columnaInicial))
        if (arrayBooleanos[20]) bolsaTemp.add(Pieza_Y(0, columnaInicial))
        if (arrayBooleanos[21]) bolsaTemp.add(Pieza_K(0, columnaInicial))
        if (arrayBooleanos[22]) bolsaTemp.add(Pieza_I_v2(0, columnaInicial))
        if (arrayBooleanos[23]) bolsaTemp.add(Pieza_C(0, columnaInicial))
        if (arrayBooleanos[24]) bolsaTemp.add(Pieza_O_v3(0, columnaInicial))
        if (arrayBooleanos[25]) bolsaTemp.add(Pieza_V(0, columnaInicial))
        if (arrayBooleanos[26]) bolsaTemp.add(Pieza_H(0, columnaInicial))
        if (arrayBooleanos[27]) bolsaTemp.add(Pieza_I_v3(-1, columnaInicial - 1))
        if (arrayBooleanos[28]) bolsaTemp.add(Pieza_Y_v2(0, columnaInicial))
        if (arrayBooleanos[29]) bolsaTemp.add(Pieza_O_v4(0, columnaInicial))
        if (arrayBooleanos[30]) bolsaTemp.add(Pieza_J_v2(0, columnaInicial))
        if (arrayBooleanos[31]) bolsaTemp.add(Pieza_A(0, columnaInicial))
        if (arrayBooleanos[32]) bolsaTemp.add(Pieza_Mini_I(0, columnaInicial))
        if (arrayBooleanos[33]) bolsaTemp.add(Pieza_Mini_I_v2(0, columnaInicial))
        if (arrayBooleanos[34]) bolsaTemp.add(Pieza_Mini_L(0, columnaInicial))
        if (arrayBooleanos[35]) bolsaTemp.add(Pieza_Mini_O(0, columnaInicial))
        if (arrayBooleanos[36]) bolsaTemp.add(Pieza_O_v5(0, columnaInicial))
        if (arrayBooleanos[37]) bolsaTemp.add(Pieza_O_v6(0, columnaInicial))
        if (arrayBooleanos[38]) bolsaTemp.add(Pieza_X_v3(0, columnaInicial))
        if (arrayBooleanos[39]) bolsaTemp.add(Pieza_E(-1, columnaInicial-1))
        if (arrayBooleanos[40]) bolsaTemp.add(Pieza_Twin_O(0, columnaInicial))
        if (arrayBooleanos[41]) bolsaTemp.add(Pieza_Twin_Y(0, columnaInicial))
        if (arrayBooleanos[42]) bolsaTemp.add(Pieza_Pickaxe(0, columnaInicial))
        if (arrayBooleanos[43]) bolsaTemp.add(Pieza_S_v3(-1, columnaInicial-1))
        if (arrayBooleanos[44]) bolsaTemp.add(Pieza_Twin_O_v2(0, columnaInicial))
        if (arrayBooleanos[45]) bolsaTemp.add(Pieza_Ladder(0, columnaInicial))
        if (arrayBooleanos[46]) bolsaTemp.add(Pieza_Z_v3(-1, columnaInicial-1))
        if (arrayBooleanos[47]) bolsaTemp.add(Pieza_H_v2(-1, columnaInicial-1))
    } else {
        bolsaTemp.add(Pieza_O(0, columnaInicial))
        bolsaTemp.add(Pieza_I(0, columnaInicial))
        bolsaTemp.add(Pieza_L(0, columnaInicial))
        bolsaTemp.add(Pieza_Z(0, columnaInicial))
        bolsaTemp.add(Pieza_J(0, columnaInicial))
        bolsaTemp.add(Pieza_S(0, columnaInicial))
        bolsaTemp.add(Pieza_T(0, columnaInicial))
    }


    bolsaTemp.shuffle()
    piezasBolsa.addAll(bolsaTemp)
}