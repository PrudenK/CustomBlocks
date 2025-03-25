package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Metodos.SubirDatos.subirImagenPerfilADB
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.paint.Color
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
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
        var fotoClanSeleccionada : MultipartBody.Part? = null
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
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
        if(nombreClan.text.isNotBlank()){
            if(descripClan.text.isNotBlank()){
                if(comboPais.value != null){
                    CoroutineScope(Dispatchers.IO).launch {
                        val nombre = nombreClan.text
                        val descripcion = descripClan.text
                        val pais = comboPais.value

                        val nombreRB = nombre.toRequestBody("text/plain".toMediaType())
                        val descripcionRB = descripcion.toRequestBody("text/plain".toMediaType())
                        val paisRB = pais.toRequestBody("text/plain".toMediaType())
                        val idLiderRB = idJugador.toString().toRequestBody("text/plain".toMediaType())

                        val response = ApiCustom.clanService.crearClan(
                            fotoClanSeleccionada, nombreRB, descripcionRB, paisRB, idLiderRB
                        )

                        println(response.code())
                        println(response)

                        when(response.code()){
                            409 ->{
                                javafx.application.Platform.runLater {
                                    labelError.textFill = Color.web("#9a1111")
                                    labelError.text = "Ya existe un clan con ese nombre"
                                }
                            }
                            201->{
                                javafx.application.Platform.runLater {
                                    labelError.textFill = Color.web("#67a8f2")
                                    labelError.text = "Clan creado con éxito"
                                }
                            }
                        }
                    }
                }else{
                    labelError.textFill = Color.web("#9a1111")
                    labelError.text = "Selecciona una país"
                }
            }else{
                labelError.textFill = Color.web("#9a1111")
                labelError.text = "Descripción vacía"
            }
        }else{
            labelError.textFill = Color.web("#9a1111")
            labelError.text = "Nombre en blanco"
        }
    }

    @FXML fun volver(){
        stageCrearClan.close()
    }

    override fun setStage(stage: Stage?) {
        stageCrearClan = stage!!
    }

    override fun setBoton(b: Button?) {}


}