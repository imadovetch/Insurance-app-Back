package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

@RestController
public class UserController {

    @GetMapping("/GetUsers")
    public String getDummyUser() {
        JSONObject jsonResponse = new JSONObject();

        // Creating a dummy user object with sample data
        jsonResponse.put("id", "N/A"); // Use actual user.getId() if available
        jsonResponse.put("name", "John Doe");
        jsonResponse.put("email", "johndoe@example.com");
        jsonResponse.put("childs", 2);
        jsonResponse.put("phoneNumber", "123-456-7890");
        jsonResponse.put("adresse", "1234 Street Name, City, Country");
        jsonResponse.put("salaire", 50000);

        return jsonResponse.toString();
    }
    @PostMapping("/AddUser")
    public String Adduser() {
        JSONObject jsonResponse = new JSONObject();

        // Creating a dummy user object with sample data
        jsonResponse.put("id", "N/A"); // Use actual user.getId() if available
        jsonResponse.put("name", "John Doe");
        jsonResponse.put("email", "johndoe@example.com");
        jsonResponse.put("childs", 2);
        jsonResponse.put("phoneNumber", "123-456-7890");
        jsonResponse.put("adresse", "1234 Street Name, City, Country");
        jsonResponse.put("salaire", 50000);

        return jsonResponse.toString();
    }
}
