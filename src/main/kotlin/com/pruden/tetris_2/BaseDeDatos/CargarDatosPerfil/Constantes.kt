package com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil

import com.pruden.tetris_2.Piezas.*

val listaModos = listOf("Clásico", "Clásico v2", "All in", "Álgebra", "RapidO", "Memory", "MemoryX", "MemoryY")

val listaModosConTodos = listOf("Clásico", "Clásico v2", "All in", "Álgebra", "RapidO", "Memory", "MemoryX", "MemoryY", "Todos")

val listaOrdenar = listOf("Fecha", "Nivel", "Lineas", "Puntuación", "Tiempo")

val listaModosEsta = listOf("estaClasico", "estaClasicoV2", "estaAllIn", "estaAlgebra", "estaRapidO",
    "estaMemory", "estaMemoryX", "estaMemoryY")

val nombresPiezas = listOf(
    "numO", "numI", "numL", "numZ", "numJ", "numS", "numT", "numP", "numX", "numU", "numLv2",
    "numW", "numTv2", "numZv2", "numXv2", "numLv3", "numF", "numOv2", "numSv2", "numB", "numY",
    "numK", "numIv2", "numC", "numOv3", "numV", "numH", "numIv3", "numYv2", "numOv4", "numJv2", "numA"
)

val nombresPiezasYTotal = listOf(
    "numO", "numI", "numL", "numZ", "numJ", "numS", "numT", "numP", "numX", "numU", "numLv2",
    "numW", "numTv2", "numZv2", "numXv2", "numLv3", "numF", "numOv2", "numSv2", "numB", "numY",
    "numK", "numIv2", "numC", "numOv3", "numV", "numH", "numIv3", "numYv2", "numOv4", "numJv2", "numA", "total"
)

val listaInstancias = listOf(
    Pieza_O::class, Pieza_I::class, Pieza_L::class, Pieza_Z::class, Pieza_J::class, Pieza_S::class, Pieza_T::class,
    Pieza_P::class, Pieza_X::class, Pieza_U::class, Pieza_L_v2::class, Pieza_W::class, Pieza_T_v2::class, Pieza_Z_v2::class,
    Pieza_X_v2::class, Pieza_L_v3::class, Pieza_F::class, Pieza_O_v2::class, Pieza_S_v2::class, Pieza_B::class, Pieza_Y::class,
    Pieza_K::class, Pieza_I_v2::class, Pieza_C::class, Pieza_O_v3::class, Pieza_V::class, Pieza_H::class, Pieza_I_v3::class,
    Pieza_Y_v2::class, Pieza_O_v4::class, Pieza_J_v2::class, Pieza_A::class
)


val paises = listOf(
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