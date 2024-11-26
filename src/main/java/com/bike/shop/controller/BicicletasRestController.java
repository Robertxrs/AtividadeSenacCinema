/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bike.shop.controller;

import com.bike.shop.entities.Bicicleta;
import com.bike.shop.service.BicicletasService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bikeshop")
public class BicicletasRestController {
    @Autowired
    private BicicletasService bicicletasService;
    
    
    @GetMapping("/all")
    public List<Bicicleta> getAllBicicletas() {
        return bicicletasService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Bicicleta> getBicicletaById(@PathVariable String id) {
        return bicicletasService.findById(id);
    }

    @PostMapping("/add")
    public Bicicleta addBicicleta(@RequestBody Bicicleta bicicleta) {
        return bicicletasService.save(bicicleta);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Bicicleta> updateBicicleta(@PathVariable String id, @RequestBody Bicicleta bicicleta) {
        Optional<Bicicleta> existingBicicleta = bicicletasService.findById(id);
        if (existingBicicleta.isPresent()) {
            Bicicleta updatedBicicleta = existingBicicleta.get();
            updatedBicicleta.setNome(bicicleta.getNome());
            updatedBicicleta.setDescricao(bicicleta.getDescricao());
            updatedBicicleta.setPreco(bicicleta.getPreco());
            updatedBicicleta.setImagem(bicicleta.getImagem());
            return ResponseEntity.ok(bicicletasService.save(updatedBicicleta));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBicicleta(@PathVariable String id) {
        if (bicicletasService.findById(id).isPresent()) {
            bicicletasService.deleteById(id);
            return ResponseEntity.ok("Bicicleta deletada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }    
}
