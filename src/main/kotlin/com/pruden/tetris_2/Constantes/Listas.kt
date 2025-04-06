package com.pruden.tetris_2.Constantes

import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Piezas.*

object Listas {
    val LISTA_VALORES_FILAS_TABLERO = listOf(14, 20, 32)
    val LISTA_VALORES_COLUMNAS_TABLERO = listOf(8, 12, 20)
    val LISTA_VALORES_TAMA_CELDAS = intArrayOf(45, 33, 20)

    val LISTA_MODOS_DE_JUEGOS = listOf("Clásico", "Clásico v2", "All in", "Álgebra", "RapidO", "Memory", "MemoryX", "MemoryY")

    val LISTA_MODOS_CON_TODOS = listOf("Clásico", "Clásico v2", "All in", "Álgebra", "RapidO", "Memory", "MemoryX", "MemoryY","Campaña", "Todos")

    val LISTA_FILTRARDOS = listOf("Fecha", "Nivel", "Lineas", "Puntuación", "Tiempo")

    val NOMBRES_PIEZAS = listOf(
        "numO", "numI", "numL", "numZ", "numJ", "numS", "numT", "numP", "numX", "numU", "numLv2",
        "numW", "numTv2", "numZv2", "numXv2", "numLv3", "numF", "numOv2", "numSv2", "numB", "numY",
        "numK", "numIv2", "numC", "numOv3", "numV", "numH", "numIv3", "numYv2", "numOv4", "numJv2", "numA",
        "numMiniI", "numMiniIv2", "numMiniL", "numMiniO", "numOv5", "numOv6", "numXv3", "numE", "numTwinO",
        "numTwinY", "numPickAxe", "numSv3", "numTwinOv2", "numZv3", "numLadder", "numHv2"
    )

    val NOMBRES_PIEZAS_Y_TOTAL = listOf(
        "numO", "numI", "numL", "numZ", "numJ", "numS", "numT", "numP", "numX", "numU", "numLv2",
        "numW", "numTv2", "numZv2", "numXv2", "numLv3", "numF", "numOv2", "numSv2", "numB", "numY",
        "numK", "numIv2", "numC", "numOv3", "numV", "numH", "numIv3", "numYv2", "numOv4", "numJv2", "numA",
        "numMiniI", "numMiniIv2", "numMiniL", "numMiniO", "numOv5", "numOv6", "numXv3", "numE", "numTwinO",
        "numTwinY", "numPickAxe", "numSv3", "numTwinOv2", "numZv3", "numLadder", "numHv2", "total"
    )

    val LETRAS_PIEZAS = listOf(
        "O", "I", "L", "Z", "J", "S", "T", "P", "X", "U", "Lv2",
        "W", "Tv2", "Zv2", "Xv2", "Lv3", "F", "Ov2", "Sv2", "B", "Y",
        "K", "Iv2", "C", "Ov3", "V", "H", "Iv3", "Yv2", "Ov4", "Jv2", "A",
        "MiniI", "MiniIv2", "MiniL", "MiniO", "Ov5", "Ov6", "Xv3", "E", "TwinO",
        "TwinY", "PickAxe", "Sv3", "TwinOv2", "Zv3", "Ladder", "Hv2"
    )

    val LISTA_INSTANCIAS_PIEZAS = listOf(
        Pieza_O::class, Pieza_I::class, Pieza_L::class, Pieza_Z::class, Pieza_J::class, Pieza_S::class, Pieza_T::class,
        Pieza_P::class, Pieza_X::class, Pieza_U::class, Pieza_L_v2::class, Pieza_W::class, Pieza_T_v2::class, Pieza_Z_v2::class,
        Pieza_X_v2::class, Pieza_L_v3::class, Pieza_F::class, Pieza_O_v2::class, Pieza_S_v2::class, Pieza_B::class, Pieza_Y::class,
        Pieza_K::class, Pieza_I_v2::class, Pieza_C::class, Pieza_O_v3::class, Pieza_V::class, Pieza_H::class, Pieza_I_v3::class,
        Pieza_Y_v2::class, Pieza_O_v4::class, Pieza_J_v2::class, Pieza_A::class, Pieza_Mini_I::class, Pieza_Mini_I_v2::class,
        Pieza_Mini_L::class, Pieza_Mini_O::class, Pieza_O_v5::class, Pieza_O_v6::class, Pieza_X_v3::class, Pieza_E::class,
        Pieza_Twin_O::class, Pieza_Twin_Y::class, Pieza_Pickaxe::class, Pieza_S_v3::class, Pieza_Twin_O_v2::class,
        Pieza_Z_v3::class, Pieza_Ladder::class, Pieza_H_v2::class
    )

    val LISTA_PAISES = listOf(
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

    val LISTA_PAISES_CON_INTERNACIONAL = listOf(
        "Internacional", "Afganistán", "Albania", "Argelia", "Andorra", "Angola", "Antigua y Barbuda", "Argentina", "Armenia",
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

    val LISTA_IMAGENES_DE_TABLEROS = listOf(
        deRutaAImagen("/Imagenes/Tableros/Tablero_12x8.jpg"),
        deRutaAImagen("/Imagenes/Tableros/Tablero_18x10.jpg"),
        deRutaAImagen("/Imagenes/Tableros/Tablero_30x20.jpg")
    )
    
    val LISTA_IMAGENES_TIPOS_TABLEROS_PRINCIPALES = listOf(
        deRutaAImagen("/Imagenes/Tipos_De_Tableros/vacio_principal.jpg"),
        deRutaAImagen("/Imagenes/Tipos_De_Tableros/clasico.jpg"),
        deRutaAImagen("/Imagenes/Tipos_De_Tableros/Memory.jpg"),
        deRutaAImagen("/Imagenes/Tipos_De_Tableros/MemoryX.jpg"),
        deRutaAImagen("/Imagenes/Tipos_De_Tableros/MemoryY.jpg")
    )
    
    val LISTA_NOMBRES_TABLEROS_PRINCIPALES = listOf(
        "Tablero vacío",
        "Tablero clásico",
        "Tablero Memory",
        "Tablero MemoryX",
        "Tablero MemoryY"
    )
    
    val LISTAS_IMAGENES_TIPOS_TABLEROS_SECUNDARIOS = listOf(
        deRutaAImagen("/Imagenes/Tipos_De_Tableros/vacio_secundario.jpg"),
        deRutaAImagen("/Imagenes/Tipos_De_Tableros/clasico_secundario.jpg")
    )

    val LISTA_NOMBRES_TABLEROS_SECUNDARIOS = listOf(
        "Tablero vacío",
        "Tablero clásico"
    )

    val LISTA_IMAGENES_TIPO_DE_PIEZAS = listOf(
        deRutaAImagen("/Imagenes/Tipo_De_Pieza/Circulo.png"),
        deRutaAImagen("/Imagenes/Tipo_De_Pieza/Triangulo.png"),
        deRutaAImagen("/Imagenes/Tipo_De_Pieza/Cuadrado.png"),
        deRutaAImagen("/Imagenes/Tipo_De_Pieza/Pentagono.png"),
        deRutaAImagen("/Imagenes/Tipo_De_Pieza/Hexagono.png")
    )

    val MAPA_TIPO_PIEZAS_IMG: HashMap<Int, javafx.scene.image.Image> = hashMapOf(
        0 to LISTA_IMAGENES_TIPO_DE_PIEZAS[0],
        3 to LISTA_IMAGENES_TIPO_DE_PIEZAS[1],
        4 to LISTA_IMAGENES_TIPO_DE_PIEZAS[2],
        5 to LISTA_IMAGENES_TIPO_DE_PIEZAS[3],
        6 to LISTA_IMAGENES_TIPO_DE_PIEZAS[4]
    )


    var LISTA_CONSTANTE_DE_NOMBRES_MODOS_DE_JUEGO = mutableListOf(
        "Modo 1", "Modo 2", "Modo 3",
        "Modo 4", "Modo 5", "Modo 6",
        "Modo 7", "Modo 8", "Modo 9",
    )

    val LISTA_CONSTANTE_DE_IMAGENES_MODOS_DE_JUEGO = listOf(
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego1.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego2.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego3.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego4.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego5.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego6.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego7.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego8.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego9.jpg")
    )

    val LISTA_IMAGENES_MODOS_OFICIALES = listOf(
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_clasico.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_clasico_v2.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_all_in.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_Algebra.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_RapidO.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_Memory.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_MemoryX.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/Modo_MemoryY.jpg")
    )
}