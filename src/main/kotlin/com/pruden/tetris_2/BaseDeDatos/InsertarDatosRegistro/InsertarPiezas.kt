package com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro

import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse

fun insertarEnTablaPiezas(){
    val consulta = """
            INSERT INTO estaPiezas ( 
            idJugador, numO, numI, numL, numZ, numJ, numS, numT, numP, numX, numU,
            numLv2, numW, numTv2, numZv2, numXv2, numLv3, numF, numOv2, numSv2,numB, numY, numK, numIv2, numC,
            numOv3, numV, numH, numIv3, numYv2, numOv4, numJv2, numA, total)
            VALUES 
            (?, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        """

    val preparedStatment = ControladorLogin.conexion.prepareStatement(consulta)

    preparedStatment.setInt(1, ControladorRegistrarse.idNuevoJugador)
    preparedStatment.executeUpdate()
}