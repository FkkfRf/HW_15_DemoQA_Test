package com.DemoQA.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import java.time.LocalDate;
import java.time.Month;
public class RandomUtils {
    public static String generateRandomString(int lenghtOfString){
        return RandomStringUtils.randomAlphanumeric(lenghtOfString);
    }
    public static String generateRandomCharString(int lenghtOfString){
        return RandomStringUtils.randomAlphabetic(lenghtOfString);
    }
    public static String generateRandomNumericString(int lenghtOfString) {
        return RandomStringUtils.randomNumeric(lenghtOfString);
    }
    public static String generateRandomEmail(){
        return generateRandomString(7) + "@" + generateRandomString(6) + ".com";
    }
    public static LocalDate randomBirthday() {
        int rN = (int)(Math.random() * 44500 );
        LocalDate lD = LocalDate.now().minusDays(rN);
        System.out.printf("randomN " + String.valueOf(rN) + "\n Generate TestDate " + lD );
        return lD;
    }
    public static String randomDay(LocalDate randomDate){
        return StringUtils.right(randomDate.toString(),2);
        //return randomDate.getDayOfMonth());
    }
    public static String randomMonth(LocalDate randomDate){
        return Month.of(randomDate.getMonthValue()).toString().charAt(0) + Month.of(randomDate.getMonthValue()).toString().substring(1).toLowerCase();
    }
    public static String randomYear(LocalDate randomDate){
        return String.valueOf(randomDate.getYear());

    }
}
