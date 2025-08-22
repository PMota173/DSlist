package com.pmotadev.dslist.services;

import com.pmotadev.dslist.dto.GameDTO;
import com.pmotadev.dslist.dto.GameListDTO;
import com.pmotadev.dslist.dto.GameMinDTO;
import com.pmotadev.dslist.entities.Game;
import com.pmotadev.dslist.entities.GameList;
import com.pmotadev.dslist.repositories.GameListRepository;
import com.pmotadev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
       List<GameList> result = gameListRepository.findAll();
       return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList result = gameListRepository.findById(id).get();
        return new GameListDTO(result);
    }
}
