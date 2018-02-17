package edu.fatec.urna.activity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.fatec.urna.R;
import edu.fatec.urna.dao.DAO;
import edu.fatec.urna.dao.EleitorDAO;
import edu.fatec.urna.entidades.Eleitor;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class FuncionarioACT extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.funcionario);

	}

	public void cadastrarEleitorClick(View v) {
		setContentView(R.layout.cadastroeleitor);
	
	}
	
	public void cadastroEleitorClick(View v) {
		EditText txtNome = (EditText) findViewById(R.id.txtNome);
		EditText txtTitulo = (EditText) findViewById(R.id.txtTitulo);

		if (txtNome.getText().toString().length() <= 0) {
			txtNome.setError("Preencha o campo nome.");
			txtNome.requestFocus();
		} else if (txtTitulo.getText().toString().length() <= 0) {
			txtTitulo.setError("Preencha o campo Titulo.");
			txtTitulo.requestFocus();
		} else {

			try {
				Eleitor e = new Eleitor();
				e.setConfirmacao(0);
				e.setNome(txtNome.getText().toString());
				e.setTitulo(txtTitulo.getText().toString());
				EleitorDAO edao = new EleitorDAO(this.getBaseContext());
				boolean atualizado =edao.inserir(e);
				if(atualizado == true){
					Toast.makeText(getBaseContext(),"Sucesso ao cadastrar eleitor."
				   			, Toast.LENGTH_SHORT).show();
				    	
				     } else{
					      Toast.makeText(getBaseContext(),"Erro ao cadastrar eleitor!"
							, Toast.LENGTH_SHORT).show();
					      finish();
					    }			
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void consultarEleitorClick(View v) {

		setContentView(R.layout.consultaeleitor_listar);
	//	 int[] to ={R.id.txvID,R.id.txvNome};
		 EleitorDAO edao = new EleitorDAO(this.getBaseContext());
		
		 try {
			 
			try {
				SimpleCursorAdapter ad = edao.pesquisarTodos();
			
			 ListView ltwDados = (ListView)findViewById(R.id.ltwDados);
			    
			    ltwDados.setAdapter(ad);
		
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		 } catch (NullPointerException e) {
			e.printStackTrace();
		 }
		
	}

}
