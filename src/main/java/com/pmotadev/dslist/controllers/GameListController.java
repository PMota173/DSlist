package com.pmotadev.dslist.controllers;

import com.pmotadev.dslist.dto.GameDTO;
import com.pmotadev.dslist.dto.GameListDTO;
import com.pmotadev.dslist.dto.GameMinDTO;
import com.pmotadev.dslist.services.GameListService;
import com.pmotadev.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }
}
