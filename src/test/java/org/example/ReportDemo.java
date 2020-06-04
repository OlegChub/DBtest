package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportDemo {
    ExtentReports extent;
    @BeforeTest
    public void reportConfig(){

        // Указывем куда сохранять репорт
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        System.out.println(path);
        //это вспомогательный объект, который отвечает за настройку страницы с репортом
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("My report");
        reporter.config().setReportName("Olegus rep");

        // основной объект, который отвечает за генерацию отчетов
        extent=new ExtentReports();
        // передаем настройки конфигурации
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Olegus Chub");
    }

    @Test
    public void test1() {
        //генерация отчета по тесту
        extent.createTest("Test-1");
        System.setProperty("webdriver.chrome.driver", "C:/Users/60066285/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fdc24.ru/");
        System.out.println(driver.getTitle());
        driver.close();

        //верстка отчета
        extent.flush();
    }
}
