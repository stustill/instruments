package investments.goji;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(MySqlResource.class)
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/hello/greeting/Stu")
            .then()
            .statusCode(200)
            .body(is("Hello, Stu"));
    }

}