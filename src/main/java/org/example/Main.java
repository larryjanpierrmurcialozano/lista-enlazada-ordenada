package org.example;

public class Main {

    // Clase Nodo para la lista enlazada
    static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Clase ListaOrdenada
    static class ListaOrdenada {
        private Nodo cabeza;

        public ListaOrdenada() {
            this.cabeza = null;
        }

        // Insertar en orden ascendente
        public void insertarOrdenado(int dato) {
            Nodo nuevoNodo = new Nodo(dato);

            // Si la lista está vacía o el nuevo dato es menor que la cabeza
            if (cabeza == null || cabeza.dato >= dato) {
                nuevoNodo.siguiente = cabeza;
                cabeza = nuevoNodo;
                return;
            }

            // Buscar la posición correcta
            Nodo actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.dato < dato) {
                actual = actual.siguiente;
            }

            // Insertar el nodo en la posición correcta
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }

        // Mostrar la lista
        public void mostrar() {
            if (cabeza == null) {
                System.out.println("La lista está vacía");
                return;
            }

            Nodo actual = cabeza;
            System.out.print("Lista: ");
            while (actual != null) {
                System.out.print(actual.dato);
                if (actual.siguiente != null) {
                    System.out.print(" -> ");
                }
                actual = actual.siguiente;
            }
            System.out.println();
        }

        // Buscar un elemento
        public boolean buscar(int dato) {
            Nodo actual = cabeza;
            while (actual != null) {
                if (actual.dato == dato) {
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        // Eliminar un elemento
        public boolean eliminar(int dato) {
            if (cabeza == null) {
                return false;
            }

            // Si el elemento a eliminar es la cabeza
            if (cabeza.dato == dato) {
                cabeza = cabeza.siguiente;
                return true;
            }

            // Buscar el elemento
            Nodo actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.dato != dato) {
                actual = actual.siguiente;
            }

            // Si se encontró el elemento
            if (actual.siguiente != null) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            return false;
        }

        // Obtener el tamaño de la lista
        public int tamaño() {
            int contador = 0;
            Nodo actual = cabeza;
            while (actual != null) {
                contador++;
                actual = actual.siguiente;
            }
            return contador;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Lista Simplemente Enlazada Ordenada ===\n");

        // Crear una nueva lista ordenada
        ListaOrdenada lista = new ListaOrdenada();

        // Insertar elementos (se insertarán automáticamente en orden)
        System.out.println("Insertando elementos: 50, 20, 80, 10, 30, 70, 40");
        lista.insertarOrdenado(50);
        lista.insertarOrdenado(20);
        lista.insertarOrdenado(80);
        lista.insertarOrdenado(10);
        lista.insertarOrdenado(30);
        lista.insertarOrdenado(70);
        lista.insertarOrdenado(40);

        // Mostrar la lista
        lista.mostrar();
        System.out.println("Tamaño de la lista: " + lista.tamaño());

        // Buscar elementos
        System.out.println("\nBuscando elementos:");
        System.out.println("¿Está el 30? " + (lista.buscar(30) ? "Sí" : "No"));
        System.out.println("¿Está el 100? " + (lista.buscar(100) ? "Sí" : "No"));

        // Eliminar un elemento
        System.out.println("\nEliminando el elemento 30...");
        lista.eliminar(30);
        lista.mostrar();

        // Insertar más elementos
        System.out.println("\nInsertando elementos: 5, 90");
        lista.insertarOrdenado(5);
        lista.insertarOrdenado(90);
        lista.mostrar();
        System.out.println("Tamaño de la lista: " + lista.tamaño());
    }
}