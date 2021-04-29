/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import jerarquicas.ArbolBin;

/**
 *
 * @author Cristian
 */
public class TestArbolBin {

    public static void main(String[] args) {
        ArbolBin arbol1 = new ArbolBin();
        ArbolBin arbol2 = new ArbolBin();
        /*
        arbol1.insertar('A', 'T', 'I');
        // System.out.println( arbol1.toString());

        arbol1.insertar('B', 'A', 'I');
        //  System.out.println( arbol1.toString());
        arbol1.insertar('C', 'A', 'D');
        //System.out.println( arbol1.toString());
        arbol1.insertar('D', 'B', 'I');
        // System.out.println( arbol1.toString());
        arbol1.insertar('E', 'B', 'D');
        //  System.out.println( arbol1.toString());
        arbol1.insertar('H', 'C', 'I');
        // System.out.println( arbol1.toString());
        arbol1.insertar('I', 'C', 'D');
        //   System.out.println( arbol1.toString());
        arbol1.insertar('Z', 'I', 'I');
        //  System.out.println( arbol1.toString());
        arbol1.insertar('Y', 'H', 'I');
        //   System.out.println( arbol1.toString());
        System.out.println(arbol1.frontera());
        /*
                     A
                   /   \
                 B      C
               /  \    /  \
             D    E   H    I
                     /     /
                    Y     Z
        
        
        
         */
 /*
        System.out.println(arbol1.listarPreorden());
        System.out.println(arbol1.listarInorden());
        System.out.println(arbol1.listarPosorden());
        System.out.println(arbol1.listarNiveles());
        
        System.out.println( arbol1.toString());
         
        System.out.println(arbol1.altura());
        arbol1.insertar('X', 'Y', 'I');
        System.out.println(arbol1.altura());*/
        //Nivel de los elementos
        /*
        System.out.println("Nivel del elemento('A')Tiene que ser 0, Da: " + arbol1.nivel('A'));
        System.out.println("Nivel del elemento('B')Tiene que ser 1, Da:  " + arbol1.nivel('B'));
        System.out.println("Nivel del elemento('C')Tiene que ser 1, Da:  " + arbol1.nivel('C'));
        System.out.println("Nivel del elemento('D')Tiene que ser 2, Da:  " + arbol1.nivel('D'));
        System.out.println("Nivel del elemento('E')Tiene que ser 2, Da:  " + arbol1.nivel('E'));
        System.out.println("Nivel del elemento('H')Tiene que ser 2, Da:  " + arbol1.nivel('H'));
        System.out.println("Nivel del elemento('I')Tiene que ser 2, Da:  " + arbol1.nivel('I'));
        System.out.println("Nivel del elemento('Y')Tiene que ser 3, Da:  " + arbol1.nivel('Y'));
        System.out.println("Nivel del elemento('Z')Tiene que ser 3, Da:  " + arbol1.nivel('Z'));
        System.out.println("Nivel del elemento('T')Tiene que ser -1, Da:  " + arbol1.nivel('T'));
        // System.out.println("Nivel del elemento('X')Tiene que ser 4, Da:  " + arbol1.nivel('X'));

        System.out.println("El padre de('A')Tiene que ser null, Da:  " + arbol1.padre('A'));
        System.out.println("El padre de('B')Tiene que ser A, Da:  " + arbol1.padre('B'));
        System.out.println("El padre de('C')Tiene que ser A, Da:  " + arbol1.padre('C'));
        System.out.println("El padre de('D')Tiene que ser B, Da:  " + arbol1.padre('D'));
        System.out.println("El padre de('E')Tiene que ser B, Da:  " + arbol1.padre('E'));
        System.out.println("El padre de('H')Tiene que ser C, Da:  " + arbol1.padre('H'));
        System.out.println("El padre de('I')Tiene que ser C, Da:  " + arbol1.padre('I'));
        System.out.println("El padre de('Y')Tiene que ser H, Da:  " + arbol1.padre('Y'));
        System.out.println("El padre de('Z')Tiene que ser I, Da:  " + arbol1.padre('Z'));
        //  System.out.println("El padre de('X')Tiene que ser Y, Da:  " + arbol1.padre('X'));
        System.out.println("El padre de('T')Tiene que ser null, Da:  " + arbol1.padre('T'));
        /*
        arbol2 = arbol1.clone();
        System.out.println("Imprimoe el Arbol 1: " + arbol1.toString());
        System.out.println("Imprimoe el Arbol 2: " + arbol2.toString());

        arbol1.insertar('T', 'E', 'D');
        System.out.println("Imprimoe el Arbol 1: " + arbol1.toString());
        System.out.println("Imprimoe el Arbol 2: " + arbol2.toString());
        arbol2.insertar('U', 'I', 'D');
        System.out.println("Imprimoe el Arbol 1: " + arbol1.toString());
        System.out.println("Imprimoe el Arbol 2: " + arbol2.toString());

        System.out.println(arbol1.esVacio());
        arbol1.vaciar();
        System.out.println(arbol1.altura());
        System.out.println(arbol1.esVacio());
         */

        arbol1.insertar('A', 'T', 'I');
        // System.out.println( arbol1.toString());
        arbol1.insertar('B', 'A', 'I');
        //  System.out.println( arbol1.toString());
        arbol1.insertar('C', 'A', 'D');
        //System.out.println( arbol1.toString());
        arbol1.insertar('D', 'B', 'I');
        // System.out.println( arbol1.toString());
        arbol1.insertar('E', 'B', 'D');
        //  System.out.println( arbol1.toString());
        arbol1.insertar('F', 'C', 'I');
        // System.out.println( arbol1.toString());
        arbol1.insertar('G', 'C', 'D');
        
        System.out.println(arbol1.toString());
        
        
        /*
                     A
                   /   \
                 B      C
               /  \    /  \
             D    E   F    G
*/
        
        arbol2=arbol1.cloneInvertido();
        
        
        
        System.out.println(arbol2.toString());
    }
}
