package com.pruden.tetris_2.API.Constantes.custom

object ConstantesCustomAPI {
    const val PATH_CUSTOM = "http://localhost:8088"

    //Imagen cadena
    const val IMAGEN_CADENA = "$PATH_CUSTOM/uploads/images/cadena.png"

    //Clan por defecto
    const val IMAGEN_CLAN_DEFAULT = "$PATH_CUSTOM/uploads/clanes/fotoPerfilClan.jpg"

    //Imagen jugador default

    //Jugadores
    const val CREAR_JUGADOR = "/crearJugador"
    const val TODOS_JUGADORES = "/jugadores"
    const val INICIAR_SESION = "/iniciarSesion"
    const val JUGADOR_POR_ID = "/jugador/{id}"
    const val SUBIR_IMAGEN = "/subirImagen/{id}"
    const val CERRAR_SESION = "/cerrarSesion/{id}"
    const val PING_JUGADOR = "/jugador/ping/{id}"
    const val CLAN_DEL_JUGADOR = "/jugador/{id}/clan"

    //Partidas
    const val SUBIR_PARTIDA = "/subirPartida"
    const val ESTA_MODOS_PARTIDA = "/estadisticasModos/{idJugador}/{modo}"
    const val MEJORES_PARTIDAS = "/mejoresPartidas/{pais}/{modo}"
    const val PARTIDAS_DEL_JUGADOR = "/partidasDelJugador/{idJugador}/{modo}"
    const val NUM_PARTIDAS_CLASICAS = "/numPartidasClasicas/{id}"
    const val NUM_LINEAS = "/numLineas/{id}"
    const val NUM_PUNTOS = "/puntuacion/{id}"

    //EstaPiezas
    const val SUBIR_ESTA_PIEZAS = "/subirEstaPiezas"
    const val ESTA_PIEZAS_POR_JUGADOR = "/estaPiezas/{id}"

    //Suscripciones
    const val OBTENER_SUSCRIPCIONES = "/suscripciones"

    //Mundo
    const val OBTENER_MUNDOS = "/mundos"

    // Nivel
    const val OBTENER_NIVELES = "/niveles"

    //Mundo jugador
    const val MUNDO_JUGADOR = "/mundoJugador/{id}"

    //Nivel jugador
    const val NIVEL_JUGADOR = "/nivelJugador/{id}"
    const val COMPLETAR_NIVEL = "/completarNivel/{id}/{idNivel}"
    const val NIVEL_PERDIDO = "/nivelPerdido/{id}/{idNivel}"

    // Logros del juagdor
    const val LOGROS_DEL_JUGADOR = "/logros/{id}"
    const val COMPLETAR_LOGRO = "/logros/{id}/{idJugador}"

    //Clan
    const val CREAR_CLAN = "/crearClan"
    const val JUGADORES_DE_UN_CLAN = "/clan/{id}/jugadores"
    const val DATOS_DE_UN_CLAN = "/clan/{id}"
    const val TODOS_LOS_CLANES = "/clanes"
}