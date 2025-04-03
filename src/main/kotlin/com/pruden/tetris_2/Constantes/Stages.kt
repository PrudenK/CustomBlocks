package com.pruden.tetris_2.Constantes

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage

object Stages {
    val OPCIONES = ClaseStage("Vistas/Otras/vistaOpciones.fxml", cPrin.nuevaPartidaB, 325.0, 436.0, timelinePartida, 0, 0)
    val SONIDO = ClaseStage("Vistas/Otras/vistaSonido.fxml", cPrin.nuevaPartidaB, 243.0, 264.0, null, 0, 0)

    val CUSTOM_OPCIONES = ClaseStage("Vistas/Custom/vista_Custom_Opciones.fxml", cPrin.nuevaPartidaB, 315.0,382.0, timelinePartida, 0, -60)
    val MODOS_DE_JUEGO = ClaseStage("Vistas/ModosDeJuego/vistaMenuModos.fxml", cPrin.nuevaPartidaB, 355.0, 436.0, timelinePartida, 0, 0)
    val SUSCRIPCIONES = ClaseStage("Vistas/Suscripciones/vistaSuscripciones.fxml", cPrin.nuevaPartidaB, 383.0, 416.0, timelinePartida, 0, 0)
    val LOGROS = ClaseStage("Vistas/Logros/vistaLogros.fxml", cPrin.nuevaPartidaB, 676.0, 727.0, timelinePartida, 0, 0)
    val PARTIDAS_GUARDADAS = ClaseStage("Vistas/Partidas/vistaPartidasGuardadas.fxml", cPrin.nuevaPartidaB, 610.0, 420.0, timelinePartida, 0, -60)

    val CLAN_MENU = ClaseStage("Vistas/Clan/vistaClanMenu.fxml", cPrin.nuevaPartidaB, 471.0, 192.0, timelinePartida, 0, -60)
    val MI_CLAN = ClaseStage("Vistas/Clan/vistaMiClan.fxml", cPrin.nuevaPartidaB, 553.0, 668.0, null, 0, 0)
    val BUSCAR_CLAN = ClaseStage("Vistas/Clan/vistaBuscarClan.fxml", cPrin.nuevaPartidaB, 534.0, 556.0, null, 0, 0)
    val CREAR_CLAN = ClaseStage("Vistas/Clan/vistaCrearClan.fxml", cPrin.nuevaPartidaB, 466.0, 539.0, null, 0, 0)
    val CHAT_DEL_CLAN = ClaseStage("Vistas/Clan/vistaChatClan.fxml", cPrin.nuevaPartidaB, 587.0, 614.0, null, 0, 0)

    val ADVERTENCIA_OTRAS_CONFI = ClaseStage("Vistas/Advertencias/vista_Advertencia_Otras_Confi.fxml", cPrin.nuevaPartidaB, 344.0, 178.0,null,0,0)
    val ADVERTENCIA_PIEZAS = ClaseStage("Vistas/Advertencias/vista_Advertencia_Piezas.fxml", cPrin.nuevaPartidaB, 344.0, 178.0, null, 0, 0)
    val ADVERTENCIA_TABLERO = ClaseStage("Vistas/Advertencias/vista_Advertencia_Tablero.fxml", cPrin.nuevaPartidaB, 344.0, 178.0, null, 0, 0)
    val ADVERTENCIA_TIPO_TABLERO_2 = ClaseStage("Vistas/Advertencias/vista_Advertencia_Tipo_Tablero2.fxml", cPrin.nuevaPartidaB, 421.0, 192.0, null, 0, 0)

    val CREAR_MODO = ClaseStage("Vistas/ModosDeJuego/TusModos/vistaCrearModo.fxml", cPrin.nuevaPartidaB, 609.0, 513.0, timelinePartida, 0, 0)

    val CUSTOM_PIEZAS = ClaseStage("Vistas/Custom/vista_Custom_Piezas.fxml", cPrin.nuevaPartidaB,700.0,820.0, null,0, 0)
    val CUSTOM_TIPO_PIEZAS = ClaseStage("Vistas/Custom/vista_Custom_Tipo_Piezas.fxml", cPrin.nuevaPartidaB,315.0,400.0, null,0, -60)
    val CUSTOM_TABLERO = ClaseStage("Vistas/Custom/vista_Custom_Tablero.fxml", cPrin.nuevaPartidaB,431.0,582.0, null,0, -40)
    val CUSTOM_TIPO_TABLERO = ClaseStage("Vistas/Custom/vista_Custom_Tipo_Tablero.fxml", cPrin.nuevaPartidaB,570.0,501.0, null,0, -20)
    val CUSTOM_OTRAS_CONFIGURACIONES = ClaseStage("Vistas/Custom/vista_Custom_Otras_Configuraciones.fxml", cPrin.nuevaPartidaB,643.0,491.0, null,0, -20)

    val PERFIL = ClaseStage("Vistas/Perfil/vista_Perfil.fxml", cPrin.nuevaPartidaB, 683.0, 602.0, timelinePartida, 0, 0)
    val RANKINGS = ClaseStage("Vistas/Rankings/vista_Ranking.fxml", cPrin.nuevaPartidaB, 731.0, 600.0, timelinePartida, 0, 0)
    val PIEZAS_PERFIL = ClaseStage("Vistas/Perfil/vista_Perfil_Piezas.fxml",cPrin.nuevaPartidaB,700.0,820.0, null,0, 0)
    val REGISTRO_PARTIDAS = ClaseStage("Vistas/Partidas/vista_Partidas.fxml", cPrin.nuevaPartidaB, 699.0, 634.0, timelinePartida, 0, 0)

    val ABRIR_MUNDO = ClaseStage("Vistas/ModosDeJuego/ModoCampa/vista_Mundo1.fxml", cPrin.nuevaPartidaB, 711.0, 809.0, null, 0, 0)
    val PERDER = ClaseStage("Vistas/Otras/vista_Perder.fxml", cPrin.nuevaPartidaB, 315.0, 232.0, null, 0, -120)

    val MENU_PVP = ClaseStage("Vistas/PVP/vistaMenuPVP.fxml", cPrin.nuevaPartidaB, 325.0, 178.0, null, 0, -120)
    val CREAR_PARTIDA_PVP = ClaseStage("Vistas/PVP/vistaCrearPartidaPVP.fxml", cPrin.nuevaPartidaB, 384.0, 558.0, null, 0, 0)
    val BUSCAR_PARTIDA_PVP = ClaseStage("Vistas/PVP/vistaBuscarPartidaPVP.fxml", cPrin.nuevaPartidaB, 604.0, 445.0, null, 0, 0)


    val STAGE_MODO_CLASICO = ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_Clasico.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
    val STAGE_MODO_CLASICO_V2 = ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_ClasicoV2.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
    val STAGE_MODO_ALL_IN = ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_Todo.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
    val STAGE_MODO_ALGEBRA = ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_Algebra.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
    val STAGE_MODO_RAPID_O = ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_RapidO.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
    val STAGE_MODO_MEMORY =  ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_Memory.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
    val STAGE_MODO_MEMORY_X = ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_MemoryX.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
    val STAGE_MODO_MEMORY_Y = ClaseStage("Vistas/ModosDeJuego/Modos/vista_Modo_MemoryY.fxml", cPrin.nuevaPartidaB,700.0,694.0, null,0, 0)
}