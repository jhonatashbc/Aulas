package com.example.jhonatashenrique.aulas.View;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.jhonatashenrique.aulas.DAO.HorarioDAO;
import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;
import com.example.jhonatashenrique.aulas.DAO.SegundaDAO;
import com.example.jhonatashenrique.aulas.Domain.Horario;
import com.example.jhonatashenrique.aulas.Domain.Materia;
import com.example.jhonatashenrique.aulas.Domain.Segunda;
import com.example.jhonatashenrique.aulas.NewAppWidget;
import com.example.jhonatashenrique.aulas.R;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SegundaView extends AppCompatActivity {

    EditText txthorario1, txthorario2, txthorario3, txthorario4, txthorario5, txthorario6;
    Spinner  txtaula2,txtaula3,txtaula4,txtaula5,txtaula6;
    Spinner txtaula1;
    FloatingActionButton btsalvarsegunda;
    Segunda segunda;
    SegundaDAO segDAO;
    MateriaDAO daoMat;
    List<Materia> listMateria;
    ArrayAdapter adapter, adap;
    Horario horario;
    HorarioDAO daoHorario;

    int valor;

    int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(new Date());
        valor = cal.get(Calendar.DAY_OF_WEEK);

        Intent intent = getIntent();
        select = (Integer) intent.getSerializableExtra("select");
        Log.i("Teste",""+select);

        segunda = new Segunda();
        horario = new Horario();
        daoHorario = new HorarioDAO(this);
        segDAO = new SegundaDAO(SegundaView.this);
        daoMat = new MateriaDAO(this);


        txthorario1 = findViewById(R.id.txthorario1s);
        txthorario2 = findViewById(R.id.txthorario2s);
        txthorario3 = findViewById(R.id.txthorario3s);
        txthorario4 = findViewById(R.id.txthorario4s);
        txthorario5 = findViewById(R.id.txthorario5s);
        txthorario6 = findViewById(R.id.txthorario6s);
        txtaula1 = findViewById(R.id.txtaula1s);
        txtaula2 = findViewById(R.id.txtaula2s);
        txtaula3 = findViewById(R.id.txtaula3s);
        txtaula4 = findViewById(R.id.txtaula4s);
        txtaula5 = findViewById(R.id.txtaula5s);
        txtaula6 = findViewById(R.id.txtaula6s);

        txtaula1.setAdapter(carregaMaterias());
        txtaula2.setAdapter(carregaMaterias());
        txtaula3.setAdapter(carregaMaterias());
        txtaula4.setAdapter(carregaMaterias());
        txtaula5.setAdapter(carregaMaterias());
        txtaula6.setAdapter(carregaMaterias());

        horario = daoHorario.buscarHorario();
        txthorario1.setText(horario.getHorario1());
        txthorario2.setText(horario.getHorario2());
        txthorario3.setText(horario.getHorario3());
        txthorario4.setText(horario.getHorario4());
        txthorario5.setText(horario.getHorario5());
        txthorario6.setText(horario.getHorario6());

        if (select == 0){
            segunda = segDAO.buscarSegunda();

            txtaula1.setSelection(getIndex(txtaula1, (int) segunda.getAula1()));
            txtaula2.setSelection(getIndex(txtaula2, (int) segunda.getAula2()));
            txtaula3.setSelection(getIndex(txtaula3, (int) segunda.getAula3()));
            txtaula4.setSelection(getIndex(txtaula4, (int) segunda.getAula4()));
            txtaula5.setSelection(getIndex(txtaula5, (int) segunda.getAula5()));
            txtaula6.setSelection(getIndex(txtaula6, (int) segunda.getAula6()));
        }

        btsalvarsegunda = findViewById(R.id.btsalvarsegunda);
        btsalvarsegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horario = daoHorario.buscarHorario();
                Materia aula1, aula2, aula3, aula4, aula5, aula6 = new Materia();
                aula1 = (Materia) txtaula1.getSelectedItem();
                aula2 = (Materia) txtaula2.getSelectedItem();
                aula3 = (Materia) txtaula3.getSelectedItem();
                aula4 = (Materia) txtaula4.getSelectedItem();
                aula5 = (Materia) txtaula5.getSelectedItem();
                aula6 = (Materia) txtaula6.getSelectedItem();
                if (select == 1) {
                    segunda.setAula1(aula1.getId());
                    segunda.setAula2(aula2.getId());
                    segunda.setAula3(aula3.getId());
                    segunda.setAula4(aula4.getId());
                    segunda.setAula5(aula5.getId());
                    segunda.setAula6(aula6.getId());

                    segDAO.SalvarSegunda(segunda);
                    segDAO.close();

                    if (valor == 2) {
                        ComponentName cn = new ComponentName(SegundaView.this, NewAppWidget.class);
                        RemoteViews views = new RemoteViews("com.example.jhonatashenrique.aulas", R.layout.new_app_widget);
                        AppWidgetManager mgr = AppWidgetManager.getInstance(SegundaView.this);
                        views.setTextViewText(R.id.txtwin, "Segunda-Feira");
                        views.setTextViewText(R.id.txthorario1win, horario.getHorario1().toString());
                        views.setTextViewText(R.id.txthorario2win, horario.getHorario2().toString());
                        views.setTextViewText(R.id.txthorario3win, horario.getHorario3().toString());
                        views.setTextViewText(R.id.txthorario4win, horario.getHorario4().toString());
                        views.setTextViewText(R.id.txthorario5win, horario.getHorario5().toString());
                        views.setTextViewText(R.id.txthorario6win, horario.getHorario6().toString());
                        views.setTextViewText(R.id.txtaula1win, aula1.getNome());
                        views.setTextViewText(R.id.txtaula2win, aula2.getNome());
                        views.setTextViewText(R.id.txtaula3win, aula3.getNome());
                        views.setTextViewText(R.id.txtaula4win, aula4.getNome());
                        views.setTextViewText(R.id.txtaula5win, aula5.getNome());
                        views.setTextViewText(R.id.txtaula6win, aula6.getNome());
                        mgr.updateAppWidget(cn, views);
                    }

                    finish();
                }else{
                    segunda.setAula1(aula1.getId());
                    segunda.setAula2(aula2.getId());
                    segunda.setAula3(aula3.getId());
                    segunda.setAula4(aula4.getId());
                    segunda.setAula5(aula5.getId());
                    segunda.setAula6(aula6.getId());

                    segDAO.alteraSegunda(segunda);
                    segDAO.close();

                    if (valor == 2) {
                        ComponentName cn = new ComponentName(SegundaView.this, NewAppWidget.class);
                        RemoteViews views = new RemoteViews("com.example.jhonatashenrique.aulas", R.layout.new_app_widget);
                        AppWidgetManager mgr = AppWidgetManager.getInstance(SegundaView.this);
                        views.setTextViewText(R.id.txtwin, "Segunda-Feira");
                        views.setTextViewText(R.id.txthorario1win, horario.getHorario1().toString());
                        views.setTextViewText(R.id.txthorario2win, horario.getHorario2().toString());
                        views.setTextViewText(R.id.txthorario3win, horario.getHorario3().toString());
                        views.setTextViewText(R.id.txthorario4win, horario.getHorario4().toString());
                        views.setTextViewText(R.id.txthorario5win, horario.getHorario5().toString());
                        views.setTextViewText(R.id.txthorario6win, horario.getHorario6().toString());
                        views.setTextViewText(R.id.txtaula1win, aula1.getNome());
                        views.setTextViewText(R.id.txtaula2win, aula2.getNome());
                        views.setTextViewText(R.id.txtaula3win, aula3.getNome());
                        views.setTextViewText(R.id.txtaula4win, aula4.getNome());
                        views.setTextViewText(R.id.txtaula5win, aula5.getNome());
                        views.setTextViewText(R.id.txtaula6win, aula6.getNome());
                        mgr.updateAppWidget(cn, views);
                    }

                    finish();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                onBackPressed();
                break;
            default:break;
        }
        return true;
    }

    private int getIndex(Spinner spinner, long myLong)
    {
        int index = 0;
        Log.i("teste","myString: "+myLong);

        for (int i=0;i<spinner.getCount();i++){
            Materia aux  = Materia.class.cast(spinner.getItemAtPosition(i));
            if (aux.getId() == myLong){
                index = i;
                break;
            }
        }
        return index;
    }

    public ArrayAdapter carregaMaterias(){
        daoMat = new MateriaDAO(this);
        listMateria = daoMat.buscarMateria();
        daoMat.close();
        Materia mat = new Materia();
        mat.setNome("");
        listMateria.add(0, mat);
        if (listMateria != null) {
            adapter = new ArrayAdapter<>(SegundaView.this, android.R.layout.simple_list_item_1, listMateria);
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        }

        return adapter;
    }
}
