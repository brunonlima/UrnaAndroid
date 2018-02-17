package edu.fatec.urna.dao;

import java.sql.SQLException;
import java.util.List;

import android.widget.SimpleCursorAdapter;

import edu.fatec.urna.entidades.Candidato;
import edu.fatec.urna.entidades.Eleitor;



public class FuncionarioDAO implements DAO{

	@Override
	public boolean inserir(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleCursorAdapter pesquisarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List vencedor() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleitor pesquisarPorTitulo(String Titulo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidato pesquisarPorNumero(int numero) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
