package com.igor.graphql.compras.Domain.services;

import com.igor.graphql.compras.Domain.models.Cliente;
import com.igor.graphql.compras.Domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository rep;

    public Cliente findById(Long id){
        return rep.findById(id).orElse(null);

    }

    public List<Cliente> findAll(){
        return rep.findAll();
    }

    @Transactional
    public Cliente save(Cliente c){
        return rep.save(c);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if(rep.findById(id).isPresent()){
            rep.deleteById(id);
            return true;
        }
        return false;
    }
}
