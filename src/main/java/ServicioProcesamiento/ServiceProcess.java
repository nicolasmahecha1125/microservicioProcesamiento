package ServicioProcesamiento;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
@Service
public class ServiceProcess {

private BufferedReader lector;
private String linea;
private String partes[] = null;
    public void procesarCsv(String nombreArchivo){
        try {
            lector = new BufferedReader(new FileReader("people.csv"));
            while((linea= lector.readLine()) != null){
                partes = linea.split(",");
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
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void imprimirLinea(){
        for(int i=0; i< partes.length;i++){
            System.out.print(partes[i]+" | ");
        }
    }
}
