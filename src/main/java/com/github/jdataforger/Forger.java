package com.github.jdataforger;

import com.github.jdataforger.generator.person.identification.CPF;

public class Forger {
    public static void main(String[] args) {
        System.out.printf(new CPF().fake());
    }
}
