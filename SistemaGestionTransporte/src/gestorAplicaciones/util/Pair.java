package gestorAplicaciones.util;

public class Pair<K, V> {
    //esta clase es de tipo generica, guarda dos valores del tipo de dato definidos al ser instanciada

    //atributos
    private final K key;
    private final V value;

    //constructor
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    //metodos setter and getter
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}






