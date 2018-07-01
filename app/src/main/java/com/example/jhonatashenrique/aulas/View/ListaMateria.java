package com.example.jhonatashenrique.aulas.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;
import com.example.jhonatashenrique.aulas.Domain.Materia;
import com.example.jhonatashenrique.aulas.R;

import java.util.List;

public class ListaMateria extends AppCompatActivity {

    ListView listresumomat;
    Materia materia;
    MateriaDAO daoMat;
    List<Materia> listMateria;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_materia);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

        listresumomat = findViewById(R.id.listmatresumo);

        listresumomat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                materia = (Materia) adapter.getItemAtPosition(position);

                Intent i = new Intent(ListaMateria.this, FaltasView.class);
                i.putExtra("materia", materia);
                startActivity(i);
            }
        });

        carregaMaterias();

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

    @Override
    protected void onResume() {
        carregaMaterias();
        super.onResume();
    }

    public void carregaMaterias(){
        daoMat = new MateriaDAO(this);
        listMateria = daoMat.buscarMateria();
        daoMat.close();
        if (listMateria != null) {
            adapter = new ArrayAdapter<Materia>(ListaMateria.this, android.R.layout.simple_list_item_1, listMateria);
            listresumomat.setAdapter(adapter);
        }

    }
}
