package com.github.jdataforger;

import com.github.jdataforger.generator.person.identification.CPF;

public class Forger {

    private final CPF cpf;

    public Forger(){
        cpf = new CPF();
    }

    public CPF CPF(){
        return cpf;
    }

}
