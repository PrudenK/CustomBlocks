--  docker exec -it baseCustom mysql -u root -p

"""
val query = """
                INSERT INTO jugador (nombre, contrasena, nivel, fechaini, pais, experiencia)
                VALUES (?, ?, ?, ?, ?, ?)
            """
"""
                """"

                val consulta = "Select * from jugador"

        try {
            val statement = conexion.createStatement()
            val resultado = statement.executeQuery(consulta)

            while (resultado.next()) {
                val id = resultado.getInt("id")
                val nombre = resultado.getString("nombre")
                val contrasena = resultado.getString("contrasena")
                val nivel = resultado.getInt("nivel")
                val fechaini = resultado.getDate("fechaini")
                val pais = resultado.getString("pais")
                val experiencia = resultado.getInt("experiencia")

                println("ID: $id, Nombre: $nombre, Contraseña: $contrasena, Nivel: $nivel, Fecha de inicio: $fechaini, País: $pais, Experiencia: $experiencia")
            }
        } catch (err: SQLException) {
            println("Error al ejecutar la consulta: ${err.message}")
        } finally {

        }

                """"

CREATE TABLE jugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    contrasena VARCHAR(255),
    nivel INT,
    fechaini DATE,
    pais VARCHAR(100),
    experiencia INT
);

CREATE TABLE suscripcion (
     tipo         INT PRIMARY KEY,
     nombre       VARCHAR(50),
     precio       VARCHAR(20),
     numModos     INT
);

CREATE TABLE clan (
      idClan INT AUTO_INCREMENT PRIMARY KEY,
      nombre VARCHAR(100),
      fechaini DATE,
      idLider INT,
      FOREIGN KEY (idLider) REFERENCES jugador(id) ON DELETE CASCADE
);


CREATE TABLE suscripcion_jugador (
     idJugador    INT,
     fechaFin     VARCHAR(10),
     tipo         INT,
     fechaInicio  VARCHAR(10),

     PRIMARY KEY (idJugador, fechaFin),
     FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE,
     FOREIGN KEY (tipo) REFERENCES suscripcion(tipo) ON DELETE CASCADE
);

CREATE TABLE partida (
     idPartida INT AUTO_INCREMENT PRIMARY KEY,
     idJugador INT,
     modo VARCHAR(100),
     nivel INT,
     puntuacion INT,
     tiempo VARCHAR(50),
     lineas INT,
     fechaJuego DATETIME,
     FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE
);


CREATE TABLE jugador_clan (
    idJugador INT,
    idClan INT,
    PRIMARY KEY (idJugador, idClan),
    FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE,
    FOREIGN KEY (idClan) REFERENCES clan(idClan) ON DELETE CASCADE
);


CREATE TABLE estaPiezas (
    idJugador INT,
    numO INT,
    numI INT,
    numL INT,
    numZ INT,
    numJ INT,
    numS INT,
    numT INT,
    numP INT,
    numX INT,
    numU INT,
    numLv2 INT,
    numW INT,
    numTv2 INT,
    numZv2 INT,
    numXv2 INT,
    numLv3 INT,
    numF INT,
    numOv2 INT,
    numSv2 INT,
    numB INT,
    numY INT,
    numK INT,
    numIv2 INT,
    numC INT,
    numOv3 INT,
    numV INT,
    numH INT,
    numIv3 INT,
    numYv2 INT,
    numOv4 INT,
    numJv2 INT,
    numA INT,
    numMiniI INT,
    numMiniIv2 INT,
    numMiniL INT,
    numMiniO INT,
    numOv5 INT,
    numOv6 INT,
    numXv3 INT,
    numE INT,
    numTwinO INT,
    numTwinY INT,
    numPickAxe INT,
    numSv3 INT,
    numTwinOv2 INT,
    numZv3 INT,
    numLadder INT,
    numHv2 INT,

    total INT,
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE
);

CREATE TABLE mundo (
   idMundo INT,
   idJugador INT,
   completado BOOLEAN NOT NULL,
   desbloqueado BOOLEAN NOT NULL,
   PRIMARY KEY (idMundo, idJugador),
   FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE
);

CREATE TABLE nivel (
   idNivel INT,
   idMundo INT,
   idJugador INT,
   tiempoObj VARCHAR(8),
   puntuacionObj INT,
   lineasObj INT,
   mejorTiempo VARCHAR(10),
   mejorPuntuacion INT,
   mejorLineas INT,
   completado BOOLEAN NOT NULL,
   desbloqueado BOOLEAN NOT NULL,
   PRIMARY KEY (idNivel, idMundo, idJugador),
   FOREIGN KEY (idMundo, idJugador) REFERENCES mundo(idMundo, idJugador) ON DELETE CASCADE
);

CREATE TABLE modos_juego(
    idJugador INT,
    idNumModo INT,
    nombre VARCHAR(255),
    arrayPiezas VARCHAR(255),
    tablero VARCHAR(20),
    tipoPieza INT,
    tipoTableroSecun INT,
    tipoTableroPrincipal INT,
    tiempoCaidaInicial INT,
    lineasParaSaltoNivel INT,
    saltoDeTiempoPorNivel INT,
    limiteRotaciones INT,
    hold INT,
    piezas INT,
    dashes INT,
    PRIMARY KEY (idJugador, idNumModo),
    FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE
);

CREATE TABLE logros (
    idLogro INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL
);

CREATE TABLE logro_jugador (
   idJugador INT,
   idLogro INT,
   PRIMARY KEY (idJugador, idLogro),
   FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE,
   FOREIGN KEY (idLogro) REFERENCES logros(idLogro) ON DELETE CASCADE
);









SELECT max(partida.nivel) FROM partida where idJugador = :id and modo = :modo;
SELECT max(partida.lineas) FROM partida where idJugador = :id and modo = :modo;
SELECT max(partida.puntuacion) FROM partida where idJugador = :id and modo = :modo;
SELECT max(partida.tiempo) FROM partida where idJugador = :id and modo = :modo;
SELECT sum(partida.lineas) FROM partida where idJugador = :id and modo = :modo;
SELECT sum(partida.puntuacion) FROM partida where idJugador = :id and modo = :modo;
SELECT partida.tiempo FROM partida where idJugador = :id and modo = :modo;

CREATE TABLE estaPiezas (
    idJugador INT,
    numO INT,        numI INT,        numL INT,        numZ INT,        numJ INT,        numS INT,
    numT INT,        numP INT,        numX INT,        numU INT,        numLv2 INT,      numW INT,
    numTv2 INT,      numZv2 INT,      numXv2 INT,      numLv3 INT,      numF INT,        numOv2 INT,
    numSv2 INT,      numB INT,        numY INT,        numK INT,        numIv2 INT,      numC INT,
    numOv3 INT,      numV INT,        numH INT,        numIv3 INT,      numYv2 INT,      numOv4 INT,
    numJv2 INT,      numA INT,        numMiniI INT,    numMiniIv2 INT,  numMiniL INT,    numMiniO INT,
    numOv5 INT,      numOv6 INT,      numXv3 INT,      numE INT,        numTwinO INT,    numTwinY INT,
    numPickAxe INT,  numSv3 INT,      numTwinOv2 INT,  numZv3 INT,      numLadder INT,   numHv2 INT,

    total INT,
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id) ON DELETE CASCADE
);
