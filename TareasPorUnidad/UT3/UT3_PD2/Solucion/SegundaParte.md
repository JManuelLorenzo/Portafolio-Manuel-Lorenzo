## ¿Cual es el problema?
**Debemos crear un algoritmo utilizando una Linked list para añadir un nuevo elemento.** Lo primero a la hora de solucionar un problema
es entender que estamos haciendo, es pensar qué vamos a resolver. Aclaremos tambíen que nuestra lista debe estar ordenada *alfabeticamente*.

#### Llamaremos a el nuevo elemento como Nx.

### ¿Qué razonamientos podemos inferir a partir de esto?
Primero consideremos varios casos:

1. La lista se encuentra vacia, en ese caso únicamente debemos añadir el Nx como si fuera la lista.
2. El Nx por orden alfabetico se encuentra al principio de todo.
3. El Nx por orden alfabetico se encuentra al final de todo, por lo tanto seria el utimoElemento.siguiente = Nx.
4. El Nx por orden alfabetico se encuentra en algun punto medio de la lista. En este caso debemos ocuparnos de ubicarlo comparando su orden alfabetico.

### Idea general del código:
Para comprender toda esta informacion nuestro codigo deberia primero que nada fijarse si la lista no esta vacia, si lo esta establece Nx como primer elemento. Posteriormente va a comparar a través del orden alfabetico con el primer elemento de la lista, si este es menor a Nx, se insertara como primero haciendo que el siguiente a Nx sea el primer elemento. Sino lo que debe hacer es comenzar a iterar la lista, posiblemente a través de un for, donde se va ir guardando una variable temp, que corresponde al nodo actual.
Se va a realizar un "If" donde se va a comparar si el siguiente de temp es mayor(alfabeticamente, por su orden de letras) que Nx, si en algun momento temp es menor entonces, lo que sucedera es que se asignara a temp.siguiente como el siguiente de Nx, entonces se asignara como el siguiente de temp a Nx. Insertando de esa manera el valor de Nx en la posición deseada, en ese momento se activa un "break". En el caso de nunca volverse true el if, podemos inferir que elemento deberia estar posicionado al final de la lista y va a ser insertado ahi. **De esa manera nuestro  algoritmo cumple los 4 casos posibles. **
