/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLineales;

import lineales.dinamicas.Cola;

/**
 *
 * @author Usuario
 */
public class TestCola {

    public static void main(String[] args) {
        Cola cola1 = new Cola();

        System.out.println("/////Inicio de test\\\\\\");
        System.out.println("Poner(1):  " + cola1.poner(1));
        System.out.println("Poner(2):  " + cola1.poner(2));
        System.out.println("Poner(3):  " + cola1.poner(3));
        System.out.println("Poner(4):  " + cola1.poner(4));
        System.out.println("Poner(5):  " + cola1.poner(5));
        System.out.println("Poner(6):  " + cola1.poner(6));
        System.out.println("Poner(7):  " + cola1.poner(7));
        System.out.println("Poner(8):  " + cola1.poner(8));
        System.out.println("Poner(9):  " + cola1.poner(9));
        System.out.println("Poner(10): " + cola1.poner(10));
        System.out.println("Poner(11): " + cola1.poner(11));
        System.out.println("Poner(12): " + cola1.poner(12));
        System.out.println("Obtengo el frente(1):  "+cola1.obtenerFrente());
        System.out.println("Muestro la cola:  " + cola1.toString());
        System.out.println("La Cola es vacia?:  " + cola1.esVacia());
        System.out.println("Obtengo el frente(null):  "+cola1.obtenerFrente());
        Cola cola2=cola1.clone();
        System.out.println("Muestro la copia"+cola2.toString());
        System.out.println("Saco de la cola original para vaciarla----------");
        System.out.println("Sacar(1): " + cola1.sacar());
        System.out.println("Obtengo el frente(2):  "+cola1.obtenerFrente());
        System.out.println("Sacar(2): " + cola1.sacar());
        System.out.println("Obtengo el frente(3):  "+cola1.obtenerFrente());
        System.out.println("Sacar(3): " + cola1.sacar());
        System.out.println("Obtengo el frente(4):  "+cola1.obtenerFrente());
        System.out.println("Sacar(4): " + cola1.sacar());
        System.out.println("Obtengo el frente(5):  "+cola1.obtenerFrente());
        System.out.println("Sacar(5): " + cola1.sacar());
        System.out.println("Obtengo el frente(6):  "+cola1.obtenerFrente());
        System.out.println("Muestro la cola:  " + cola1.toString());
        System.out.println("La Cola es vacia?:  " + cola1.esVacia());
        System.out.println("Sacar(6): " + cola1.sacar());
        System.out.println("Obtengo el frente(7):  "+cola1.obtenerFrente());
        System.out.println("Sacar(7): " + cola1.sacar());
        System.out.println("Obtengo el frente(8):  "+cola1.obtenerFrente());
        System.out.println("Sacar(8): " + cola1.sacar());
        System.out.println("Obtengo el frente(9):  "+cola1.obtenerFrente());
        System.out.println("Sacar(9): " + cola1.sacar());
        System.out.println("Cola1 vacia:  "+cola1.esVacia());
        System.out.println("Muestro la cola vacia:  "+cola1.toString());
        System.out.println("Saco un elemento que no existe(Devuelve false): " + cola1.sacar());
    }
}
