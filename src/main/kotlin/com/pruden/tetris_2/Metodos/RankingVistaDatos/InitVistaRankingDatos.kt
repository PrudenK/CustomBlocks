package com.pruden.tetris_2.Metodos.RankingVistaDatos

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.Rankings.ControladorRankings.Companion.cRanking
import javafx.collections.FXCollections
import javafx.scene.control.cell.PropertyValueFactory

fun initRankingDatos(){
    with(cRanking){
        datosRanking = FXCollections.observableArrayList()

        comboPais.items.add("Global")
        comboPais.items.addAll(Listas.LISTA_PAISES)
        comboPais.value = "Global"

        comboModo.items.addAll(Listas.LISTA_MODOS_DE_JUEGOS)
        comboModo.value = Listas.LISTA_MODOS_DE_JUEGOS[0]


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