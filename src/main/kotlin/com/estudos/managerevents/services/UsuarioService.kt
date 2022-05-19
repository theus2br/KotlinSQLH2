package com.estudos.managerevents.services

import com.estudos.managerevents.entities.Response
import com.estudos.managerevents.entities.Usuario
import com.estudos.managerevents.repositories.UsuarioRepository
import com.estudos.managerevents.utilities.UsuariosUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UsuarioService {

    @Autowired
    lateinit var repository:UsuarioRepository
    lateinit var response:Response
    private val logger = LoggerFactory.getLogger(javaClass)

    var usuariosUtils: UsuariosUtils = UsuariosUtils()

    fun criarUsuario(novoUsuarioBody: Usuario):Response{
        logger.info("Iniciado as validações para criação de Usuario")
        novoUsuarioBody.dCadastro = LocalDateTime.now().toString()
        try {
            if(repository.findByCpf(novoUsuarioBody.cpf) != null){
                logger.info("Já existe um usuario com esse CPF")
                response = Response("Já existe um usuario com esse CPF")
                return response
            }
            repository.save(novoUsuarioBody)
            response = Response("Cadastrado com sucesso!")
            return response
        } catch (e: Exception){
           response = Response("Erro ao cadastrar")
           return response
        }
    }

    fun exibirDadosCadastrais(cpf: String): ResponseEntity<*> {
        var usuarioEncontrado = repository.findByCpf(cpf)
        if(usuarioEncontrado != null) {
            return ResponseEntity.ok(usuarioEncontrado)
        }else {
            response = Response("Nenhum usuario encontrado")
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}