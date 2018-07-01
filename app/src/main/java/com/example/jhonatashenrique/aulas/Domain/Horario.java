package com.example.jhonatashenrique.aulas.Domain;

import java.io.Serializable;

public class Horario implements Serializable {

    private long id;
    private String horario1,horario2, horario3, horario4, horario5, horario6;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHorario1() {
        return horario1;
    }

    public void setHorario1(String horario1) {
        this.horario1 = horario1;
    }

    public String getHorario2() {
        return horario2;
    }

    public void setHorario2(String horario2) {
        this.horario2 = horario2;
    }

    public String getHorario3() {
        return horario3;
    }

    public void setHorario3(String horario3) {
        this.horario3 = horario3;
    }

    public String getHorario4() {
        return horario4;
    }

    public void setHorario4(String horario4) {
        this.horario4 = horario4;
    }

    public String getHorario5() {
        return horario5;
    }

    public void setHorario5(String horario5) {
        this.horario5 = horario5;
    }

    public String getHorario6() {
        return horario6;
    }

    public void setHorario6(String horario6) {
        this.horario6 = horario6;
    }
}
