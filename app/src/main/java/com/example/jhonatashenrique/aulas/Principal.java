package com.example.jhonatashenrique.aulas;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import org.threeten.bp.*;

import com.example.jhonatashenrique.aulas.DAO.CheckInAulaDAO;
import com.example.jhonatashenrique.aulas.DAO.FaltasDAO;
import com.example.jhonatashenrique.aulas.DAO.HorarioDAO;
import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;
import com.example.jhonatashenrique.aulas.DAO.QuartaDAO;
import com.example.jhonatashenrique.aulas.DAO.QuintaDAO;
import com.example.jhonatashenrique.aulas.DAO.SegundaDAO;
import com.example.jhonatashenrique.aulas.DAO.SextaDAO;
import com.example.jhonatashenrique.aulas.DAO.TercaDAO;
import com.example.jhonatashenrique.aulas.Domain.CheckInAula;
import com.example.jhonatashenrique.aulas.Domain.Faltas;
import com.example.jhonatashenrique.aulas.Domain.Horario;
import com.example.jhonatashenrique.aulas.Domain.Materia;
import com.example.jhonatashenrique.aulas.Domain.Quarta;
import com.example.jhonatashenrique.aulas.Domain.Quinta;
import com.example.jhonatashenrique.aulas.Domain.Segunda;
import com.example.jhonatashenrique.aulas.Domain.Sexta;
import com.example.jhonatashenrique.aulas.Domain.Terca;
import com.example.jhonatashenrique.aulas.View.HorarioView;
import com.example.jhonatashenrique.aulas.View.ListaFaltas;
import com.example.jhonatashenrique.aulas.View.ListaMateria;
import com.example.jhonatashenrique.aulas.View.MateriaView;
import com.example.jhonatashenrique.aulas.View.QuartaView;
import com.example.jhonatashenrique.aulas.View.QuintaView;
import com.example.jhonatashenrique.aulas.View.SegundaView;
import com.example.jhonatashenrique.aulas.View.SextaView;
import com.example.jhonatashenrique.aulas.View.TercaView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Timer;

import static android.icu.text.DateFormat.SHORT;
import static android.text.TextUtils.isEmpty;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout layoutFrag;
    float initialX, initialY;
    int escolhas = 0;
    TextView txthorario1, txthorario2, txthorario3, txthorario4, txthorario5, txthorario6;
    TextView txtaula1, txtaula2,txtaula3,txtaula4,txtaula5,txtaula6;
    TextView txtajuda1, txtajuda2,txtajuda3,txtajuda4,txtajuda5;
    TextView txtPrin;
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
    CheckInAulaDAO daoCheckInAula;
    Faltas faltas;
    FaltasDAO daoFaltas;
    BottomNavigationView diasdasemana;
    FloatingActionButton btpresencaaula1, btpresencaaula2, btpresencaaula3, btpresencaaula4,
            btpresencaaula5, btpresencaaula6, btfaltaaula1, btfaltaaula2, btfaltaaula3, btfaltaaula4,
            btfaltaaula5, btfaltaaula6, btfaltastodas, btajuda;

    int auxhelp=0;

    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //-----------------------------------------------------------------------------------------
        final Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(new Date());
        final int valor = cal.get(Calendar.DAY_OF_WEEK);
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        segunda = new Segunda();
        terca = new Terca();
        quarta = new Quarta();
        quinta = new Quinta();
        sexta = new Sexta();
        horario = new Horario();
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        daoHorario = new HorarioDAO(this);
        segDAO = new SegundaDAO(Principal.this);
        terDAO = new TercaDAO(Principal.this);
        quarDAO = new QuartaDAO(Principal.this);
        quinDAO = new QuintaDAO(Principal.this);
        sexDAO = new SextaDAO(Principal.this);
        daoMat = new MateriaDAO(this);
        daoCheckInAula = new CheckInAulaDAO(this);
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        txthorario1 = findViewById(R.id.txthorario1prin);
        txthorario2 = findViewById(R.id.txthorario2prin);
        txthorario3 = findViewById(R.id.txthorario3prin);
        txthorario4 = findViewById(R.id.txthorario4prin);
        txthorario5 = findViewById(R.id.txthorario5prin);
        txthorario6 = findViewById(R.id.txthorario6prin);
        txtaula1 = findViewById(R.id.txtaula1prin);
        txtaula2 = findViewById(R.id.txtaula2prin);
        txtaula3 = findViewById(R.id.txtaula3prin);
        txtaula4 = findViewById(R.id.txtaula4prin);
        txtaula5 = findViewById(R.id.txtaula5prin);
        txtaula6 = findViewById(R.id.txtaula6prin);
        txtPrin = findViewById(R.id.txtPrin);
        btpresencaaula1 = findViewById(R.id.btpresencaaula1);
        btpresencaaula2 = findViewById(R.id.btpresencaaula2);
        btpresencaaula3 = findViewById(R.id.btpresencaaula3);
        btpresencaaula4 = findViewById(R.id.btpresencaaula4);
        btpresencaaula5 = findViewById(R.id.btpresencaaula5);
        btpresencaaula6 = findViewById(R.id.btpresencaaula6);
        btfaltaaula1 = findViewById(R.id.btfaltaaula1);
        btfaltaaula2 = findViewById(R.id.btfaltaaula2);
        btfaltaaula3 = findViewById(R.id.btfaltaaula3);
        btfaltaaula4 = findViewById(R.id.btfaltaaula4);
        btfaltaaula5 = findViewById(R.id.btfaltaaula5);
        btfaltaaula6 = findViewById(R.id.btfaltaaula6);
        btfaltastodas = findViewById(R.id.btfaltatodas);
        btajuda = findViewById(R.id.btajuda);
        txtajuda1 = findViewById(R.id.txtajuda1);
        txtajuda2 = findViewById(R.id.txtajuda2);
        txtajuda3 = findViewById(R.id.txtajuda3);
        txtajuda4 = findViewById(R.id.txtajuda4);
        txtajuda5 = findViewById(R.id.txtajuda5);
        diasdasemana = findViewById(R.id.diasdasemana);
        diasdasemana.setOnNavigationItemSelectedListener(this);
        layoutFrag = findViewById(R.id.layoutFrag);
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        btajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auxhelp == 0) {
                    txtajuda1.setVisibility(View.VISIBLE);
                    txtajuda2.setVisibility(View.VISIBLE);
                    txtajuda3.setVisibility(View.VISIBLE);
                    txtajuda4.setVisibility(View.VISIBLE);
                    txtajuda5.setVisibility(View.VISIBLE);

                    btfaltastodas.setVisibility(View.VISIBLE);
                    btfaltastodas.setEnabled(false);

                    btpresencaaula1.setVisibility(View.VISIBLE);
                    btpresencaaula1.setEnabled(false);
                    btpresencaaula2.setVisibility(View.VISIBLE);
                    btpresencaaula2.setEnabled(false);
                    btpresencaaula3.setVisibility(View.VISIBLE);
                    btpresencaaula3.setEnabled(false);
                    btpresencaaula4.setVisibility(View.VISIBLE);
                    btpresencaaula4.setEnabled(false);
                    btpresencaaula5.setVisibility(View.VISIBLE);
                    btpresencaaula5.setEnabled(false);
                    btpresencaaula6.setVisibility(View.VISIBLE);
                    btpresencaaula6.setEnabled(false);

                    btfaltaaula1.setVisibility(View.VISIBLE);
                    btfaltaaula1.setEnabled(false);
                    btfaltaaula2.setVisibility(View.VISIBLE);
                    btfaltaaula2.setEnabled(false);
                    btfaltaaula3.setVisibility(View.VISIBLE);
                    btfaltaaula3.setEnabled(false);
                    btfaltaaula4.setVisibility(View.VISIBLE);
                    btfaltaaula4.setEnabled(false);
                    btfaltaaula5.setVisibility(View.VISIBLE);
                    btfaltaaula5.setEnabled(false);
                    btfaltaaula6.setVisibility(View.VISIBLE);
                    btfaltaaula6.setEnabled(false);

                    auxhelp++;
                }else {
                    txtajuda1.setVisibility(View.GONE);
                    txtajuda2.setVisibility(View.GONE);
                    txtajuda3.setVisibility(View.GONE);
                    txtajuda4.setVisibility(View.GONE);
                    txtajuda5.setVisibility(View.GONE);

                    btfaltastodas.setVisibility(View.GONE);
                    btfaltastodas.setEnabled(true);

                    btpresencaaula1.setVisibility(View.GONE);
                    btpresencaaula1.setEnabled(true);
                    btpresencaaula2.setVisibility(View.GONE);
                    btpresencaaula2.setEnabled(true);
                    btpresencaaula3.setVisibility(View.GONE);
                    btpresencaaula3.setEnabled(true);
                    btpresencaaula4.setVisibility(View.GONE);
                    btpresencaaula4.setEnabled(true);
                    btpresencaaula5.setVisibility(View.GONE);
                    btpresencaaula5.setEnabled(true);
                    btpresencaaula6.setVisibility(View.GONE);
                    btpresencaaula6.setEnabled(true);

                    btfaltaaula1.setVisibility(View.GONE);
                    btfaltaaula1.setEnabled(true);
                    btfaltaaula2.setVisibility(View.GONE);
                    btfaltaaula2.setEnabled(true);
                    btfaltaaula3.setVisibility(View.GONE);
                    btfaltaaula3.setEnabled(true);
                    btfaltaaula4.setVisibility(View.GONE);
                    btfaltaaula4.setEnabled(true);
                    btfaltaaula5.setVisibility(View.GONE);
                    btfaltaaula5.setEnabled(true);
                    btfaltaaula6.setVisibility(View.GONE);
                    btfaltaaula6.setEnabled(true);

                    auxhelp --;
                }
            }
        });

        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        btpresencaaula1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int escolha = 1;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);
                btpresencaaula1.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula1(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();

            }
        });

        btpresencaaula2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 2;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula2.setVisibility(View.GONE);
                btfaltaaula2.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula2(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btpresencaaula3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 3;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula3.setVisibility(View.GONE);
                btfaltaaula3.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula3(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btpresencaaula4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 4;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula4.setVisibility(View.GONE);
                btfaltaaula4.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula4(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btpresencaaula5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 5;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula5.setVisibility(View.GONE);
                btfaltaaula5.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula5(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btpresencaaula6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 6;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula6.setVisibility(View.GONE);
                btfaltaaula6.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula6(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btfaltaaula1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 7;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula1.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula1(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btfaltaaula2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 8;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula2.setVisibility(View.GONE);
                btfaltaaula2.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula2(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btfaltaaula3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 9;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula3.setVisibility(View.GONE);
                btfaltaaula3.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula3(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btfaltaaula4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int escolha = 10;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula4.setVisibility(View.GONE);
                btfaltaaula4.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula4(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btfaltaaula5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 11;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula5.setVisibility(View.GONE);
                btfaltaaula5.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula5(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btfaltaaula6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int escolha = 12;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula6.setVisibility(View.GONE);
                btfaltaaula6.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula6(1);
                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });

        btfaltastodas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolha = 13;
                Intent i = new Intent(Principal.this, Services.class);
                i.putExtra("escolha", escolha);
                startService(i);

                btpresencaaula1.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
                CheckInAula checkInAula = daoCheckInAula.buscarCheckInAula();
                checkInAula.setCheckaula1(1);
                checkInAula.setCheckaula2(1);
                checkInAula.setCheckaula3(1);
                checkInAula.setCheckaula4(1);
                checkInAula.setCheckaula5(1);
                checkInAula.setCheckaula6(1);

                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();
            }
        });
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        segunda = segDAO.buscarSegunda(); //Por algum motivo cria o BD

        //-----------------------------------------------------------------------------------------

        CheckInAula checkInAula = new CheckInAula();
        checkInAula = daoCheckInAula.buscarCheckInAula();
        if (checkInAula.getId() != 1) {

            checkInAula.setCheckaula1(0);
            checkInAula.setCheckaula2(0);
            checkInAula.setCheckaula3(0);
            checkInAula.setCheckaula4(0);
            checkInAula.setCheckaula5(0);
            checkInAula.setCheckaula6(0);
            daoCheckInAula.SalvarCheckInAula(checkInAula);
        }

        //-----------------------------------------------------------------------------------------
        if (txtaula1.equals("") || txtaula1.equals(null)){
            Toast.makeText(Principal.this, "Cadastre as aulas", Toast.LENGTH_LONG).show();
        }
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        if (valor >=2 && valor <=6) {
            int hora = cal.get(Calendar.HOUR_OF_DAY);
            int minuto = cal.get(Calendar.MINUTE);
            Horario horario2 = daoHorario.buscarHorario();

            org.threeten.bp.LocalTime aula1 = null;
            org.threeten.bp.LocalTime aula2 = null;
            org.threeten.bp.LocalTime aula3 = null;
            org.threeten.bp.LocalTime aula4 = null;
            org.threeten.bp.LocalTime aula5 = null;
            org.threeten.bp.LocalTime aula6 = null;

            if (horario2.getId() == 1) {
                if (!horario2.getHorario1().equals("")) {
                    aula1 = org.threeten.bp.LocalTime.parse(horario2.getHorario1());
                }
                if (!horario2.getHorario2().equals("")) {
                    aula2 = org.threeten.bp.LocalTime.parse(horario2.getHorario2());
                }
                if (!horario2.getHorario3().equals("")) {
                    aula3 = org.threeten.bp.LocalTime.parse(horario2.getHorario3());
                }
                if (!horario2.getHorario4().equals("")) {
                    aula4 = org.threeten.bp.LocalTime.parse(horario2.getHorario4());
                }
                if (!horario2.getHorario5().equals("")) {
                    aula5 = org.threeten.bp.LocalTime.parse(horario2.getHorario5());
                }
                if (!horario2.getHorario6().equals("")) {
                    aula6 = org.threeten.bp.LocalTime.parse(horario2.getHorario6());
                }


            }

            if (aula1 == null) {
                Toast.makeText(this, "Cadastre os horários", Toast.LENGTH_SHORT).show();
            } else {
                checkInAula = daoCheckInAula.buscarCheckInAula();

                org.threeten.bp.LocalTime horaatual = org.threeten.bp.LocalTime.of(hora,minuto);

                if (horaatual.isAfter(aula1) && horaatual.isBefore(aula1.plusHours(4))) {
                    if (checkInAula.getCheckaula1() != 1) {
                        btpresencaaula1.setVisibility(View.VISIBLE);
                        btfaltaaula1.setVisibility(View.VISIBLE);
                        btfaltastodas.setVisibility(View.VISIBLE);
                    }
                }
                if (aula2 != null) {
                    if (horaatual.isAfter(aula2) && horaatual.isBefore(aula2.plusHours(3))) {
                        if (checkInAula.getCheckaula2() != 1) {
                            btpresencaaula2.setVisibility(View.VISIBLE);
                            btfaltaaula2.setVisibility(View.VISIBLE);
                        }
                    }
                }
                if (aula3 != null) {
                    if (horaatual.isAfter(aula3) && horaatual.isBefore(aula3.plusHours(2))) {
                        if (checkInAula.getCheckaula3() != 1) {
                            btpresencaaula3.setVisibility(View.VISIBLE);
                            btfaltaaula3.setVisibility(View.VISIBLE);
                        }
                    }
                }
                if (aula4 != null) {
                    if (horaatual.isAfter(aula4) && horaatual.isBefore(aula4.plusHours(1))) {
                        if (checkInAula.getCheckaula4() != 1) {
                            btpresencaaula4.setVisibility(View.VISIBLE);
                            btfaltaaula4.setVisibility(View.VISIBLE);
                        }
                    }
                }
                if (aula5 != null) {
                    if (horaatual.isAfter(aula5) && horaatual.isBefore(aula5.plusHours(1))) {
                        if (checkInAula.getCheckaula5() != 1) {
                            btpresencaaula5.setVisibility(View.VISIBLE);
                            btfaltaaula5.setVisibility(View.VISIBLE);
                        }
                    }
                }
                if (aula6 != null){
                    if (horaatual.isAfter(aula6) && horaatual.isBefore(aula6.plusHours(1))) {
                        if (checkInAula.getCheckaula6() != 1) {
                            btpresencaaula6.setVisibility(View.VISIBLE);
                            btfaltaaula6.setVisibility(View.VISIBLE);
                        }
                    }
                }

                if(horaatual.isAfter(aula1.plusHours(5))) {

                    checkInAula.setCheckaula1(0);
                    checkInAula.setCheckaula2(0);
                    checkInAula.setCheckaula3(0);
                    checkInAula.setCheckaula4(0);
                    checkInAula.setCheckaula5(0);
                    checkInAula.setCheckaula6(0);

                    daoCheckInAula.alteraCheckInAula(checkInAula);
                    daoCheckInAula.close();
                    //----------------------------------------------------------------------------------
                    btpresencaaula1.setVisibility(View.GONE);
                    btpresencaaula2.setVisibility(View.GONE);
                    btpresencaaula3.setVisibility(View.GONE);
                    btpresencaaula4.setVisibility(View.GONE);
                    btpresencaaula5.setVisibility(View.GONE);
                    btpresencaaula6.setVisibility(View.GONE);
                    btfaltaaula1.setVisibility(View.GONE);
                    btfaltaaula2.setVisibility(View.GONE);
                    btfaltaaula3.setVisibility(View.GONE);
                    btfaltaaula4.setVisibility(View.GONE);
                    btfaltaaula5.setVisibility(View.GONE);
                    btfaltaaula6.setVisibility(View.GONE);
                    btfaltastodas.setVisibility(View.GONE);
                }
            }
        }
        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //-----------------------------------------------------------------------------------------

        carregatela();

        layoutFrag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                int action = event.getActionMasked();

                switch (action) {

                    case MotionEvent.ACTION_DOWN:
                        initialX = event.getX();
                        initialY = event.getY();

                    case MotionEvent.ACTION_UP:
                        float finalX = event.getX();
                        float finalY = event.getY();

                        if (initialX < finalX) {

                            if(escolhas > 1 && escolhas <= 5) {
                                escolhas--;
                                if (escolhas == 1){
                                    diasdasemana.setSelectedItemId(R.id.action_segunda);

                                }else if (escolhas == 2){
                                    diasdasemana.setSelectedItemId(R.id.action_terca);

                                }else if (escolhas == 3){
                                    diasdasemana.setSelectedItemId(R.id.action_quarta);

                                }else if (escolhas == 4){
                                    diasdasemana.setSelectedItemId(R.id.action_quinta);

                                }else if (escolhas == 5){
                                    diasdasemana.setSelectedItemId(R.id.action_sexta);

                                }
                            }
                        }

                        if (initialX > finalX) {
                            if(escolhas >= 1 && escolhas < 5) {
                                escolhas++;
                                if (escolhas == 1){
                                    diasdasemana.setSelectedItemId(R.id.action_segunda);

                                }else if (escolhas == 2){
                                    diasdasemana.setSelectedItemId(R.id.action_terca);

                                }else if (escolhas == 3){
                                    diasdasemana.setSelectedItemId(R.id.action_quarta);

                                }else if (escolhas == 4){
                                    diasdasemana.setSelectedItemId(R.id.action_quinta);

                                }else if (escolhas == 5){
                                    diasdasemana.setSelectedItemId(R.id.action_sexta);
                                }

                            }
                        }

                        break;
                }

                return true;
            }
        });

    }

    @Override
    protected void onResume() {

        carregatela();

        super.onResume();
    }


    public void carregatela(){
        final Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(new Date());
        final int valor = cal.get(Calendar.DAY_OF_WEEK);
        if (valor == 2){
            escolhas = 1;
            diasdasemana.setSelectedItemId(R.id.action_segunda);

        }else if (valor == 3){
            escolhas = 2;
            diasdasemana.setSelectedItemId(R.id.action_terca);

        }else if (valor == 4){
            escolhas = 3;
            diasdasemana.setSelectedItemId(R.id.action_quarta);

        }else if (valor == 5){
            escolhas = 4;
            diasdasemana.setSelectedItemId(R.id.action_quinta);

        }else if (valor == 6){
            escolhas = 5;
            diasdasemana.setSelectedItemId(R.id.action_sexta);

        }else {
            escolhas = 5;
            diasdasemana.setSelectedItemId(R.id.action_sexta);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(Principal.this, Sobre.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.btsegunda) {
            segunda = segDAO.buscarSegunda();
            String aux = String.valueOf(segunda.getId());
            Log.i("Aux: ",""+aux);
            if (aux.equals("0")){
                int select = 1;
                Intent i = new Intent(Principal.this, SegundaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }else {
                int select = 0;
                Intent i = new Intent(Principal.this, SegundaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }

        } else if (id == R.id.btterca) {
            terca = terDAO.buscarTerca();
            String aux = String.valueOf(terca.getId());
            if (aux.equals("0")){
                int select = 1;
                Intent i = new Intent(Principal.this, TercaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }else {
                int select = 0;
                Intent i = new Intent(Principal.this, TercaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }

        } else if (id == R.id.btquarta) {
            quarta = quarDAO.buscarQuarta();
            String aux = String.valueOf(quarta.getId());
            if (aux.equals("0")){
                int select = 1;
                Intent i = new Intent(Principal.this, QuartaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }else {
                int select = 0;
                Intent i = new Intent(Principal.this, QuartaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }

        } else if (id == R.id.btquinta) {
            quinta = quinDAO.buscarQuinta();
            String aux = String.valueOf(quinta.getId());
            if (aux.equals("0")){
                int select = 1;
                Intent i = new Intent(Principal.this, QuintaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }else {
                int select = 0;
                Intent i = new Intent(Principal.this, QuintaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }

        } else if (id == R.id.btsexta) {
            sexta = sexDAO.buscarSexta();
            String aux = String.valueOf(sexta.getId());
            if (aux.equals("0")){
                int select = 1;
                Intent i = new Intent(Principal.this, SextaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }else {
                int select = 0;
                Intent i = new Intent(Principal.this, SextaView.class);
                i.putExtra("select", select);
                startActivity(i);
            }

        }if (id == R.id.action_segunda) {
            final Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(new Date());
            final int valor = cal.get(Calendar.DAY_OF_WEEK);
            if (valor != 2){
                escolhas = 1;
                btpresencaaula1.setVisibility(View.GONE);
                btpresencaaula2.setVisibility(View.GONE);
                btpresencaaula3.setVisibility(View.GONE);
                btpresencaaula4.setVisibility(View.GONE);
                btpresencaaula5.setVisibility(View.GONE);
                btpresencaaula6.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltaaula2.setVisibility(View.GONE);
                btfaltaaula3.setVisibility(View.GONE);
                btfaltaaula4.setVisibility(View.GONE);
                btfaltaaula5.setVisibility(View.GONE);
                btfaltaaula6.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
            }
            segunda = segDAO.buscarSegunda();
            horario = daoHorario.buscarHorario();
            txtPrin.setText("Segunda-Feira");
            txthorario1.setText(horario.getHorario1());
            txthorario2.setText(horario.getHorario2());
            txthorario3.setText(horario.getHorario3());
            txthorario4.setText(horario.getHorario4());
            txthorario5.setText(horario.getHorario5());
            txthorario6.setText(horario.getHorario6());
            txtaula1.setText(daoMat.buscarMateria(segunda.getAula1()).getNome());
            txtaula2.setText( daoMat.buscarMateria(segunda.getAula2()).getNome());
            txtaula3.setText( daoMat.buscarMateria(segunda.getAula3()).getNome());
            txtaula4.setText( daoMat.buscarMateria(segunda.getAula4()).getNome());
            txtaula5.setText( daoMat.buscarMateria(segunda.getAula5()).getNome());
            txtaula6.setText( daoMat.buscarMateria(segunda.getAula6()).getNome());


        } else if (id == R.id.action_terca) {
            final Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(new Date());
            final int valor = cal.get(Calendar.DAY_OF_WEEK);
            if (valor != 3){
                escolhas = 2;
                btpresencaaula1.setVisibility(View.GONE);
                btpresencaaula2.setVisibility(View.GONE);
                btpresencaaula3.setVisibility(View.GONE);
                btpresencaaula4.setVisibility(View.GONE);
                btpresencaaula5.setVisibility(View.GONE);
                btpresencaaula6.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltaaula2.setVisibility(View.GONE);
                btfaltaaula3.setVisibility(View.GONE);
                btfaltaaula4.setVisibility(View.GONE);
                btfaltaaula5.setVisibility(View.GONE);
                btfaltaaula6.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
            }
            terca = terDAO.buscarTerca();
            horario = daoHorario.buscarHorario();
            txtPrin.setText("Terça-Feira");
            txthorario1.setText(horario.getHorario1());
            txthorario2.setText(horario.getHorario2());
            txthorario3.setText(horario.getHorario3());
            txthorario4.setText(horario.getHorario4());
            txthorario5.setText(horario.getHorario5());
            txthorario6.setText(horario.getHorario6());
            txtaula1.setText(daoMat.buscarMateria(terca.getAula1()).getNome());
            txtaula2.setText( daoMat.buscarMateria(terca.getAula2()).getNome());
            txtaula3.setText( daoMat.buscarMateria(terca.getAula3()).getNome());
            txtaula4.setText( daoMat.buscarMateria(terca.getAula4()).getNome());
            txtaula5.setText( daoMat.buscarMateria(terca.getAula5()).getNome());
            txtaula6.setText( daoMat.buscarMateria(terca.getAula6()).getNome());


        } else if (id == R.id.action_quarta) {
            final Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(new Date());
            final int valor = cal.get(Calendar.DAY_OF_WEEK);
            if (valor != 4){
                escolhas = 3;
                btpresencaaula1.setVisibility(View.GONE);
                btpresencaaula2.setVisibility(View.GONE);
                btpresencaaula3.setVisibility(View.GONE);
                btpresencaaula4.setVisibility(View.GONE);
                btpresencaaula5.setVisibility(View.GONE);
                btpresencaaula6.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltaaula2.setVisibility(View.GONE);
                btfaltaaula3.setVisibility(View.GONE);
                btfaltaaula4.setVisibility(View.GONE);
                btfaltaaula5.setVisibility(View.GONE);
                btfaltaaula6.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
            }
            quarta = quarDAO.buscarQuarta();
            horario = daoHorario.buscarHorario();
            txtPrin.setText("Quarta-Feira");
            txthorario1.setText(horario.getHorario1());
            txthorario2.setText(horario.getHorario2());
            txthorario3.setText(horario.getHorario3());
            txthorario4.setText(horario.getHorario4());
            txthorario5.setText(horario.getHorario5());
            txthorario6.setText(horario.getHorario6());
            txtaula1.setText(daoMat.buscarMateria(quarta.getAula1()).getNome());
            txtaula2.setText( daoMat.buscarMateria(quarta.getAula2()).getNome());
            txtaula3.setText( daoMat.buscarMateria(quarta.getAula3()).getNome());
            txtaula4.setText( daoMat.buscarMateria(quarta.getAula4()).getNome());
            txtaula5.setText( daoMat.buscarMateria(quarta.getAula5()).getNome());
            txtaula6.setText( daoMat.buscarMateria(quarta.getAula6()).getNome());

        } else if (id == R.id.action_quinta) {
            final Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(new Date());
            final int valor = cal.get(Calendar.DAY_OF_WEEK);
            if (valor != 5){
                escolhas = 4;
                btpresencaaula1.setVisibility(View.GONE);
                btpresencaaula2.setVisibility(View.GONE);
                btpresencaaula3.setVisibility(View.GONE);
                btpresencaaula4.setVisibility(View.GONE);
                btpresencaaula5.setVisibility(View.GONE);
                btpresencaaula6.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltaaula2.setVisibility(View.GONE);
                btfaltaaula3.setVisibility(View.GONE);
                btfaltaaula4.setVisibility(View.GONE);
                btfaltaaula5.setVisibility(View.GONE);
                btfaltaaula6.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
            }
            quinta = quinDAO.buscarQuinta();
            horario = daoHorario.buscarHorario();
            txtPrin.setText("Quinta-Feira");
            txthorario1.setText(horario.getHorario1());
            txthorario2.setText(horario.getHorario2());
            txthorario3.setText(horario.getHorario3());
            txthorario4.setText(horario.getHorario4());
            txthorario5.setText(horario.getHorario5());
            txthorario6.setText(horario.getHorario6());
            txtaula1.setText(daoMat.buscarMateria(quinta.getAula1()).getNome());
            txtaula2.setText( daoMat.buscarMateria(quinta.getAula2()).getNome());
            txtaula3.setText( daoMat.buscarMateria(quinta.getAula3()).getNome());
            txtaula4.setText( daoMat.buscarMateria(quinta.getAula4()).getNome());
            txtaula5.setText( daoMat.buscarMateria(quinta.getAula5()).getNome());
            txtaula6.setText( daoMat.buscarMateria(quinta.getAula6()).getNome());


        } else if (id == R.id.action_sexta) {
            final Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(new Date());
            final int valor = cal.get(Calendar.DAY_OF_WEEK);
            if (valor != 6){
                escolhas = 5;
                btpresencaaula1.setVisibility(View.GONE);
                btpresencaaula2.setVisibility(View.GONE);
                btpresencaaula3.setVisibility(View.GONE);
                btpresencaaula4.setVisibility(View.GONE);
                btpresencaaula5.setVisibility(View.GONE);
                btpresencaaula6.setVisibility(View.GONE);
                btfaltaaula1.setVisibility(View.GONE);
                btfaltaaula2.setVisibility(View.GONE);
                btfaltaaula3.setVisibility(View.GONE);
                btfaltaaula4.setVisibility(View.GONE);
                btfaltaaula5.setVisibility(View.GONE);
                btfaltaaula6.setVisibility(View.GONE);
                btfaltastodas.setVisibility(View.GONE);
            }
            sexta = sexDAO.buscarSexta();
            horario = daoHorario.buscarHorario();
            txtPrin.setText("Sexta-Feira");
            txthorario1.setText(horario.getHorario1());
            txthorario2.setText(horario.getHorario2());
            txthorario3.setText(horario.getHorario3());
            txthorario4.setText(horario.getHorario4());
            txthorario5.setText(horario.getHorario5());
            txthorario6.setText(horario.getHorario6());
            txtaula1.setText(daoMat.buscarMateria(sexta.getAula1()).getNome());
            txtaula2.setText( daoMat.buscarMateria(sexta.getAula2()).getNome());
            txtaula3.setText( daoMat.buscarMateria(sexta.getAula3()).getNome());
            txtaula4.setText( daoMat.buscarMateria(sexta.getAula4()).getNome());
            txtaula5.setText( daoMat.buscarMateria(sexta.getAula5()).getNome());
            txtaula6.setText( daoMat.buscarMateria(sexta.getAula6()).getNome());

        }else if (id == R.id.btlistmaterias){
            Intent i = new Intent(Principal.this, ListaMateria.class);
            startActivity(i);
        }else if (id == R.id.btlistfaltas){
            Intent i = new Intent(Principal.this, ListaFaltas.class);
            startActivity(i);
        }else if (id == R.id.btcadastromat){
            Intent i = new Intent(Principal.this, MateriaView.class);
            startActivity(i);
        }else if (id == R.id.bthorarios){
            horario = daoHorario.buscarHorario();
            String aux = String.valueOf(horario.getId());
            if (aux.equals("0")){
                int select = 1;
                Intent i = new Intent(Principal.this, HorarioView.class);
                i.putExtra("select", select);
                startActivity(i);
            }else {
                int select = 0;
                Intent i = new Intent(Principal.this, HorarioView.class);
                i.putExtra("select", select);
                startActivity(i);
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
