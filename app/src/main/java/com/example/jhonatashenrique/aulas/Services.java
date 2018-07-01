package com.example.jhonatashenrique.aulas;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.jhonatashenrique.aulas.DAO.FaltasDAO;
import com.example.jhonatashenrique.aulas.DAO.HorarioDAO;
import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;
import com.example.jhonatashenrique.aulas.DAO.QuartaDAO;
import com.example.jhonatashenrique.aulas.DAO.QuintaDAO;
import com.example.jhonatashenrique.aulas.DAO.SegundaDAO;
import com.example.jhonatashenrique.aulas.DAO.SextaDAO;
import com.example.jhonatashenrique.aulas.DAO.TercaDAO;
import com.example.jhonatashenrique.aulas.Domain.Faltas;
import com.example.jhonatashenrique.aulas.Domain.Horario;
import com.example.jhonatashenrique.aulas.Domain.Materia;
import com.example.jhonatashenrique.aulas.Domain.Quarta;
import com.example.jhonatashenrique.aulas.Domain.Quinta;
import com.example.jhonatashenrique.aulas.Domain.Segunda;
import com.example.jhonatashenrique.aulas.Domain.Sexta;
import com.example.jhonatashenrique.aulas.Domain.Terca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Services extends IntentService {

    Segunda segunda;
    Terca terca;
    Quarta quarta;
    Quinta quinta;
    Sexta sexta;
    Horario horario;
    HorarioDAO daoHorario;
    SegundaDAO segDAO;
    TercaDAO terDAO;
    QuartaDAO quarDAO;
    QuintaDAO quinDAO;
    SextaDAO sexDAO;
    MateriaDAO daoMat;
    Faltas faltas;
    FaltasDAO daoFaltas;

    public Services (){
        super ("Services");
    }

    public Services(String name) {
        super(name);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent( Intent intent) {

        segunda = new Segunda();
        terca = new Terca();
        quarta = new Quarta();
        quinta = new Quinta();
        sexta = new Sexta();
        horario = new Horario();

        daoHorario = new HorarioDAO(this);
        segDAO = new SegundaDAO(this);
        terDAO = new TercaDAO(this);
        quarDAO = new QuartaDAO(this);
        quinDAO = new QuintaDAO(this);
        sexDAO = new SextaDAO(this);
        daoMat = new MateriaDAO(this);

        final Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(new Date());
        final int valor = cal.get(Calendar.DAY_OF_WEEK);

        int escolha = (int) intent.getSerializableExtra("escolha");
        if (escolha == 1){
            Log.i("teste", "Chegou até aqui");
            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula1());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula1());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula1());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula1());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula1());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }

        }else if (escolha == 2){
            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula2());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula2());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula2());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula2());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula2());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }

        }else if (escolha == 3){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula3());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula3());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula3());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula3());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula3());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }
        }else if (escolha == 4){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula4());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula4());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula4());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula4());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula4());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }
        }else if (escolha == 5){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula5());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula5());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula5());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula5());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula5());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }
        }else if (escolha == 6){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula6());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula6());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula6());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula6());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula6());
                int aux = materia.getPresenca();
                aux++;
                materia.setPresenca(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
            }
        }else if (escolha == 7){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula1());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(this);
                faltas.setId_materia(segunda.getAula1());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula1());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(this);
                faltas.setId_materia(terca.getAula1());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula1());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula1());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula1());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula1());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula1());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula1());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }
        }else if (escolha == 8){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula2());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula2());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula2());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula2());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula2());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula2());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula2());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula2());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula2());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula2());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }
        }else if (escolha == 9){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula3());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula3());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula3());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula3());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula3());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula3());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula3());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula3());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula3());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula3());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }
        }else if (escolha == 10){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula4());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula4());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula4());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula4());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula4());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula4());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula4());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula4());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula4());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula4());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }
        }else if (escolha == 11){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula5());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula5());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula5());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula5());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula5());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula5());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula5());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula5());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula5());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula5());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }
        }else if (escolha == 12){

            if (valor == 2){
                segunda = segDAO.buscarSegunda();
                Materia materia = daoMat.buscarMateria(segunda.getAula6());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula6());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia = daoMat.buscarMateria(terca.getAula6());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula6());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia = daoMat.buscarMateria(quarta.getAula6());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula6());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia = daoMat.buscarMateria(quinta.getAula6());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula6());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia = daoMat.buscarMateria(sexta.getAula6());
                int aux = materia.getFalta();
                aux++;
                materia.setFalta(aux);
                daoMat.alteraMateria(materia);
                daoMat.close();
                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula6());
                faltas.setNomeMat(materia.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }
        }else if (escolha == 13){
            if (valor == 2){
                segunda = segDAO.buscarSegunda();

                Materia materia1 = daoMat.buscarMateria(segunda.getAula1());
                Materia materia2 = daoMat.buscarMateria(segunda.getAula2());
                Materia materia3 = daoMat.buscarMateria(segunda.getAula3());
                Materia materia4 = daoMat.buscarMateria(segunda.getAula4());
                Materia materia5 = daoMat.buscarMateria(segunda.getAula5());
                Materia materia6 = daoMat.buscarMateria(segunda.getAula6());

                int aux1 = materia1.getFalta();
                int aux2 = materia2.getFalta();
                int aux3 = materia3.getFalta();
                int aux4 = materia4.getFalta();
                int aux5 = materia5.getFalta();
                int aux6 = materia6.getFalta();

                aux1++;
                aux2++;
                aux3++;
                aux4++;
                aux5++;
                aux6++;

                materia1.setFalta(aux1);
                materia2.setFalta(aux2);
                materia3.setFalta(aux3);
                materia4.setFalta(aux4);
                materia5.setFalta(aux5);
                materia6.setFalta(aux6);

                daoMat.alteraMateria(materia1);
                daoMat.alteraMateria(materia2);
                daoMat.alteraMateria(materia3);
                daoMat.alteraMateria(materia4);
                daoMat.alteraMateria(materia5);
                daoMat.alteraMateria(materia6);
                daoMat.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula1());
                faltas.setNomeMat(materia1.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();


                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula2());
                faltas.setNomeMat(materia2.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula3());
                faltas.setNomeMat(materia3.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula4());
                faltas.setNomeMat(materia4.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula5());
                faltas.setNomeMat(materia5.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(segunda.getAula6());
                faltas.setNomeMat(materia6.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

            }else if (valor == 3){
                terca = terDAO.buscarTerca();
                Materia materia1 = daoMat.buscarMateria(terca.getAula1());
                Materia materia2 = daoMat.buscarMateria(terca.getAula2());
                Materia materia3 = daoMat.buscarMateria(terca.getAula3());
                Materia materia4 = daoMat.buscarMateria(terca.getAula4());
                Materia materia5 = daoMat.buscarMateria(terca.getAula5());
                Materia materia6 = daoMat.buscarMateria(terca.getAula6());

                int aux1 = materia1.getFalta();
                int aux2 = materia2.getFalta();
                int aux3 = materia3.getFalta();
                int aux4 = materia4.getFalta();
                int aux5 = materia5.getFalta();
                int aux6 = materia6.getFalta();

                aux1++;
                aux2++;
                aux3++;
                aux4++;
                aux5++;
                aux6++;

                materia1.setFalta(aux1);
                materia2.setFalta(aux2);
                materia3.setFalta(aux3);
                materia4.setFalta(aux4);
                materia5.setFalta(aux5);
                materia6.setFalta(aux6);

                daoMat.alteraMateria(materia1);
                daoMat.alteraMateria(materia2);
                daoMat.alteraMateria(materia3);
                daoMat.alteraMateria(materia4);
                daoMat.alteraMateria(materia5);
                daoMat.alteraMateria(materia6);
                daoMat.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula1());
                faltas.setNomeMat(materia1.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula2());
                faltas.setNomeMat(materia2.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula3());
                faltas.setNomeMat(materia3.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula4());
                faltas.setNomeMat(materia4.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula5());
                faltas.setNomeMat(materia5.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(terca.getAula6());
                faltas.setNomeMat(materia6.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 4){
                quarta = quarDAO.buscarQuarta();
                Materia materia1 = daoMat.buscarMateria(quarta.getAula1());
                Materia materia2 = daoMat.buscarMateria(quarta.getAula2());
                Materia materia3 = daoMat.buscarMateria(quarta.getAula3());
                Materia materia4 = daoMat.buscarMateria(quarta.getAula4());
                Materia materia5 = daoMat.buscarMateria(quarta.getAula5());
                Materia materia6 = daoMat.buscarMateria(quarta.getAula6());

                int aux1 = materia1.getFalta();
                int aux2 = materia2.getFalta();
                int aux3 = materia3.getFalta();
                int aux4 = materia4.getFalta();
                int aux5 = materia5.getFalta();
                int aux6 = materia6.getFalta();

                aux1++;
                aux2++;
                aux3++;
                aux4++;
                aux5++;
                aux6++;

                materia1.setFalta(aux1);
                materia2.setFalta(aux2);
                materia3.setFalta(aux3);
                materia4.setFalta(aux4);
                materia5.setFalta(aux5);
                materia6.setFalta(aux6);

                daoMat.alteraMateria(materia1);
                daoMat.alteraMateria(materia2);
                daoMat.alteraMateria(materia3);
                daoMat.alteraMateria(materia4);
                daoMat.alteraMateria(materia5);
                daoMat.alteraMateria(materia6);
                daoMat.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula1());
                faltas.setNomeMat(materia1.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula2());
                faltas.setNomeMat(materia2.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula3());
                faltas.setNomeMat(materia3.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula4());
                faltas.setNomeMat(materia4.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula5());
                faltas.setNomeMat(materia5.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quarta.getAula6());
                faltas.setNomeMat(materia6.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 5){
                quinta = quinDAO.buscarQuinta();
                Materia materia1 = daoMat.buscarMateria(quinta.getAula1());
                Materia materia2 = daoMat.buscarMateria(quinta.getAula2());
                Materia materia3 = daoMat.buscarMateria(quinta.getAula3());
                Materia materia4 = daoMat.buscarMateria(quinta.getAula4());
                Materia materia5 = daoMat.buscarMateria(quinta.getAula5());
                Materia materia6 = daoMat.buscarMateria(quinta.getAula6());

                int aux1 = materia1.getFalta();
                int aux2 = materia2.getFalta();
                int aux3 = materia3.getFalta();
                int aux4 = materia4.getFalta();
                int aux5 = materia5.getFalta();
                int aux6 = materia6.getFalta();

                aux1++;
                aux2++;
                aux3++;
                aux4++;
                aux5++;
                aux6++;

                materia1.setFalta(aux1);
                materia2.setFalta(aux2);
                materia3.setFalta(aux3);
                materia4.setFalta(aux4);
                materia5.setFalta(aux5);
                materia6.setFalta(aux6);

                daoMat.alteraMateria(materia1);
                daoMat.alteraMateria(materia2);
                daoMat.alteraMateria(materia3);
                daoMat.alteraMateria(materia4);
                daoMat.alteraMateria(materia5);
                daoMat.alteraMateria(materia6);
                daoMat.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula1());
                faltas.setNomeMat(materia1.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula2());
                faltas.setNomeMat(materia2.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula3());
                faltas.setNomeMat(materia3.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula4());
                faltas.setNomeMat(materia4.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula5());
                faltas.setNomeMat(materia5.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(quinta.getAula6());
                faltas.setNomeMat(materia6.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }else if (valor == 6){
                sexta = sexDAO.buscarSexta();
                Materia materia1 = daoMat.buscarMateria(sexta.getAula1());
                Materia materia2 = daoMat.buscarMateria(sexta.getAula2());
                Materia materia3 = daoMat.buscarMateria(sexta.getAula3());
                Materia materia4 = daoMat.buscarMateria(sexta.getAula4());
                Materia materia5 = daoMat.buscarMateria(sexta.getAula5());
                Materia materia6 = daoMat.buscarMateria(sexta.getAula6());

                int aux1 = materia1.getFalta();
                int aux2 = materia2.getFalta();
                int aux3 = materia3.getFalta();
                int aux4 = materia4.getFalta();
                int aux5 = materia5.getFalta();
                int aux6 = materia6.getFalta();

                aux1++;
                aux2++;
                aux3++;
                aux4++;
                aux5++;
                aux6++;

                materia1.setFalta(aux1);
                materia2.setFalta(aux2);
                materia3.setFalta(aux3);
                materia4.setFalta(aux4);
                materia5.setFalta(aux5);
                materia6.setFalta(aux6);

                daoMat.alteraMateria(materia1);
                daoMat.alteraMateria(materia2);
                daoMat.alteraMateria(materia3);
                daoMat.alteraMateria(materia4);
                daoMat.alteraMateria(materia5);
                daoMat.alteraMateria(materia6);
                daoMat.close();

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula1());
                faltas.setNomeMat(materia1.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                int mes= cal.get(Calendar.MONTH);
                mes++;
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula2());
                faltas.setNomeMat(materia2.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula3());
                faltas.setNomeMat(materia3.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula4());
                faltas.setNomeMat(materia4.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula5());
                faltas.setNomeMat(materia5.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);

                faltas = new Faltas();
                daoFaltas = new FaltasDAO(Services.this);
                faltas.setId_materia(sexta.getAula6());
                faltas.setNomeMat(materia6.getNome());
                faltas.setDia(cal.get(Calendar.DAY_OF_MONTH));
                faltas.setMes(mes);
                daoFaltas.SalvarFaltas(faltas);
                daoFaltas.close();
            }
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Registrando [...]", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
