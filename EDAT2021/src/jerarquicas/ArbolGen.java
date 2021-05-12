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
 * @author Usuario
 */
public class ArbolGen {

    //Atributos
    private NodoGen raiz;

    //Constructor
    public ArbolGen() {
        this.raiz = null;
    }

    //operaciones basicas
    public boolean insertar(Object nuevo, Object padre) {
        boolean exito = false;

        if (this.raiz == null) {
            this.raiz = new NodoGen(nuevo, null, null);
        } else {
            NodoGen nodoPadre = obtenerNodo(this.raiz, padre);
            if (nodoPadre != null) {
                NodoGen hijo = nodoPadre.getHijoIzquierdo();
                if (hijo != null) {
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(nuevo, null, null));
                } else {
                    nodoPadre.setHijoIzquierdo(new NodoGen(nuevo, null, null));
                }
            }
        }

        return exito;
    }

    private NodoGen obtenerNodo(NodoGen nodo, Object buscado) {
        NodoGen devolver = null;

        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                devolver = nodo;
            } else {
                devolver = obtenerNodo(nodo.getHijoIzquierdo(), buscado);
                if (devolver == null) {
                    devolver = obtenerNodo(nodo.getHermanoDerecho(), buscado);
                }
            }
        }
        return devolver;
    }

    public boolean pertenece(Object elem) {
        boolean exito = false;
        NodoGen elemento;
        elemento = obtenerNodo(this.raiz, elem);
        if (elemento != null) {
            exito = true;
        }
        return exito;
    }

    public Lista ancestros(Object elemento) {
        Lista lista = new Lista();
        if (this.raiz != null) {
            ancestrosAux(this.raiz, elemento, lista);
        }
        return lista;
    }

    private boolean ancestrosAux(NodoGen nodo, Object elem, Lista lista) {
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                encontrado = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !encontrado) {
                    encontrado = ancestrosAux(hijo, elem, lista);
                    hijo = hijo.getHermanoDerecho();
                }
                if (encontrado) {
                    lista.insertar(nodo.getElem(), lista.longitud() + 1);
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura() {
        return alturaAux(this.raiz, -1);
    }

    private int alturaAux(NodoGen nodo, int altura) {
        int a, b;
        if (nodo != null) {
            a = alturaAux(nodo.getHijoIzquierdo(), altura + 1);
            b = alturaAux(nodo.getHermanoDerecho(), altura);
            if (a > b) {
                altura = a;
            } else {
                altura = b;
            }
        }
        return altura;
    }

    public int nivel(Object elem) {
        int res = -1;
        if (this.raiz != null) {
            res = nivelAux(this.raiz, elem, 0);
        }
        return res;
    }

    private int nivelAux(NodoGen nodo, Object elem, int nivel) {
        int res = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                res = nivel;
            } else {
                res = nivelAux(nodo.getHijoIzquierdo(), elem, nivel + 1);
                if (res == -1) {
                    res = nivelAux(nodo.getHermanoDerecho(), elem, nivel);
                }
            }
        }
        return res;
    }

    public Object padre(Object elem) {
        Object res = null;
        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(elem)) {
                res = padreAux(this.raiz, elem);
            }
        }
        return res;
    }

    private Object padreAux(NodoGen nodo, Object elem) {
        Object res = null;

        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null && !hijo.getElem().equals(elem)) {
                hijo = hijo.getHermanoDerecho();
            }
            if (hijo != null) {
                res = nodo.getElem();
            } else {
                res = padreAux(nodo.getHijoIzquierdo(), elem);
                if (res == null) {
                    res = padreAux(nodo.getHermanoDerecho(), elem);
                }
            }
        }
        return res;
    }

    //listados
    public Lista listarPreorden() {
        Lista salida = new Lista();
        listarPreordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPreordenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            listarPreordenAux(nodo.getHermanoDerecho(), lista);
            listarPreordenAux(nodo.getHijoIzquierdo(), lista);
            lista.insertar(nodo.getElem(), 1);
        }
    }

    public Lista listarInorden() {
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //LLamado recursivo con primer hijo de n
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            //visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);

            //LLamados recursivos con los otros hijos de n
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPosordenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                listarPosordenAux(hijo, lista);
                hijo = hijo.getHermanoDerecho();
            }
            lista.insertar(nodo.getElem(), lista.longitud() + 1);
        }
    }

    public Lista listarNiveles() {
        Lista lista = new Lista();
        if (this.raiz != null) {
            Cola q = new Cola();
            q.poner(this.raiz);
            while (!q.esVacia()) {
                NodoGen nodo = (NodoGen) q.obtenerFrente();
                q.sacar();
                lista.insertar(nodo, lista.longitud() + 1);
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    q.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return lista;
    }

    public void vaciar() {
        this.raiz = null;
    }

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen nodo) {
        String retorno = "";
        if (nodo != null) {
            //Visita del nodo 
            retorno += nodo.getElem().toString() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                retorno += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            //Comienza recorrido de los hijos de nodo , llamando recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                retorno += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return retorno;
    }
}
