package com.igor.graphql.compras.Domain.services;

import com.igor.graphql.compras.Domain.models.Cliente;
import com.igor.graphql.compras.Domain.models.Compra;
import com.igor.graphql.compras.Domain.repositories.CompraRepository;
import com.igor.graphql.compras.graphql.Exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository rep;

    public Compra findById(Long id){
        return rep.findById(id).orElse(null);
    }

    public List<Compra> findAll(){
        return rep.findAll();
    }

    @Transactional
    public Compra save(Compra c){
        if(c.getQuantidade() > 100){
            throw new DomainException("Não é possível fazer uma compra com mais de 100 itens.");
        }
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

    public List<Compra> findAllByCliente(Cliente c) {
        return rep.findAllByCliente(c);
    }
}
