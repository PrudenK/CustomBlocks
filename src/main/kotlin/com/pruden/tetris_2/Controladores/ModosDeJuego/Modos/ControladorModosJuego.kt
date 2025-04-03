package com.pruden.tetris_2.Controladores.ModosDeJuego.Modos

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.ImageView
import javafx.scene.text.Text
import javafx.stage.Stage
import java.net.URL
import java.util.*


class ControladorModosJuego : ControladorGEN(), Initializable {
    lateinit var elemento : Button
    @FXML private lateinit var textoModos: Text
    @FXML private lateinit var imgModos: ImageView
    @FXML lateinit var jugar: Button

    companion object{
        lateinit var stageModos: Stage
        lateinit var cModosJuego: ControladorModosJuego
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cModosJuego = this
        cronometro.parar()
        cambairUISegunIndice()
    }

    private var indice = 0

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
        imgModos.image = Listas.LISTA_IMAGENES_MODOS_OFICIALES[indice]
    }

    override fun setStage(stage: Stage?) {
        stageModos = stage!!
    }

    override fun setBoton(b: Button?) {
        elemento = b!!
    }
}