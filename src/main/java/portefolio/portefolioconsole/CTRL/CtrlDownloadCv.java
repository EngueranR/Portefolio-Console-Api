package portefolio.portefolioconsole.CTRL;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class CtrlDownloadCv {

    private final ResourceLoader resourceLoader;

    public CtrlDownloadCv(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/downloadCv")
    public ResponseEntity<InputStreamResource> downloadCV() {
        try {
            Resource pdfFile = resourceLoader.getResource("classpath:assets/CV-Engueran-Raout-2023.pdf");
            InputStream inputStream = pdfFile.getInputStream();
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
