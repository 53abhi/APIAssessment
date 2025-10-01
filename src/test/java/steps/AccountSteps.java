package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AccountSteps {

    private String baseUrl;
    private Response response;

    @Given("I have the user API endpoint")
    public void i_have_the_user_api_endpoint() {
        // Example public API: reqres.in
        baseUrl = "https://reqres.in/api/users";
    }

    @When("I send a GET request for user with ID {int}")
    public void i_send_a_get_request_for_user_with_id(Integer userId) {
        response = given()
                .when()
                .get(baseUrl + "/" + userId);
        response.then().log().all();
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatus) {
        assertThat("Status code mismatch", response.getStatusCode(), equalTo(expectedStatus));
    }

    @Then("the user name should be {string}")
    public void the_user_name_should_be(String expectedName) {
        String firstName = response.jsonPath().getString("data.first_name");
        String lastName  = response.jsonPath().getString("data.last_name");
        String actualName = firstName + " " + lastName;

        assertThat("User name mismatch", actualName, equalTo(expectedName));
    }
}
