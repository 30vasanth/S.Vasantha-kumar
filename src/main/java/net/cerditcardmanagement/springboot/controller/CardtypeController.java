package net.cerditcardmanagement.springboot.controller;

import net.cerditcardmanagement.springboot.exception.ResourceNotFoundException;
import net.cerditcardmanagement.springboot.model.Cardtype;
import net.cerditcardmanagement.springboot.repository.CardtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/cardtype")
public class CardtypeController {

    @Autowired
    private CardtypeRepository cardtypeRepository;

    @GetMapping
    public List<Cardtype> getAllCardtype(){
        return cardtypeRepository.findAll();
    }

    //create card type Rest API
    @PostMapping()
    public Cardtype createEmployee(@RequestBody Cardtype cardtype){

        return cardtypeRepository.save(cardtype);
    }

    @PostMapping("{id}")
    public ResponseEntity<Cardtype> getCardtypeById(@PathVariable int id){
        Cardtype ct = cardtypeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("cardtype not exist with id: "+id));
        return ResponseEntity.ok(ct);
    }

    @PostMapping("/cardtypeupdate/{id}")
    public ResponseEntity<Cardtype> updateCardtype(@PathVariable int id,@RequestBody Cardtype ct){
        Cardtype updatect = cardtypeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("cardtype not exist with id: "+id));
        updatect.setCardname(ct.getCardname());
        updatect.setRange(ct.getRange());
        updatect.setId(ct.getId());
        cardtypeRepository.save(updatect);
        return ResponseEntity.ok(updatect);
    }

    @PostMapping("/cardtypedelete/{id}")
    public ResponseEntity<Cardtype> deleteCardtype(@PathVariable int id){
        Cardtype deletect = cardtypeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("cardtype not exist with id: "+id));
        cardtypeRepository.delete(deletect);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}