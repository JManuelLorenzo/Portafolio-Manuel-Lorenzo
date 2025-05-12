package com.example;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;


public class totalTest {
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
       Assert.assertEquals(ejemplo.ObtenerClaveMayor(), Integer.valueOf(22));
    }   
@Test
public void pruebaClave(){
    TArbolBB <Integer> ejemplo = new TArbolBB<>();
        TElementoAB <Integer> nodo1 = new TElementoAB<>(15, 15);
        TElementoAB <Integer> nodo2 = new TElementoAB<>(22, 22);
        TElementoAB  <Integer> nodo3 = new TElementoAB<>(4, 4);
        ejemplo.insertar(nodo1);
        ejemplo.insertar(nodo2);
        ejemplo.insertar(nodo3);
        Assert.assertEquals(ejemplo.ObtenerSiguienteClave(nodo2.getEtiqueta()), Integer.valueOf(15));
}
@Test
public void pruebaObtenerNivel(){TArbolBB <Integer> ejemplo = new TArbolBB<>();
        TElementoAB <Integer> nodo1 = new TElementoAB<>(15, 15);
        TElementoAB <Integer> nodo2 = new TElementoAB<>(22, 22);
        TElementoAB  <Integer> nodo3 = new TElementoAB<>(4, 4);
        ejemplo.insertar(nodo1);
        ejemplo.insertar(nodo2);
        ejemplo.insertar(nodo3);
    Assert.assertEquals(2, ejemplo.CantidadNodosNivel(1));
}  
@Test
public void pruebaConseguirHojas(){TArbolBB <Integer> ejemplo = new TArbolBB<>();
        TElementoAB <Integer> nodo1 = new TElementoAB<>(15, 15);
        TElementoAB <Integer> nodo2 = new TElementoAB<>(22, 22);
        TElementoAB  <Integer> nodo3 = new TElementoAB<>(4, 4);
        ejemplo.insertar(nodo1);
        ejemplo.insertar(nodo2);
        ejemplo.insertar(nodo3);
        LinkedList<TElementoAB> a = new LinkedList<>();
    Assert.assertEquals(2, ejemplo.ListarHojas(a).size());
}  
}