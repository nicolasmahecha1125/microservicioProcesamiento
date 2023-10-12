package controladorServicio;

import ServicioProcesamiento.ServiceProcessCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ArchiveController {

    @Autowired
    private ServiceProcessCsv csvService;

    @PostMapping("/process-csv")
    public List<String[]> processCsv(@RequestParam String fileName) {
        csvService.procesarCsv("people.cvs");
        csvService.imprimirLinea();
        return csvService.getCsvData();
    }
}
