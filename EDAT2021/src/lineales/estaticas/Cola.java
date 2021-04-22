
package lineales.estaticas;


/**
 *
 * @author Cristian Wilberger FAI-2375
 */
public class Cola {
    //Atributos de la clase Cola

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    //Constructor vacio
    public Cola() {
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    //Métodos básicos de la clase Cola
    public boolean poner(Object elem) {
        boolean exito;
        
        if ((this.fin + 1) % TAMANIO == this.frente) {//Si fin+1 es igual al frente,entonces la cola ya esta llena
            exito = false;
        } else {
             //Sino, pongo el elem en la posicion y aumento el fin
            this.arreglo[fin] = elem;
            this.fin = (this.fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito;

        if (this.frente == this.fin) {//Si son iguales, la Cola esta vacía
            exito = false;
        } else {//Sino, saco el elem y aumento el frente
            this.arreglo[frente] = null;
            this.frente = (this.frente + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object retorno;

        if (this.esVacia()) {//Si esta vacia retorno null
            retorno = null;
        } else {
            retorno = this.arreglo[this.frente];// sino, devuelvo el elem del frente
        }
        return retorno;
    }

    //Otras operaciones de la clase Cola
    public boolean esVacia() {    
        return this.frente == this.fin;//Devuelve un booleano si es vacia o no
    }

    public void vaciar() {
        int i = this.frente;
        
        while (i != this.fin) {// mientras que el frente sea distinto de null
            this.arreglo[i] = null;//le asigno null 
            i = (i + 1) % this.TAMANIO;// a i le asigno i mas el mod tamanio por la circularidad
        }
        this.fin = 0;// seteo el fin
        this.frente = 0;// seteo el frente
    }

    public Cola clone() {
        Cola clonada = new Cola();
        int i = this.frente;
        
        while (i != this.fin) {//mientras que el frente no sea igual a fin
            clonada.arreglo[i] = this.arreglo[i];// al clon en la pos i le asigno el valor de la original en la pos i
            i = (i + 1) % TAMANIO;// circularidad
        }
        clonada.fin = this.fin;//Le asigno el fin de la original al clon
        clonada.frente = this.frente;//Le asigno el frente de la original al clon
        return clonada;
    }

    public String toString() {
        //metodo para debuggear
        String res = "[";
        int i = this.frente;
        while (i != this.fin) {
            res = res + this.arreglo[i].toString()+" ";
            i = (i + 1) % this.TAMANIO;
        }
        res = res + "]";
        return res;
    }

}
