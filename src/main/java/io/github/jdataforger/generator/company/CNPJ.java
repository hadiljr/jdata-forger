package io.github.jdataforger.generator.company;

import io.github.jdataforger.generator.abstraction.IForgery;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Hadil
 * Forge CNPJ (Company identification in Brazil) numbers
 */
public class CNPJ implements IForgery<String> {

    @Override
    public String fake() {
        SecureRandom rn = new SecureRandom();
        List<Integer> baseDigits = rn.ints(8, 0, 10)
                .mapToObj(d -> Integer.valueOf(d))
                .collect(Collectors.toList());

        //Adiciona os numeros de CNPJ matriz
        baseDigits.add(0);
        baseDigits.add(0);
        baseDigits.add(0);
        baseDigits.add(1);

        return generateCNPJ(baseDigits);
    }

    public boolean isCNPJValid(String cpf) {
        String cnpjNormalized = cpf
                                .replace(".", "")
                                .replace("/", "")
                                .replace("-", "");
        if (cnpjNormalized.length() < 14 || !cnpjNormalized.chars().allMatch(Character::isDigit)) {
            return false;
        } else {
            String baseDigits = cnpjNormalized.substring(0,cnpjNormalized.length()-2);
            List<Integer> digits = baseDigits.chars().mapToObj(c -> Integer.valueOf(Character.toString(c))).collect(Collectors.toList());
            return generateCNPJ(digits).equals(cpf);
        }
    }

    private String generateCNPJ(List<Integer> digits){

        if (baseNumberIsValid(digits)) {
            generateVerifyDigits(digits);
            return String.format("%d%d.%d%d%d.%d%d%d/%d%d%d%d-%d%d", digits.toArray());
        }

        return null;
    }

    private void generateVerifyDigits(List<Integer> baseNumbers) {
        //Create first verify digit
        baseNumbers.add(createVerifyDigit(baseNumbers));
        //Create second verify digit
        baseNumbers.add(createVerifyDigit(baseNumbers));
    }

    private boolean baseNumberIsValid(List<Integer> baseNumber) {
        return !baseNumber.stream()
                .allMatch(x -> x == baseNumber.get(0));
    }

    private int createVerifyDigit(List<Integer> baseNumber) throws IllegalArgumentException {
        List<Integer> digitMultiplier = new ArrayList<>();
        Collections.addAll(digitMultiplier,new Integer[]{5,4,3,2,9,8,7,6,5,4,3,2});

        if (baseNumber.size() != 12 && baseNumber.size() != 13) {
            throw new IllegalArgumentException("baseNumber argument must have 12 or 13 values");
        }

        //Se tiver no segundo digito verificador inserir 6 na lista de multiplicadores do digito
        if(baseNumber.size() == 13){
            digitMultiplier.add(0,6);
        }

        int sum = 0;
        for (int i = 0; i < baseNumber.size(); i++) {
            sum += baseNumber.get(i) * digitMultiplier.get(i);
        }

        int digito = 11 - (sum % 11);

        return digito > 9 ? 0 : digito;
    }
}
