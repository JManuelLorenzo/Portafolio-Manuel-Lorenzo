# Respuestas a el *PD7:*
## Ejercicio 1:
La razón de porque esto ocurre en Java se debe  como funciónan las relaciones
de tipo igualacion es decir "==" o "!=" especialmente en el caso de las Strings se basa en la comparación de referencias.
Cuando uno hace `s+='0'` esta cambiando la referencia del objeto. Por lo tanto "1000" y s estan en pools distintas, lo
que significa que nunca van a ser iguales debido a que apuntan a lugares diferentes. En otros lenguajes como **C** se
basa en el contenido interior del valor. Para hacer eso en Java debes usar el .equals con las strings.

---
## Ejercicio2:
1La primera version da true mientras que la segunda da false, ¿por qué?
Se debe a que sus referencias son distintas, en java no se compara por el contenido sino por sus referencias,
podemos observar en la primera version al correr ` System.out.println(System.identityHashCode(s1));
System.out.println(System.identityHashCode(s2));`
Que nos dara el mismo valor mientras que en el segundo seran distintos.


Cuando nosotros definimos una string sin el operador new la estamos mandando a la pool de strings (asi si existe una igual la repite)
llega la diferencia cuando utilizamos new(crea siempre diferentes objetos) para crear strings, en ese momento la estamos mandando a el heap, lo que hace que sus
referencias no sean iguales y como ya sabemos en Java "==" compara referencias y no contenido.
Intern lo que permite hacer es copiar del heap para el pool.

2) El ejercicio 1 de manera correcta esta en el main.
  
Referencias:
- https://www.geeksforgeeks.org/interning-of-string/
- https://www.baeldung.com/string-intern
- https://stackoverflow.com/questions/41908321/difference-between-heap-memory-and-string-pool