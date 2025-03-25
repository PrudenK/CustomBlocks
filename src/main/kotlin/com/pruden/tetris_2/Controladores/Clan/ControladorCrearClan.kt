package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Metodos.SubirDatos.subirImagenPerfilADB
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import okhttp3.MultipartBody
import java.net.URL
import java.util.*

class ControladorCrearClan: ControladorGEN(), Initializable {
    lateinit var stageCrearClan: Stage

    @FXML lateinit var labelUbicacion: Label
    @FXML lateinit var descrip: Label
    @FXML lateinit var labelError: Label
    @FXML lateinit var nombreClan: TextField
    @FXML lateinit var descripClan: TextArea
    @FXML lateinit var comboPais: ComboBox<String>
    @FXML lateinit var fotoClan: ImageView

    companion object{
        lateinit var fotoClanSeleccionada : MultipartBody.Part
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        stageCrearClan = labelError.scene.window as Stage

        labelUbicacion.text = "Ubicación"
        descrip.text = "Desripción al Clan"

        comboPais.items.addAll(Listas.LISTA_PAISES_CON_INTERNACIONAL)

        nombreClan.textFormatter = TextFormatter<String> { change ->
            if (change.controlNewText.length <= 15) change else null
        }

        descripClan.textFormatter = TextFormatter<String> { change ->
            if (change.controlNewText.length <= 75) change else null
        }

        fotoClan.setOnMouseClicked {
            subirImagenPerfilADB("Seleccionar imagen del clan", fotoClan)
        }
    }


    @FXML fun crear(){

    }

    @FXML fun volver(){
        stageCrearClan.close()
    }

    override fun setStage(stage: Stage?) {
    }

    override fun setBoton(b: Button?) {}


}