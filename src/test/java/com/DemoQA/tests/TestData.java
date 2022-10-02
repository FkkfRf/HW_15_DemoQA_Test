package com.DemoQA.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDate;
import static com.DemoQA.utils.RandomUtils.*;
import static com.codeborne.selenide.Selenide.$;

public class TestData {
   private String subjectArr[] = new String[] {"Maths" , "Accounting",
            "Arts" , "Social Studies" ,
            "Biology" , "Physics" ,
            "Chemistry" , "Computer Science" ,
            "Commerce" , "Economics" ,
            "Civics" , "Hindi" ,
            "English" , "History"};
   private String stateArr[] = new String[] {"NCR" , "Uttar Pradesh" , "Haryana" , "Rajasthan" };
   private String cityArr[] = new String[] {"Delhi" , "Agra", "Karnal", "Jaipur" };
   private int arr = (int) (Math.random() * 4 );


    private LocalDate randomD = randomBirthday();
    String firstName = generateRandomCharString(7),
            lastName = generateRandomCharString(10),
            gender = "Female",
            phoneNumber = generateRandomNumericString(10),
            userEmail = generateRandomEmail(),
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
            address = "221b \n Baker St, \n  London, Grate Britain";

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
