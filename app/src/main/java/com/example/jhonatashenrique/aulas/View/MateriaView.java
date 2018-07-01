package com.example.jhonatashenrique.aulas.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.jhonatashenrique.aulas.DAO.CheckInAulaDAO;
import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;
import com.example.jhonatashenrique.aulas.Domain.CheckInAula;
import com.example.jhonatashenrique.aulas.Domain.Materia;
import com.example.jhonatashenrique.aulas.Principal;
import com.example.jhonatashenrique.aulas.R;

import java.util.List;

public class MateriaView extends AppCompatActivity {

    EditText txtnomemat;
    ListView listmat;
    FloatingActionButton btsalvarmat, bteditarmat;
    Materia materia;
    CheckInAula checkInAula;
    CheckInAulaDAO daoCheckInAula;
    MateriaDAO daoMat;
    List<Materia> listMateria;
    ArrayAdapter adapter;
    long id_mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

        daoMat = new MateriaDAO(this);
        materia = new Materia();
        checkInAula = new CheckInAula();
        daoCheckInAula = new CheckInAulaDAO(this);
        txtnomemat =  findViewById(R.id.txtnomeMat);
        listmat = findViewById(R.id.listMat);
        btsalvarmat = findViewById(R.id.btSalvarMat);
        bteditarmat = findViewById(R.id.btEditarMateria);
        carregaMaterias();

        bteditarmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertaEditar();
            }
        });

        btsalvarmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia.setNome(txtnomemat.getText().toString());

                daoMat.SalvarMeteria(materia);
                daoMat.close();
                carregaMaterias();
                txtnomemat.setText("");

            }
        });

        listmat.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                materia = (Materia) adapter.getItemAtPosition(position);
                return false;
            }
        });
        registerForContextMenu(listmat);

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


    private AlertDialog alerta;

    private void AlertaDelete(final Materia materia) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Excluindo Matéria");
        //define a mensagem
        builder.setMessage("Tem certeza? ");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                daoMat = new MateriaDAO(MateriaView.this);
                daoMat.deletaMateria(materia);
                daoMat.close();

                carregaMaterias();

            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MateriaView.this,"Nenhuma mudança feita!", Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    private void AlertaEditar() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Editando Matéria");
        //define a mensagem
        builder.setMessage("Tem certeza? ");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                materia.setId(id_mat);
                materia.setNome(txtnomemat.getText().toString());

                daoMat.alteraMateria(materia);
                daoMat.close();

                checkInAula.setCheckaula1(0);
                checkInAula.setCheckaula2(0);
                checkInAula.setCheckaula3(0);
                checkInAula.setCheckaula4(0);
                checkInAula.setCheckaula5(0);
                checkInAula.setCheckaula6(0);

                daoCheckInAula.alteraCheckInAula(checkInAula);
                daoCheckInAula.close();

                Toast.makeText(MateriaView.this,"Matéria editada com sucesso", Toast.LENGTH_SHORT).show();
                carregaMaterias();
                btsalvarmat.setVisibility(View.VISIBLE);
                bteditarmat.setVisibility(View.GONE);
                txtnomemat.setText("");

            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MateriaView.this,"Nenhuma mudança feita!", Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    //Metodo para criar uma opcoes na lista
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem mDelete = menu.add("Deletar Matéria");
        mDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertaDelete(materia);


                return true;
            }
        });
        MenuItem mEdit = menu.add("Editar Matéria");
        mEdit.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                txtnomemat.setText(materia.getNome());
                id_mat = materia.getId();
                Log.i("ID ITEM LISTA: ", ""+id_mat);
                btsalvarmat.setVisibility(View.GONE);
                bteditarmat.setVisibility(View.VISIBLE);

                carregaMaterias();

                return true;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void carregaMaterias(){
        daoMat = new MateriaDAO(this);
            listMateria = daoMat.buscarMateria();
            daoMat.close();
            if (listMateria != null) {
                adapter = new ArrayAdapter<Materia>(MateriaView.this, android.R.layout.simple_list_item_1, listMateria);
                listmat.setAdapter(adapter);
            }

    }

}
