
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roboto
 */
public class Read {

    public static Ventanas ventanas = new Ventanas();

    public static void Leer(Stage s) {
        try (BufferedReader bf = new BufferedReader(new FileReader("./src/Recursos/texto.txt"))) {

            String linea = bf.readLine();
            linea = bf.readLine();
            //System.out.println(linea);
            while (linea != null) {

                String cadena[] = linea.split(";");
                Ventana v = new Ventana(s, cadena[0], cadena[1], cadena[2], cadena[3], cadena[4], Integer.parseInt(cadena[5]));

                ventanas.add(v);
                linea = bf.readLine();
            }
        } catch (FileNotFoundException fex) {
            System.out.println("File not found Exception");
        } catch (IOException ioex) {
            System.out.println("IOException");
        }

    }
}
