package com.igor.graphql.compras.graphql.Resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.igor.graphql.compras.Domain.models.Cliente;
import com.igor.graphql.compras.Domain.models.Compra;
import com.igor.graphql.compras.Domain.models.Produto;
import com.igor.graphql.compras.Domain.services.ClienteService;
import com.igor.graphql.compras.Domain.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public String status(Compra c){
        return "Teste: " + c.getStatus();
    }

    public Cliente cliente(Compra c){
        return clienteService.findById(c.getCliente().getId());
    }

    public Produto produto(Compra c){
        return produtoService.findById(c.getProduto().getId());
    }
}
