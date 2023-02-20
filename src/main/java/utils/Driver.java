package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Driver {
    public static WebDriver driver;

    //@BeforeSuite
    public static void startDriver(String browserName) {

        if (browserName.equals("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equals("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }

        driver.manage().window().maximize();

    }
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string
        String jsonContent;
        jsonContent = FileUtils.readFileToString(new File(filePath));
        //string to HashMap

        //String to HashMap Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String,String>>>() {});
        return data;
    }

    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName +".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName +".png";
    }

    //@AfterSuite
    public void endDriver() {
        driver.quit();

    }
}