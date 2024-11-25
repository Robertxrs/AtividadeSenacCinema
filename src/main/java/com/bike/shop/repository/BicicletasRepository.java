/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bike.shop.repository;

import com.bike.shop.entities.Bicicleta;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author rober
 */
public interface BicicletasRepository extends MongoRepository<Bicicleta,String>{
    
}
