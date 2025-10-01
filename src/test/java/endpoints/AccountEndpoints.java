package endpoints;

import payload.Login;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class AccountEndpoints {

    private static ResourceBundle getURL() {
        return ResourceBundle.getBundle("logindetails");
    }

    /** Create a new user */
    public static Response createUser(Login payload) {
        String post_url = getURL().getString("user_url");
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
            .when()
                .post(post_url);
    }

    /** Generate token for a user */
    public static Response generateToken(Login payload) {
        String token_url = getURL().getString("generate_token_url");
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
            .when()
                .post(token_url);
    }

    /** Delete user by ID (requires token) */
    public static Response deleteUser(String userId, String token) {
        String delete_url = getURL().getString("delete_userByID_url");
        return given()
                .header("Authorization", "Bearer " + token)
                .pathParam("UUID", userId)
            .when()
                .delete(delete_url);
    }
}
