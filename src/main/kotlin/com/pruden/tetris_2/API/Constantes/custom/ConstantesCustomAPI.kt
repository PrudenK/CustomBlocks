package com.pruden.tetris_2.API.Constantes.custom

object ConstantesCustomAPI {
    const val PATH_CUSTOM = "http://localhost:8088"

    //Jugadores
    const val CREAR_JUGADOR = "/crearJugador"
    const val TODOS_JUGADORES = "/jugadores"
    const val INICIAR_SESION = "/iniciarSesion"
    const val JUGADOR_POR_ID = "/jugador/{id}"
    const val SUBIR_IMAGEN = "/subirImagen/{id}"

    //Partidas
    const val SUBIR_PARTIDA = "/subirPartida"
    const val ESTA_MODOS_PARTIDA = "/estadisticasModos/{idJugador}/{modo}"
    const val MEJORES_PARTIDAS = "/mejoresPartidas/{pais}/{modo}"
    const val PARTIDAS_DEL_JUGADOR = "/partidasDelJugador/{idJugador}/{modo}"

    //EstaPiezas
    const val SUBIR_ESTA_PIEZAS = "/subirEstaPiezas"
    const val ESTA_PIEZAS_POR_JUGADOR = "/estaPiezas/{id}"

    //Suscripciones
    const val OBTENER_SUSCRIPCIONES = "/suscripciones"

    //Mundo
    const val OBTENER_MUNDOS = "/mundos"

    // Nivel
    const val OBTENER_NIVELES = "/niveles"

}