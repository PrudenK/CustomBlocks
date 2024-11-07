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


CREATE TABLE clan (
    idClan INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    fechaini DATE,
    idLider INT,
    FOREIGN KEY (idLider) REFERENCES jugador(id)
);


CREATE TABLE jugador_clan (
    idJugador INT,
    idClan INT,
    PRIMARY KEY (idJugador, idClan),
    FOREIGN KEY (idJugador) REFERENCES jugador(id),
    FOREIGN KEY (idClan) REFERENCES clan(idClan)
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
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaClasico (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaClasicoV2 (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaAllIn (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaAlgebra (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaMemory (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaMemoryX (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaMemoryY (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaRapidO (
    idJugador INT,
    maxNivel INT,
    maxLineas INT,
    maxPuntuacion INT,
    maxTiempo VARCHAR(50),
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);

CREATE TABLE estaCustom (
    idJugador INT,
    lineasSum INT,
    puntuacionesSum INT,
    tiempoTotal VARCHAR(50),
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
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
    total INT,
    PRIMARY KEY (idJugador),
    FOREIGN KEY (idJugador) REFERENCES jugador(id)
);
