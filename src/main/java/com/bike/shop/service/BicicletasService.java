
package com.bike.shop.service;

import com.bike.shop.entities.Bicicleta;
import com.bike.shop.repository.BicicletasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BicicletasService {

    @Autowired
    private BicicletasRepository bicicletaRepository;

    public List<Bicicleta> findAll() {
        return bicicletaRepository.findAll();
    }

    public Optional<Bicicleta> findById(String id) {
        return bicicletaRepository.findById(id);
    }

    public Bicicleta save(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    public void deleteById(String id) {
        bicicletaRepository.deleteById(id);
    }
    
}
