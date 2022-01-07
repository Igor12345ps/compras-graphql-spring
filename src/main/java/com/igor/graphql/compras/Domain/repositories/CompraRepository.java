package com.igor.graphql.compras.Domain.repositories;

import com.igor.graphql.compras.Domain.models.Cliente;
import com.igor.graphql.compras.Domain.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import javax.persistence.QueryHint;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value = "true")})
    List<Compra> findAllByCliente(Cliente c);
}
