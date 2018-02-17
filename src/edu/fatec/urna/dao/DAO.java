package edu.fatec.urna.dao;

import java.sql.SQLException;
import java.util.List;

import android.widget.SimpleCursorAdapter;

import edu.fatec.urna.entidades.Candidato;
import edu.fatec.urna.entidades.Eleitor;



public interface DAO {
	public boolean inserir( Object obj ) throws SQLException;
	public void remover( long id,Object obj ) throws SQLException;
	public void atualizar(long id, Object obj) throws SQLException ;
	public Object pesquisarPorNome(String nome) throws SQLException;
	public SimpleCursorAdapter pesquisarTodos() throws SQLException;
	public List vencedor() throws SQLException;
	public Eleitor pesquisarPorTitulo(String Titulo)throws SQLException;
	public Candidato pesquisarPorNumero(int numero)throws SQLException;
}
