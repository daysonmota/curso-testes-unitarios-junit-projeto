package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void assercaoAgrupada(){

        Pessoa pessoa = new Pessoa("Dayson", "Rodrigues");

//        assertEquals("Dayson",pessoa.getNome());
//        assertEquals("Rodrigues",pessoa.getSobrenome());

        assertAll("Asserções de Pessoa"
                ,()-> assertEquals("Dayson", pessoa.getNome())
                ,()-> assertEquals("Rodrigues", pessoa.getSobrenome()));
    }

}