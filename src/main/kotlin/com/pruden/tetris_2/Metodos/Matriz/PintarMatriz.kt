package com.pruden.tetris_2.Metodos.Matriz

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasilla
import com.pruden.tetris_2.Constantes.Globales
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
import com.pruden.tetris_2.Piezas.Pieza_Pickaxe.Companion.CENTRO_PICKAXE
import com.pruden.tetris_2.Piezas.Pieza_Pickaxe.Companion.COLOR_PICKAXE
import com.pruden.tetris_2.Piezas.Pieza_Pickaxe.Companion.NUMPIEZA_PICKAXE
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

val mapaColores = mapOf(
    NUMPIEZA_O to COLOR_O,
    NUMPIEZA_J to COLOR_J, CENTRO_J to COLOR_J,
    NUMPIEZA_L to COLOR_L, CENTRO_L to COLOR_L,
    NUMPIEZA_S to COLOR_S, CENTRO_S to COLOR_S,
    NUMPIEZA_Z to COLOR_Z, CENTRO_Z to COLOR_Z,
    NUMPIEZA_T to COLOR_T, CENTRO_T to COLOR_T,
    NUMPIEZA_I to COLOR_I, CENTRO_I to COLOR_I,
    NUMPIEZA_U to COLOR_U, CENTRO_U to COLOR_U,
    NUMPIEZA_V to COLOR_V, CENTRO_V to COLOR_V,
    NUMPIEZA_J_v2 to COLOR_J_v2, CENTRO_J_v2 to COLOR_J_v2,
    NUMPIEZA_B to COLOR_B, CENTRO_B to COLOR_B,
    NUMPIEZA_C to COLOR_C,
    NUMPIEZA_F to COLOR_F, CENTRO_F to COLOR_F,
    NUMPIEZA_H to COLOR_H, CENTRO_H to COLOR_H,
    NUMPIEZA_H_v2 to COLOR_H_v2, CENTRO_H_v2 to COLOR_H_v2,
    NUMPIEZA_I_v2 to COLOR_I_v2, CENTRO_I_v2 to COLOR_I_v2,
    NUMPIEZA_I_v3 to COLOR_I_v3, CENTRO_I_v3 to COLOR_I_v3,
    NUMPIEZA_K to COLOR_K, CENTRO_K to COLOR_K,
    NUMPIEZA_L_v2 to COLOR_L_v2,
    NUMPIEZA_L_v3 to COLOR_L_v3, CENTRO_L_v3 to COLOR_L_v3,
    NUMPIEZA_O_v2 to COLOR_O_v2, CENTRO_O_v2 to COLOR_O_v2,
    NUMPIEZA_O_v3 to COLOR_O_v3, CENTRO_O_v3 to COLOR_O_v3,
    NUMPIEZA_O_v4 to COLOR_O_v4, CENTRO_O_v4 to COLOR_O_v4,
    NUMPIEZA_O_v5 to COLOR_O_v5, CENTRO_O_v5 to COLOR_O_v5,
    NUMPIEZA_O_v6 to COLOR_O_v6, CENTRO_O_v6 to COLOR_O_v6,
    NUMPIEZA_P to COLOR_P, CENTRO_P to COLOR_P,
    NUMPIEZA_S_v2 to COLOR_S_v2, CENTRO_S_v2 to COLOR_S_v2,
    NUMPIEZA_S_v3 to COLOR_S_v3, CENTRO_S_v3 to COLOR_S_v3,
    NUMPIEZA_T_v2 to COLOR_T_v2, CENTRO_T_v2 to COLOR_T_v2,
    NUMPIEZA_W to COLOR_W, CENTRO_W to COLOR_W,
    NUMPIEZA_X to COLOR_X, CENTRO_X to COLOR_X,
    NUMPIEZA_X_v2 to COLOR_X_v2, CENTRO_X_v2 to COLOR_X_v2,
    NUMPIEZA_X_v3 to COLOR_X_v3, CENTRO_X_v3 to COLOR_X_v3,
    NUMPIEZA_Y to COLOR_Y, CENTRO_Y to COLOR_Y,
    NUMPIEZA_Y_v2 to COLOR_Y_v2, CENTRO_Y_v2 to COLOR_Y_v2,
    NUMPIEZA_Z_v2 to COLOR_Z_v2, CENTRO_Z_v2 to COLOR_Z_v2,
    NUMPIEZA_Z_v3 to COLOR_Z_v3, CENTRO_Z_v3 to COLOR_Z_v3,
    NUMPIEZA_A to COLOR_A, CENTRO_A to COLOR_A,
    NUMPIEZA_E to COLOR_E, CENTRO_E to COLOR_E,
    NUMPIEZA_MINI_I to COLOR_MINI_I, CENTRO_MINI_I to COLOR_MINI_I,
    NUMPIEZA_MINI_I_v2 to COLOR_MINI_I_v2, CENTRO_MINI_I_v2 to COLOR_MINI_I_v2,
    NUMPIEZA_MINI_L to COLOR_MINI_L, CENTRO_MINI_L to COLOR_MINI_L,
    CENTRO_MINI_O to COLOR_MINI_O,
    NUMPIEZA_TWIN_O to COLOR_TWIN_O, CENTRO_TWIN_O to COLOR_TWIN_O,
    NUMPIEZA_TWIN_O_v2 to COLOR_TWIN_O_v2, CENTRO_TWIN_O_v2 to COLOR_TWIN_O_v2,
    NUMPIEZA_TWIN_Y to COLOR_TWIN_Y, CENTRO_TWIN_Y to COLOR_TWIN_Y,
    NUMPIEZA_LADDER to COLOR_LADDER, CENTRO_LADDER to COLOR_LADDER,
    NUMPIEZA_PICKAXE to COLOR_PICKAXE,
    CENTRO_PICKAXE to Globales.COLOR_MANGO_PICO,
    Globales.NUMPIEZA_PICO to Globales.COLOR_MANGO_PICO
)


fun pintarMatriz(j: Int, tipo: Int) {
    for (k in matrizNumerica[0].indices) {
        if (j == tipo) {
            matrizNumerica[j][k] = Globales.BLANCO
            pintarCasilla(FONDO, j.toDouble(), k.toDouble())
        } else {
            if (tipo == 0) {
                matrizNumerica[j][k] = matrizNumerica[j - 1][k]
            }

            val valor = matrizNumerica[j][k]
            val color = mapaColores[valor]

            if (valor == Globales.BLANCO) {
                pintarCasilla(FONDO, j.toDouble(), k.toDouble())
            } else if (color != null) {
                pintarCasilla(color, j.toDouble(), k.toDouble())
            }

            if (tipo == -10) {
                matrizNumerica[j][k] = valor
            }
        }
    }
}
