package portefolio.portefolioconsole.CTRL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portefolio.portefolioconsole.BO.Cursus;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/cursus")
public class CtrlCursus {

    @GetMapping
    public ResponseEntity<List<Cursus>> getExperience() {
        List<Cursus> cursus = getCursusList();
        return new ResponseEntity<>(cursus, HttpStatus.OK);
    }


    private List<Cursus> getCursusList() {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Initialize the result
        List<Cursus> result = null;

        try {
            // Get the JSON file from the resources folder
            InputStream jsonStream = getClass().getResourceAsStream("/assets/cursus.json");

            // Read JSON file and convert it to a list
            result = objectMapper.readValue(jsonStream, new TypeReference<List<Cursus>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}

