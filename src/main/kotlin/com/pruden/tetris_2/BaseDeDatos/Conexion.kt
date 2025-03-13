package com.pruden.tetris_2.BaseDeDatos

import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.statment
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


val DB_HOST = "172.30.77.43"
val DB_PORT = "3306"
val DB_USER = "root"
val DB_PASSWORD = "1234"
val DB_NAME = "baseCustom"

private var conexion : Connection? = null
@Synchronized
fun getConexion(): Connection {
    if (conexion == null || conexion!!.isClosed) {
        try {
            val connectionUrl = "jdbc:mysql://$DB_HOST:$DB_PORT/$DB_NAME?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"

            conexion = DriverManager.getConnection(connectionUrl, DB_USER, DB_PASSWORD)

            if (conexion != null) {
                statment = conexion!!.createStatement()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw RuntimeException("Error al conectar a la base de datos", e)
        }
    }
    return conexion!!
}