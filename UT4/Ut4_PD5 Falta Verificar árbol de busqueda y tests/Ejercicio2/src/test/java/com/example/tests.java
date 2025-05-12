package com.example;

import org.junit.Assert;
import org.junit.Test;

public class tests {
@Test    
public void pruebaUno() {
        TArbolBB <Integer> ejemplo = new TArbolBB<>();
        TElementoAB <Integer>nodo1 = new TElementoAB<>(15, 15);
        TElementoAB <Integer>nodo2 = new TElementoAB<>(22, 22);
        TElementoAB  <Integer> nodo3 = new TElementoAB<>(4, 4);
        ejemplo.insertar(nodo1);
        ejemplo.insertar(nodo2);
        ejemplo.insertar(nodo3);
       Assert.assertEquals(ejemplo.ObtenerClaveMenor(), Integer.valueOf(4));
    }   
@Test    
public void pruebaDos() {
        TArbolBB <Integer> ejemplo = new TArbolBB<>();
        TElementoAB <Integer>nodo1 = new TElementoAB<>(15, 15);
        TElementoAB <Integer>nodo2 = new TElementoAB<>(22, 22);
        TElementoAB  <Integer> nodo3 = new TElementoAB<>(4, 4);
        ejemplo.insertar(nodo1);
        ejemplo.insertar(nodo2);
        ejemplo.insertar(nodo3);
       Assert.assertEquals(ejemplo.ObtenerClaveMenor(), Integer.valueOf(22));
    }   
} 