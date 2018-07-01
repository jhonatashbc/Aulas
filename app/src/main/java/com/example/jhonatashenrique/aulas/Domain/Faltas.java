package com.example.jhonatashenrique.aulas.Domain;

import android.content.Context;

import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;

import java.io.Serializable;

public class Faltas implements Serializable{

    String nomeMat;
    private long id;
    private long id_materia;
    private int dia;
    private int mes;

    public String getNomeMat() {
        return nomeMat;
    }

    public void setNomeMat(String nomeMat) {
        this.nomeMat = nomeMat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_materia() {
        return id_materia;
    }

    public void setId_materia(long id_materia) {
        this.id_materia = id_materia;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return ""+nomeMat +", Dia "+dia +"/"+mes;
    }
}
