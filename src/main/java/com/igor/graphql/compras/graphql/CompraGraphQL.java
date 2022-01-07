package com.igor.graphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.igor.graphql.compras.graphql.DTO.CompraInput;
import com.igor.graphql.compras.Domain.models.Compra;
import com.igor.graphql.compras.Domain.services.ClienteService;
import com.igor.graphql.compras.Domain.services.CompraService;
import com.igor.graphql.compras.Domain.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CompraService compraService;

    public Compra compra(Long id){
        return compraService.findById(id);
    }

    public List<Compra> compras(){
        return compraService.findAll();
    }

    public Compra saveCompra(CompraInput input){
        ModelMapper m = new ModelMapper();
        Compra c = m.map(input, Compra.class);

        c.setData(new Date());

        c.setCliente(clienteService.findById(input.getClienteId()));
        c.setProduto(produtoService.findById(input.getProdutoId()));

        return compraService.save(c);
    }

    public Boolean deleteCompra(Long id){
        return compraService.deleteById(id);
    }

}
