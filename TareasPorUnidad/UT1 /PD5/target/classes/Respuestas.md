Recomendable abrirlo en un editor de markdown(.md)
# Respuestas:
<!-- TOC -->
* [Respuestas:](#respuestas)
  * [Ejercicio 1:](#ejercicio-1)
  * [Ejercicio 3:](#ejercicio-3-)
  * [Ejercicio 4:](#ejercicio-4)
  * [Ejercicio 5:](#ejercicio-5)
  * [Ejercicio 6:](#ejercicio-6)
  * [Ejericio 7:](#ejericio-7)
  * [Ejercicio 8:](#ejercicio-8)
  * [Ejericio 9:](#ejericio-9)
  * [Ejercicio 10:](#ejercicio-10)
  * [Ejercicio 11:](#ejercicio-11)
<!-- TOC -->
## Ejercicio 1:
Todo el código se encuentra en el package ejercicio 1

---
## Ejercicio 3: 
El código se comporta de la siguiente manera, estuve
probando valores, caracteres diferentes, lo que hace el codigo es tomar los
caracteres de más a la derecha y ponerlos en la izquierda, asi sucesivamente, si se puede leer
igual, entonces es un palindromo.

---
## Ejercicio 4:
Supuse que había problemas en código porque los metodos
estaban mal implementados en algunos casos y se llamaban mal, 
también la longitud del argumento era 3 y no de 2. Arreglando eso
el codígo funciona.

1) Valores pedidos con  13.4 y 66.1:
- a + b = 79.5
- a - b = -52.699997
- a * b = 885.7399
- a / b = 0.20272315
- a % b = 13.4

2) Seria de esta manera:  
`int a = (Integer.valueOf(args[0])).intValue();    
int b = (Integer.valueOf(args[1])).intValue();`

*Solo debemos cambiar esas dos lineas (9 y 10) de esa manera y todo 
funcionara de manera correcta.*

---

## Ejercicio 5:
1) El programa indica la cantidad de digitos que existen antes y luego de la coma.
2) Se puede partir este problema en dos partes, la primera parte:
`System.out.println(dot + " digits " + "before decimal point.");`
Se imprime el indice dot, que es el valor donde se encuentra el "." en el double transformado
a string. Lo que es siempre la cantidad de digitos detras del "."
La segunda parte hace algo similar donde se buscan los digitos despues del punto, se toma
la longitud de la string, se le saca hasta donde llega los primeros digitos y uno más que es el punto.
Ese valor es el de la cantidad de digitos luego del punto, el resto. Luego se imprime el valor con un texto.

---
## Ejercicio 6:
En el package ejercicio6.

---
 
## Ejericio 7:
En el package ejercicio7.

---
## Ejercicio 8:
La capacidad es 42, el ejercicio esta en ejercicio8.

---

## Ejericio 9:
En el package ejercicio9.

---
## Ejercicio 10:
En el package ejercicio10.

---
## Ejercicio 11:
El numero indica despues de que linea.
1 texto: "eola"
2 texto: "e2la"
3 texto: "e 2la"
4 texto: "e 2laste"
5 texto: "e 2am laste"

