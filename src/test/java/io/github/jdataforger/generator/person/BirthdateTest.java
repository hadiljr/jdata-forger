package io.github.jdataforger.generator.person;

import io.github.jdataforger.Forger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BirthdateTest {

    private static Forger forger;

    @BeforeAll
    private static void Init(){
        forger = new Forger();
    }

    @Test
    @DisplayName("Create new Birthdate")
    public void create_Fake_Birthdate(){
        LocalDate fakeBirthdate = forger.Birthdate().fake();
        assertTrue(fakeBirthdate.getYear()<LocalDate.now().getYear());
        assertTrue(fakeBirthdate.getYear()>=LocalDate.now().getYear()-100);
    }

    @Test
    @DisplayName("Create new Birthdate between 18 and 70 years old")
    public void create_Fake_Birthdate_Between(){
        LocalDate fakeBirthdate = forger.Birthdate().between(18L,70L);
        assertTrue(fakeBirthdate.getYear()<=LocalDate.now().getYear()-18);
        assertTrue(fakeBirthdate.getYear()>=LocalDate.now().getYear()-70);
    }

    @Test
    @DisplayName("when MinAge is more than MaxAge then throws IllegalArgumentException exception")
    public void when_MinAge_is_more_than_MaxAge_then_throws_exception(){
        assertThrows(IllegalArgumentException.class,()->forger.Birthdate().between(100,10));
    }
}
