package me.sekitaka.pendingintentextra;

import java.io.Serializable;

/**
 * Created by Takashi Seki on 2017/05/15.
 */

public class SerializablePlayer implements Serializable {
    int id;
    String name;

    public SerializablePlayer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + id + ":" + name + "}";
    }

}
