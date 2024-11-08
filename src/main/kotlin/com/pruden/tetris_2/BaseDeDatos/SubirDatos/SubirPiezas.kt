package com.pruden.tetris_2.BaseDeDatos.SubirDatos

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Piezas.*


val nombresPiezas = listOf("numO", "numI", "numL", "numZ", "numJ", "numS", "numT", "numP", "numX", "numU", "numLv2",
    "numW", "numTv2", "numZv2", "numXv2", "numLv3", "numF", "numOv2", "numSv2", "numB", "numY", "numK", "numIv2",
    "numC", "numOv3", "numV", "numH", "numIv3", "numYv2", "numOv4", "numJv2", "numA")

val listaInstancias = listOf(
    Pieza_O::class, Pieza_I::class, Pieza_L::class, Pieza_Z::class, Pieza_J::class, Pieza_S::class, Pieza_T::class,
    Pieza_P::class, Pieza_X::class, Pieza_U::class, Pieza_L_v2::class, Pieza_W::class, Pieza_T_v2::class, Pieza_Z_v2::class,
    Pieza_X_v2::class, Pieza_L_v3::class, Pieza_F::class, Pieza_O_v2::class, Pieza_S_v2::class, Pieza_B::class, Pieza_Y::class,
    Pieza_K::class, Pieza_I_v2::class, Pieza_C::class, Pieza_O_v3::class, Pieza_V::class, Pieza_H::class, Pieza_I_v3::class,
    Pieza_Y_v2::class, Pieza_O_v4::class, Pieza_J_v2::class, Pieza_A::class
)

var contadorPiezas = MutableList(nombresPiezas.size) { 0 }

fun sumarTipoPieza(pieza : Piezas){
    for ((indice, p) in listaInstancias.withIndex()){
        if (p.isInstance(pieza)){
            contadorPiezas[indice] += 1
            break
        }
    }
}
fun subirTodoEstaPiezas(){
    for (pieza in nombresPiezas){
        subirPiezas(pieza)
    }
    val consultaSubirTotal = """
        Update estaPiezas 
        set total = ?
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val consultaObtenerTotal = """
       Select total from estaPiezas
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val totalPiezas = ControladorLogin.statment.executeQuery(consultaObtenerTotal)
    totalPiezas.next()
    val piezaActu = totalPiezas.getInt("total") + contadorPiezas.sum()

    val preparedStatement = ControladorLogin.conexion.prepareStatement(consultaSubirTotal)

    preparedStatement.setInt(1,piezaActu)

    preparedStatement.executeUpdate()
}

private fun subirPiezas(piezaColumna : String){
    val consultaSubirPieza = """
        Update estaPiezas 
        set $piezaColumna = ?
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val consultaObtenerPieza = """
       Select $piezaColumna from estaPiezas
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val piezaTabla = ControladorLogin.statment.executeQuery(consultaObtenerPieza)
    piezaTabla.next()
    val piezaActu = piezaTabla.getInt(piezaColumna) + contadorPiezas[nombresPiezas.indexOf(piezaColumna)]

    val preparedStatement = ControladorLogin.conexion.prepareStatement(consultaSubirPieza)

    preparedStatement.setInt(1,piezaActu)

    preparedStatement.executeUpdate()
}

