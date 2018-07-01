package com.example.jhonatashenrique.aulas.Domain;

import java.io.Serializable;

public class CheckInAula implements Serializable {

    private long id;
    private int checkaula1, checkaula2, checkaula3, checkaula4, checkaula5, checkaula6;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCheckaula1() {
        return checkaula1;
    }

    public void setCheckaula1(int checkaula1) {
        this.checkaula1 = checkaula1;
    }

    public int getCheckaula2() {
        return checkaula2;
    }

    public void setCheckaula2(int checkaula2) {
        this.checkaula2 = checkaula2;
    }

    public int getCheckaula3() {
        return checkaula3;
    }

    public void setCheckaula3(int checkaula3) {
        this.checkaula3 = checkaula3;
    }

    public int getCheckaula4() {
        return checkaula4;
    }

    public void setCheckaula4(int checkaula4) {
        this.checkaula4 = checkaula4;
    }

    public int getCheckaula5() {
        return checkaula5;
    }

    public void setCheckaula5(int checkaula5) {
        this.checkaula5 = checkaula5;
    }

    public int getCheckaula6() {
        return checkaula6;
    }

    public void setCheckaula6(int checkaula6) {
        this.checkaula6 = checkaula6;
    }
}
