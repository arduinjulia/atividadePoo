package com.example.demo.service;


import com.example.demo.model.Card;
import com.example.demo.model.StatusKanban;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CardService {

    @Autowired
    private CardRepository CardRepository;

    public Card criarCard(Card card){
        return CardRepository.save(card);
    }

    public List<Card> listatarefas(){
        return CardRepository.findAll();
    }

    public Card procuraCard(int id) {
        Optional<Card> optionalCard = CardRepository.findById(id);
        if (optionalCard.isPresent()) {
            Card objCard = optionalCard.get();

            objCard.setTitulo(objCard.getTitulo());
            objCard.setDescricao(objCard.getDescricao());
            objCard.setStatus(objCard.getStatus());
            objCard.setPrioridade(objCard.getPrioridade());
            objCard.setDataLimite(objCard.getDataLimite());

            return optionalCard.get();
        } else {
            throw new RuntimeException("Card não encontrado");
        }
    }

    public Card moverCard(int id){
        Card objCard = procuraCard(id);
        if (objCard.getStatus() == StatusKanban.A_FAZER){
            objCard.setStatus(StatusKanban.EM_PROGRESSO);
        }
        else if( objCard.getStatus() == StatusKanban.EM_PROGRESSO){
            objCard.setStatus(StatusKanban.CONCLUIDO);
        }
        return CardRepository.save(objCard);

    }

    public void excluirCard(int id){
        CardRepository.deleteById(id);
    }




}
