package com.estudos.managerevents.controllers

import com.estudos.managerevents.entities.Response
import com.estudos.managerevents.entities.Usuario
import com.estudos.managerevents.repositories.UsuarioRepository
import com.estudos.managerevents.services.UsuarioService
import org.hibernate.validator.constraints.br.CPF
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    lateinit var service: UsuarioService

    @PostMapping
    fun criarUsuario(@RequestBody body:Usuario):Response? = service.criarUsuario(body)

    @GetMapping("/{cpf}")
    fun listarUsuarios(@PathVariable("cpf") cpf: String): ResponseEntity<*> = service.exibirDadosCadastrais(cpf)
}