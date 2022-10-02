package com.DemoQA.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDate;
import java.util.Locale;
import static com.DemoQA.utils.RandomUtils.*;
import static com.codeborne.selenide.Selenide.$;

public class TestData {
    Faker fakerRu = new Faker(new Locale("ru"));
    Faker faker = new Faker();
   private final String[] subjectArr = new String[] {"Maths" , "Accounting",
            "Arts" , "Social Studies" ,
            "Biology" , "Physics" ,
            "Chemistry" , "Computer Science" ,
            "Commerce" , "Economics" ,
            "Civics" , "Hindi" ,
            "English" , "History"};
   private final String[] stateArr = new String[] {"NCR" , "Uttar Pradesh" , "Haryana" , "Rajasthan" };
   private final String[] cityArr = new String[] {"Delhi" , "Agra", "Karnal", "Jaipur" };
   private final int arr = (int) (Math.random() * 4 );
   private static LocalDate randomD = randomBirthday();

    String firstName = fakerRu.name().firstName(),
            lastName = fakerRu.name().lastName(),
            gender = "Female",
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            userEmail = faker.internet().emailAddress(),
            dayC = randomDay(randomD),
            monthC = randomMonth(randomD),
            yearC = randomYear(randomD),
            subject1 = subjectArr[(int) (Math.random() * 5 )],
            subject2 = subjectArr[(int) (Math.random() * 5 + 5)],
            subject3 = subjectArr[(int) (Math.random() * 5 + 10)],
            state = stateArr[arr],
            city = cityArr[arr],
            fileUpload = "ForDemoQA.txt",
            hobbies1 = "Sports",
            hobbies2 = "Music",
            hobbies3 = "Reading",
            address = faker.address().streetAddress();

    public SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userEmailInput = $("#userEmail"),
            birthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            stateItemInput = $("#state"),
            cityItemInput = $("#city"),
            fileUploadInput = $("#uploadPicture"),
            curentAddressInput = $("#currentAddress"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            modalDialogInput = $(".modal-dialog"),
            modaleTitleInput = $(".modal-title"),
            modalTitleResponsiveInput = $(".table-responsive");

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1986";
        Configuration.holdBrowserOpen = true;
    }

}
