package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorOpcionesClan : ControladorGEN() {
    lateinit var stageClanOpciones: Stage


    @FXML fun miClan(){
        if(idClanDelJugador != -1){
            crearStage(ClaseStage("Vistas/Clan/vistaMiClan.fxml", cPrin.nuevaPartidaB, 553.0, 625.0, null, 0, 0))
        }else{

        }
    }

    @FXML fun buscarClan(){
        crearStage(ClaseStage("Vistas/Clan/vistaBuscarClan.fxml", cPrin.nuevaPartidaB, 553.0, 625.0, null, 0, 0))
    }

    @FXML fun crearClan(){
        if(idClanDelJugador == -1){
            crearStage(ClaseStage("Vistas/Clan/vistaCrearClan.fxml", cPrin.nuevaPartidaB, 466.0, 539.0, null, 0, 0))
        }else{

        }
    }

    @FXML fun volver() = stageClanOpciones.close()

    override fun setStage(stage: Stage?) {
        stageClanOpciones = stage!!
    }

    override fun setBoton(b: Button?) {}
}