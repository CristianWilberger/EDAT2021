/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Cristian Wilberger FAI-2375
 */
public class Cola {

    //Atributos 
    private Nodo frente;
    private Nodo fin;

    //Constructor 
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object elem) {
        Nodo nuevo = new Nodo(elem, null);

        if (frente == null) {//Si la cola esta vacia, le asigno el frente al nuevo nodo
            this.frente = nuevo;
        } else {//Sino, le seteo el enlace del ultimo nodo con el nodo recien creado
            this.fin.setEnlace(nuevo);
        }
        this.fin = nuevo;//Le asigno fin al ultimo nodo puesto
        return true;
    }

    public boolean sacar() {
        boolean exito = true;
        if (this.frente == null) {
            //La cola esta vacia, devuelve un error
            exito = false;
        } else {
            //Hay elementos, quita el primer elemento y cambia el frente
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {//Si se vacia la cola por el frente, seteo el fin 
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object retorno = null;
        //Por precondicion la Pila tiene que tener elementos
        if (this.frente != null) {
            //Retorno el elemento del frente
            retorno = this.frente.getElem();
        }
        return retorno;
    }

    public boolean esVacia() {
        //Metodo que verifica si el frente esta vacio, en caso afirmativo devuelve true
        return this.frente == null;
    }

    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    public Cola clone() {
        Cola clon = new Cola();//Creo la nueva cola
        Nodo aux1, aux2; //Asigno 2 nuevos nodos auxiliares para poder moverme en las estructuras       
        aux1 = this.frente;//le asigno el frente para poder empezar a clonar

        if (aux1 != null) {//Si el frente no es nulo
           
            aux2 = new Nodo(aux1.getElem(), null);// Al nodo aux2 le creo un nuevo nodo con el elem del frente de la original
           
            clon.frente = aux2;//Le asigno el frente 
           
            clon.fin = aux2;// y el fin
            while (aux1.getEnlace() != null) {// mientras que el siguiente elem de aux1 no sea nulo
               
                aux1 = aux1.getEnlace();//paso al siguiente elem de la cola
                
                aux2 = new Nodo(aux1.getElem(), null);//Creo un nodo nuevo con ese elemento
                
                clon.fin.setEnlace(aux2);//Le seteo el enlace del elemnto del fin de la cola, para que apunte al nodo recien creado
                
                clon.fin = clon.fin.getEnlace();// ahora mi fin es el recien enlazado
                
                //Repito los pasos hasta que me quede sin elementos 
            }
        }
        return clon;

    }

    public String toString() {
        String retorno;

        if (this.frente != null) {
            retorno = "[" + toStringPaso(this.frente) + "]";
        } else {
            retorno = "Cola vacia!";
        }
        return retorno;
    }

    public String toStringPaso(Nodo frente) {
        String retornoAux;

        if (frente.getEnlace() != null) {
            retornoAux = frente.getElem().toString() + "," + toStringPaso(frente.getEnlace());
        } else {
            retornoAux = frente.getElem().toString();
        }
        return retornoAux;
    }
}
