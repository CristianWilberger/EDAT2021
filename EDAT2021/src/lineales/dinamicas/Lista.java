package lineales.dinamicas;

/**
 *
 * @author Cristian Wilberger FAI-2375
 */
public class Lista {
    //Atributos

    private Nodo cabecera;
    private int longitud;

    //Constructor
    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    //Métodos basicos del TDA Lista
    public boolean insertar(Object elem, int pos) {
        //Inserta el elem en la pos pasada por parámetro
        boolean exito = true;
        //Si no es una posicion valida devuelve error
        if (pos < 1 || pos > this.longitud + 1) {
            exito = false;
        } else {
            if (pos == 1) {//Crea el nnuevo Nodo y lo enlaza a la cabecera
                this.cabecera = new Nodo(elem, this.cabecera);
            } else {//avanzo hasta el elem en la posicion pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //Creo el nodo y lo enlazo
                Nodo nuevo = new Nodo(elem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;//Al usar el atributo longitud, lo incremento cada vez que inserto
        }//No puede haber error de Lista llena, devuelve siempre true en caso de que la posicion si sea valida
        return exito;
    }

    public boolean eliminar(int pos) {
        //Elimina el elem en la posicion indicada
        boolean exito = true;
        //Si no es una posicion válida devuelve un error
        if (longitud == 0 || pos < 1 || pos > this.longitud) {
            exito = false;
        } else {
            if (pos == 1) {//Si hay que eliminar el elem de la primera posicion, le asigno la cabecera al siguiente 
                this.cabecera = this.cabecera.getEnlace();
            } else {// sino, avanzo hasta el elem en la pos -1 y le seteo el enlace al consiguiente
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;//Decremento la longitud de la lista cada vez que elimino con exito
        }
        return exito;
    }

    public Object recuperar(int pos) {
        Object retorno;
        int i = 1;
        if (pos < 1 || pos > this.longitud) { //Si la posicion no es valida devuelvo un objeto nulo
            retorno = null;
        } else {  //Sino,recorro desde la cabecera hasta la pos indicada y devuelvo el elem de ese Nodo 
            Nodo aux = this.cabecera;
            while (i != pos) {
                aux = aux.getEnlace();
                i++;
            }
            retorno = aux.getElem();
        }
        return retorno;
    }

    public int localizar(Object elem) {
        int pos = -1;
        int i = 1;
        int lon = this.longitud;
        Nodo aux = this.cabecera;
        while (i <= lon) {//Mientras que i sea menor que la longitud 
            if (aux.getElem().equals(elem)) {// Si el elem en la posicion es igual a el ingresado, corto la iteracion y devuelvo la pos
                pos = i;
                i = this.longitud + 1;
            } else {// Sino, aumento el i y a aux le asigno el siguiente enlace
                i++;
                aux = aux.getEnlace();
            }
        }
        return pos;//Devolvera la posicion encontrada o si no encuentra el elemnto devolvera -1 por defecto
    }

    public void vaciar() {
        this.cabecera = null;// seteo la cabecera para que sea null y los demas elementos se los lleve el garbage collector
        this.longitud = 0;// le reseteo la longitud a 0

    }

    public boolean esVacia() {
        return this.longitud == 0;// si la Longitud de la lista es 0 , no tiene elementos por lo que es vacia
    }

    public int longitud() {
        return this.longitud;// al usar el atributo longitud , puedo solo devolver ese atributo
    }

    public Lista clone() {

        Lista clon = new Lista();

        Nodo aux1, aux2;
        aux1 = this.cabecera;
        if (aux1 != null) {//Si la Lista No esta vacía , Creo un Nodo en la nueva Lista con el elem de aux 1 y le asigno la cabecera
            aux2 = new Nodo(aux1.getElem(), null);
            clon.cabecera = aux2;
            while (aux1.getEnlace() != null) {// Mientras que el enlace del nodo no sea nulo , creo un nodo nuevo, con el elem de la original
                aux1 = aux1.getEnlace();
                Nodo nuevo = new Nodo(aux1.getElem(), null);
                aux2.setEnlace(nuevo);// y seteo los enlaces del ultimo Nodo con el nuevo y actualizo aux 2
                aux2 = aux2.getEnlace();
            }
        }
        clon.longitud = this.longitud;//A la lista clon le asigno la longitud de la original 
        return clon;
    }

    public String toString() {
        //metodo para debuggin
        String cadena = "Lista vacia";

        int j = this.longitud;
        if (j > 0) {
            cadena = "[";
            int i = 1;
            Nodo aux = this.cabecera;
            while (i <= j && aux != null) {
                cadena = cadena + aux.getElem().toString() + " ";
                i++;
                aux = aux.getEnlace();
            }
            cadena = cadena + "]";
        }
        return cadena;
    }
}
