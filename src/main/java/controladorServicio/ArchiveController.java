package controladorServicio;

import ServicioProcesamiento.ServiceProcessCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArchiveController {

    @Autowired
    private ServiceProcessCsv csvService;

    @GetMapping("/process-csv")
    public List<String[]> processCsv(@RequestParam String fileName) {
        csvService.procesarCsv("people.cvs");
        return csvService.getCsvData();
    }
}
