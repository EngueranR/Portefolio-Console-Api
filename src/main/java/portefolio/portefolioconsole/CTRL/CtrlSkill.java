package portefolio.portefolioconsole.CTRL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portefolio.portefolioconsole.BO.Experience;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import portefolio.portefolioconsole.BO.Skill;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/skill")
public class CtrlSkill {


    @GetMapping
    public ResponseEntity<List<Skill>> getExperience() {
        List<Skill> skill = getSkillList();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    private List<Skill> getSkillList() {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Skill> result = null;

        try {
            InputStream jsonStream = getClass().getResourceAsStream("/assets/skill.json");
            result = objectMapper.readValue(jsonStream, new TypeReference<List<Skill>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
