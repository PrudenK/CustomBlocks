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
        deRutaAImagen("/Imagenes/Tipo_De_Pieza/Hexagono.png"),
        deRutaAImagen("/Imagenes/Tipo_De_Pieza/Octagono.png")
    )

    val MAPA_TIPO_PIEZAS_IMG: HashMap<Int, javafx.scene.image.Image> = hashMapOf(
        0 to LISTA_IMAGENES_TIPO_DE_PIEZAS[0],
        3 to LISTA_IMAGENES_TIPO_DE_PIEZAS[1],
        4 to LISTA_IMAGENES_TIPO_DE_PIEZAS[2],
        5 to LISTA_IMAGENES_TIPO_DE_PIEZAS[3],
        6 to LISTA_IMAGENES_TIPO_DE_PIEZAS[4],
        8 to LISTA_IMAGENES_TIPO_DE_PIEZAS[5],
    )

    val MAPA_TIPO_PIEZAS_NOMBRES: HashMap<Int, String> = hashMapOf(
        0 to "Círculo",
        1 to "Triángulo",
        2 to "Cuadrado",
        3 to "Pentágono",
        4 to "Hexágono",
        5 to "Octágono",
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

    val MAPA_PAISES_SIMBOLOS_BANDERAS = mapOf(
        "Afganistán" to "af",
        "Albania" to "al",
        "Alemania" to "de",
        "Andorra" to "ad",
        "Angola" to "ao",
        "Antigua y Barbuda" to "ag",
        "Arabia Saudita" to "sa",
        "Argelia" to "dz",
        "Argentina" to "ar",
        "Armenia" to "am",
        "Australia" to "au",
        "Austria" to "at",
        "Azerbaiyán" to "az",
        "Bahamas" to "bs",
        "Bahrein" to "bh",
        "Bangladesh" to "bd",
        "Barbados" to "bb",
        "Bélgica" to "be",
        "Belice" to "bz",
        "Benín" to "bj",
        "Bielorrusia" to "by",
        "Birmania" to "mm",
        "Bolivia" to "bo",
        "Bosnia y Herzegovina" to "ba",
        "Botsuana" to "bw",
        "Brasil" to "br",
        "Brunéi" to "bn",
        "Bulgaria" to "bg",
        "Burkina Faso" to "bf",
        "Burundi" to "bi",
        "Bután" to "bt",
        "Cabo Verde" to "cv",
        "Camboya" to "kh",
        "Camerún" to "cm",
        "Canadá" to "ca",
        "Catar" to "qa",
        "Chad" to "td",
        "Chile" to "cl",
        "China" to "cn",
        "Chipre" to "cy",
        "Colombia" to "co",
        "Comoras" to "km",
        "Congo" to "cg",
        "Corea del Norte" to "kp",
        "Corea del Sur" to "kr",
        "Costa Rica" to "cr",
        "Croacia" to "hr",
        "Cuba" to "cu",
        "Dinamarca" to "dk",
        "Dominica" to "dm",
        "Ecuador" to "ec",
        "Egipto" to "eg",
        "El Salvador" to "sv",
        "Emiratos Árabes Unidos" to "ae",
        "Eritrea" to "er",
        "Eslovaquia" to "sk",
        "Eslovenia" to "si",
        "España" to "es",
        "Estados Unidos" to "us",
        "Estonia" to "ee",
        "Eswatini" to "sz",
        "Etiopía" to "et",
        "Filipinas" to "ph",
        "Finlandia" to "fi",
        "Fiyi" to "fj",
        "Francia" to "fr",
        "Gabón" to "ga",
        "Gambia" to "gm",
        "Georgia" to "ge",
        "Ghana" to "gh",
        "Granada" to "gd",
        "Grecia" to "gr",
        "Guatemala" to "gt",
        "Guinea" to "gn",
        "Guinea-Bisáu" to "gw",
        "Guinea Ecuatorial" to "gq",
        "Guyana" to "gy",
        "Haití" to "ht",
        "Honduras" to "hn",
        "Hungría" to "hu",
        "India" to "in",
        "Indonesia" to "id",
        "Irak" to "iq",
        "Irán" to "ir",
        "Irlanda" to "ie",
        "Islandia" to "is",
        "Islas Marshall" to "mh",
        "Islas Salomón" to "sb",
        "Israel" to "il",
        "Italia" to "it",
        "Jamaica" to "jm",
        "Japón" to "jp",
        "Jordania" to "jo",
        "Kazajistán" to "kz",
        "Kenia" to "ke",
        "Kirguistán" to "kg",
        "Kiribati" to "ki",
        "Kuwait" to "kw",
        "Laos" to "la",
        "Lesoto" to "ls",
        "Letonia" to "lv",
        "Líbano" to "lb",
        "Liberia" to "lr",
        "Libia" to "ly",
        "Liechtenstein" to "li",
        "Lituania" to "lt",
        "Luxemburgo" to "lu",
        "Madagascar" to "mg",
        "Malasia" to "my",
        "Malaui" to "mw",
        "Maldivas" to "mv",
        "Malí" to "ml",
        "Malta" to "mt",
        "Marruecos" to "ma",
        "Mauricio" to "mu",
        "Mauritania" to "mr",
        "México" to "mx",
        "Micronesia" to "fm",
        "Moldavia" to "md",
        "Mónaco" to "mc",
        "Mongolia" to "mn",
        "Montenegro" to "me",
        "Mozambique" to "mz",
        "Namibia" to "na",
        "Nauru" to "nr",
        "Nepal" to "np",
        "Nicaragua" to "ni",
        "Níger" to "ne",
        "Nigeria" to "ng",
        "Noruega" to "no",
        "Nueva Zelanda" to "nz",
        "Omán" to "om",
        "Países Bajos" to "nl",
        "Pakistán" to "pk",
        "Palaos" to "pw",
        "Panamá" to "pa",
        "Papúa Nueva Guinea" to "pg",
        "Paraguay" to "py",
        "Perú" to "pe",
        "Polonia" to "pl",
        "Portugal" to "pt",
        "Reino Unido" to "gb",
        "República Centroafricana" to "cf",
        "República Checa" to "cz",
        "República Dominicana" to "do",
        "República Democrática del Congo" to "cd",
        "Ruanda" to "rw",
        "Rumanía" to "ro",
        "Rusia" to "ru",
        "San Cristóbal y Nieves" to "kn",
        "San Marino" to "sm",
        "San Vicente y las Granadinas" to "vc",
        "Santa Lucía" to "lc",
        "Santo Tomé y Príncipe" to "st",
        "Senegal" to "sn",
        "Serbia" to "rs",
        "Seychelles" to "sc",
        "Sierra Leona" to "sl",
        "Singapur" to "sg",
        "Siria" to "sy",
        "Somalia" to "so",
        "Sri Lanka" to "lk",
        "Sudáfrica" to "za",
        "Sudán" to "sd",
        "Sudán del Sur" to "ss",
        "Suecia" to "se",
        "Suiza" to "ch",
        "Surinam" to "sr",
        "Tailandia" to "th",
        "Tanzania" to "tz",
        "Tayikistán" to "tj",
        "Timor Oriental" to "tl",
        "Togo" to "tg",
        "Tonga" to "to",
        "Trinidad y Tobago" to "tt",
        "Túnez" to "tn",
        "Turkmenistán" to "tm",
        "Turquía" to "tr",
        "Tuvalu" to "tv",
        "Ucrania" to "ua",
        "Uganda" to "ug",
        "Uruguay" to "uy",
        "Uzbekistán" to "uz",
        "Vanuatu" to "vu",
        "Vaticano" to "va",
        "Venezuela" to "ve",
        "Vietnam" to "vn",
        "Yemen" to "ye",
        "Yibuti" to "dj",
        "Zambia" to "zm",
        "Zimbabue" to "zw"
    )

}