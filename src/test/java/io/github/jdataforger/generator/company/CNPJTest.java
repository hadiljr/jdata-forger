package io.github.jdataforger.generator.company;

import io.github.jdataforger.Forger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CNPJTest {
    private static Forger forger;

    @BeforeAll
    private static void Init(){
        forger = new Forger();
    }

    @Test
    @DisplayName("Create new valid CNPJ")
    public void create_Fake_Valid_CNPJ(){
        String cnpjNumber = forger.CNPJ().fake();
        assertTrue(forger.CNPJ().isCNPJValid(cnpjNumber));
    }

    @Test
    @DisplayName("when CNPJ is valid then return true")
    public void when_CNPJ_is_valid_then_return_true(){
        assertTrue(forger.CNPJ().isCNPJValid("27.582.455/0001-19"));
    }

    @Test
    @DisplayName("when CNPJ is invalid then return false")
    public void when_CNPJ_is_invalid_then_return_false(){
        assertFalse(forger.CNPJ().isCNPJValid("27.582.455/0001-18"));
    }

}
