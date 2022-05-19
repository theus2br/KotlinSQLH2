package com.estudos.managerevents.repositories

import com.estudos.managerevents.entities.Show
import org.springframework.data.jpa.repository.JpaRepository

interface ShowRepository: JpaRepository<Show, Long>{

}