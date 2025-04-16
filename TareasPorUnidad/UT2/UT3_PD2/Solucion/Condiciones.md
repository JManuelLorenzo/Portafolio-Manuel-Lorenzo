# Precondiciones y Postcondiciones del Algoritmo de Inserción en Lista Enlazada.

## Contexto General
Este documento presenta las precondiciones y postcondiciones del algoritmo encargado de insertar un nuevo producto en una lista enlazada simple, manteniendo el orden alfabético según el nombre del producto (Segun lo acordado por el Grupo). 

---

## Precondiciones
Antes de ejecutar el algoritmo de inserción, se deben cumplir las siguientes condiciones:

1. **Estructura válida:**
   - La estructura de datos utilizada es una lista enlazada simple, con nodos conectados de forma unidireccional.

2. **Lista accesible:**
   - Se cuenta con una referencia al primer nodo de la lista.

3. **Lista ordenada:**
   - La lista existente (si no esta vacia) se encuentra ordenada alfabéticamente por el nombre del producto.

4. **Nodo nuevo válido:**
   - El nuevo nodo  a insertar contiene un nombre de producto válido.
   - Además, contiene como mínimo los campos: nombre, código de identificación y precio unitario (coma flotante).

5. **Capacidad de comparación:**
   - El sistema tiene la capacidad de comparar alfabéticamente los nombres de productos.

6. **Consistencia de enlaces:**
   - Todos los nodos existentes en la lista tienen correctamente definidos sus punteros al siguiente nodo.
---

## Postcondiciones
Una vez ejecutado el algoritmo de inserción, se espera que las siguientes condiciones se cumplan:

1. **Lista actualizada:**
   - La lista enlazada contiene todos los elementos originales, más el nuevo nodo  insertado en la posición correcta de acuerdo al orden alfabético.

2. **Orden mantenido:**
   - La propiedad de orden alfabético de la lista se mantiene intacta tras la inserción.

3. **Estructura válida:**
   - La estructura de la lista sigue siendo una lista enlazada simple válida: cada nodo apunta al siguiente y el último nodo apunta a "null".

4. **Nodo correctamente enlazado:**
   - El nuevo nodo  está enlazado entre dos nodos existentes (o al principio o al final, según corresponda) sin perder ningún enlace anterior.

5. **No se pierde información:**
   - Ningún nodo existente antes de la operación fue eliminado ni sobrescrito. El contenido de la lista anterior se conserva íntegro.

6. **Lista no vacía:**
   - Si la lista estaba vacía, ahora contiene un único nodo: , que se convierte en la cabeza de la lista.

7. **Estabilidad operativa:**
   - El algoritmo finaliza correctamente sin generar errores o fallos en la ejecución.
