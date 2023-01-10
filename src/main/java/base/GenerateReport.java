package base;

import java.io.IOException;

public class GenerateReport {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c start cmd /k \" cd src\\main\\resources\\allure\\bin && allure serve " + System.getProperty("user.dir") + "\\allure-results \"");
    }
}

