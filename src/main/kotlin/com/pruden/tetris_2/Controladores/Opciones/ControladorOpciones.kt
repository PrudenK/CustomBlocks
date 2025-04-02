package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.animacionEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Controladores.Partidas.ControladorPartidasGuardadas
import com.pruden.tetris_2.Controladores.Suscripciones.ControladorSuscripciones.Companion.indiceSuscripciones
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorOpciones : ControladorGEN(), Initializable{
    @FXML private lateinit var sonidoo_B: Button

    companion object{
        lateinit var stageOpciones: Stage
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        timelinePartida.stop()
        cronometro.parar()
    }
    @FXML fun volver() {
        reanudarPartida()
        stageOpciones.close()
    }
    @FXML fun sonido() {
        crearStage(Stages.SONIDO)
    }

    @FXML fun reiniciar() {
        cPrin.partdiaNueva()
        stageOpciones.close()
    }
    @FXML fun reanudar() {
        reanudarPartida()
        stageOpciones.close()
    }

    @FXML fun perfil(){
        crearStage(Stages.PERFIL)
    }

    @FXML fun rankings(){
        crearStage(Stages.RANKINGS)
    }

    @FXML fun guardar(){
        ControladorPartidasGuardadas.modo = "Guardar"
        if (!animacionEnCurso) crearStage(Stages.PARTIDAS_GUARDADAS)
    }

    @FXML fun partidasGuardadas(){
        if(jugarOnline){
            ControladorPartidasGuardadas.modo = "Jugar"
            if (!animacionEnCurso) crearStage(Stages.PARTIDAS_GUARDADAS)
        }
    }

    @FXML fun logros(){
        if(jugarOnline){
            crearStage(Stages.LOGROS)
        }
    }

    @FXML fun suscripciones(){
        if(jugarOnline){
            indiceSuscripciones = 0
            if (!animacionEnCurso) crearStage(Stages.SUSCRIPCIONES)
        }
    }

    override fun setStage(stage: Stage?) {
        stageOpciones = stage!!
    }

    override fun setBoton(b: Button?) {
        println()
    }
}