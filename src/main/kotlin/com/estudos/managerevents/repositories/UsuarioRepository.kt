package com.estudos.managerevents.repositories

import com.estudos.managerevents.entities.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByCpf(cpf: String): Usuario?
}