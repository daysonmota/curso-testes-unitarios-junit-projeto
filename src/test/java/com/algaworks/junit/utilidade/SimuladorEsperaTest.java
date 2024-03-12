package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "PROD")
    void deveEsperarNaoDarTimeout(){

        /*Ele ignora o teste através configurado */
       Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), () -> "Abortando teste: não deve ser executado em PROD");

//        Assertions.assertTimeout(Duration.ofSeconds(1) //Espera acabar pra mostrar o erro
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1) //Se demorar mais de 1 segundo ele já mostra o erro,
//                , () -> SimuladorEspera.esperar(Duration.ofSeconds(10)));
                  , () -> SimuladorEspera.esperar(Duration.ofMillis(10))); //nao demora muito para ser executado.
   }
}
