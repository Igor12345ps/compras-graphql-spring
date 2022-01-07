package com.igor.graphql.compras.graphql.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraInput {

    private Long id;
    private Integer quantidade;
    private String status;
    private Long clienteId;
    private Long produtoId;
}
