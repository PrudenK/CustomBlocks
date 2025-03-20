package com.pruden.tetris_2.Constantes.custom

object ConstantesCustomAPI {
    const val PATH_CUSTOM = "http://localhost:8088"

    //Jugadores
    const val CREAR_JUGADOR = "/crearJugador"
    const val TODOS_JUGADORES = "/jugadores"
    const val INICIAR_SESION = "/iniciarSesion"
    const val JUGADOR_POR_ID = "/jugador/{id}"

    //Partidas
    const val SUBIR_PARTIDA = "/subirPartida"
    const val ESTA_MODOS_PARTIDA = "/estadisticasModos/{idJugador}/{modo}"

    //EstaPiezas
    const val SUBIR_ESTA_PIEZAS = "/subirEstaPiezas"
}