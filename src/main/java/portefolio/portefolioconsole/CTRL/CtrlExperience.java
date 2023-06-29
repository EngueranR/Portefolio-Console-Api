package portefolio.portefolioconsole.CTRL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portefolio.portefolioconsole.BO.Experience;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/experience")
public class CtrlExperience {

    @GetMapping
    public ResponseEntity<List<Experience>> getExperience() {
        List<Experience> experiences = getExperienceList();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }


    private List<Experience> getExperienceList() {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Initialize the result
        List<Experience> result = null;

        try {
            // Get the JSON file from the resources folder
            InputStream jsonStream = getClass().getResourceAsStream("/assets/experience.json");

            // Read JSON file and convert it to a list
            result = objectMapper.readValue(jsonStream, new TypeReference<List<Experience>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}