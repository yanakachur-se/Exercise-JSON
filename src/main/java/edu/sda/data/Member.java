package edu.sda.data;

import java.util.Objects;

public class Member {
    private String name;
    private String id;
    private boolean isAttend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAttend() {
        return isAttend;
    }

    public void setAttend(boolean attend) {
        isAttend = attend;
    }

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Member() {
    }

}
