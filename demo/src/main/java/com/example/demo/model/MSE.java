package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MSE {
    @Id
    private int id;
    private int wt;
    private int daa;
    private int sdam;
    private int toc;

    public MSE() {
    }

    public MSE(int id, int wt, int daa, int sdam, int toc) {
        this.id = id;
        this.wt = wt;
        this.daa = daa;
        this.sdam = sdam;
        this.toc = toc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWt() {
        return wt;
    }

    public void setWt(int wt) {
        this.wt = wt;
    }

    public int getDaa() {
        return daa;
    }

    public void setDaa(int daa) {
        this.daa = daa;
    }

    public int getSdam() {
        return sdam;
    }

    public void setSdam(int sdam) {
        this.sdam = sdam;
    }

    public int getToc() {
        return toc;
    }

    public void setToc(int toc) {
        this.toc = toc;
    }

}
