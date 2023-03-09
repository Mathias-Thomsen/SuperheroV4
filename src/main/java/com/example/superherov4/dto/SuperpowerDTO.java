package com.example.superherov4.dto;

public class SuperpowerDTO {
    private String superpowerName;
    private int superpowerId;

    public SuperpowerDTO(String superpowerName, int superpowerId) {
        this.superpowerName = superpowerName;
        this.superpowerId = superpowerId;
    }

    public String getSuperpowerName() {
        return superpowerName;
    }

    public void setSuperpowerName(String superpowerName) {
        this.superpowerName = superpowerName;
    }

    public int getSuperpowerId() {
        return superpowerId;
    }

    public void setSuperpowerId(int superpowerId) {
        this.superpowerId = superpowerId;
    }

    //TODO: lave denne klasse og implamentere det i repository. En liste der viser navn på alle superkrafterne.
}
