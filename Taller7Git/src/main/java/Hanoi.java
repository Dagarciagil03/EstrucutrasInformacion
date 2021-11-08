

import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Hanoi {

    public static Pilas pPila1 = new Pilas();
    public static Pilas pPila2 = new Pilas();
    public static Pilas pPila3 = new Pilas();
    public static int tope;

    public static void main(String[] args) {
        Logger logger;
        logger = Logger.getLogger("Menu");

        int CantidadDiscos;
        CantidadDiscos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos discos desea?"));
        for (int i = 1; i <= CantidadDiscos; i++) {
            pPila1.PUSH(i);
        }
        logger.log(Level.INFO, "Origen " + pPila1.Listar() + " Medio " + pPila2.Listar() + "Destino " + pPila3.Listar());
        PasosHanoi(Integer.parseInt(pPila1.TOP()),1, 2, 3);
    }

    public static void PasosHanoi(int Numero, int Origen, int Auxiliar, int Destino) {
        Logger logger;
        logger = Logger.getLogger("Menu");

        if (Numero == 1) {
            if (Origen == 1) {
                
                tope = Integer.parseInt(pPila1.TOP());
                pPila1.POP();
            }
            if (Origen == 2) {
                tope = Integer.parseInt(pPila2.TOP());
                pPila2.POP();
            }
            if (Origen == 3) {
                tope = Integer.parseInt(pPila3.TOP());
                pPila3.POP();
            }

            if (Destino == 1) {
                pPila1.PUSH(tope);
            }
            if (Destino == 2) {
                pPila2.PUSH(tope);
            }
            if (Destino == 3) {
                pPila3.PUSH(tope);
            }
            logger.log(Level.INFO, "\nOrigen" + pPila1.Listar() + "\nMedio" + pPila2.Listar() + "\nDestino " + pPila3.Listar());

        } else {
            PasosHanoi(Numero - 1, Origen, Destino, Auxiliar);
            logger.log(Level.INFO, "Mover disco de " + Origen + " a " + Destino);
            if (Origen == 1) {
                tope = Integer.parseInt(pPila1.TOP());
                pPila1.POP();
            }
            if (Origen == 2) {
                tope = Integer.parseInt(pPila2.TOP());
                pPila2.POP();
            }
            if (Origen == 3) {
                tope = Integer.parseInt(pPila3.TOP());
                pPila3.POP();
            }

            if (Destino == 1) {
                pPila1.PUSH(tope);
            }
            if (Destino == 2) {
                pPila2.PUSH(tope);
            }
            if (Destino == 3) {
                pPila3.PUSH(tope);
            }
            logger.log(Level.INFO, "\nOrigen" + pPila1.Listar() + "\nMedio" + pPila2.Listar() + "\nDestino " + pPila3.Listar());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            PasosHanoi(Numero - 1, Auxiliar, Origen, Destino);
        }
    }
}
