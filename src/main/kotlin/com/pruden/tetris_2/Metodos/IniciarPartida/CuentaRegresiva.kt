package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cuentaRegresivaHecha
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.lockCuentaRegresiva
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.util.Duration


private val num1 = deRutaAImagen("/Imagenes/NumerosCuentaRegresiva/i1.png")
private val num2 = deRutaAImagen("/Imagenes/NumerosCuentaRegresiva/i2.png")
private val num3 = deRutaAImagen("/Imagenes/NumerosCuentaRegresiva/i3.png")


fun cuentaAtras(){
    configuracionInicioAnimacion()
    cuentaRegresivaHecha = false

    val timeline = Timeline( // TODO cambiar tiempo
        crearFrame(0.0, num3, "/Musica/Efectos/cuenta_regresiva_3_2_1.mp3", cPrin.cuentaRegresivaIMG),
        crearFrame(1.0, num2, "/Musica/Efectos/cuenta_regresiva_3_2_1.mp3", cPrin.cuentaRegresivaIMG),
        crearFrame(2.0, num1, "/Musica/Efectos/cuenta_regresiva_3_2_1.mp3", cPrin.cuentaRegresivaIMG),
        crearFrame(3.0, null, "/Musica/Efectos/cuenta_final.mp3", cPrin.cuentaRegresivaIMG)
    )
    timeline.cycleCount = 1

    timeline.setOnFinished {
        synchronized(lockCuentaRegresiva){
            cuentaRegresivaHecha = true
            (lockCuentaRegresiva as Object).notify()
        }
    }

    timeline.play()

}

private fun crearFrame(secs : Double, img : Image?, ruta : String, imgView : ImageView) : KeyFrame{
    return KeyFrame(Duration.seconds(secs), { _: ActionEvent? ->
        imgView.image = img
        efectoSonido(ruta)
    })
}
