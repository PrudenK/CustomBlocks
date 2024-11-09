package com.pruden.tetris_2.Metodos.PartidaVistaDatos

import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.listaModosConTodos
import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.listaOrdenar
import com.pruden.tetris_2.Controladores.Partidas.ControladorPartidas.Companion.cPartidas
import javafx.collections.FXCollections
import javafx.scene.control.cell.PropertyValueFactory

fun initPartidaDatos(){
    with(cPartidas){
        datosPartida = FXCollections.observableArrayList()

        comboFiltrar.items.addAll(listaModosConTodos)
        comboFiltrar.value = listaModosConTodos[0]
        comboOrdenar.items.addAll(listaOrdenar)
        comboOrdenar.value = listaOrdenar[0]


        cargarDatosPartidas()

        comboFiltrar.valueProperty().addListener { _, _, _ ->
            cargarDatosPartidas()
        }

        comboOrdenar.valueProperty().addListener { _, _, _ ->
            ordenar()
        }

        modo.cellValueFactory = PropertyValueFactory("modo")
        nivel.cellValueFactory = PropertyValueFactory("nivel")
        puntu.cellValueFactory = PropertyValueFactory("puntuacion")
        tiempo.cellValueFactory = PropertyValueFactory("tiempo")
        lineas.cellValueFactory = PropertyValueFactory("lineas")
        fecha.cellValueFactory = PropertyValueFactory("fechaJuego")

        tableView.items = datosPartida
    }
}

