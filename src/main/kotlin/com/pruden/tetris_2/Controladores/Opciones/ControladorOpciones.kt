package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.animacionEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaPVPenCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Controladores.Partidas.ControladorPartidasGuardadas
import com.pruden.tetris_2.Controladores.Suscripciones.ControladorSuscripciones.Companion.indiceSuscripciones
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorOpciones : ControladorGEN(), Initializable{
    @FXML lateinit var guardados: Button
    @FXML lateinit var perfil: Button
    @FXML lateinit var rankings: Button
    @FXML lateinit var suscripciones: Button
    @FXML lateinit var logros: Button
    @FXML lateinit var guardar: Button
    @FXML lateinit var reiniciar: Button

    companion object{
        lateinit var stageOpciones: Stage
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        if(partidaPVPenCurso){
            guardados.isDisable = true
            perfil.isDisable = true
            rankings.isDisable = true
            suscripciones.isDisable = true
            logros.isDisable = true
            guardar.isDisable = true
            reiniciar.isDisable = true
        }else{
            timelinePartida.stop()
            cronometro.parar()
        }
    }
    @FXML fun volver() {
        if(partidaEnCurso && !partidaPVPenCurso){
            reanudarPartida()
        }
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
        if(!partidaPVPenCurso){
            reanudarPartida()
        }
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