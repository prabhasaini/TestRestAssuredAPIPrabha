package TestsPkg;

import BaseFilePkg.BaseFileClass;
import EndPointsPkg.EndPointsClass;
import PayloadsPkg.PayLoadsClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserTest extends BaseFileClass {
   // @Test(priority = 1)
    public void createUserTest() {
        PayLoadsClass pload = new PayLoadsClass();
        pload.setName("Prabha Saini");
        pload.setCity("Ghaziabad");
        pload.setFirstname("Prabha");
        pload.setCountry("India");
        pload.setAddress1("Ghaziabad Sihani");
        pload.setPassword("prabha111");
        pload.setState("Uttar Pradesh");
        pload.setZipcode("201001");
        pload.setLastname("Saini");
        pload.setEmail("prbha.saini@gmail.com");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(pload)
                .when()
                .post(EndPointsClass.createUser);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 201);
    }

    //@Test
    public void GetProductList() {
        Response response = given()
                .when()
                .get(EndPointsClass.getProductList);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 201);
    }

   // @Test
    public void UpdateUserAccount() {
        PayLoadsClass pload = new PayLoadsClass();
        pload.setName("Prabha");
        pload.setEmail("prabha.saini@gmail.com");
        pload.setFirstname("Prabha");
        pload.setLastname("Saini");
        pload.setPassword("prabha111");
        pload.setMobile_number("1122334455");
        pload.setCountry("India");
        pload.setState("Uttar Pradesh");
        pload.setZipcode("201001");
        pload.setAddress1("VijayNagar Delhi");// Update
        pload.setCity("Delhi"); // Update
        Response response = given()
                .contentType(ContentType.JSON)
                .body(pload)
                .when()
                .put(EndPointsClass.updateUser);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    //@Test
    public void DeleteUser() {
        Response response = given()
                .when()
                .delete(EndPointsClass.deleteUser);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }
    // https://fakestoreapi.com
    @Test
    public void createUserTestFaker() {
        PayLoadsClass pload = new PayLoadsClass();
        pload.setId("123");
        pload.setUsername("PrabhaSaini");
        pload.setEmail("prbha.saini@gmail.com");
        pload.setPassword("12345");
        //pload.setCategory("men's clothing");
        System.out.println("Testing");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(pload)
                .when()
                .post(EndPointsClass.createUserFaker);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 201);
        //"id": 11
    }
    @Test
    public void GetUsersFakestore() {
        Response response = given()
                .pathParam("id", 1)
                .when()
                .get(EndPointsClass.getFakerUsers);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }
    @Test
    //email": "john@gmail.com",
    public void DeleteUserFakerstore() {
        Response res = given()
                .contentType(ContentType.JSON)
                .pathParam("id",1)
                .when()
                .delete(EndPointsClass.deleteUserFaker)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
                String Msg = res.jsonPath().getString("address.city");
                System.out.print("Description is :" + Msg);
                assertEquals(Msg, "kilcoole");
    }
}