package io.github.jdataforger;

import io.github.jdataforger.generator.company.CNPJ;
import io.github.jdataforger.generator.person.Birthdate;
import io.github.jdataforger.generator.person.identification.CPF;
import io.github.jdataforger.generator.phone.ptBR.Phone;

/**
 * Main class of library
 * @author Hadil
 */
public class Forger {

    private final CPF cpf;
    private final CNPJ cnpj;
    private final Birthdate birthdate;
    private final Phone phonePtBr;

    public Forger(){

        cpf = new CPF();
        cnpj = new CNPJ();
        birthdate = new Birthdate();
        phonePtBr = new Phone();
    }

    public CPF CPF(){
        return cpf;
    }

    public CNPJ CNPJ(){
        return cnpj;
    }

    public Birthdate Birthdate(){return birthdate;}

    public Phone Phone(){return  phonePtBr;}
}
