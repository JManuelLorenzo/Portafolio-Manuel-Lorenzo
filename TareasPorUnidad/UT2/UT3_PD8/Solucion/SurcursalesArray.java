import java.util.ArrayList;
public class SurcursalesArray <T>{
    private  ArrayList lista = new ArrayList();
    public void add(T value){
        lista.add(value);
    }
    public int find(String palabra){
      return lista.indexOf(palabra);
    }
    public boolean remove(int posicion){
        lista.remove(posicion);
        return true;
    }
    public String listAll(){
        int length = lista.size() -1;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++){
           str.append(i + " "  + lista.get(i) + " ");
        }
        return str.toString();
    }
    public String listAll(String parameter){
        int length = lista.size() -1;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++){
            str.append(lista.get(i) );
            str.append(parameter);
        }
        return str.toString();
    }
    public  int quantitySize(){
        return lista.size();
    }
    public  boolean isEmpty(){
        return lista.isEmpty();
    }

}
