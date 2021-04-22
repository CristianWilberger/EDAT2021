/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLineales;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
/**
 *
 * @author Usuario
 */
public class MixLineales {
    public static void main(String[] args) {
        Cola q1 = new Cola();
        Cola q2=new Cola();
        q1.poner('A');
        q1.poner('B');
        q1.poner('$');
        q1.poner('C');
        q1.poner('$');
        q1.poner('D');
        q1.poner('E');
        q1.poner('F');

        q2=generarOtraCola(q1);

        System.out.println(q2.toString());
    }
    
    
    public static Cola generarOtraCola(Cola original){
        Cola colaRetorno=new Cola();
        Pila aux= new Pila();
        
        
        while(!original.esVacia()){
            while(!original.esVacia()&&(char)original.obtenerFrente()!='$'){
                colaRetorno.poner((char)original.obtenerFrente());
                aux.apilar(original.obtenerFrente());
                original.sacar();
            }
            original.sacar();
            while(!aux.esVacia()){
                colaRetorno.poner(aux.obtenerTope());
                aux.desapilar();
            }
            colaRetorno.poner('$');
        }
        return colaRetorno;
    }
    
    /*
    public void invertir() {
        Nodo aux = this.cabecera;
        invertirAux(this.cabecera);
        if (aux != null)
            aux.setEnlace(null);
    }

    private void invertirAux(Nodo nodo) {
        if (nodo != null) {
            this.cabecera = nodo;
            invertirAux(nodo.getEnlace());
            if (nodo.getEnlace() != null)
                nodo.getEnlace().setEnlace(nodo);
        }
    }
    */
}
