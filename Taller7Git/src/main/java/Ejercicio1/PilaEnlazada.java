package Ejercicio1;

public class PilaEnlazada {

    class Nodo {

        Object elem;
        Nodo Next;

        public Nodo(Object o) {
            elem = o;
            Next = null;
        }
    }

    Nodo cima;
    int longitud;

    public PilaEnlazada() {
        cima = null;
        longitud = 0;
    }

    public void PUSH(Object o) {
        Nodo nuevo = new Nodo(o);
        if (cima== null) {
            cima = nuevo;
        } else {
            nuevo.Next =  cima;
             cima = nuevo;
        }
        longitud++;
    }

     // insertar objetos

  public Object POP() {
        if (cima == null) {
            return null;
        }

        Object o = cima.elem;
         cima =  cima.Next;
        longitud--;
        return o;
    }// sacar los objetos de la pila

    public boolean EstaVacio() {

        return (longitud == 0);
    }

    public int longitud() {

        return longitud;
    }

    public Object TOP() {

        if (cima == null) {
            return null;
        } else {
            return cima.elem;
        }
    }

}
