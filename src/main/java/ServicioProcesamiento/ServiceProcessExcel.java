package ServicioProcesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceProcessExcel {
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    private List<String[]> ExcelData = new ArrayList<>();

    public void procesarExcel(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader("sampledatasafety.xlsx"));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                ExcelData.add(partes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            linea = null;
            partes = null;
        }
    }



    public List<String[]> getExcelData() {
        return ExcelData;
    }

}
