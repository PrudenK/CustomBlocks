package com.pruden.tetris_2.Controladores.TusModos

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.checkBoxes
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.tabPosicion
import com.pruden.tetris_2.Metodos.SubirDatos.subirImagenPerfilADB
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.stage.Stage
import okhttp3.MultipartBody
import java.net.URL
import java.util.*

class ControladorCrearModo: ControladorGEN(), Initializable {
    lateinit var stageCrearModo : Stage

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        seleccionarImagen()
        cargarListaCheckBoxes()

        cargarTableroYTitulo()

    }




    companion object{
        var fotoModoDeJuegoSeleccionada : MultipartBody.Part? = null
    }



    // Apartado de nombre e imagen

    @FXML lateinit var pane1: Pane

    @FXML lateinit var textFieldNombreModo: TextField
    @FXML lateinit var imgViewModo: ImageView


    @FXML fun siguiente1(){
        saltoPagina(pane1, pane2)
    }

    @FXML fun volverSalir() = stageCrearModo.close()


    private fun seleccionarImagen(){
        imgViewModo.setOnMouseClicked {
            subirImagenPerfilADB("Seleccionar imagen para modo de juego", imgViewModo)
        }
    }


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

    private fun cargarListaCheckBoxes(){
        checkBoxes = listOf(
            ck_O, ck_I, ck_L, ck_Z, ck_J, ck_S, ck_T, ck_P, ck_X, ck_U,
            ck_L_v2, ck_W, ck_T_v2, ck_Z_v2, ck_X_v2, ck_L_v3, ck_F, ck_O_v2,
            ck_S_v2, ck_B, ck_Y, ck_K, ck_I_v2, ck_C, ck_O_v3, ck_V, ck_H,
            ck_I_v3, ck_Y_v2, ck_O_v4, ck_J_v2, ck_A, ck_Mini_I, ck_Mini_I_v2,
            ck_Mini_L_v2, ck_Mini_O, ck_O_v5, ck_O_v6, ck_X_v3, ck_E, ck_Tw_O,
            ck_Tw_Y, ck_Pick, ck_S_v3, ck_Tw_O_v2, ck_Ladder, ck_Z_v3, ck_H_v2
        )
    }

    private fun devolverListaPiezas(): String{
        var listaPiezas = ""
        for((i, checkBox) in checkBoxes.withIndex()){
            if(checkBox.isSelected){
                listaPiezas += i.toString()+"_"
            }
        }
        listaPiezas = listaPiezas.substring(0, listaPiezas.length-1)
        return listaPiezas
    }


    // Tablero

    @FXML lateinit var pane3: Pane

    @FXML lateinit var carruselTamaTablero: ImageView
    @FXML lateinit var carruselDiseTablero: ImageView
    @FXML lateinit var nombreTamaTablero: Label
    @FXML lateinit var nombreDiseTablero: Label

    private var indiceTamaTablero = 1

    @FXML fun volverTablero(){
        saltoPagina(pane3, pane2)
    }

    @FXML fun siguiente3(){
        saltoPagina(pane3, pane4)
    }

    @FXML fun siguienteTamaTablero(){
        if (indiceTamaTablero == Listas.LISTA_IMAGENES_DE_TABLEROS.size - 1) {
            indiceTamaTablero = 0
        } else indiceTamaTablero++
        cargarTableroYTitulo()
    }

    @FXML fun anteriorTamaTablero(){
        if (indiceTamaTablero == 0) {
            indiceTamaTablero = Listas.LISTA_IMAGENES_DE_TABLEROS.size - 1
        } else indiceTamaTablero--
        cargarTableroYTitulo()
    }

    @FXML fun siguienteDiseTablero(){

    }

    @FXML fun anteriorDiseTablero(){

    }

    private fun cargarTableroYTitulo(){
        val tab: Image = Listas.LISTA_IMAGENES_DE_TABLEROS[indiceTamaTablero]
        nombreTamaTablero.text = tab.url.substring(tab.url.lastIndexOf("/") + 1, tab.url.lastIndexOf("."))
        carruselTamaTablero.image = tab
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