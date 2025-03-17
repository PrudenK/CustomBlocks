package com.pruden.tetris_2.Metodos.Matriz

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasilla
import com.pruden.tetris_2.Piezas.Pieza_J_v2.Companion.CENTRO_J_v2
import com.pruden.tetris_2.Piezas.Pieza_J_v2.Companion.COLOR_J_v2
import com.pruden.tetris_2.Piezas.Pieza_J_v2.Companion.NUMPIEZA_J_v2
import com.pruden.tetris_2.Piezas.Pieza_A.Companion.CENTRO_A
import com.pruden.tetris_2.Piezas.Pieza_A.Companion.COLOR_A
import com.pruden.tetris_2.Piezas.Pieza_A.Companion.NUMPIEZA_A
import com.pruden.tetris_2.Piezas.Pieza_B.Companion.CENTRO_B
import com.pruden.tetris_2.Piezas.Pieza_B.Companion.COLOR_B
import com.pruden.tetris_2.Piezas.Pieza_B.Companion.NUMPIEZA_B
import com.pruden.tetris_2.Piezas.Pieza_C.Companion.COLOR_C
import com.pruden.tetris_2.Piezas.Pieza_C.Companion.NUMPIEZA_C
import com.pruden.tetris_2.Piezas.Pieza_E.Companion.CENTRO_E
import com.pruden.tetris_2.Piezas.Pieza_E.Companion.COLOR_E
import com.pruden.tetris_2.Piezas.Pieza_E.Companion.NUMPIEZA_E
import com.pruden.tetris_2.Piezas.Pieza_F.Companion.CENTRO_F
import com.pruden.tetris_2.Piezas.Pieza_F.Companion.COLOR_F
import com.pruden.tetris_2.Piezas.Pieza_F.Companion.NUMPIEZA_F
import com.pruden.tetris_2.Piezas.Pieza_H.Companion.CENTRO_H
import com.pruden.tetris_2.Piezas.Pieza_H.Companion.COLOR_H
import com.pruden.tetris_2.Piezas.Pieza_H.Companion.NUMPIEZA_H
import com.pruden.tetris_2.Piezas.Pieza_H_v2.Companion.CENTRO_H_v2
import com.pruden.tetris_2.Piezas.Pieza_H_v2.Companion.COLOR_H_v2
import com.pruden.tetris_2.Piezas.Pieza_H_v2.Companion.NUMPIEZA_H_v2
import com.pruden.tetris_2.Piezas.Pieza_I.Companion.CENTRO_I
import com.pruden.tetris_2.Piezas.Pieza_I.Companion.COLOR_I
import com.pruden.tetris_2.Piezas.Pieza_I.Companion.NUMPIEZA_I
import com.pruden.tetris_2.Piezas.Pieza_I_v2.Companion.CENTRO_I_v2
import com.pruden.tetris_2.Piezas.Pieza_I_v2.Companion.COLOR_I_v2
import com.pruden.tetris_2.Piezas.Pieza_I_v2.Companion.NUMPIEZA_I_v2
import com.pruden.tetris_2.Piezas.Pieza_I_v3.Companion.CENTRO_I_v3
import com.pruden.tetris_2.Piezas.Pieza_I_v3.Companion.COLOR_I_v3
import com.pruden.tetris_2.Piezas.Pieza_I_v3.Companion.NUMPIEZA_I_v3
import com.pruden.tetris_2.Piezas.Pieza_J.Companion.CENTRO_J
import com.pruden.tetris_2.Piezas.Pieza_J.Companion.COLOR_J
import com.pruden.tetris_2.Piezas.Pieza_J.Companion.NUMPIEZA_J
import com.pruden.tetris_2.Piezas.Pieza_K.Companion.CENTRO_K
import com.pruden.tetris_2.Piezas.Pieza_K.Companion.COLOR_K
import com.pruden.tetris_2.Piezas.Pieza_K.Companion.NUMPIEZA_K
import com.pruden.tetris_2.Piezas.Pieza_L.Companion.CENTRO_L
import com.pruden.tetris_2.Piezas.Pieza_L.Companion.COLOR_L
import com.pruden.tetris_2.Piezas.Pieza_L.Companion.NUMPIEZA_L
import com.pruden.tetris_2.Piezas.Pieza_L_v2.Companion.COLOR_L_v2
import com.pruden.tetris_2.Piezas.Pieza_L_v2.Companion.NUMPIEZA_L_v2
import com.pruden.tetris_2.Piezas.Pieza_L_v3.Companion.CENTRO_L_v3
import com.pruden.tetris_2.Piezas.Pieza_L_v3.Companion.COLOR_L_v3
import com.pruden.tetris_2.Piezas.Pieza_L_v3.Companion.NUMPIEZA_L_v3
import com.pruden.tetris_2.Piezas.Pieza_Ladder.Companion.CENTRO_LADDER
import com.pruden.tetris_2.Piezas.Pieza_Ladder.Companion.COLOR_LADDER
import com.pruden.tetris_2.Piezas.Pieza_Ladder.Companion.NUMPIEZA_LADDER
import com.pruden.tetris_2.Piezas.Pieza_Mini_I.Companion.CENTRO_MINI_I
import com.pruden.tetris_2.Piezas.Pieza_Mini_I.Companion.COLOR_MINI_I
import com.pruden.tetris_2.Piezas.Pieza_Mini_I.Companion.NUMPIEZA_MINI_I
import com.pruden.tetris_2.Piezas.Pieza_Mini_I_v2.Companion.CENTRO_MINI_I_v2
import com.pruden.tetris_2.Piezas.Pieza_Mini_I_v2.Companion.COLOR_MINI_I_v2
import com.pruden.tetris_2.Piezas.Pieza_Mini_I_v2.Companion.NUMPIEZA_MINI_I_v2
import com.pruden.tetris_2.Piezas.Pieza_Mini_L.Companion.CENTRO_MINI_L
import com.pruden.tetris_2.Piezas.Pieza_Mini_L.Companion.COLOR_MINI_L
import com.pruden.tetris_2.Piezas.Pieza_Mini_L.Companion.NUMPIEZA_MINI_L
import com.pruden.tetris_2.Piezas.Pieza_Mini_O.Companion.CENTRO_MINI_O
import com.pruden.tetris_2.Piezas.Pieza_Mini_O.Companion.COLOR_MINI_O
import com.pruden.tetris_2.Piezas.Pieza_O.Companion.COLOR_O
import com.pruden.tetris_2.Piezas.Pieza_O.Companion.NUMPIEZA_O
import com.pruden.tetris_2.Piezas.Pieza_O_v2.Companion.CENTRO_O_v2
import com.pruden.tetris_2.Piezas.Pieza_O_v2.Companion.COLOR_O_v2
import com.pruden.tetris_2.Piezas.Pieza_O_v2.Companion.NUMPIEZA_O_v2
import com.pruden.tetris_2.Piezas.Pieza_O_v3.Companion.CENTRO_O_v3
import com.pruden.tetris_2.Piezas.Pieza_O_v3.Companion.COLOR_O_v3
import com.pruden.tetris_2.Piezas.Pieza_O_v3.Companion.NUMPIEZA_O_v3
import com.pruden.tetris_2.Piezas.Pieza_O_v4.Companion.CENTRO_O_v4
import com.pruden.tetris_2.Piezas.Pieza_O_v4.Companion.COLOR_O_v4
import com.pruden.tetris_2.Piezas.Pieza_O_v4.Companion.NUMPIEZA_O_v4
import com.pruden.tetris_2.Piezas.Pieza_O_v5.Companion.CENTRO_O_v5
import com.pruden.tetris_2.Piezas.Pieza_O_v5.Companion.COLOR_O_v5
import com.pruden.tetris_2.Piezas.Pieza_O_v5.Companion.NUMPIEZA_O_v5
import com.pruden.tetris_2.Piezas.Pieza_O_v6.Companion.CENTRO_O_v6
import com.pruden.tetris_2.Piezas.Pieza_O_v6.Companion.COLOR_O_v6
import com.pruden.tetris_2.Piezas.Pieza_O_v6.Companion.NUMPIEZA_O_v6
import com.pruden.tetris_2.Piezas.Pieza_P.Companion.CENTRO_P
import com.pruden.tetris_2.Piezas.Pieza_P.Companion.COLOR_P
import com.pruden.tetris_2.Piezas.Pieza_P.Companion.NUMPIEZA_P
import com.pruden.tetris_2.Piezas.Pieza_S.Companion.CENTRO_S
import com.pruden.tetris_2.Piezas.Pieza_S.Companion.COLOR_S
import com.pruden.tetris_2.Piezas.Pieza_S.Companion.NUMPIEZA_S
import com.pruden.tetris_2.Piezas.Pieza_S_v2.Companion.CENTRO_S_v2
import com.pruden.tetris_2.Piezas.Pieza_S_v2.Companion.COLOR_S_v2
import com.pruden.tetris_2.Piezas.Pieza_S_v2.Companion.NUMPIEZA_S_v2
import com.pruden.tetris_2.Piezas.Pieza_S_v3.Companion.CENTRO_S_v3
import com.pruden.tetris_2.Piezas.Pieza_S_v3.Companion.COLOR_S_v3
import com.pruden.tetris_2.Piezas.Pieza_S_v3.Companion.NUMPIEZA_S_v3
import com.pruden.tetris_2.Piezas.Pieza_T.Companion.CENTRO_T
import com.pruden.tetris_2.Piezas.Pieza_T.Companion.COLOR_T
import com.pruden.tetris_2.Piezas.Pieza_T.Companion.NUMPIEZA_T
import com.pruden.tetris_2.Piezas.Pieza_T_v2.Companion.CENTRO_T_v2
import com.pruden.tetris_2.Piezas.Pieza_T_v2.Companion.COLOR_T_v2
import com.pruden.tetris_2.Piezas.Pieza_T_v2.Companion.NUMPIEZA_T_v2
import com.pruden.tetris_2.Piezas.Pieza_Twin_O.Companion.CENTRO_TWIN_O
import com.pruden.tetris_2.Piezas.Pieza_Twin_O.Companion.NUMPIEZA_TWIN_O
import com.pruden.tetris_2.Piezas.Pieza_Twin_O.Companion.COLOR_TWIN_O
import com.pruden.tetris_2.Piezas.Pieza_Twin_O_v2.Companion.CENTRO_TWIN_O_v2
import com.pruden.tetris_2.Piezas.Pieza_Twin_O_v2.Companion.COLOR_TWIN_O_v2
import com.pruden.tetris_2.Piezas.Pieza_Twin_O_v2.Companion.NUMPIEZA_TWIN_O_v2
import com.pruden.tetris_2.Piezas.Pieza_Twin_Y.Companion.CENTRO_TWIN_Y
import com.pruden.tetris_2.Piezas.Pieza_Twin_Y.Companion.COLOR_TWIN_Y
import com.pruden.tetris_2.Piezas.Pieza_Twin_Y.Companion.NUMPIEZA_TWIN_Y
import com.pruden.tetris_2.Piezas.Pieza_U.Companion.CENTRO_U
import com.pruden.tetris_2.Piezas.Pieza_U.Companion.COLOR_U
import com.pruden.tetris_2.Piezas.Pieza_U.Companion.NUMPIEZA_U
import com.pruden.tetris_2.Piezas.Pieza_V.Companion.CENTRO_V
import com.pruden.tetris_2.Piezas.Pieza_V.Companion.COLOR_V
import com.pruden.tetris_2.Piezas.Pieza_V.Companion.NUMPIEZA_V
import com.pruden.tetris_2.Piezas.Pieza_W.Companion.CENTRO_W
import com.pruden.tetris_2.Piezas.Pieza_W.Companion.COLOR_W
import com.pruden.tetris_2.Piezas.Pieza_W.Companion.NUMPIEZA_W
import com.pruden.tetris_2.Piezas.Pieza_X.Companion.CENTRO_X
import com.pruden.tetris_2.Piezas.Pieza_X.Companion.COLOR_X
import com.pruden.tetris_2.Piezas.Pieza_X.Companion.NUMPIEZA_X
import com.pruden.tetris_2.Piezas.Pieza_X_v2.Companion.CENTRO_X_v2
import com.pruden.tetris_2.Piezas.Pieza_X_v2.Companion.COLOR_X_v2
import com.pruden.tetris_2.Piezas.Pieza_X_v2.Companion.NUMPIEZA_X_v2
import com.pruden.tetris_2.Piezas.Pieza_X_v3.Companion.CENTRO_X_v3
import com.pruden.tetris_2.Piezas.Pieza_X_v3.Companion.COLOR_X_v3
import com.pruden.tetris_2.Piezas.Pieza_X_v3.Companion.NUMPIEZA_X_v3
import com.pruden.tetris_2.Piezas.Pieza_Y.Companion.CENTRO_Y
import com.pruden.tetris_2.Piezas.Pieza_Y.Companion.COLOR_Y
import com.pruden.tetris_2.Piezas.Pieza_Y.Companion.NUMPIEZA_Y
import com.pruden.tetris_2.Piezas.Pieza_Y_v2.Companion.CENTRO_Y_v2
import com.pruden.tetris_2.Piezas.Pieza_Y_v2.Companion.COLOR_Y_v2
import com.pruden.tetris_2.Piezas.Pieza_Y_v2.Companion.NUMPIEZA_Y_v2
import com.pruden.tetris_2.Piezas.Pieza_Z.Companion.CENTRO_Z
import com.pruden.tetris_2.Piezas.Pieza_Z.Companion.COLOR_Z
import com.pruden.tetris_2.Piezas.Pieza_Z.Companion.NUMPIEZA_Z
import com.pruden.tetris_2.Piezas.Pieza_Z_v2.Companion.CENTRO_Z_v2
import com.pruden.tetris_2.Piezas.Pieza_Z_v2.Companion.COLOR_Z_v2
import com.pruden.tetris_2.Piezas.Pieza_Z_v2.Companion.NUMPIEZA_Z_v2
import com.pruden.tetris_2.Piezas.Pieza_Z_v3.Companion.CENTRO_Z_v3
import com.pruden.tetris_2.Piezas.Pieza_Z_v3.Companion.COLOR_Z_v3
import com.pruden.tetris_2.Piezas.Pieza_Z_v3.Companion.NUMPIEZA_Z_v3

fun pintarMatriz(j : Int, tipo : Int){
    for (k in matrizNumerica[0].indices) {
        if(j == tipo){
            matrizNumerica[j][k] = BLANCO
            pintarCasilla(FONDO, j.toDouble(), k.toDouble());
        }else {
            if(tipo == 0){
                matrizNumerica[j][k] = matrizNumerica[j-1][k];
            }

            if (matrizNumerica[j][k] == BLANCO) {
                pintarCasilla(FONDO, j.toDouble(), k.toDouble())
            } else if (matrizNumerica[j][k] == NUMPIEZA_O) {
                pintarCasilla(COLOR_O, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_J || matrizNumerica[j][k] == CENTRO_J){
                pintarCasilla(COLOR_J, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_L || matrizNumerica[j][k] == CENTRO_L){
                pintarCasilla(COLOR_L, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_S || matrizNumerica[j][k] == CENTRO_S){
                pintarCasilla(COLOR_S, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_Z || matrizNumerica[j][k] == CENTRO_Z){
                pintarCasilla(COLOR_Z, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_T || matrizNumerica[j][k] == CENTRO_T){
                pintarCasilla(COLOR_T, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_I || matrizNumerica[j][k] == CENTRO_I){
                pintarCasilla(COLOR_I, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_U || matrizNumerica[j][k] == CENTRO_U){
                pintarCasilla(COLOR_U, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_V || matrizNumerica[j][k] == CENTRO_V){
                pintarCasilla(COLOR_V, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_J_v2 || matrizNumerica[j][k] == CENTRO_J_v2){
                pintarCasilla(COLOR_J_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_B || matrizNumerica[j][k] == CENTRO_B){
                pintarCasilla(COLOR_B, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_C){
                pintarCasilla(COLOR_C, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_F || matrizNumerica[j][k] == CENTRO_F){
                pintarCasilla(COLOR_F, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_H || matrizNumerica[j][k] == CENTRO_H){
                pintarCasilla(COLOR_H, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_I_v2 || matrizNumerica[j][k] == CENTRO_I_v2){
                pintarCasilla(COLOR_I_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_I_v3 || matrizNumerica[j][k] == CENTRO_I_v3){
                pintarCasilla(COLOR_I_v3, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_K || matrizNumerica[j][k] == CENTRO_K){
                pintarCasilla(COLOR_K, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_L_v2){
                pintarCasilla(COLOR_L_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_O_v2 || matrizNumerica[j][k] == CENTRO_O_v2){
                pintarCasilla(COLOR_O_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_O_v3 || matrizNumerica[j][k] == CENTRO_O_v3){
                pintarCasilla(COLOR_O_v3, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_O_v4 || matrizNumerica[j][k] == CENTRO_O_v4){
                pintarCasilla(COLOR_O_v4, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_P || matrizNumerica[j][k] == CENTRO_P){
                pintarCasilla(COLOR_P, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_S_v2 || matrizNumerica[j][k] == CENTRO_S_v2){
                pintarCasilla(COLOR_S_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_T_v2 || matrizNumerica[j][k] == CENTRO_T_v2){
                pintarCasilla(COLOR_T_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_W || matrizNumerica[j][k] == CENTRO_W){
                pintarCasilla(COLOR_W, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_X || matrizNumerica[j][k] == CENTRO_X){
                pintarCasilla(COLOR_X, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_X_v2 || matrizNumerica[j][k] == CENTRO_X_v2){
                pintarCasilla(COLOR_X_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_Y || matrizNumerica[j][k] == CENTRO_Y){
                pintarCasilla(COLOR_Y, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_Y_v2 || matrizNumerica[j][k] == CENTRO_Y_v2){
                pintarCasilla(COLOR_Y_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_Z_v2 || matrizNumerica[j][k] == CENTRO_Z_v2){
                pintarCasilla(COLOR_Z_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_A || matrizNumerica[j][k] == CENTRO_A){
                pintarCasilla(COLOR_A, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_L_v3 || matrizNumerica[j][k] == CENTRO_L_v3){
                pintarCasilla(COLOR_L_v3, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == CENTRO_MINI_O){
                pintarCasilla(COLOR_MINI_O, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_MINI_I || matrizNumerica[j][k] == CENTRO_MINI_I){
                pintarCasilla(COLOR_MINI_I, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_MINI_L || matrizNumerica[j][k] == CENTRO_MINI_L){
                pintarCasilla(COLOR_MINI_L, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_MINI_I_v2 || matrizNumerica[j][k] == CENTRO_MINI_I_v2){
                pintarCasilla(COLOR_MINI_I_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_E || matrizNumerica[j][k] == CENTRO_E){
                pintarCasilla(COLOR_E, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_O_v5 || matrizNumerica[j][k] == CENTRO_O_v5){
                pintarCasilla(COLOR_O_v5, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_O_v6 || matrizNumerica[j][k] == CENTRO_O_v6){
                pintarCasilla(COLOR_O_v6, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_TWIN_O || matrizNumerica[j][k] == CENTRO_TWIN_O){
                pintarCasilla(COLOR_TWIN_O, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_TWIN_Y || matrizNumerica[j][k] == CENTRO_TWIN_Y){
                pintarCasilla(COLOR_TWIN_Y, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_X_v3 || matrizNumerica[j][k] == CENTRO_X_v3){
                pintarCasilla(COLOR_X_v3, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_Z_v3 || matrizNumerica[j][k] == CENTRO_Z_v3){
                pintarCasilla(COLOR_Z_v3, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_TWIN_O_v2 || matrizNumerica[j][k] == CENTRO_TWIN_O_v2){
                pintarCasilla(COLOR_TWIN_O_v2, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_LADDER || matrizNumerica[j][k] == CENTRO_LADDER){
                pintarCasilla(COLOR_LADDER, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_S_v3 || matrizNumerica[j][k] == CENTRO_S_v3){
                pintarCasilla(COLOR_S_v3, j.toDouble(), k.toDouble())
            }else if (matrizNumerica[j][k] == NUMPIEZA_H_v2 || matrizNumerica[j][k] == CENTRO_H_v2){
                pintarCasilla(COLOR_H_v2, j.toDouble(), k.toDouble())
            }


            if(tipo == -10){
                matrizNumerica[j][k] = matrizNumerica[j][k];
            }
        }
    }
}