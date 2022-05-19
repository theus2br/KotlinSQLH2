package com.estudos.managerevents.entities

import javax.persistence.*

@Entity
@Table(name = "show")
data class Show(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val nomeShow: String,
    val data:String,
    val promotor:String,
    val status: String,
    val local: String,
    val quantidadeTotalIngressos: Int,
    val ingressosDisponiveis: Int?
    )