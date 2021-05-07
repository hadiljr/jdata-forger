package io.github.jdataforger.generator.phone.ptBR.model;

import io.github.jdataforger.generator.phone.ptBR.PhoneType;


public class PhoneModel {

    private int ddd;
    private String number;
    private PhoneType type;

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String formattedNumber(){
        int firstEnd = 0;

        if(number.length()%2 == 0){
            firstEnd = (number.length()/2);
        }
        else{
            firstEnd = (number.length()/2)-1;
        }

        return number.substring(0,firstEnd)+"-"+number.substring(firstEnd);
    }

    @Override
    public String toString() {
        return "(" + ddd + ") " + formattedNumber();
    }
}
