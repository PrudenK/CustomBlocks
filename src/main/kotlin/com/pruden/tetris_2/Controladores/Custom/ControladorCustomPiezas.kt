package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.Observables.cargarObersvablePiezas
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.beans.property.BooleanProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCustomPiezas : ControladorGEN(), Initializable {
    @FXML private lateinit var ck_O: CheckBox
    @FXML private lateinit var ck_I: CheckBox
    @FXML private lateinit var ck_L: CheckBox
    @FXML private lateinit var ck_Z: CheckBox
    @FXML private lateinit var ck_J: CheckBox
    @FXML private lateinit var ck_S: CheckBox
    @FXML private lateinit var ck_T: CheckBox
    @FXML private lateinit var ck_P: CheckBox
    @FXML private lateinit var ck_X: CheckBox
    @FXML private lateinit var ck_U: CheckBox
    @FXML private lateinit var ck_L_v2: CheckBox
    @FXML private lateinit var ck_W: CheckBox
    @FXML private lateinit var ck_T_v2: CheckBox
    @FXML private lateinit var ck_Z_v2: CheckBox
    @FXML private lateinit var ck_X_v2: CheckBox
    @FXML private lateinit var ck_L_v3: CheckBox
    @FXML private lateinit var ck_F: CheckBox
    @FXML private lateinit var ck_O_v2: CheckBox
    @FXML private lateinit var ck_S_v2: CheckBox
    @FXML private lateinit var ck_B: CheckBox
    @FXML private lateinit var ck_Y: CheckBox
    @FXML private lateinit var ck_K: CheckBox
    @FXML private lateinit var ck_I_v2: CheckBox
    @FXML private lateinit var ck_C: CheckBox
    @FXML private lateinit var ck_O_v3: CheckBox
    @FXML private lateinit var ck_V: CheckBox
    @FXML private lateinit var ck_H: CheckBox
    @FXML private lateinit var ck_I_v3: CheckBox
    @FXML private lateinit var ck_Y_v2: CheckBox
    @FXML private lateinit var ck_O_v4: CheckBox
    @FXML private lateinit var ck_J_v2: CheckBox
    @FXML private lateinit var ck_A: CheckBox

    private lateinit var elemento : Button


    companion object{
        lateinit var checkBoxes: List<CheckBox>
        var listaPiezasSeleccionadas = ArrayList<Boolean>()
        lateinit var guardarPiezas: BooleanProperty
        lateinit var stageCustomPiezas : Stage
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cargarListaCheckBoxes()
        cargarCheckboxesInicio()
        cargarObersvablePiezas()
    }


    @FXML private fun salir() {
        stageCustomPiezas.close()
    }

    @FXML private fun guardar() {
        crearStage(ClaseStage("Vistas/Advertencias/vista_Advertencia_Piezas.fxml", elemento, 370.0, 210.0, null, 0, 0))
    }


    private fun cargarCheckboxesInicio(){
        if (listaPiezasSeleccionadas.isNotEmpty()) {
            for (i in checkBoxes.indices) {
                checkBoxes[i].isSelected = listaPiezasSeleccionadas[i]
            }
        }
    }

    private fun cargarListaCheckBoxes(){
        checkBoxes = listOf(
            ck_O, ck_I, ck_L, ck_Z, ck_J, ck_S, ck_T, ck_P, ck_X, ck_U,
            ck_L_v2, ck_W, ck_T_v2, ck_Z_v2, ck_X_v2, ck_L_v3, ck_F, ck_O_v2,
            ck_S_v2, ck_B, ck_Y, ck_K, ck_I_v2, ck_C, ck_O_v3, ck_V, ck_H,
            ck_I_v3, ck_Y_v2, ck_O_v4, ck_J_v2, ck_A
        )
    }


    override fun setStage(stage: Stage?) {
        stageCustomPiezas = stage!!
    }

    override fun setBoton(b: Button?) {
        elemento = b!!
    }
}