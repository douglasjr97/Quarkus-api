package io.github.douglasjr97.quarkusapi.rest;

import io.github.douglasjr97.quarkusapi.rest.dto.CreateUserRequest;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserResourceTest {
    @Test
    @DisplayName("should create an user succesfully")
    public void createUserTest(){
        var user = new CreateUserRequest();
        user.setName("Douglas");
        user.setAge(26);

        var response =
                given()
                .contentType(ContentType.JSON)
                        .body(user).when()
                        .post("/users")
                        .then()
                        .statusCode(200);

    }

    @Test
    @DisplayName("should return error when json is not valid")
    public void createUserValidationError(){
        var user = new CreateUserRequest();
        user.setName(null);
        user.setAge(null);

        var response =
                given()
                        .contentType(ContentType.JSON)
                        .body(user).when()
                        .post("/users")
                        .then()
                        .statusCode(500);

    }

    @Test
    @DisplayName("should return json with users")
    public void GetAllUsersTest() {
        var user = new CreateUserRequest();
        user.setName("Douglas");
        user.setAge(26);

        given()
                .when().get("/users")
                .then()
                .statusCode(200)
                .body("size()", Matchers.is(1));
    }
}