/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.tallern;

import java.util.Scanner;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Hanoi {

    Logger logger;

    public void Hanoi(int numeroAros, String A, String B, String C) {
        logger = Logger.getLogger("Metodo Recursivo");
        if (numeroAros == 1) {
            logger.log(Level.INFO, "MOviendo de la torre de inicio " + A + " a la torre del destino " + C);
        } else {
            Hanoi(numeroAros - 1, "A", "C", "B");
            logger.log(Level.INFO, "MOviendo de la torre de inicio " + A + " a la torre del destino " + C);
            Hanoi(numeroAros - 1, "B", "A", "C");
        }

    }

    public static void main(String[] args) {
        Logger logger;
        Scanner teclado = new Scanner(System.in);
        logger = Logger.getLogger("Principal");
        Hanoi llamado = new Hanoi();
        
        logger.log(Level.INFO, "Ingrese el numero de aros (discos)");
        int numeroAros = teclado.nextInt();
        llamado.Hanoi(numeroAros, "A", "B", "C");
    }
}
