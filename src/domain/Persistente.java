package domain;

import java.io.Serializable;

public interface Persistente<E extends Serializable> extends Serializable {
    E getId();
}

