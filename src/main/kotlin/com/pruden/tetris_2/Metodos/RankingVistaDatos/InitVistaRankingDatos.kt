package com.pruden.tetris_2.Metodos.RankingVistaDatos

import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.listaModos
import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.paises
import com.pruden.tetris_2.Controladores.Rankings.ControladorRankings.Companion.cRanking
import javafx.collections.FXCollections
import javafx.scene.control.cell.PropertyValueFactory

fun initRankingDatos(){
    with(cRanking){
        datosRanking = FXCollections.observableArrayList()

        comboPais.items.add("Global")
        comboPais.items.addAll(paises)
        comboPais.value = "Global"

        comboModo.items.addAll(listaModos)
        comboModo.value = listaModos[0]


        cargarDatosRanking()

        comboModo.valueProperty().addListener { _, _, _ ->
            cargarDatosRanking()
        }

        comboPais.valueProperty().addListener { _, _, _ ->
            cargarDatosRanking()
        }

        nombre.cellValueFactory = PropertyValueFactory("nombre")
        nivelUser.cellValueFactory = PropertyValueFactory("nivelJugador")
        nivelPartida.cellValueFactory = PropertyValueFactory("nivelPartida")
        lineas.cellValueFactory = PropertyValueFactory("lineas")
        puntu.cellValueFactory = PropertyValueFactory("puntuacion")
        tiempoPartida.cellValueFactory = PropertyValueFactory("tiempoPartida")
        pais.cellValueFactory = PropertyValueFactory("pais")

        tableView.items = datosRanking
    }
}