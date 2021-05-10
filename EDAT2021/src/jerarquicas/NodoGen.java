/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Usuario
 */
public class NodoGen {
    //Atributos
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    //Constructor
    public NodoGen(Object elem,NodoGen hijoIzq,NodoGen hermanoDer){
        this.elem=elem;
        this.hijoIzquierdo=hijoIzq;
        this.hermanoDerecho=hermanoDer;
    }
    
     //Modificadores
    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setHijoIzquierdo(NodoGen izquierdo) {
        this.hijoIzquierdo = izquierdo;
    }

    public void setHermanoDerecho(NodoGen derecho) {
        this.hermanoDerecho = derecho;
    }

    //Observadores
    public Object getElem() {
        return elem;
    }

    public NodoGen getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return hermanoDerecho;
    }
}
