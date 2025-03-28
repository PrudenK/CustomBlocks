package com.pruden.tetris_2.Controladores.TusModos

import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.stage.Stage

class ControladorCrearModo: ControladorGEN() {
    lateinit var stageCrearModo : Stage


    // Apartado de nombre e imagen

    @FXML lateinit var pane1: Pane

    @FXML lateinit var textFieldNombreModo: TextField
    @FXML lateinit var imgViewModo: ImageView


    @FXML fun siguiente1(){
        saltoPagina(pane1, pane2)
    }

    @FXML fun volverSalir() = stageCrearModo.close()


    // Apartado de piezas

    @FXML lateinit var pane2: Pane

    @FXML lateinit var ck_O: CheckBox
    @FXML lateinit var ck_I: CheckBox
    @FXML lateinit var ck_L: CheckBox
    @FXML lateinit var ck_Z: CheckBox
    @FXML lateinit var ck_J: CheckBox
    @FXML lateinit var ck_S: CheckBox
    @FXML lateinit var ck_T: CheckBox
    @FXML lateinit var ck_P: CheckBox
    @FXML lateinit var ck_X: CheckBox
    @FXML lateinit var ck_U: CheckBox
    @FXML lateinit var ck_L_v2: CheckBox
    @FXML lateinit var ck_W: CheckBox
    @FXML lateinit var ck_T_v2: CheckBox
    @FXML lateinit var ck_Z_v2: CheckBox
    @FXML lateinit var ck_X_v2: CheckBox
    @FXML lateinit var ck_L_v3: CheckBox
    @FXML lateinit var ck_F: CheckBox
    @FXML lateinit var ck_O_v2: CheckBox
    @FXML lateinit var ck_S_v2: CheckBox
    @FXML lateinit var ck_B: CheckBox
    @FXML lateinit var ck_Y: CheckBox
    @FXML lateinit var ck_K: CheckBox
    @FXML lateinit var ck_I_v2: CheckBox
    @FXML lateinit var ck_C: CheckBox
    @FXML lateinit var ck_O_v3: CheckBox
    @FXML lateinit var ck_V: CheckBox
    @FXML lateinit var ck_H: CheckBox
    @FXML lateinit var ck_I_v3: CheckBox
    @FXML lateinit var ck_Y_v2: CheckBox
    @FXML lateinit var ck_O_v4: CheckBox
    @FXML lateinit var ck_J_v2: CheckBox
    @FXML lateinit var ck_A: CheckBox
    @FXML lateinit var ck_Mini_I: CheckBox
    @FXML lateinit var ck_Mini_I_v2: CheckBox
    @FXML lateinit var ck_Mini_L_v2: CheckBox
    @FXML lateinit var ck_Mini_O: CheckBox
    @FXML lateinit var ck_O_v5: CheckBox
    @FXML lateinit var ck_O_v6: CheckBox
    @FXML lateinit var ck_X_v3: CheckBox
    @FXML lateinit var ck_E: CheckBox
    @FXML lateinit var ck_Tw_O: CheckBox
    @FXML lateinit var ck_Tw_Y: CheckBox
    @FXML lateinit var ck_Pick: CheckBox
    @FXML lateinit var ck_S_v3: CheckBox
    @FXML lateinit var ck_Tw_O_v2: CheckBox
    @FXML lateinit var ck_Ladder: CheckBox
    @FXML lateinit var ck_Z_v3: CheckBox
    @FXML lateinit var ck_H_v2: CheckBox

    
    @FXML fun volverPiezas(){
        saltoPagina(pane2, pane1)
    }

    @FXML fun siguiente2(){
        saltoPagina(pane2, pane3)
    }


    // Tablero

    @FXML lateinit var pane3: Pane

    @FXML lateinit var carruselTamaTablero: ImageView
    @FXML lateinit var carruselDiseTablero: ImageView
    @FXML lateinit var nombreTamaTablero: Label
    @FXML lateinit var nombreDiseTablero: Label


    @FXML fun volverTablero(){
        saltoPagina(pane3, pane2)
    }

    @FXML fun siguiente3(){
        saltoPagina(pane3, pane4)
    }

    @FXML fun siguienteTamaTablero(){

    }

    @FXML fun anteriorTamaTablero(){

    }

    @FXML fun siguienteDiseTablero(){

    }

    @FXML fun anteriorDiseTablero(){

    }


    // Diseño

    @FXML lateinit var pane4: Pane

    @FXML lateinit var imgViewTiposPieza: ImageView
    @FXML lateinit var imgViewTipoTableroSecun: ImageView
    @FXML lateinit var labelNombreTipoPieza: Label
    @FXML lateinit var labelNombreTipoTableroSecun: Label


    @FXML fun volverDise(){
        saltoPagina(pane4, pane3)
    }

    @FXML fun siguiente4(){
        saltoPagina(pane4, pane5)
    }

    @FXML fun atrasDisePiezas(){

    }

    @FXML fun siguienteDisePiezas(){

    }

    @FXML fun atrasDiseTableroSecun(){

    }

    @FXML fun siguienteDiseTableroSecun(){

    }


    // Otras configuraciones

    @FXML lateinit var pane5: Pane

    @FXML lateinit var labelTiempoCaidaInicial: Label
    @FXML lateinit var labelLinesSaltoNivel: Label
    @FXML lateinit var labelSaltoTiempoNivel: Label
    @FXML lateinit var labelLimiteRotaciones: Label


    @FXML lateinit var masLimiteRotacionesB: Button
    @FXML lateinit var menosLimiteRotacionesB: Button
    @FXML lateinit var activarLimite: Button
    @FXML lateinit var activarHoldB: Button
    @FXML lateinit var siguientesPiezasB: Button
    @FXML lateinit var activarDashButton: Button


    @FXML fun masTiempoCaidaInicial(){

    }

    @FXML fun menosTiempoCaidaInicial(){

    }

    @FXML fun masLinesSaltoNivel(){

    }

    @FXML fun menosLinesSaltoNivel(){

    }

    @FXML fun masSaltoTiempoNivel(){

    }

    @FXML fun menosSaltoTiempoNivel(){

    }

    @FXML fun masLimiteRotaciones(){

    }

    @FXML fun menosLimiteRotaciones(){

    }

    @FXML fun limiteB(){

    }

    @FXML fun activarHold(){

    }

    @FXML fun siguientesPiezas(){

    }

    @FXML fun activarDashes(){

    }

    @FXML fun guardarModo(){

    }

    @FXML fun volverConfi(){
        saltoPagina(pane5, pane4)
    }



    private fun saltoPagina(paneActual: Pane, paneMove: Pane){
        paneActual.isVisible = false
        paneMove.isVisible = true
    }

    override fun setStage(stage: Stage?) {
        stageCrearModo = stage!!
    }

    override fun setBoton(b: Button?) {}
}