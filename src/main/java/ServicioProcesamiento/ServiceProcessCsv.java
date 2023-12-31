package ServicioProcesamiento;


import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProcessCsv {

    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    private List<String[]> csvData = new ArrayList<>();

    public void procesarCsv(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader("people.csv"));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                csvData.add(partes);
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



    public List<String[]> getCsvData() {
        return csvData;
    }
}

