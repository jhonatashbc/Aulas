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
import android.widget.EditText;
import android.widget.RemoteViews;

import com.example.jhonatashenrique.aulas.DAO.HorarioDAO;
import com.example.jhonatashenrique.aulas.Domain.Horario;
import com.example.jhonatashenrique.aulas.NewAppWidget;
import com.example.jhonatashenrique.aulas.R;

public class HorarioView extends AppCompatActivity {

    EditText txthorario1, txthorario2, txthorario3, txthorario4, txthorario5, txthorario6;
    FloatingActionButton btsalvarhorarios;
    int select;
    Horario horario;
    HorarioDAO daoHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

        Intent intent = getIntent();
        select = (Integer) intent.getSerializableExtra("select");
        Log.i("Teste", "" + select);

        horario = new Horario();
        daoHorario = new HorarioDAO(this);

        txthorario1 = findViewById(R.id.txthorario1main);
        txthorario2 = findViewById(R.id.txthorario2main);
        txthorario3 = findViewById(R.id.txthorario3main);
        txthorario4 = findViewById(R.id.txthorario4main);
        txthorario5 = findViewById(R.id.txthorario5main);
        txthorario6 = findViewById(R.id.txthorario6main);
        btsalvarhorarios = findViewById(R.id.btsalvarhorarios);

        if (select == 0) {
            horario = daoHorario.buscarHorario();
            txthorario1.setText(horario.getHorario1());
            txthorario2.setText(horario.getHorario2());
            txthorario3.setText(horario.getHorario3());
            txthorario4.setText(horario.getHorario4());
            txthorario5.setText(horario.getHorario5());
            txthorario6.setText(horario.getHorario6());

        }

        btsalvarhorarios.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (select == 1) {
                        horario.setHorario1(txthorario1.getText().toString());
                        horario.setHorario2(txthorario2.getText().toString());
                        horario.setHorario3(txthorario3.getText().toString());
                        horario.setHorario4(txthorario4.getText().toString());
                        horario.setHorario5(txthorario5.getText().toString());
                        horario.setHorario6(txthorario6.getText().toString());

                        daoHorario.SalvarHorario(horario);
                        daoHorario.close();

                        ComponentName cn = new ComponentName(HorarioView.this, NewAppWidget.class);
                        RemoteViews views = new RemoteViews("com.example.jhonatashenrique.aulas", R.layout.new_app_widget);
                        AppWidgetManager mgr = AppWidgetManager.getInstance(HorarioView.this);
                        views.setTextViewText(R.id.txthorario1win, horario.getHorario1().toString());
                        views.setTextViewText(R.id.txthorario2win, horario.getHorario2().toString());
                        views.setTextViewText(R.id.txthorario3win, horario.getHorario3().toString());
                        views.setTextViewText(R.id.txthorario4win, horario.getHorario4().toString());
                        views.setTextViewText(R.id.txthorario5win, horario.getHorario5().toString());
                        views.setTextViewText(R.id.txthorario6win, horario.getHorario6().toString());
                        mgr.updateAppWidget(cn, views);
                        finish();
                    } else {
                        horario.setHorario1(txthorario1.getText().toString());
                        horario.setHorario2(txthorario2.getText().toString());
                        horario.setHorario3(txthorario3.getText().toString());
                        horario.setHorario4(txthorario4.getText().toString());
                        horario.setHorario5(txthorario5.getText().toString());
                        horario.setHorario6(txthorario6.getText().toString());

                        daoHorario.alteraHorario(horario);
                        daoHorario.close();

                        ComponentName cn = new ComponentName(HorarioView.this, NewAppWidget.class);
                        RemoteViews views = new RemoteViews("com.example.jhonatashenrique.aulas", R.layout.new_app_widget);
                        AppWidgetManager mgr = AppWidgetManager.getInstance(HorarioView.this);
                        views.setTextViewText(R.id.txthorario1win, horario.getHorario1().toString());
                        views.setTextViewText(R.id.txthorario2win, horario.getHorario2().toString());
                        views.setTextViewText(R.id.txthorario3win, horario.getHorario3().toString());
                        views.setTextViewText(R.id.txthorario4win, horario.getHorario4().toString());
                        views.setTextViewText(R.id.txthorario5win, horario.getHorario5().toString());
                        views.setTextViewText(R.id.txthorario6win, horario.getHorario6().toString());
                        mgr.updateAppWidget(cn, views);
                        finish();
                    }
                }
            }
        );

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
}
