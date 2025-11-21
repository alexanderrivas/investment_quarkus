package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.jwt.build.Jwt;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExampleResourceTest {

    private String obtainKeycloakToken() {
        // Utiliza credenciais padrão de admin (username/password = admin/admin)
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "password")
                .formParam("client_id", "security-admin-console")
                .formParam("username", "admin")
                .formParam("password", "admin")
                .post("http://localhost:8081/realms/master/protocol/openid-connect/token")
                .then()
                .statusCode(200)
                .extract()
                .path("access_token");
    }

    @Test
    void testHelloEndpoint() {
//        String token = obtainKeycloakToken();

        given()
//                .header("Authorization", "Bearer " + token)
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}