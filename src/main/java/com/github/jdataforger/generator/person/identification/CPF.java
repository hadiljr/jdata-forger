package com.github.jdataforger.generator.person.identification;

import com.github.jdataforger.generator.abstraction.IForgery;

import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CPF implements IForgery<String> {

    @Override
    public String fake() {
        Random rn = new Random();
        List<Integer> baseDigits = rn.ints(9, 0, 10)
                .mapToObj(d -> Integer.valueOf(d))
                .collect(Collectors.toList());
        return generateCPF(baseDigits);
    }


    public boolean isCPFValid(String cpf) {
        String cpfNormalized = cpf.replace(".", "").replace("-", "");
        if (cpfNormalized.length() < 11 || !cpfNormalized.chars().allMatch(Character::isDigit)) {
            return false;
        } else {
            String baseDigits = cpfNormalized.substring(0,cpfNormalized.length()-2);
            List<Integer> digits = baseDigits.chars().mapToObj(c -> Integer.valueOf(Character.toString(c))).collect(Collectors.toList());
            return generateCPF(digits).equals(cpf);
        }
    }

    private void generateVerifyDigits(List<Integer> baseNumbers) {
        //Create first verify digit
        baseNumbers.add(createVerifyDigit(baseNumbers));
        //Create second verify digit
        baseNumbers.add(createVerifyDigit(baseNumbers));
    }

    private String generateCPF(List<Integer> digits) {

        if (baseNumberIsValid(digits)) {
            generateVerifyDigits(digits);
            return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", digits.toArray());
        }

        return null;
    }


    private boolean baseNumberIsValid(List<Integer> baseNumber) {
        return !baseNumber.stream()
                .allMatch(x -> x == baseNumber.get(0));
    }


    private int createVerifyDigit(List<Integer> baseNumber) throws IllegalArgumentException {
        if (baseNumber.size() != 9 && baseNumber.size() != 10) {
            throw new IllegalArgumentException("baseNumber argument must have 9 ou 10 values");
        }

        int sum = 0;
        for (int i = 0; i < baseNumber.size(); i++) {
            sum += baseNumber.get(i) * (baseNumber.size() + 1 - i);
        }

        int digito = 11 - (sum % 11);

        return digito > 9 ? 0 : digito;
    }
}
