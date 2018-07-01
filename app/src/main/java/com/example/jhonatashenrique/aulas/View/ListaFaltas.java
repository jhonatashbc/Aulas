package com.example.jhonatashenrique.aulas.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jhonatashenrique.aulas.DAO.FaltasDAO;
import com.example.jhonatashenrique.aulas.Domain.Faltas;
import com.example.jhonatashenrique.aulas.R;

import java.util.List;

public class ListaFaltas extends AppCompatActivity {

    ListView listafaltatodas;
    Faltas faltas;
    FaltasDAO daoFaltas;
    List<Faltas> listaFaltas;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_faltas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

        faltas = new Faltas();
        daoFaltas = new FaltasDAO(this);
        listafaltatodas = findViewById(R.id.listfaltastodas);

        carregaFaltas();
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

    public void carregaFaltas(){
        daoFaltas = new FaltasDAO(this);
        listaFaltas = daoFaltas.buscarFaltas();
        daoFaltas.close();
        if (listaFaltas != null) {
            adapter = new ArrayAdapter<Faltas>(ListaFaltas.this, android.R.layout.simple_list_item_1, listaFaltas);
            listafaltatodas.setAdapter(adapter);
        }

    }
}
