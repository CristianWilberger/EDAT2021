/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
import libraries.TecladoIn;

/**
 *
 * @author Usuario
 */
public class PruebaLista {

    public static void main(String[] args) {
        int i;
        System.out.println("---------------------------------");
        System.out.println("--------------MENU---------------");
        System.out.println("1)Concatenar 2 listas ");
        System.out.println("2)Comprobar si una Lista tiene la forma a0a0b0");
        System.out.println("3)Invertir ");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("Ingrese una opcion a realizar");
        i = TecladoIn.readInt();
        Lista lista1 = new Lista(), lista2 = new Lista(), lista3 = new Lista();
        Lista lista4 = new Lista();

        lista1.insertar(2, 1);
        lista1.insertar(4, 2);
        lista1.insertar(6, 3);
        
        lista2.insertar(5, 1);
        lista2.insertar(1, 2);
        lista2.insertar(6, 3);
        lista2.insertar(7, 4);
        
        lista4.insertar(2, 1);
        lista4.insertar(4, 2);
        lista4.insertar(6, 3);
        lista4.insertar(8, 4);
        lista4.insertar(10, 5);
        lista4.insertar(12, 6);
        lista4.insertar(14, 7);
        lista4.insertar(16, 8);

        
        lista3.insertar(0, 1);
        lista3.insertar(6, 2);
        lista3.insertar(5, 3);
        lista3.insertar(0, 4);
        lista3.insertar(9, 5);
        lista3.insertar(6, 6);
        lista3.insertar(5, 7);
        lista3.insertar(0, 8);
        lista3.insertar(5, 9);
        lista3.insertar(6, 10);
        lista3.insertar(9, 11);
        switch (i) {
            case 1:
                concatenar(lista1, lista2);
                break;
            case 2:
                comprobar(lista3);
                break;
            case 3:
                invertir(lista4);
                break;
            default:
                System.out.println("Elija una opcion válida");
        }

    }

    public static Lista concatenar(Lista lista1, Lista lista2) {
        Lista listaNueva = new Lista();

        int i = 1, pos;
        Object elem;
        int long1 = lista1.longitud();
        int long2 = lista2.longitud();
        while (i <= long1) {
            elem = lista1.recuperar(i);
            listaNueva.insertar(elem, i);
            i++;
        }
        pos = i;
        i = 1;
        while (i <= long2) {
            elem = lista2.recuperar(i);
            listaNueva.insertar(elem, pos);
            i++;
            pos++;
        }
        System.out.println("Imprime la Lista nueva concatenada: " + listaNueva.toString());
        return listaNueva;
    }

    public static boolean comprobar(Lista lista3) {
        boolean valido = false;
        Pila aux1 = new Pila();
        Cola aux2 = new Cola();

        int i = 1, longitud = lista3.longitud();

        if (!lista3.esVacia()) {
            int elem = (int) lista3.recuperar(i);
            while (elem != 0 && i <= longitud) {
                aux2.poner(elem);
                aux1.apilar(elem);
                i++;
                if (i <= longitud) {
                    elem = (int) lista3.recuperar(i);
                }
            }
            if (elem == 0) {
                i++;
                while (!aux2.esVacia() && aux2.obtenerFrente() == lista3.recuperar(i)) {
                    aux2.sacar();
                    i++;
                }
                if (aux2.esVacia() && (int) lista3.recuperar(i) == 0) {
                    i++;
                    while (!aux1.esVacia() && aux1.obtenerTope() == lista3.recuperar(i)) {
                        aux1.desapilar();
                        i++;
                    }
                    if (aux1.esVacia()) {
                        valido = true;
                    }
                }
            }
        }
        System.out.println(valido);
        return valido;
    }

    public static Lista invertir(Lista lista1) {
        Lista invertida = new Lista();
        int i = lista1.longitud();
        Object elem;
        int j = 1;
        while (i >= 1) {
            elem = lista1.recuperar(i);
            invertida.insertar(elem, j);
            i--;
            j++;
        }
        System.out.println("Imprime la Lista invertida: " + invertida.toString());
        return invertida;
    }

}
