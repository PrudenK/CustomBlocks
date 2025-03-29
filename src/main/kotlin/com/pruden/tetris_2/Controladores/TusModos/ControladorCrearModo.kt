package com.pruden.tetris_2.Controladores.TusModos

import com.google.gson.Gson
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAux.ModoDeJuegoAPI
import com.pruden.tetris_2.Constantes.Configuraciones
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaTusModosDeJuego
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.checkBoxes
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.net.URL
import java.util.*

class ControladorCrearModo: ControladorGEN(), Initializable {
    lateinit var stageCrearModo : Stage

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        seleccionarImagen()
        cargarListaCheckBoxes()

        cargarTamaTableroYTitulo()
        cargarInitDiseTableroPrincipal()
        ponerNombreLabelDisePiezas()
        cargarInitDiseTableroSecun()
        cargarValoresInitOtrasConfiguraciones()
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

    @FXML fun volverSalir(){
        fotoModoDeJuegoSeleccionada = null
        stageCrearModo.close()
    }


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
    private var indiceDiseTablero = 1

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
        cargarTamaTableroYTitulo()
    }

    @FXML fun anteriorTamaTablero(){
        if (indiceTamaTablero == 0) {
            indiceTamaTablero = Listas.LISTA_IMAGENES_DE_TABLEROS.size - 1
        } else indiceTamaTablero--
        cargarTamaTableroYTitulo()
    }

    @FXML fun siguienteDiseTablero(){
        if (indiceDiseTablero == Listas.LISTA_IMAGENES_TIPOS_TABLEROS_PRINCIPALES.size - 1) {
            indiceDiseTablero = 0
        } else indiceDiseTablero++
        carruselDiseTablero.image = Listas.LISTA_IMAGENES_TIPOS_TABLEROS_PRINCIPALES[indiceDiseTablero]
        nombreDiseTablero.text = Listas.LISTA_NOMBRES_TABLEROS_PRINCIPALES[indiceDiseTablero]
        println(indiceDiseTablero)
    }

    @FXML fun anteriorDiseTablero(){
        if (indiceDiseTablero == 0) {
            indiceDiseTablero = Listas.LISTA_IMAGENES_TIPOS_TABLEROS_PRINCIPALES.size - 1
        } else indiceDiseTablero--
        carruselDiseTablero.image = Listas.LISTA_IMAGENES_TIPOS_TABLEROS_PRINCIPALES[indiceDiseTablero]
        nombreDiseTablero.text = Listas.LISTA_NOMBRES_TABLEROS_PRINCIPALES[indiceDiseTablero]
    }

    private fun cargarTamaTableroYTitulo(){
        val tab: Image = Listas.LISTA_IMAGENES_DE_TABLEROS[indiceTamaTablero]
        nombreTamaTablero.text = tab.url.substring(tab.url.lastIndexOf("/") + 1, tab.url.lastIndexOf("."))
        carruselTamaTablero.image = tab
    }

    private fun cargarInitDiseTableroPrincipal(){
        carruselDiseTablero.image = Listas.LISTA_IMAGENES_TIPOS_TABLEROS_PRINCIPALES[indiceDiseTablero]
        nombreDiseTablero.text = Listas.LISTA_NOMBRES_TABLEROS_PRINCIPALES[indiceDiseTablero]
    }


    // Diseño

    @FXML lateinit var pane4: Pane

    @FXML lateinit var imgViewTiposPieza: ImageView
    @FXML lateinit var imgViewTipoTableroSecun: ImageView
    @FXML lateinit var labelNombreTipoPieza: Label
    @FXML lateinit var labelNombreTipoTableroSecun: Label

    private var indiceDisePieza = 2
    private var indiceDiseTableroSecun = 1

    @FXML fun volverDise(){
        saltoPagina(pane4, pane3)
    }

    @FXML fun siguiente4(){
        saltoPagina(pane4, pane5)
    }

    @FXML fun atrasDisePiezas(){
        if (indiceDisePieza != 0) {
            indiceDisePieza--
        } else indiceDisePieza = Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS.size - 1
        ponerNombreLabelDisePiezas()
    }

    @FXML fun siguienteDisePiezas(){
        if (indiceDisePieza != Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS.size - 1) {
            indiceDisePieza++
        } else indiceDisePieza = 0
        ponerNombreLabelDisePiezas()
    }

    @FXML fun atrasDiseTableroSecun(){
        if (indiceDiseTableroSecun == 0) {
            indiceDiseTableroSecun =
                Listas.LISTAS_IMAGENES_TIPOS_TABLEROS_SECUNDARIOS.size - 1
        } else indiceDiseTableroSecun--
        imgViewTipoTableroSecun.image = Listas.LISTAS_IMAGENES_TIPOS_TABLEROS_SECUNDARIOS[indiceDiseTableroSecun]
        labelNombreTipoTableroSecun.text = Listas.LISTA_NOMBRES_TABLEROS_SECUNDARIOS[indiceDiseTableroSecun]
    }

    @FXML fun siguienteDiseTableroSecun(){
        if (indiceDiseTableroSecun == Listas.LISTAS_IMAGENES_TIPOS_TABLEROS_SECUNDARIOS.size - 1) {
            indiceDiseTableroSecun = 0
        } else indiceDiseTableroSecun++
        imgViewTipoTableroSecun.image = Listas.LISTAS_IMAGENES_TIPOS_TABLEROS_SECUNDARIOS[indiceDiseTableroSecun]
        labelNombreTipoTableroSecun.text = Listas.LISTA_NOMBRES_TABLEROS_SECUNDARIOS[indiceDiseTableroSecun]
    }

    private fun ponerNombreLabelDisePiezas() {
        imgViewTiposPieza.image = Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS[indiceDisePieza];
        labelNombreTipoPieza.text = (Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS[indiceDisePieza].url.substring(Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS[indiceDisePieza].
        url.lastIndexOf("/")+1, Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS[indiceDisePieza].url.lastIndexOf(".")));
    }

    private fun cargarInitDiseTableroSecun(){
        imgViewTipoTableroSecun.image = Listas.LISTAS_IMAGENES_TIPOS_TABLEROS_SECUNDARIOS[indiceDiseTableroSecun]
        labelNombreTipoTableroSecun.text = Listas.LISTA_NOMBRES_TABLEROS_SECUNDARIOS[indiceDiseTableroSecun]
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

    private var tiempoCaida = 1500
    private var saltoNivel = 10
    private var saltoTiempoNivel = 100
    private var rotaciones = 0
    private var limiteRotaciones = false
    private var activarSiguientesPiezasB = true
    private var activarHoldGuardar = true
    private var activarDashes = false


    @FXML fun menosTiempoCaidaInicial(){
        if (tiempoCaida > Configuraciones.TIEMPO_MINIMO_CAIDA) {
            tiempoCaida -= Configuraciones.SALTO_TIEMPO_CAIDA
            labelTiempoCaidaInicial.text = tiempoCaida.toString() + Configuraciones.MS
        }
    }

    @FXML fun masTiempoCaidaInicial(){
        if (tiempoCaida < Configuraciones.TIEMPO_MAXIMO_CAIDA) {
            tiempoCaida += Configuraciones.SALTO_TIEMPO_CAIDA
            labelTiempoCaidaInicial.text = tiempoCaida.toString() + Configuraciones.MS
        }
    }

    @FXML fun menosLinesSaltoNivel(){
        if (saltoNivel > Configuraciones.LINEAS_SALTO_NIVEL_MINIMO) {
            saltoNivel -= Configuraciones.SALTO_LINEAS_SALTO_NIVEL
            labelLinesSaltoNivel.text = saltoNivel.toString()
        }
    }

    @FXML fun masLinesSaltoNivel(){
        if (saltoNivel < Configuraciones.LINEAS_SALTO_NIVEL_MAXIMO) {
            saltoNivel += Configuraciones.SALTO_LINEAS_SALTO_NIVEL
            labelLinesSaltoNivel.text = saltoNivel.toString()
        }
    }

    @FXML fun menosSaltoTiempoNivel(){
        if (saltoTiempoNivel > Configuraciones.SALTO_TIEMPO_NIVEL_MINIMO) {
            saltoTiempoNivel -= Configuraciones.SALTO_SALTO_TIEMPO_NIVEL
            labelSaltoTiempoNivel.text = saltoTiempoNivel.toString() + Configuraciones.MS
        }
    }

    @FXML fun masSaltoTiempoNivel(){
        if (saltoTiempoNivel < Configuraciones.SALTO_TIEMPO_NIVEL_MAXIMO) {
            saltoTiempoNivel += Configuraciones.SALTO_SALTO_TIEMPO_NIVEL
            labelSaltoTiempoNivel.text = saltoTiempoNivel.toString() + Configuraciones.MS
        }
    }

    @FXML fun menosLimiteRotaciones(){
        if (rotaciones > Configuraciones.LIMITE_ROTACIONES_MINIMO) {
            rotaciones -= Configuraciones.SALTO_ROTACIONES
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML fun masLimiteRotaciones(){
        if (rotaciones < Configuraciones.LIMITE_ROTACIONES_MAXIMO) {
            rotaciones += Configuraciones.SALTO_ROTACIONES
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML fun limiteB(){
        if (limiteRotaciones) {
            activarLimite.text = "Sin límite"
            masLimiteRotacionesB.isDisable = true
            menosLimiteRotacionesB.isDisable = true
            limiteRotaciones = false
            labelLimiteRotaciones.text = "SIN"
        } else {
            activarLimite.text = "Con límite"
            masLimiteRotacionesB.isDisable = false
            menosLimiteRotacionesB.isDisable = false
            limiteRotaciones = true
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML fun activarHold(){
        if (activarHoldB.text == "Activo") {
            activarHoldB.text = "Desactivado"
            activarHoldGuardar = false
        } else {
            activarHoldB.text = "Activo"
            activarHoldGuardar = true
        }
    }

    @FXML fun siguientesPiezas(){
        if (siguientesPiezasB.text == "Activo") {
            siguientesPiezasB.text = "Desactivado"
            activarSiguientesPiezasB = false
        } else {
            siguientesPiezasB.text = "Activo"
            activarSiguientesPiezasB = true
        }
    }

    @FXML fun activarDashes(){
        if (activarDashButton.text == "Activo"){
            activarDashButton.text = "Desactivado"
            activarDashes = false
        }else{
            activarDashButton.text = "Activo"
            activarDashes = true
        }
    }

    private fun cargarValoresInitOtrasConfiguraciones(){
        labelTiempoCaidaInicial.text = Configuraciones.TIEMPO_CAIDA_POR_DEFECTO.toString() + Configuraciones.MS
        labelLinesSaltoNivel.text = Configuraciones.LINEAS_POR_NIVEL_POR_DEFECTO.toString()
        labelSaltoTiempoNivel.text = Configuraciones.REDUCCION_TIEMPO_POR_NIVEL_POR_DEFECTO.toString() + Configuraciones.MS


        activarLimite.text = "Sin límite"
        masLimiteRotacionesB.isDisable = true
        menosLimiteRotacionesB.isDisable = true
        labelLimiteRotaciones.text = "SIN"

        siguientesPiezasB.text = "Activo"

        activarHoldB.text = "Activo"

        activarDashButton.text = "Desactivado"
    }

    @FXML fun guardarModo(){
        var rotacionesAux = -1
        if(limiteRotaciones) {
           rotacionesAux = rotaciones
        }

        val modoJuego = ModoDeJuegoAPI(
            idJugador = idJugador,
            idnummodo = 1,
            nombre = textFieldNombreModo.text.toString(),
            imagen = "",
            arraypiezas = this.devolverListaPiezas(),
            tablero = indiceTamaTablero,
            tipotableroprincipal = indiceDiseTablero,
            tipopieza = indiceDisePieza,
            tipotablerosecun = indiceDiseTableroSecun,
            tiempocaidainicial = tiempoCaida,
            lineasparasaltonivel = saltoNivel,
            saltodetiempopornivel = saltoTiempoNivel,
            limiterotaciones = rotacionesAux,
            hold = if (activarHoldGuardar) 1 else 0,
            piezas = if (activarSiguientesPiezasB) 1 else 0,
            dashes = if (activarDashes) 1 else 0
        )


        CoroutineScope(Dispatchers.IO).launch {
            val requestBodyModoJuego = Gson().toJson(modoJuego)
                .toRequestBody("application/json; charset=utf-8".toMediaType())

            val response = ApiCustom.modoDeJuegoService.crearModoDeJuego(requestBodyModoJuego, fotoModoDeJuegoSeleccionada)
            when(response.code()){
                200 -> {
                    listaTusModosDeJuego = response.body()!!.toMutableList()
                }
            }
            println(response.code())
            println(response)
        }
        fotoModoDeJuegoSeleccionada = null
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
        stageCrearModo.setOnCloseRequest {
            fotoModoDeJuegoSeleccionada = null
        }
    }

    override fun setBoton(b: Button?) {}
}