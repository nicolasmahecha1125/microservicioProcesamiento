package controladorServicio;

import ServicioProcesamiento.ServiceProcessCsv;
import ServicioProcesamiento.ServiceProcessExcel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/api")
@RequiredArgsConstructor
public class ArchiveController {

    @Autowired
    private ServiceProcessCsv csvService;
    @Autowired
    private ServiceProcessExcel excelService;

    @GetMapping("/process-cvs")
    public List<String[]> processCsv(@RequestParam String fileName) {
        csvService.procesarCsv("people.cvs");
        return csvService.getCsvData();
    }
    @GetMapping("/process-Excel")
    public List<String[]> procesarExcel(@RequestParam String fileName) {
        excelService.procesarExcel("sampledatasafety.xlsx");
        return excelService.getExcelData();
    }
}
