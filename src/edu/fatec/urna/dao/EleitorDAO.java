package edu.fatec.urna.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.SimpleCursorAdapter;

import edu.fatec.urna.entidades.Candidato;
import edu.fatec.urna.entidades.Eleitor;

import edu.fatec.urna.R;
import edu.fatec.urna.R.layout;


public class EleitorDAO extends SQLiteOpenHelper implements DAO {

	private  SQLiteDatabase db   ; 
	private static final String TABELA = "Eleitor";
	private static final int VERSION = 1;
	private Context ctx;
	
	
	public  EleitorDAO(Context context){
		
		super(context,TABELA, null,VERSION);
		this.ctx=context; 
		db = context.openOrCreateDatabase("election.db",
				Context.MODE_PRIVATE, null);
		this.onCreate(db);
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		this.setDb(db);		
		StringBuilder sqlEleitores = new StringBuilder();
		sqlEleitores.append("CREATE TABLE IF NOT EXISTS " +TABELA+"(");
		sqlEleitores.append("_id INTEGER PRIMARY KEY AUTOINCREMENT ,");
		sqlEleitores.append("confirmacao INT,");
		sqlEleitores.append("nome VARCHAR(100),");	
		sqlEleitores.append("titulo VARCHAR(20));");	
		this.getDb().execSQL(sqlEleitores.toString());
	    
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + EleitorDAO.TABELA);
	      this.onCreate(db);
		
	}
	
	
	@Override
	public boolean inserir(Object obj) throws SQLException {
		 Eleitor eleitor;
		if(obj instanceof Eleitor){
		   eleitor =(Eleitor) obj;	
		 ContentValues valores = new ContentValues(); 
		 valores.put("confirmacao", eleitor.getConfirmacao());
	      valores.put("nome", eleitor.getNome());
	      valores.put("titulo", eleitor.getTitulo());
	     if( this.getDb().insert(TABELA, "id", valores) > 0)
	      return true;
	      
	     this.getDb().close();
	      }
		else
			this.getDb().close();
	    	  return false;
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
		 Eleitor eleitor;
			if(obj instanceof Eleitor){
			   eleitor =(Eleitor) obj;			   
		      getWritableDatabase().delete(TABELA,"_id=?", new String[]{String.valueOf(id)});
		      	           
		      }
		
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
		Eleitor eleitor;
		if(obj instanceof Eleitor){
		   eleitor =(Eleitor) obj;	
		
		 ContentValues valores = new ContentValues();
	      valores.put("confirmacao", eleitor.getConfirmacao());
	      valores.put("nome", eleitor.getNome());
	      valores.put("titulo", eleitor.getTitulo());
	   
	      getWritableDatabase().update(TABELA, valores,"_id=?", new String[]{String.valueOf(id)});
	      	      
	      }
		
	}
		
	

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public SimpleCursorAdapter pesquisarTodos() throws SQLException {
		 String[] from={"_id","nome","titulo"};
//		Cursor c =this.getDb().query(TABELA,from, null, null, null, null, null, null);		
		int[] to ={R.id.txvID,R.id.txvNome,R.id.txvTitulo};
		 Cursor c = db.rawQuery("Select * FROM eleitor", null);
	
	int i =R.layout.consultaeleitor;
		
		android.widget.SimpleCursorAdapter ad = new SimpleCursorAdapter(ctx, i, c, from, to, 0);

		List<Eleitor> lista = new ArrayList<Eleitor>();
	      while(c.moveToNext()){
	          Eleitor e = new Eleitor();
	          e.setId(c.getInt(0));
	          e.setNome(c.getString(1));
	          e.setTitulo(c.getString(2));
	         
	          lista .add(e);
	      }
	  c.close();
	 
	 return ad;
		
	}

	@Override
	public List vencedor() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleitor pesquisarPorTitulo(String Titulo)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidato pesquisarPorNumero(int numero)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public SQLiteDatabase getDb() {
		return db;
	}

	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	

	
	

}
