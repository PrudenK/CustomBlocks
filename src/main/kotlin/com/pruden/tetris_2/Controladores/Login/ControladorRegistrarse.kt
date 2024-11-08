package com.pruden.tetris_2.Controladores.Login

import com.pruden.tetris_2.BaseDeDatos.Comprobaciones.Registrarse.comprobacionesRegistrar
import com.pruden.tetris_2.BaseDeDatos.Comprobaciones.Registrarse.registrarJugador
import com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro.insertarEnTablaPiezas
import com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro.insertarEstasGen
import com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro.insetarEnTablasModos
import com.pruden.tetris_2.BaseDeDatos.hashearContraConSAl
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.conexion
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.stageLogin
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.statment
import com.pruden.tetris_2.Metodos.Eventos.arrastrarFun
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.Pane
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorRegistrarse : Initializable{
    @FXML lateinit var paneLogin: Pane
    @FXML lateinit var passInput: PasswordField
    @FXML lateinit var repetirPassInput: PasswordField
    @FXML lateinit var userInput: TextField
    @FXML lateinit var errorLabel: Label
    @FXML lateinit var comboPais: ComboBox<String>
    lateinit var stageRegistrarse :Stage

    var contraHas = ""
    var loginCorrecto = true

    private val paises = listOf(
        "Afganistán", "Albania", "Argelia", "Andorra", "Angola", "Antigua y Barbuda", "Argentina", "Armenia",
        "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bahrein", "Bangladesh", "Barbados", "Bielorrusia",
        "Bélgica", "Belice", "Benín", "Bután", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil",
        "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Camboya", "Camerún", "Canadá",
        "Catar", "Chile", "China", "Chipre", "Colombia", "Comoras", "Congo", "Corea del Norte", "Corea del Sur",
        "Costa Rica", "Croacia", "Cuba", "Curazao", "Chipre", "República Checa", "Dinamarca", "Djibouti",
        "Dominica", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Ecuador", "Eritrea", "Eslovaquia",
        "Eslovenia", "España", "Estados Unidos", "Estonia", "Eswatini", "Etiopía", "Fiyi", "Filipinas",
        "Finlandia", "Francia", "Gabon", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala",
        "Guayana", "Guinea", "Guinea Ecuatorial", "Guyana Francesa", "Haití", "Honduras", "Hungría", "India",
        "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Cook", "Islas Marshall", "Islas Salomón",
        "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati",
        "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania",
        "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Marianas del Norte",
        "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro",
        "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda",
        "Omán", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia",
        "Portugal", "Reino Unido", "República Dominicana", "República Checa", "Rumanía", "Rusia", "Ruanda",
        "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santo Tomé y Príncipe",
        "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Sudáfrica",
        "Sudán", "Sudán del Sur", "Suecia", "Suiza", "Surinam", "Seychelles", "Tailandia", "Tanzania", "Togo",
        "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay",
        "Uzbekistán", "Vanuatu", "Vaticano", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"
    )


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cRegistrarse = this
        arrastrarFun(paneLogin, stageLogin)

        comboPais.items.addAll(paises)
    }

    companion object{
        lateinit var cRegistrarse : ControladorRegistrarse
        var idNuevoJugador = -1
    }

    @FXML fun volver(){
        stageLogin.x = stageRegistrarse.x
        stageLogin.y = stageRegistrarse.y

        stageRegistrarse.close()


        stageLogin.isIconified = false

    }

    @FXML fun registrarse(){
        registrarJugador()
    }
}