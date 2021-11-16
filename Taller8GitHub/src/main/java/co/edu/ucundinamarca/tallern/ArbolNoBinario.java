/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.tallern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

class Proyecto_EstructuraI {

    Nodo raiz;

    public Nodo insertarRaiz(String dato) {
        raiz = new Nodo(dato);
        return raiz;
    }

    public void PREORDEN(Nodo nodo) {
        for (int i = 0; i < nodo.nohijos; i++) {
            nodo.hijos[i].PREORDEN();
            PREORDEN(nodo.hijos[i]);
        }
    }

    public void INORDEN(Nodo nodo) {
        Logger logger;
        logger = Logger.getLogger("Inorden");

        if (nodo.nohijos == 0) {
            logger.log(Level.INFO, nodo.getDato());

        } else if (nodo.nohijos > 0) {
            INORDEN(nodo.hijos[0]);
            logger.log(Level.INFO, nodo.getDato());
            for (int i = 1; i < nodo.nohijos; i++) {
                INORDEN(nodo.hijos[i]);
            }
        }
    }

    public void POSTORDEN(Nodo nodo) {
        Logger logger;
        logger = Logger.getLogger("Postorden");

        for (int i = 0; i < nodo.nohijos; i++) {
            POSTORDEN(nodo.hijos[i]);
        }
        logger.log(Level.INFO, nodo.getDato());
    }

    public void InsertarRecursivo(Nodo nodo, String dato, String padre) {
        Nodo nuevo = new Nodo(dato);
        if (nodo.getDato().equals(padre)) {
            nodo.aumentarHijos(nuevo);
        } else {
            for (int i = 0; i < nodo.nohijos; i++) {
                if (nodo.hijos[i].getDato().equals(padre)) {
                    nodo.hijos[i].aumentarHijos(nuevo);
                } else {
                    InsertarRecursivo(nodo.hijos[i], dato, padre);
                }
            }
        }
    }

    public static void main(String[] args) {
        Proyecto_EstructuraI arbol = new Proyecto_EstructuraI();
        Nodo nodo = arbol.insertarRaiz("A");
        arbol.raiz.PREORDEN();

        arbol.InsertarRecursivo(nodo, "B", "A");
        arbol.InsertarRecursivo(nodo, "C", "A");
        arbol.InsertarRecursivo(nodo, "D", "A");

        arbol.InsertarRecursivo(nodo, "C.E", "C");
        arbol.InsertarRecursivo(nodo, "C.F", "C");

        arbol.InsertarRecursivo(nodo, "F.G", "C.F");
        arbol.PREORDEN(nodo); //6.64
        arbol.INORDEN(nodo); //6.677
        arbol.POSTORDEN(nodo); // 7.252

    }
}

class Nodo {

    String info;
    int nohijos;
    Nodo hijos[];
    Nodo hijosT[];

    public Nodo(String dato) {
        info = dato;
        this.nohijos = 0;
    }

    public void copiarHijos() {
        hijosT = new Nodo[nohijos + 1];
        for (int i = 0; i < this.nohijos; i++) {
            hijosT[i] = hijos[i];
        }
    }

    public void aumentarHijos(Nodo nodo) {
        copiarHijos();
        hijosT[this.nohijos] = nodo;
        hijos = hijosT;
        this.nohijos++;

    }

    public String getDato() {
        return info;
    }

    public void setDato(String dato) {
        info = dato;
    }

    public void PREORDEN() {
        Logger logger;
        logger = Logger.getLogger("Preorden");
        logger.log(Level.INFO, "PREORDEN {" + info + "}");

    }
}
