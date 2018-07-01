package com.example.jhonatashenrique.aulas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.jhonatashenrique.aulas.DAO.CheckInAulaDAO;
import com.example.jhonatashenrique.aulas.Domain.CheckInAula;

public class Sobre extends AppCompatActivity {

    TextView info;
    CheckInAulaDAO daoCheckin;
    CheckInAula checkInAula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

        info = findViewById(R.id.info);
        daoCheckin = new CheckInAulaDAO(this);
        checkInAula = new CheckInAula();

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInAula = daoCheckin.buscarCheckInAula();
                info.setText("A1: "+checkInAula.getCheckaula1() +" A2: "+checkInAula.getCheckaula2() +
                        " A3: "+checkInAula.getCheckaula3() +" A4: "+checkInAula.getCheckaula4() +
                        " A5: "+checkInAula.getCheckaula5() +" A6: "+checkInAula.getCheckaula6());

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
}
