package io.github.jdataforger.generator.person;

import io.github.jdataforger.generator.abstraction.IForgery;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Generate birthdates
 * @author Hadil
 */
public class Birthdate implements IForgery<LocalDate> {

    /**
     * Generate random birthdate between 1 and 100 old.
     * @return {@link LocalDate}
     */
    @Override
    public LocalDate fake() {
        return generateBirthdate(1,100);
    }


    /**
     * Generate random birthday between ( inclusive) ages;
     * @param minAge - min age value
     * @param maxAge - max age value
     * @return {@link LocalDate}
     *
     * @throws IllegalArgumentException if minAge is greater than maxAge
     */
    public LocalDate between(long minAge, long maxAge) throws IllegalArgumentException {
        return generateBirthdate(minAge,maxAge);
    }

    private LocalDate generateBirthdate(long minAge,long maxAge) throws IllegalArgumentException{

        if(minAge>maxAge){
            throw new IllegalArgumentException("minAge should be less than maxAge");
        }

        long early = LocalDate.now().minusYears(minAge).toEpochDay();
        long older = LocalDate.now().minusYears(maxAge+1).toEpochDay();
        long randomDate = ThreadLocalRandom.current().nextLong(older,early);

        return LocalDate.ofEpochDay(randomDate);
    }


}
