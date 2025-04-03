package com.pruden.tetris_2.Metodos.SubirDatos

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.Clan.ControladorCrearClan.Companion.fotoClanSeleccionada
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ModosDeJuego.TusModos.ControladorCrearModo.Companion.fotoModoDeJuegoSeleccionada
import javafx.scene.image.Image
import javafx.scene.image.ImageView
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
import java.io.File

fun subirImagenPerfilADB(titulo: String, imageView: ImageView){
    val fileChooser = FileChooser().apply {
        title = titulo
        extensionFilters.addAll(
            FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        )
    }

    val selectedFile = fileChooser.showOpenDialog(imageView.scene.window as Stage)

    if (selectedFile != null) {
        val requestFile = selectedFile.asRequestBody("image/*".toMediaTypeOrNull())

        val body = MultipartBody.Part.createFormData("imagen", selectedFile.name, requestFile)

       when(titulo){
           "Seleccionar imagen de perfil" -> subirImagenPerfil(imageView, body)
           "Seleccionar imagen del clan" -> subirImagenClan(imageView, selectedFile, body)
           "Seleccionar imagen para modo de juego" -> subirImagenParaModoDeJuego(imageView, selectedFile, body)
       }
    }
}

private fun subirImagenPerfil(imageView: ImageView, body: MultipartBody.Part){
    CoroutineScope(Dispatchers.IO).launch {
        val response = ApiCustom.jugadorService.subirImagen(idJugador, body)

        withContext(Dispatchers.Main) {
            if (response.isSuccessful) {
                val responseBody = response.body()?.string()

                val json = JSONObject(responseBody)
                val rutaRelativa = json.getString("ruta") // ej: "/uploads/abcd123.png"

                val urlCompleta = "${ConstantesCustomAPI.PATH_CUSTOM}$rutaRelativa" // cambia tu dominio

                jugadorConTodo!!.imagen = rutaRelativa

                val image = Image(urlCompleta, true)
                imageView.image = image
            }
        }
    }
}

private fun subirImagenClan(imageView: ImageView, selectedFile: File, body: MultipartBody.Part){
    val image = Image(selectedFile.toURI().toString())
    imageView.image = image
    fotoClanSeleccionada = body
}

private fun subirImagenParaModoDeJuego(imageView: ImageView, selectedFile: File, body: MultipartBody.Part){
    val image = Image(selectedFile.toURI().toString())
    imageView.image = image
    fotoModoDeJuegoSeleccionada = body
}