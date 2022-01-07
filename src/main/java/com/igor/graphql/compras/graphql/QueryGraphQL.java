package com.igor.graphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.igor.graphql.compras.Domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository clienteRep;

    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b){
        return a+b;
    }

}
