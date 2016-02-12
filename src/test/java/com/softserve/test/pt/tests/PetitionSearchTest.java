package com.softserve.test.pt.tests;

import com.softserve.test.at.data.StartData;
import com.softserve.test.at.tools.BrowserUtils;
import com.softserve.test.pt.data.StartPage;
import com.softserve.test.pt.pages.PetitionPage;
import com.softserve.test.pt.pages.PetitionSearchPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Reporter.log;

/**
 * Created by rdem on 10.02.2016.
 */
public class PetitionSearchTest {

    private SoftAssert softAssert;
    private StartData startData;
    @BeforeClass
    public void oneTimeSetUp() {
        startData = new StartData("https://petition.president.gov.ua/",
                "implicit","firefox","");
        softAssert = new SoftAssert();
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] saveImageAttach(String attachName) {
        try {
            return  ((TakesScreenshot)BrowserUtils.get().getBrowser().getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
    private static byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }


    @Title("petition metallica test")
    @Description("check if 'Metallica' text is present on the page")
    @Attachment(value = "{0}", type = "image/png")
    @Step("assert if expected test equals to actual")
    @Test
    public void test1(){
        PetitionPage petitionPage = StartPage.get().load(startData);
        PetitionSearchPage petitionSearchPage = petitionPage.search(PetitionPage.SEARCH_RESULT);
        softAssert.assertEquals(petitionSearchPage.findText(PetitionSearchPage.FIND_TEXT),true);
        System.out.print(petitionSearchPage.findText(PetitionSearchPage.FIND_TEXT));
     //   saveImageAttach("Image attach");
        softAssert.assertAll();


    }
}
