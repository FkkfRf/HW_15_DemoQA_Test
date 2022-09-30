package com.DemoQA.utils;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;
public class RandomUtils {
    private static int lenghtOfString;

    public static String generateRandomCharString(int lenghtOfString){
        return RandomStringUtils.randomAlphabetic(10);
    }
    public static String generateRandomString(int lenghtOfString){
        return RandomStringUtils.randomAlphanumeric(10);
    }
    public static String generateRandomEmail(){
        return generateRandomString(7) + "@" + generateRandomString(6) + ".com";
    }
    public static String generateRandomNumericString(int lenghtOfString){
        return RandomStringUtils.randomNumeric(lenghtOfString);
    }
}
