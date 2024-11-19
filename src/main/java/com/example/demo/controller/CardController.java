package com.example.demo.controller;


import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Card criarCard(@RequestBody Card card){
        return cardService.criarCard(card);
    }

    @GetMapping
    public List<Card> findAll(){
        return cardService.listatarefas();
    }

    @GetMapping("/{id}")
    public Card procurarCard(@PathVariable int id) {
        return cardService.procuraCard(id);
    }

    @PutMapping("/{id}/mover/")
    public Card moverCard(@PathVariable int id) {
        return cardService.moverCard(id);
    }

    @DeleteMapping("/{id}")
    public void excluirCard(@PathVariable int id) {
        cardService.excluirCard(id);
    }

}
