package DAO.Generic;

import java.util.HashMap;
import java.util.Map;

public class SingletonMap {
    private static Map<Long, Object> map;

    private SingletonMap() {
    }

    public static Map<Long, Object> getInstance() {
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }
}

