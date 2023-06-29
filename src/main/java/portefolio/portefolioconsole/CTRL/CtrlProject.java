package portefolio.portefolioconsole.CTRL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portefolio.portefolioconsole.BO.Experience;
import portefolio.portefolioconsole.BO.Project;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/project")
public class CtrlProject {

    @GetMapping
    public ResponseEntity<List<Project>> getExperience() {
        List<Project> project = getProjectList();
        return new ResponseEntity<>(project, HttpStatus.OK);
    }


    private List<Project> getProjectList() {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Initialize the result
        List<Project> result = null;

        try {
            // Get the JSON file from the resources folder
            InputStream jsonStream = getClass().getResourceAsStream("/assets/project.json");

            // Read JSON file and convert it to a list
            result = objectMapper.readValue(jsonStream, new TypeReference<List<Project>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
