package com.estudos.managerevents.entities

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,

    @field:NotNull
    val nome:String,

    @field:NotNull
    val senha:String,

    @field:NotNull
    val email:String,

    @field:NotNull
    val cpf:String,

    @field:NotNull
    val telefone:String,

    @field:NotNull
    val dNascimento:String,

    var dCadastro:String?

    )
