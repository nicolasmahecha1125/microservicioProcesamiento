package ServicioProcesamiento;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
            lector = new BufferedReader(new FileReader(nombreArchivo)); // Use the provided filename
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                csvData.add(partes); // Add the parts to the list
                imprimirLinea();
                System.out.println();
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void imprimirLinea() {
        for (int i = 0; i < partes.length; i++) {
            System.out.print(partes[i] + " | ");
        }
    }

    public List<String[]> getCsvData() {
        return csvData;
    }
}

