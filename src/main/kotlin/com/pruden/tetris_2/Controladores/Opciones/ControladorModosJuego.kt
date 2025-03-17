package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Modos.ModoDeJuego
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.ImageView
import javafx.scene.text.Text
import javafx.stage.Stage
import java.net.URL
import java.util.*


class ControladorModosJuego : ControladorGEN(), Initializable {
    private lateinit var elemento : Button
    @FXML private lateinit var textoModos: Text
    @FXML private lateinit var imgModos: ImageView

    companion object{
        lateinit var stageModos: Stage
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cronometro.parar()
        cambairUISegunIndice()
    }

    private var indice = 0

    private val modoClasico = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_clasico.jpg")
    private val modoClasicoV2 = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_clasico_v2.jpg")
    private val modoAllIn = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_all_in.jpg")
    private val modoAlgebra = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_Algebra.jpg")
    private val modoRapidO = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_RapidO.jpg")
    private val modoMemory = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_Memory.jpg")
    private val modoMemoryX = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_MemoryX.jpg")
    private val modoMemoryY = deRutaAImagen("/Imagenes/ModosDeJuego/Modo_MemoryY.jpg")

    private val listaImagenesModos = listOf(modoClasico, modoClasicoV2, modoAllIn, modoAlgebra,
        modoRapidO, modoMemory, modoMemoryX, modoMemoryY)


    @FXML fun volver() {
        reanudarPartida()
        stageModos.close()
    }

    @FXML fun jugar(){
        crearStage(Listas.LISTA_STAGES_MODOS_DE_JUEGOS[indice])
    }

    @FXML fun atras(){
        if(indice == 0){
            indice = Listas.LISTA_MODOS_DE_JUEGOS.size - 1
        }else{
            indice--
        }
        cambairUISegunIndice()
    }

    @FXML fun siguiente(){
        if(indice == Listas.LISTA_MODOS_DE_JUEGOS.size - 1){
            indice = 0
        }else{
            indice++
        }
        cambairUISegunIndice()
    }

    private fun cambairUISegunIndice(){
        textoModos.text = Listas.LISTA_MODOS_DE_JUEGOS[indice]
        imgModos.image = listaImagenesModos[indice]
    }

    override fun setStage(stage: Stage?) {
        stageModos = stage!!
    }

    override fun setBoton(b: Button?) {
        elemento = b!!
    }
}