package BaseFilePkg;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseFileClass {

    @BeforeClass
    public void setup() {
        //RestAssured.baseURI = "https://automationexercise.com/"; }


        RestAssured.baseURI = "https://fakestoreapi.com/"; }
}
