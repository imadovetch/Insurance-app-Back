package Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import Model.User;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated

public class UserController {

    // For demonstration purposes, we'll use an in-memory list
    private List<User> users = new ArrayList<>();



    @Autowired
    private UserService userService = new UserService();

    @GetMapping("/GetUsers")
    public List<User> getDummyUsers() {
        // Return a list of users instead of a dummy user object
        return users; // In a real application, retrieve this from a database
    }

    @PostMapping("/AddUser")
    public ResponseEntity<String> addUser(@RequestBody  @Valid User user) {
        try {


            userService.addUser(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(user.toString());
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing request: " + e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String requestBody) {
        try {
            // Manually parse the request body to extract email and password
            // Assuming the request body is JSON in the format: {"email": "example@example.com", "password": "password123"}
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(requestBody);

            String email = jsonNode.get("email").asText();
            String password = jsonNode.get("password").asText();

            // Retrieve the user based on the email provided
            User user = userService.findByEmail(email);

            if (user == null) {
                // If user with given email doesn't exist, return error response
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }

            // Check if the provided password matches the user's password
            if (!user.getPassword().equals(password)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }

            // If email and password match, return a success message
            return ResponseEntity.ok("Login successful");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing request: " + e.getMessage());
        }
    }
}
//
//public class UserMapper {
//
//    public User mapStringToUser(String requestBody) {
//        // Split the request body by commas and extract fields
//        String[] fields = requestBody.split(",");
//
//        // Assuming the order of fields is consistent
//        String name = fields[0].split(":")[1].trim().replace("\"", "");
//        String email = fields[1].split(":")[1].trim().replace("\"", "");
//        String password = fields[2].split(":")[1].trim().replace("\"", "");
//        String phoneNumber = fields[3].split(":")[1].trim().replace("\"", "");
//        String adresse = fields.length > 4 ? fields[4].split(":")[1].trim().replace("\"", "") : null; // Optional
//        Integer age = fields.length > 5 ? Integer.valueOf(fields[5].split(":")[1].trim()) : null; // Optional
//
//        return new User(name, email, password, phoneNumber, adresse, age);
//    }
//}
//
