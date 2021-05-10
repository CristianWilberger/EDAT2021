/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *
 * @author Cristian Wilberger FAI-2375
 */
public class ArbolBin {

    //Atributos 
    private NodoArbol raiz;

    //Constructor
    public ArbolBin() {
        this.raiz = null;
    }

    //Métodos básicos del TDA ArbolBin
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        //inserta elemNuevo como hijo del primer nodo encontrado en preorden 
        // igual a elemPadre , como hijo izquierdo (I) o derecho (D) 
        //, segun lo indique el parametro lugar

        boolean exito = true;

        if (this.raiz == null) {
            //Si el arbol esta vacio, ponemos el elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            //si no está vacio , se busca al padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    //Si el padre existe y no tiene HI se lo agrega
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        //Si el padre existe y no tiene HD se lo agrega
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } else {
                        //Si el padre no existe o ya tiene ese hijo, da error
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        // metodo Privado que busca un elemento y devuelve el nodo que
        // lo contiene. Si no se encuentra el elem buscado devuelve null

        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //Si el buscado es n, lo devuelve
                resultado = n;
            } else {
                //No es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //Si no lo encuentra en el HI, lo busca en el HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {

        return this.raiz == null;
    }

    public int altura() {
        //Devuelve un entero con la longitud mas larga desde la raiz hasta una hoja
        int res = 0;
        if (this.raiz != null) {//Si no esta vacio , llamo a un metodo auxiliar
            res = alturaAux(this.raiz);
        }
        res--;//Resto uno al valor encontrado porque en el metodo auxiliar cuento los nodos hasta una hoja y la altura son los enlaces
        return res;
    }

    private int alturaAux(NodoArbol nodo) {
        //El Método es privado ya que ingresa un NodoArbol por parámetro y el usuario no puede conocerlo
        int res = 0;
        int res1 = 0;
        if (nodo != null) {//Si el nodo ingresado es distinto de null, hago los llamados recursivos
            res = res + alturaAux(nodo.getIzquierdo()) + 1;//Busco la altura del arbol por el lado Izquierdo
            res1 = res1 + alturaAux(nodo.getDerecho()) + 1;//Busco la altura del arbol por el lado derecgo
            if (res1 >= res) {// Si la altura encontrada por el lado derecho, es mas grande que la del lado izquierdo
                res = res1;//Se la asigno a la variable y la devuelvo
            }
        }
        return res;
    }

    public int nivel(Object elem) {
        //Metodo nivel, Ingresa un elemento por parametro y devuelve el nivel en el que se encuentra
        int res = -1;
        //Si no hay elementos devuelve -1
        if (this.raiz != null) {
            res = nivelAux(this.raiz, elem, 0);//Envio a un metodo auxiliar mi raiz , el elemnto buscado y el nivel en 0
        }
        return res;
    }

    private int nivelAux(NodoArbol nodo, Object elem, int nivel) {
        //Es un método recursivo privado ya que al ingresar un Nodo por parametro el usuario no puede conocer la implementacion
        int res = -1;

        if (nodo != null) {//Si es dintinto de null
            if (nodo.getElem().equals(elem)) {//Y el elemento es el buscado, retorno el nivel
                res = nivel;
            } else {// Sino, llamo  recursivamente por el hijo izquierdo, y aumento el nivel en 1
                res = nivelAux(nodo.getIzquierdo(), elem, nivel + 1);
                if (res == -1) {//Si no lo encontro en el lado izquierdo
                    res = nivelAux(nodo.getDerecho(), elem, nivel + 1);//Llamo por el lado derecho
                }
            }
        }
        return res;
    }

    public Object padre(Object elem) {
        //Método padre, Ingresa un elem por parámetro y si lo encuentro devuelvo el elemnto de su padre. Si no lo encuentro o es la raiz devuelvo null
        Object res = null;
        if (this.raiz != null) {//Si esta vacia
            if (!this.raiz.getElem().equals(elem)) {// O si es la raiz, devuelvo null
                res = padreAux(this.raiz, elem, this.raiz.getElem());//Sino, llamo a un metodo recursivo auxiliar
            }
        }
        return res;
    }

    private Object padreAux(NodoArbol nodo, Object elem, Object elemRaiz) {
        //Es un método recursivo privado ya que al ingresar un Nodo por parametro el usuario no puede conocer la implementacion
        Object res = null;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {//Si el elemento del nodo es igual al elemento buscado, devuelvo el elemRaiz, que es el padre
                res = elemRaiz;
            } else {
                res = padreAux(nodo.getIzquierdo(), elem, nodo.getElem());//Si no es igual, hago el llamado recursivo por la izquierda
                if (res == null) {//Si todavia no lo encontro
                    res = padreAux(nodo.getDerecho(), elem, nodo.getElem());//Llamo por la derecha
                }
            }
        }
        return res;
    }

    public Lista listarPreorden() {
        //Retorna una lista con los elementos del árbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        //Método recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);//1

            //Recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis);//2
            listarPreordenAux(nodo.getDerecho(), lis);//3
        }
    }

    public Lista listarInorden() {
        //Retorna una lista con los elementos del árbol en InORDEN
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        //Método recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            listarInordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        //Retorna una lista con los elementos del árbol en POSORDEN
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        //Método recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        //Retorna una lista con los elementos del árbol Por niveles
        Lista lis = new Lista();
        if (this.raiz != null) {
            listarNivelesAux(this.raiz, lis);
        }
        return lis;
    }

    private void listarNivelesAux(NodoArbol nodo, Lista lis) {
        Cola cola = new Cola();
        int pos;
        cola.poner(nodo);
        pos = 1;

        while (!cola.esVacia()) {
            nodo = (NodoArbol) cola.obtenerFrente();
            cola.sacar();

            lis.insertar(nodo.getElem(), pos);
            pos++;

            if (nodo.getIzquierdo() != null) {
                cola.poner(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                cola.poner(nodo.getDerecho());
            }
        }
    }

    public void vaciar() {
        //Vacio la raiz y por el garbage collector, se lleva los demas elementos
        this.raiz = null;
    }

    public String toString() {
        //Metodo para debuggear
        String cadena = "El arbol esta vacio";
        if (this.raiz != null) {
            cadena = toStringAux(this.raiz, "");
        }
        return cadena;
    }

    private String toStringAux(NodoArbol nodo, String cadena) {
        String cadena2 = cadena;
        cadena2 += "Nodo: " + nodo.getElem() + "\t";
        if (nodo.getIzquierdo() != null) {
            cadena2 += "HI: " + nodo.getIzquierdo().getElem() + "\t";
        } else {
            cadena2 += "HI:- \t";
        }
        if (nodo.getDerecho() != null) {
            cadena2 += "HD: " + nodo.getDerecho().getElem() + "\n";
        } else {
            cadena2 += "HD:- \n";
        }
        if (nodo.getIzquierdo() != null) {
            cadena2 = toStringAux(nodo.getIzquierdo(), cadena2);
        }
        if (nodo.getDerecho() != null) {
            cadena2 = toStringAux(nodo.getDerecho(), cadena2);
        }
        return cadena2;
    }

    public Lista frontera() {
        Lista hojas = new Lista();
        int pos = 1;
        if (this.raiz != null) {//Si hay elementos sigo 
            if (this.raiz.getIzquierdo() == null && this.raiz.getDerecho() == null) {//Si la raiz tmb es una hoja lo inserto en la lista y la devuelvo
                hojas.insertar(this.raiz.getElem(), pos);
            } else {//Sino, llamo al metodo recursivo
                fronteraAux(hojas, this.raiz, pos);
            }
        }
        return hojas;
    }

    private void fronteraAux(Lista hojas, NodoArbol nodo, int pos) {

        if (nodo != null) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {//Si el nodo no tiene hijos, es una hoja y la inserto en la lista
                hojas.insertar(nodo.getElem(), pos);
                pos++;
            } else {//Sino
                fronteraAux(hojas, nodo.getDerecho(), pos);//Llamo por la derecha
                fronteraAux(hojas, nodo.getIzquierdo(), pos);// y llamo por la izquierda
            }
        }
    }

    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();

        if (this.raiz != null) {//Si no esta vacio, llamo a un metodo recursivo
            clon.raiz = new NodoArbol(this.raiz.getElem(), null, null);//Creo el nodo raiz de mi clon, con el elem de la original y enlaces en null
            cloneAux(this.raiz, clon.raiz);//llamo a mi metodo recursivo
        }
        return clon;
    }

    private void cloneAux(NodoArbol raizOriginal, NodoArbol raizClon) {

        if (raizOriginal.getIzquierdo() != null) {//Si el arbol original tiene hijo izquierdo

            raizClon.setIzquierdo(new NodoArbol(raizOriginal.getIzquierdo().getElem(), null, null));//le seteo el hijo izquierdo al clon
            //Con el hijo izquierdo de la original (SE crea el nodo con el elem y enlaces en null)
            cloneAux(raizOriginal.getIzquierdo(), raizClon.getIzquierdo());//vuelvo a llamar al clonAux con el hijo izquierdo de la original
            //y tmb con el recien creado del clon
        }
        //Cuando no tengo mas por izquierda, pregunto por la derecha
        if (raizOriginal.getDerecho() != null) {
            //Aca es todo igual al lado izquierdo solo que con el lado derecho
            raizClon.setDerecho(new NodoArbol(raizOriginal.getDerecho().getElem(), null, null));
            cloneAux(raizOriginal.getDerecho(), raizClon.getDerecho());
        }
    }

    public ArbolBin cloneInvertido() {
        // crea un clon del arbol original pero con sus hijos intercambiados
        ArbolBin nuevo = new ArbolBin();

        if (this.raiz != null) {//Si no esta vacio, llamo a un metodo recursivo
            nuevo.raiz = new NodoArbol(this.raiz.getElem(), null, null);//Creo el nodo raiz de mi clon, con el elem de la original y enlaces en null
            cloneInvertidoAux(this.raiz, nuevo.raiz);//llamo a mi metodo recursivo
        }
        return nuevo;
    }

    private void cloneInvertidoAux(NodoArbol original, NodoArbol clon) {

        if (original.getIzquierdo() != null) {//Si el arbol original tiene hijo izquierdo

            clon.setDerecho(new NodoArbol(original.getIzquierdo().getElem(), null, null));//le seteo el hijo derecho al clon
            //Con el hijo izquierdo de la original (SE crea el nodo con el elem y enlaces en null)
            cloneInvertidoAux(original.getIzquierdo(), clon.getDerecho());//vuelvo a llamar al clonAux con el hijo izquierdo de la original
            //y con el derecho del clon
        }
        //Cuando no tengo mas por izquierda, pregunto por la derecha
        if (original.getDerecho() != null) {
            //Aca es todo igual al lado izquierdo solo que con el lado derecho
            clon.setIzquierdo(new NodoArbol(original.getDerecho().getElem(), null, null));
            cloneInvertidoAux(original.getDerecho(), clon.getIzquierdo());
        }
    }

    public boolean verificarPatron(Lista patron) {
        boolean exito = false;
        int pos = 1;
        if (this.raiz != null) {
            exito = verificarPatronAux(this.raiz, patron, pos);
        }
        return exito;
    }

    private boolean verificarPatronAux(NodoArbol nodo, Lista patron, int pos) {
        boolean retorno = false;

        if (nodo != null) {
            if (nodo.getElem().equals(patron.recuperar(pos))) {
                if (pos == patron.longitud()) {
                    if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                        retorno = true;
                    }
                } else {
                    retorno = verificarPatronAux(nodo.getIzquierdo(), patron, pos + 1);
                    if (!retorno) {
                        retorno = verificarPatronAux(nodo.getDerecho(), patron, pos + 1);
                    }
                }
            }
        }
        return retorno;
    }

    public void modificarSubarboles(Object d1, Object d2, Object d3) {

        if (this.raiz != null) {
            modificarAux(this.raiz, d1, d2, d3);
        }
    }

    private void modificarAux(NodoArbol nodo, Object d1, Object d2, Object d3) {
        NodoArbol nuevo;
        if (nodo != null) {
            if (nodo.getElem().equals(d1)) {
                if (nodo.getIzquierdo() == null) {
                    nuevo = new NodoArbol(d2, null, null);
                    nodo.setIzquierdo(nuevo);
                } else {
                    nodo.getIzquierdo().setElem(d2);
                }
                if (nodo.getDerecho() == null) {
                    nuevo = new NodoArbol(d3, null, null);
                    nodo.setDerecho(nuevo);
                } else {
                    nodo.getDerecho().setElem(d3);
                }
            } else {
                modificarAux(nodo.getIzquierdo(), d1, d2, d3);
                modificarAux(nodo.getDerecho(), d1, d2, d3);
            }
        }
    }
}
