module com.pruden.tetris_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.desktop;
    requires javafx.media;
    requires java.sql;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires com.google.gson;
    requires okhttp3;
    requires kotlinx.coroutines.core;
    requires retrofit2.kotlin.coroutines.adapter;
    requires org.json;
    requires Java.WebSocket;
    requires java.net.http;
    opens com.pruden.tetris_2.Metodos.Publicidad to com.google.gson;
    opens com.pruden.tetris_2.API.ObjsAuxApi to com.google.gson, javafx.base;

    opens com.pruden.tetris_2 to javafx.fxml;
    opens com.pruden.tetris_2.Controladores to javafx.fxml;
    opens com.pruden.tetris_2.Metodos.PartidaVistaDatos to javafx.base;
    opens com.pruden.tetris_2.Metodos.RankingVistaDatos to javafx.base;


    opens com.pruden.tetris_2.Controladores.Otros to javafx.fxml; //////////
    opens com.pruden.tetris_2.Controladores.Custom to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Advertencias to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.ModosDeJuego.Modos to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Login to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Opciones to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Perfil to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Partidas to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Rankings to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Suscripciones to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Logros to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Notificaciones to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Clan to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.Dialogos to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.ModosDeJuego to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.ModosDeJuego.TusModos to javafx.fxml;
    opens com.pruden.tetris_2.Controladores.ModosDeJuego.PVP to javafx.fxml;

    exports com.pruden.tetris_2;



}