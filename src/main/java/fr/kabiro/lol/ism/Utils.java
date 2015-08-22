package fr.kabiro.lol.ism;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class Utils {
    public static <K, V> Map<K, V> safe(Map<K, V> map) {
        return map != null ? map : Collections.EMPTY_MAP;
    }

    public static <T> Collection<T> safe(Collection<T> collection) {
        return collection != null ? collection : Collections.emptyList();
    }
}
