
package lineales.dinamicas;

/**
 *
 * @author Usuario
 */
public class Pila {

    //Atributo de la clase Pila
    private Nodo tope;

    //constructor vacio
    public Pila() {
        this.tope = null;
    }

    //Métodos basicos de la clase Pila
    public boolean apilar(Object elem) {

        //Crea un nuevo Nodo adelante de la antigua cabecera
        Nodo nuevo = new Nodo(elem, this.tope);

        //Actualiza el tope para que apunte al nodo nuevo
        this.tope = nuevo;

        //Como no habrá error de Pila llena, devuelve True
        return true;
    }

    public boolean desapilar() {
        boolean exito = false;

        //Podra desapilar solo si no es vacía
        if (this.tope != null) {
            //Reordeno el tope asignandoselo al siguiente elemento unido por el enlace
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object retorno = null;
        //Por precondicion la Pila tiene que tener elementos
        if (this.tope != null) {
            //Retorno el elemento que esta en el tope
            retorno = this.tope.getElem();
        }
        return retorno;
    }

    //Otras operaciones de la clase Pila
    public boolean esVacia() {
        /*
        boolean vacio = false;
        if (this.tope == null) {
            vacio = true;
        }
        return vacio;*/
        return this.tope ==null;
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone() {
        Pila clon = new Pila();
        //Mando mi Pila y el tope a un metodo recursivo privado
        cloneAux(clon, this.tope);
        return clon;
    }

    private void cloneAux(Pila clon, Nodo aux) {
        //Hara el paso recursivo mientras que no sea igual a null
        if (aux != null) {
            cloneAux(clon, aux.getEnlace());//Hago el llamado recursivo hasta llegar a el caso base
            clon.tope = new Nodo(aux.getElem(), clon.tope);//Creo un nodo nuevo, con el elemento de su posicion y enlazandolo con el tope actual
        }
        

    }

    public String toString() {
        String cadena = "";
        //Verifico si la pila esta vacia, en ese caso devuelvo pila vacia, Sino llamo a un metodo auxiliar recursivo para realizar la cadena
        if (this.tope == null) {
            cadena = "Pila Vacia!";
        } else {
            cadena = "[" + toStringRecursivo(this.tope) + "]";
        }
        return cadena;
    }

    private String toStringRecursivo(Nodo pos) {
        String retorno;
        //Se hace el paso recursivo hasta que el enlace de un elemento sea null, este caso seria cuando llegue al primer elemento de la pila
        if (pos.getEnlace() == null) {
            retorno = pos.getElem().toString(); //Retorna el primer elemento de la pila
        } else {
            //Obtenemos el valor del nodo
            //Concatenamos el llamado con el elemento del siguiente
            retorno = this.toStringRecursivo(pos.getEnlace()) + "," + pos.getElem().toString();
        }
        return retorno;
    }

}
