package portefolio.portefolioconsole.CTRL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portefolio.portefolioconsole.BO.Contact;
import portefolio.portefolioconsole.BO.Experience;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class CtrlContact {


    @GetMapping
    public ResponseEntity<List<Contact>> getExperience() {
        List<Contact> contact = getContactList();
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }


    private List<Contact> getContactList() {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Initialize the result
        List<Contact> result = null;

        try {
            // Get the JSON file from the resources folder
            InputStream jsonStream = getClass().getResourceAsStream("/assets/contact.json");

            // Read JSON file and convert it to a list
            result = objectMapper.readValue(jsonStream, new TypeReference<List<Contact>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}



