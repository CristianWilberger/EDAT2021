/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author Usuario
 */
public class TestCadenas {

    public static void main(String[] args) {
        Cola q1 = new Cola();
        Cola q2 = new Cola();
        Pila pila1 = new Pila();
        Lista lista = new Lista();
        pila1.apilar('R');
        pila1.apilar('T');
        pila1.apilar('Z');
        pila1.apilar('@');
        pila1.apilar('T');
        pila1.apilar('Y');
        pila1.apilar('@');
        pila1.apilar('Z');
        pila1.apilar('R');
        pila1.apilar('@');
        pila1.apilar('W');
        pila1.apilar('Y');
        pila1.apilar('X');
        
        pila1.apilar('@');
        pila1.apilar('P');
        pila1.apilar('Q');
        pila1.apilar('R');

        System.out.println("LA pila es: " + pila1.toString());

        lista = formarLista(pila1);
        System.out.println("La lista es: " + lista);
        /*q1.poner('A');
        q1.poner('B');
        q1.poner('#');
        q1.poner('C');
        q1.poner('#');
        q1.poner('D');
        q1.poner('E');
        q1.poner('F');

        q2 = generar(q1);

        System.out.println(q2.toString());
         */
 /*
        q1.poner('(');
        q1.poner('{');
        q1.poner('+');
        q1.poner('4');
        q1.poner('8');
        q1.poner('[');
        q1.poner('3');
        q1.poner('-');
        q1.poner('(');
        q1.poner('4');
        q1.poner('/');
        q1.poner('2');
        q1.poner(')');
        q1.poner('6');
        q1.poner(']');
        q1.poner('1');
        q1.poner('-');
        q1.poner('}');
        q1.poner(')');

        System.out.println(q1.toString());
        boolean verdadero;

        verdadero = verificarBalance(q1);

        System.out.println(verdadero);
         */
    }

    //Intento numero uno , lo hago llamando a el obtener frente varias veces
    // y lo hice con lista
    /*
        Cola retorno = new Cola();
        Pila aux = new Pila();
        Lista listaAux = new Lista();
        int pos = 1;
        while (!original.esVacia()) {
            while (!original.esVacia() && (char) original.obtenerFrente() != '#') {
                retorno.poner((char) original.obtenerFrente());
                aux.apilar((char) original.obtenerFrente());
                listaAux.insertar((char) original.obtenerFrente(), pos);
                pos++;
                original.sacar();
            }
            original.sacar();
            while (!aux.esVacia()) {
                retorno.poner(aux.obtenerTope());
                aux.desapilar();
            }
            pos = 1;
            while (!listaAux.esVacia()) {
                retorno.poner(listaAux.recuperar(pos));
                listaAux.eliminar(pos);
            }
            if (!original.esVacia()) {
                retorno.poner('#');
            }
        }
        return retorno;
    }
     */
    //Segundo intento, lo hago con lista y 
    // usando el elem object
    /* Cola retorno = new Cola();
        Pila aux = new Pila();
        Lista listaAux = new Lista();
        int pos = 1;
       
        while (!original.esVacia()) {
             Object elem = (char) original.obtenerFrente();
            while (!original.esVacia() && !elem.equals('#')) {
                retorno.poner(elem);
                aux.apilar(elem);
                listaAux.insertar(elem, pos);
                pos++;
                original.sacar();
                if (!original.esVacia()) {
                    elem = (char) original.obtenerFrente();
                }
            }
            original.sacar();
            while (!aux.esVacia()) {
                retorno.poner(aux.obtenerTope());
                aux.desapilar();
            }
            pos = 1;
            while (!listaAux.esVacia()) {
                retorno.poner(listaAux.recuperar(pos));
                listaAux.eliminar(pos);
            }
            if (!original.esVacia()) {
                retorno.poner('#');
            }
        }
        return retorno;
    }
    
     */
    public static Cola generar(Cola original) {
        Cola retorno = new Cola();
        Pila aux = new Pila();
        Cola colaAux = new Cola();

        while (!original.esVacia()) {
            Object elem = (char) original.obtenerFrente();
            while (!original.esVacia() && !elem.equals('#')) {
                retorno.poner(elem);
                aux.apilar(elem);
                colaAux.poner(elem);
                original.sacar();
                if (!original.esVacia()) {
                    elem = (char) original.obtenerFrente();
                }
            }
            original.sacar();
            while (!aux.esVacia()) {
                retorno.poner(aux.obtenerTope());
                aux.desapilar();
            }

            while (!colaAux.esVacia()) {
                retorno.poner(colaAux.obtenerFrente());
                colaAux.sacar();
            }
            if (!original.esVacia()) {
                retorno.poner('#');
            }
        }
        return retorno;
    }

    /* Cola cola = q.clone();
        char elem;
        char tope;
        Pila pila = new Pila();
        boolean res = true;
        while (!cola.esVacia() && res) {
            elem = (char) cola.obtenerFrente();
            if (elem == '[' || elem == '{' || elem == '(') {
                pila.apilar(elem);
            } else {
                if (!pila.esVacia() || elem == ']' || elem == '}' || elem == ')') {
                    tope = (char) pila.obtenerTope();
                    res = (tope == '}' && elem == '{') || (elem == '(' && tope == ')') || (elem == '[' && tope == ']');
                }
                pila.desapilar();
            }
            cola.sacar();
        }
        return res;

    }
     */
 /*
       Cola clon = q.clone();
        Pila pila = new Pila();
        String elemento;
        Object tope;
        boolean hayBalance = true;
        while (!clon.esVacia() && hayBalance) {
            elemento = Character.toString((char) clon.obtenerFrente());
            if ("([{".contains(elemento)) {
                if (!pila.esVacia()) {
                    if (pila.obtenerTope().equals("(") && elemento.equals("(")) {// Si esta guardado un ( en el tope la pila, solo inserto si viene otra (
                        pila.apilar(elemento);
                    }
                    if (pila.obtenerTope().equals("{")) { // Si esta guardado una { en el tope, guardo lo que venga
                        pila.apilar(elemento);
                    }
                    if (pila.obtenerTope().equals("[") && !elemento.equals("{")) { // Si es un [ solo guardo si es [ o (
                        pila.apilar(elemento);
                    }

                } else { // Si está vacía guardo cualquiera
                    pila.apilar(elemento);
                }
            } else if (!pila.esVacia() && ")]}".contains(elemento)) {
                tope = pila.obtenerTope();
                if (elemento.equals(")")) {
                    hayBalance = tope.equals("(");
                }
                if (elemento.equals("]")) {
                    hayBalance = tope.equals("[");
                }
                if (elemento.equals("}")) {
                    hayBalance = tope.equals("{");
                }
                pila.desapilar();
            } else {
                if (pila.esVacia() && ")]}".contains(elemento)) {
                    hayBalance = false;
                }

            }
            clon.sacar();

        }
        hayBalance = pila.esVacia();
        return hayBalance;
    }
    
    
    
     */
    public static boolean verificarBalance(Cola q) {
        Cola cola2 = new Cola();
        Pila pila = new Pila();
        boolean balance = true;
        char elem, tope, frente;
        while (!q.esVacia()) {
            elem = (char) q.obtenerFrente();
            if (elem == '(' || elem == '[' || elem == '{') {
                pila.apilar(elem);
            } else if (elem == ')' || elem == ']' || elem == '}') {
                cola2.poner(elem);
            }
            q.sacar();
        }
        while (!pila.esVacia() && balance) {
            tope = (char) pila.obtenerTope();
            frente = (char) cola2.obtenerFrente();
            switch (tope) {
                case '(':
                    if (frente != ')') {
                        balance = false;
                    }
                    break;
                case '[':
                    if (frente != ']') {
                        balance = false;
                    }
                    break;
                case '{':
                    if (frente != '}') {
                        balance = false;
                    }
                    break;
                default:
                    break;
            }
            pila.desapilar();
            cola2.sacar();
            if (pila.esVacia() && !cola2.esVacia()) {
                balance = false;
            } else if (!pila.esVacia() && cola2.esVacia()) {
                balance = false;
            }
        }
        return balance;
    }

    /* while(!pila.esVacia()&&balance){
            tope=(char)pila.obtenerTope();
            frente=(char)cola2.obtenerFrente();
            if (tope=='(') {
                if (frente!=')') {
                    balance=false;
                }
            }else if (tope=='[') {
                if (frente!=']') {
                    balance=false;
                }
            }else{
                
            }
        }*/
    public static Lista formarLista(Pila pila1) {
        Lista retorno = new Lista();
        Pila aux = new Pila();
        Pila clon = new Pila();
        int cont = 0;
        clon = pila1.clone();

        while (!clon.esVacia()) {
            Object arroba = (char) clon.obtenerTope();
            if (arroba.equals('@')) {
                cont++;
            }
            clon.desapilar();
        }

        while (!pila1.esVacia()) {
            Object elem = (char) pila1.obtenerTope();
            while (!pila1.esVacia() && !elem.equals('@')) {
                if (cont % 2 != 0) {
                    aux.apilar(elem);
                } else {
                    retorno.insertar(elem, 1);
                }
                pila1.desapilar();
                if (!pila1.esVacia()) {
                    elem = (char) pila1.obtenerTope();
                }
            }
            if (elem.equals('@')) {
                cont++;
            }
            pila1.desapilar();
            while (!aux.esVacia()) {
                retorno.insertar(aux.obtenerTope(), 1);
                aux.desapilar();
            }
            if (!pila1.esVacia()) {
                retorno.insertar('@', 1);
            }

        }

        return retorno;
    }

}
