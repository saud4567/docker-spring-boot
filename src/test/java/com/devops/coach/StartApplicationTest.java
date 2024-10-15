import static org.junit.Assert.assertTrue;  // Add this line for assertTrue
import java.time.LocalDate;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StartApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testIndex() {
        // Get today's date
        String expectedDate = LocalDate.now().toString();
        
        // Adjust this to match the expected title format in your application
        String expectedTitle = "Welcome folks..We are learning Kubernete Deployment using Helm, Jenkins Pipeline Today's date is " + expectedDate + "..!!!!";

        // Send a request to the home page
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        String responseBody = response.getBody();

        // Assert that the response contains the correct dynamic date
        assertTrue(responseBody.contains(expectedTitle));
    }
}
