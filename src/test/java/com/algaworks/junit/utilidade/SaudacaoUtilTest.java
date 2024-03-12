package com.algaworks.junit.utilidade;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static com.algaworks.junit.utilidade.SaudacaoUtilConditions.igualBomDia;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SaudacaoUtilTest {

    @Test
    public void Dado_uma_horario_matuino_Quando_saudar_Entao_deve_retornar_bom_dia() {
        int horaValida = 9;
        String saudacao = saudar(horaValida);

        //        assertEquals("Bom dia", saudacao);

        assertThat(saudacao).is(igualBomDia());
    }

    @Test
    public void Dado_uma_horario_vespertino_Quando_saudar_Entao_deve_retornar_boa_tarde() {
        int horaValida = 15;
        String saudacao = saudar(horaValida);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    public void Dado_uma_horario_noturno_Quando_saudar_Entao_deve_retornar_boa_noite() {
        int horaValida = 4;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao);
    }

    @Test
    public void Dado_uma_hora_invalida_Quando_saudar_Entao_deve_lancar_exception() {
        int horaInvalida = -10;
        // Executable chamadaInvalidaDeMetodo = () -> saudar(horaInvalida);
        // IllegalArgumentException e = assertThrows(IllegalArgumentException.class, chamadaInvalidaDeMetodo);
        // assertEquals("Hora inválida", e.getMessage());


        assertThatThrownBy(() -> saudar(horaInvalida))
                .isInstanceOf(IllegalArgumentException.class)
//                .hasRootCause(new IllegalArgumentException())
                .hasMessage("Hora Inválida");
    }

    @Test
    public void Dado_uma_hora_valida_Quando_saudar_Entao_nao_deve_lancar_exception() {
        int horaValida = 0;
        Executable chamadaValidaDeMetodo = () -> saudar(horaValida);
        assertDoesNotThrow(chamadaValidaDeMetodo);
    }


    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9,10,11})
    public void Dado_horario_matinal_Quando_saudar_Entao_deve_retornar_bom_dia(int hora){

        String saudacao = saudar(hora);

        assertEquals("Bom dia",saudacao);
    }
}