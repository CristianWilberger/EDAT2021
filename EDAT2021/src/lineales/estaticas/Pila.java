/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Usuario
 */
public class Pila {

    //Atributos de la clase Pila
    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 10;

    //Constructor vacio
    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    //Metodos Básicos de la clase Pila
    public boolean apilar(Object elem) {
        boolean exito;

        if (this.tope + 1 >= this.TAMANIO) {
            //ERROR: La pila esta llena
            exito = false;
        } else {
            //Pone el elemento ingresado por parámetro en el tope de la pila e incrementa el tope
            this.tope++;
            this.arreglo[tope] = elem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito;

        if (this.tope > -1) {
            //Le asigna null al elemento del tope para desapilar y decrece el tope de la Pila
            this.arreglo[this.tope] = null;
            this.tope--;
            exito = true;
        } else {
            //ERROR: La pila está vacia
            exito = false;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object retorno=null;
        //Precondicion= La pila no debe estar vacía
        if (this.tope > -1) {
            //Verifico si la Pila Tiene elementos 
            retorno = this.arreglo[tope];
        } 
        
        return retorno;
    }

    //Otras operaciones con Pila
    public boolean esVacia() {
        boolean vacio;

        if (this.tope != -1) {
            //Si el tope es distinto de -1 entonces tiene elementos y devuelve false
            vacio = false;
        } else {
            //Sino, la Pila no tiene elementos y devuelve true
            vacio = true;
        }
        return vacio;
    }

    public void vaciar() {
        int i = 0;

        while (i <= this.tope) {
            this.arreglo[i] = null;
            i++;
        }
        this.tope=-1;
    }

    public Pila clone() {
        //Declaro y construyo la nueva pila clonada
        Pila clonada = new Pila();
        int i = 0;
        while (i <= this.tope) {
            //Recorro la Pila original, asignandole los valores a la Pila clonada
            clonada.arreglo[i] = this.arreglo[i];
            i++;
        }
        //Le asigno el tope de la Pila original a la nueva
        clonada.tope = this.tope;
        return clonada;
    }

    public String toString() {
        
        String retorno = "";
        int i = 0;
        int top = this.tope;
        if (!esVacia()) {
            //Recorre la pila si esta no es vacia
            retorno = "[";
            while (i <= top) {
                retorno = retorno + this.arreglo[i];
                if (i < top) {
                    retorno = retorno + ",";
                }
                i++;
            }
            retorno = retorno + "]";
        } else {
            retorno = "La Pila es vacia";
        }
        return retorno;

        
    }
}
