package gestorAplicaciones.util;

import java.io.Serial;
import java.io.Serializable;

public class Pair<K, V>  implements Serializable {
    //esta clase es de tipo generica, guarda dos valores (key, value) del tipo de dato definidos al ser instanciada.

    @Serial
    private static final long serialVersionUID = 1L;
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






