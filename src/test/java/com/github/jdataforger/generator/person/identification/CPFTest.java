package com.github.jdataforger.generator.person.identification;

import com.github.jdataforger.Forger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CPFTest {

    private static Forger forger;

    @BeforeAll
    private static void Init(){
        forger = new Forger();
    }

    @Test
    @DisplayName("Create new valid CPF")
    public void createFakeValidCPF(){
        String cpfNumber = forger.CPF().fake();
        assertTrue(forger.CPF().isCPFValid(cpfNumber));
    }

    @Test
    @DisplayName("when CPF is valid then return true")
    public void when_CPF_is_valid_then_return_true(){
        assertTrue(forger.CPF().isCPFValid("700.779.240-53"));
    }

    @Test
    @DisplayName("when CPF is invalid then return false")
    public void when_CPF_is_invalid_then_return_false(){
        assertFalse(forger.CPF().isCPFValid("700.779.240-55"));
    }

}
