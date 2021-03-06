package io.github.jdataforger.generator.phone.ptBR;

import io.github.jdataforger.Forger;
import io.github.jdataforger.generator.phone.ptBR.model.PhoneModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneTest {
    private static Forger forger;

    private String phoneRegex = "^(^|\\()?\\s*(\\d{2})\\s*(\\s|\\))*(9?\\d{4})(\\s|-)?(\\d{4})($|\\n)";

    @BeforeAll
    private static void Init(){
        forger = new Forger();
    }

    @Test
    @DisplayName("Create new Phone Number")
    public void create_Fake_Phone_Number(){
        String number = forger.Phone().fake();
        System.out.println(number);
        assertTrue(number.matches(phoneRegex));
    }

    @Test
    @DisplayName("Create new Phone Number From Null")
    public void create_Fake_Phone_Number_From(){
        String number = forger.Phone().getPhoneFrom(null,null);
        System.out.println(number);
        assertTrue(number.matches(phoneRegex));
    }

    @Test
    @DisplayName("Create new Mobile Number")
    public void create_Fake_Mobile_Number(){
        String number = forger.Phone().getPhoneFrom(PhoneType.MOBILE,null);
        System.out.println(number);
        assertTrue(number.matches(phoneRegex));
    }

    @Test
    @DisplayName("Create new Mobile Number from São Paulo")
    public void create_Fake_Mobile_Number_Sao_Paulo(){
        String number = forger.Phone().getPhoneFrom(PhoneType.MOBILE,11);
        System.out.println(number);
        assertTrue(number.matches(phoneRegex));
    }

    @Test
    @DisplayName("Create new Fixed Number")
    public void create_Fake_Fixed_Number(){
        String number = forger.Phone().getPhoneFrom(PhoneType.FIXED,null);
        System.out.println(number);
        assertTrue(number.matches(phoneRegex));
    }

    @Test
    @DisplayName("Create new Phone Number Model")
    public void create_Fake_Phone_Number_Model(){
        PhoneModel phone = forger.Phone().getRandomPhone();

        assertTrue(phone.toString().matches(phoneRegex));
        assertTrue(Arrays.asList(PhoneUtil.DDD).contains(phone.getDdd()));
        assertTrue(phone.getType() instanceof PhoneType);
    }
}
