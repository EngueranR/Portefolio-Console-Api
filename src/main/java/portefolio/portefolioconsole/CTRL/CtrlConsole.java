package portefolio.portefolioconsole.CTRL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import portefolio.portefolioconsole.BO.Console;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CtrlConsole {

    private Console console = new Console();

    @GetMapping("/console")
    public String interpretCommand(@RequestParam(required = false) String command) {
        if (command == null) {
            // Retourner une réponse par défaut si aucun paramètre n'est fourni
            return "Aucune commande n'a été fournie. Utilisez 'help' pour voir les commandes disponibles.";
        }
        return console.interpretCommand(command);
    }

    @GetMapping("/commands")
    public ResponseEntity<List<Map<String, String>>> getCommandsList() {
        List<Map<String, String>> commands = console.getCommandsList();
        return new ResponseEntity<>(commands, HttpStatus.OK);
    }


}
