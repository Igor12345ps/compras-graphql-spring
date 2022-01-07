package com.igor.graphql.compras.graphql.Resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.igor.graphql.compras.Domain.models.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto>  {

    public String valorReais(Produto p){
        return "R$" + p.getValor();
    }
}
