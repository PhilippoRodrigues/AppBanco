package br.com.philippo.wallet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.philippo.wallet.conexao.Conexao;
import br.com.philippo.wallet.negocio.Titular;

public class TitularDao {

	private static String sql = "SELECT * FROM TTitular ORDER BY nome";
	private static String sqlId = "SELECT * FROM TTitular WHERE id = ?";

	public static Titular obterPorId(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sqlId);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Titular(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("nomeBanco"),
						rs.getString("dataAberturaConta"), 
						DocumentacaoDao.obterPorId(rs.getInt("idDocumentacao")),
						ContaBancariaDao.obterListaPorTitular(rs.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static boolean realizarCadastroConta(int idTitular, int idContaBancaria) {
		try {
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO TTitularCB (idTitular, idContaBancaria) VALUES (?,?)");

			ps.setInt(1, idTitular);
			ps.setInt(2, idContaBancaria);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	public static Titular associarDocumentacao(Titular titular) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("UPDATE TTitular SET idDocumentacao = ? WHERE id = ?");

			ps.setInt(1, titular.getDocumentacao().getId());
			ps.setInt(2, titular.getId());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return titular;
	}

	public static Titular incluir(Titular titular) {
		try {

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TTitular (nome, nomeBanco, dataAberturaConta) values (?,?,?)");

			ps.setString(1, titular.getNome());
			ps.setString(2, titular.getNomeBanco());
			ps.setString(3, titular.getDataAberturaConta());

			ps.execute();

			return titular;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Titular> obterLista() {

		List<Titular> lista = new ArrayList<Titular>();

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Titular(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("nomeBanco"),
						rs.getString("dataAberturaConta"),
						DocumentacaoDao.obterPorId(rs.getInt("idDocumentacao")),
						ContaBancariaDao.obterListaPorTitular(rs.getInt("id"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	private static boolean cancelarTitular(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TTitular WHERE id = ?"
						);

			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	public static boolean excluir(int idTitular) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TTitularCB WHERE idTitular = ?");

			ps.setInt(1, idTitular);

			ps.execute();
			
			TitularDao.cancelarTitular(idTitular);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
