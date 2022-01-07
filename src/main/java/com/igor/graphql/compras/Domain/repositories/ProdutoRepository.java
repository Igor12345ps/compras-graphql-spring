package com.igor.graphql.compras.Domain.repositories;

import com.igor.graphql.compras.Domain.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Override
    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value = "true")})
    List<Produto> findAll();
}
