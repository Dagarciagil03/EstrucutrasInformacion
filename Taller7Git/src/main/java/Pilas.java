

public class Pilas {

    private Nodo cabeza = null;
    private int longitud = 0;

    
    public class Nodo {

        public int Numero;
        public Nodo siguiente = null;

        public Nodo(int Numero) {
            this.Numero = Numero;
        }
    }
        public  void PUSH(int Numero) {

            Nodo nodo = new Nodo(Numero);
            nodo.siguiente = cabeza;
            cabeza = nodo;
            longitud++;
        }

        public String TOP() {
            String Dato = "";
            if (cabeza == null) {
                return null;
            } else {
                Nodo puntero = cabeza;
                Dato = "" + puntero.Numero;
                return Dato;
            }
        }

        public String estaVacia() {
            if (cabeza == null) {

                return "La pila esta vacia";
            } else {
                return "La pila No esta vacia";
            }
        }

        public void POP() {
            if (cabeza == null) {
                Nodo primer = cabeza;
                cabeza = cabeza.siguiente;
                primer = null;
                longitud--;
            }
        }

        public String Listar() {
            String Dato = "";
            Nodo aux = cabeza;
            int n = 0;
            while (aux != null) {
                Dato += aux.Numero + "  ";
                aux = aux.siguiente;
                n++;
            }
            return (Dato);
        }

        public void VaciarPila() {
            if (cabeza != null) {
                Nodo primer = cabeza;
                cabeza = cabeza.siguiente = null;
                primer = null;
                longitud = 0;
            }
        }
    
}
