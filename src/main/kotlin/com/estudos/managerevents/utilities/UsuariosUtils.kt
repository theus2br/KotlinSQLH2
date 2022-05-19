package com.estudos.managerevents.utilities

import com.estudos.managerevents.repositories.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired

class UsuariosUtils {

    @Autowired
    lateinit var repository: UsuarioRepository

    fun usuarioJaExistente(cpf: String): Boolean {

        return repository.findByCpf(cpf) != null
    }
}