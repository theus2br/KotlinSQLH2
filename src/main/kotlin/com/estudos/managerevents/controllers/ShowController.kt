package com.estudos.managerevents.controllers

import com.estudos.managerevents.entities.Show
import com.estudos.managerevents.repositories.ShowRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfigureOrder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/show")
class ShowController {

    @Autowired
    private lateinit var repo:ShowRepository

    @GetMapping("/todos")
    fun listarShows():MutableList<Show>{
        return repo.findAll()
    }

    @PostMapping
    fun salvarShow(@RequestBody novoShow:Show):Show{
       return repo.save(novoShow)
    }
}