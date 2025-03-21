package com.pruden.tetris_2.Metodos.SubirDatos

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.Perfil.ControladorPerfil.Companion.cPerfil
import javafx.scene.image.Image
import javafx.stage.FileChooser
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.json.JSONObject

fun subirImagenPerfilADB(){
    val fileChooser = FileChooser().apply {
        title = "Seleccionar Imagen"
        extensionFilters.addAll(
            FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        )
    }

    val selectedFile = fileChooser.showOpenDialog(cPerfil.imagenPerfil.scene.window as Stage)

    if (selectedFile != null) {
        val requestFile = selectedFile
            .asRequestBody("image/*".toMediaTypeOrNull())

        val body = MultipartBody.Part.createFormData("imagen", selectedFile.name, requestFile)

        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiCustom.jugadorService.subirImagen(idJugador, body)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responseBody = response.body()?.string()

                    val json = JSONObject(responseBody)
                    val rutaRelativa = json.getString("ruta") // ej: "/uploads/abcd123.png"

                    val urlCompleta = "${ConstantesCustomAPI.PATH_CUSTOM}$rutaRelativa" // cambia tu dominio

                    val image = Image(urlCompleta, true)
                    cPerfil.imagenPerfil.image = image
                }
            }
        }
    }
}