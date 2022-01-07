package com.igor.graphql.compras.graphql.Resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.igor.graphql.compras.Domain.models.Cliente;
import com.igor.graphql.compras.Domain.models.Compra;
import com.igor.graphql.compras.Domain.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente>  {

    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente c){
        return compraService.findAllByCliente(c);
    }
}
