/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
import lineales.dinamicas.Lista;
/**
 *
 * @author Usuario
 */
public class ArbolGen {
        
        //Atributos
        private NodoGen raiz;
        
        //Constructor
        public ArbolGen(){
            this.raiz=null;
        }
        
        
        
        
        
        
        
        //listados
        public Lista listarInprden(){
            Lista salida= new Lista();
            listarInordenAux(this.raiz,salida);
            return salida;
        }
        
        
        private void listarInordenAux(NodoGen n, Lista ls){
            if (n !=null ) {
                //LLamado recursivo con primer hijo de n
                if (n.getHijoIzquierdo()!= null) {
                    listarInordenAux(n.getHijoIzquierdo(),ls);
                }
                //visita del nodo n
                ls.insertar(n.getElem(), ls.longitud()+1);
                
                //LLamados recursivos con los otros hijos de n
                if (n.getHijoIzquierdo()!=null) {
                    NodoGen hijo=n.getHijoIzquierdo().getHermanoDerecho();
                    while(hijo!=null){
                        listarInordenAux(hijo,ls);
                        hijo=hijo.getHermanoDerecho();
                    }
                }
            }
        }
        
        
        
        
        @Override
        public String toString(){
            return toStringAux(this.raiz);
        }
        
        private String toStringAux(NodoGen nodo){
            String retorno="";
            if (nodo!=null) {
                //Visita del nodo 
                retorno+=nodo.getElem().toString()+" -> ";
                NodoGen hijo=nodo.getHijoIzquierdo();
                while(hijo !=null){
                    retorno+=hijo.getElem().toString() + ", ";
                    hijo=hijo.getHermanoDerecho();
                }
                
                //Comienza recorrido de los hijos de nodo , llamando recursivamente
                //para que cada hijo agregue su subcadena a la general
                hijo=nodo.getHijoIzquierdo();
                while(hijo!=null){
                    retorno+="\n"+ toStringAux(hijo);
                    hijo=hijo.getHermanoDerecho();
                }
            }
            return retorno;
        }
}
