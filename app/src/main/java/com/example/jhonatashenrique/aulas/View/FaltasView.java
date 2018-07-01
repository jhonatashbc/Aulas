package com.example.jhonatashenrique.aulas.View;

import android.annotation.SuppressLint;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.jhonatashenrique.aulas.DAO.FaltasDAO;
import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;
import com.example.jhonatashenrique.aulas.Domain.Faltas;
import com.example.jhonatashenrique.aulas.Domain.Materia;
import com.example.jhonatashenrique.aulas.R;

import java.util.List;

public class FaltasView extends AppCompatActivity {

    TextView txtnomemat, txtfaltas, txtpresencas, txtajuste1, txtajuste2, txtajuste3, txtfrequencia;
    EditText txtajustefaltas, txtajustepresencas;
    RadioGroup rescolhaF, rescolhaP;
    RadioButton rescolhaP1, rescolhaP2, rescolhaF1, rescolhaF2;
    FloatingActionButton btsalvarajustefaltas, btsalvarajustepresenca;
    ToggleButton btajuste;
    ListView listfaltas;
    Faltas faltas;
    Materia materia;
    FaltasDAO daoFaltas;
    MateriaDAO daoMat;
    List<Faltas> listaFaltas;
    ArrayAdapter adapter;
    long id_materia;
    int presencatotal, faltatotal, limitecontrole;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltas_view);

        faltas = new Faltas();
        daoFaltas = new FaltasDAO(this);
        materia = new Materia();
        daoMat = new MateriaDAO(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta

// --------------------------------------------------------------------------------------------
        txtnomemat = findViewById(R.id.txtnomeMatFaltas);
        txtfaltas = findViewById(R.id.txtfaltasatuais);
        txtpresencas = findViewById(R.id.txtpresencaatual);
        txtajuste1 = findViewById(R.id.txtajuste1);
        txtajuste2 = findViewById(R.id.txtajuste2);
        txtajuste3 = findViewById(R.id.txtajuste3);
        txtajustefaltas = findViewById(R.id.txtajustefaltas);
        txtajustepresencas = findViewById(R.id.txtajustepresenca);
        txtfrequencia = findViewById(R.id.txtfrequencia);

        rescolhaF = findViewById(R.id.rescolhaF);
        rescolhaP = findViewById(R.id.rescolherP);
        rescolhaP1 = findViewById(R.id.rescolher1P);
        rescolhaP2 = findViewById(R.id.rescolher2P);
        rescolhaF1 = findViewById(R.id.rescolha1F);
        rescolhaF2 = findViewById(R.id.rescolha2F);

        btsalvarajustefaltas = findViewById(R.id.btsalvarajustefaltas);
        btsalvarajustepresenca = findViewById(R.id.btsalvarajustepresenca);

        btajuste = findViewById(R.id.btajuste);
        btajuste.setChecked(false);

        listfaltas = findViewById(R.id.listfaltas);
// --------------------------------------------------------------------------------------------

        Intent intent = getIntent();
        materia = (Materia) intent.getSerializableExtra("materia");

        txtnomemat.setText(""+materia.getNome());
        txtfaltas.setText(( ""+materia.getFalta()));
        txtpresencas.setText(""+materia.getPresenca());

        presencatotal = materia.getPresenca();
        faltatotal = materia.getFalta();
        id_materia = materia.getId();

        if (presencatotal != 0) {
            txtfrequencia.setText("" + (presencatotal * 100) / (presencatotal + faltatotal) + "%");
        }

        btsalvarajustepresenca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertaPresenca();

            }
        });

        btsalvarajustefaltas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertaFaltas();
            }
        });

        btajuste.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    listfaltas.setVisibility(View.GONE);
                    txtajuste1.setVisibility(View.VISIBLE);
                    txtajuste2.setVisibility(View.VISIBLE);
                    txtajuste3.setVisibility(View.VISIBLE);
                    txtajustefaltas.setVisibility(View.VISIBLE);
                    txtajustepresencas.setVisibility(View.VISIBLE);
                    rescolhaF.setVisibility(View.VISIBLE);
                    rescolhaP.setVisibility(View.VISIBLE);
                    rescolhaF1.setVisibility(View.VISIBLE);
                    rescolhaF2.setVisibility(View.VISIBLE);
                    rescolhaP1.setVisibility(View.VISIBLE);
                    rescolhaP2.setVisibility(View.VISIBLE);
                    btsalvarajustefaltas.setVisibility(View.VISIBLE);
                    btsalvarajustepresenca.setVisibility(View.VISIBLE);

                }else {
                    listfaltas.setVisibility(View.VISIBLE);
                    txtajuste1.setVisibility(View.GONE);
                    txtajuste2.setVisibility(View.GONE);
                    txtajuste3.setVisibility(View.GONE);
                    txtajustefaltas.setVisibility(View.GONE);
                    txtajustepresencas.setVisibility(View.GONE);
                    rescolhaF.setVisibility(View.GONE);
                    rescolhaP.setVisibility(View.GONE);
                    rescolhaF1.setVisibility(View.GONE);
                    rescolhaF2.setVisibility(View.GONE);
                    rescolhaP1.setVisibility(View.GONE);
                    rescolhaP2.setVisibility(View.GONE);
                    btsalvarajustefaltas.setVisibility(View.GONE);
                    btsalvarajustepresenca.setVisibility(View.GONE);

                }

            }
        });

        carregaFaltas();

        listfaltas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                faltas = (Faltas) adapter.getItemAtPosition(position);
                return false;
            }
        });

        registerForContextMenu(listfaltas);
    }

    //Metodo para criar uma opcao de delete
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem mDelete = menu.add("Deletar Falta");
        mDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                faltatotal = faltatotal - 1;
                presencatotal = presencatotal + 1;
                materia.setFalta(faltatotal);
                materia.setPresenca(presencatotal);

                daoMat.alteraMateria(materia);
                daoMat.close();

                daoFaltas = new FaltasDAO(FaltasView.this);
                daoFaltas.deletaFaltas(faltas);
                daoFaltas.close();

                txtfaltas.setText(faltatotal);
                txtpresencas.setText(presencatotal);
                if (presencatotal != 0) {
                    txtfrequencia.setText("" + (presencatotal * 100) / (presencatotal + faltatotal) + "%");
                }
                carregaFaltas();


                return true;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
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


    //Dialogo de alerta para fechar conta
    private AlertDialog alerta;

    private void AlertaPresenca() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Atualizando Presença");
        //define a mensagem
        builder.setMessage("Tem certeza? ");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (rescolhaP1.isChecked()){
                    int aux = Integer.parseInt(txtajustepresencas.getText().toString());
                    presencatotal = presencatotal + aux;
                    materia.setPresenca(presencatotal);

                    Log.i("Info Materia: ",""+materia.getId() +"  "+materia.getNome() +"  "+materia.getFalta() +
                    "  "+materia.getPresenca());
                    daoMat.alteraMateria(materia);
                    daoMat.close();

                    txtajustepresencas.setText("");
                    txtpresencas.setText(""+presencatotal);
                    if (presencatotal != 0) {
                        txtfrequencia.setText("" + (presencatotal * 100) / (presencatotal + faltatotal) + "%");
                    }

                }else if (rescolhaP2.isChecked()){
                    int aux = Integer.parseInt(txtajustepresencas.getText().toString());
                        if (presencatotal-aux < 0){
                            Toast.makeText(FaltasView.this,"Limite de ajuste excedido! Nenhum modificação feita.", Toast.LENGTH_SHORT).show();
                            txtpresencas.setText("" + presencatotal);
                        }else{
                            presencatotal = presencatotal - aux;
                            materia.setPresenca(presencatotal);

                            daoMat.alteraMateria(materia);
                            daoMat.close();

                            txtajustepresencas.setText("");
                            txtpresencas.setText("" + presencatotal);
                            if (presencatotal != 0) {
                                txtfrequencia.setText("" + (presencatotal * 100) / (presencatotal + faltatotal) + "%");
                            }
                        }
                }
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(FaltasView.this,"Nenhuma mudança feita!", Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
    private void AlertaFaltas() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Atualizando Faltas");
        //define a mensagem
        builder.setMessage("Tem certeza? ");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (rescolhaF1.isChecked()){
                    int aux = Integer.parseInt(txtajustefaltas.getText().toString());
                    faltatotal = faltatotal + aux;
                    materia.setFalta(faltatotal);

                    daoMat.alteraMateria(materia);
                    daoMat.close();

                    txtajustefaltas.setText("");
                    txtfaltas.setText(""+faltatotal);
                    if (presencatotal != 0) {
                        txtfrequencia.setText("" + (presencatotal * 100) / (presencatotal + faltatotal) + "%");
                    }

                }else if (rescolhaF2.isChecked()){
                    int aux = Integer.parseInt(txtajustefaltas.getText().toString());
                    if (faltatotal-aux < limitecontrole){
                        Toast.makeText(FaltasView.this,"Limite de ajuste excedido! Nenhum modificação feita.", Toast.LENGTH_SHORT).show();
                        txtfaltas.setText("" + faltatotal);
                    }else {
                        faltatotal = faltatotal - aux;
                        materia.setFalta(faltatotal);

                        daoMat.alteraMateria(materia);
                        daoMat.close();

                        txtajustefaltas.setText("");
                        txtfaltas.setText("" + faltatotal);
                        if (presencatotal != 0) {
                            txtfrequencia.setText("" + (presencatotal * 100) / (presencatotal + faltatotal) + "%");
                        }
                    }
                }

            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(FaltasView.this,"Nenhuma mudança feita!", Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    public void carregaFaltas(){
        daoFaltas = new FaltasDAO(this);
        listaFaltas = daoFaltas.buscarFaltas(id_materia);
        daoFaltas.close();
        limitecontrole = listaFaltas.size();
        Log.i("teste","tamanho lista: "+limitecontrole);
        if (listaFaltas != null) {
            adapter = new ArrayAdapter<Faltas>(FaltasView.this, android.R.layout.simple_list_item_1, listaFaltas);
            listfaltas.setAdapter(adapter);
        }

    }


}
