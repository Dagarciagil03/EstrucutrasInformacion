package Ejercicio1;

import co.edu.ucundinamarca.tallern.Main;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Prueba {

    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Scanner Teclado = new Scanner(System.in);
        PilaEnlazada llamar = new PilaEnlazada();
        String Cadena = null;
        log.debug("INGRESE VALORES");
        for (int i = 0; i < 4; i++) {
            Cadena = Teclado.nextLine();
            llamar.PUSH(Cadena);
        }
        while ((Cadena = (String) llamar.POP()) != null) {
            log.debug(Cadena);
        }
    }
}
