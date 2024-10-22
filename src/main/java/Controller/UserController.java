package Controller;

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

    @GetMapping("/GetUsers")
    public List<User> getDummyUsers() {
        // Return a list of users instead of a dummy user object
        return users; // In a real application, retrieve this from a database
    }

    @PostMapping("/AddUser")
    public ResponseEntity<String> addUser(@RequestBody  @Valid User user) {
        try {
            user.setId(1L);
            return ResponseEntity.status(HttpStatus.CREATED).body(user.toString());
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing request: " + e.getMessage());
        }
    }
    @PostMapping("/AddUsernormal")
    public ResponseEntity<String> addUsernormal(@RequestBody String requestBody) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(requestBody);
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
