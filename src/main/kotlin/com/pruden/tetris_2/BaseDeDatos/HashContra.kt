package com.pruden.tetris_2.BaseDeDatos

import java.security.MessageDigest
import java.security.SecureRandom
import java.util.Base64

fun hashearContraConSAl(contra: String): String {
    val salt = generarSal()
    val hashedPassword = hashPassword(contra, salt)
    val saltString = Base64.getEncoder().encodeToString(salt)
    return "$saltString:$hashedPassword"
}
fun comprobarContra(contraIntro: String, contraHash: String): Boolean {
    val parts = contraHash.split(":")
    if (parts.size != 2) {
        return false
    }
    val salt = Base64.getDecoder().decode(parts[0])
    val contraHasheada = parts[1]
    val inputHasheada = hashPassword(contraIntro, salt)
    return contraHasheada == inputHasheada
}

private fun generarSal(length: Int = 16): ByteArray {
    val salt = ByteArray(length)
    SecureRandom().nextBytes(salt)
    return salt
}

private fun hashPassword(contra: String, salt: ByteArray): String {
    val md = MessageDigest.getInstance("SHA-256")
    val saltedPassword = salt + contra.toByteArray()
    val hashedPassword = md.digest(saltedPassword)
    return Base64.getEncoder().encodeToString(hashedPassword)
}
