package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import conexao.Conexao;
import modelo.ContaBancaria;

public class ContaBancariaDao {

	public static ContaBancaria obterPorId(int id) {

		ContaBancaria cb = ContaCorrenteDao.obterPorId(id);

		if (cb == null) {
			cb = ContaPoupancaDao.obterPorId(id);

			if (cb == null) {
				cb = InvestimentoDao.obterPorId(id);
			}
		}

		return cb;
	}

	public static Set<ContaBancaria> obterListaPorTitular(int idTitular) {
		Set<ContaBancaria> lista = new HashSet<ContaBancaria>();

		String sql = "SELECT * FROM TTitularCB where idTitular = ?";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, idTitular);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(obterPorId(rs.getInt("idContaBancaria")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static ContaBancaria incluir(ContaBancaria cb) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"INSERT into TContaBancaria (agencia, numConta, saldo) values (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, cb.getAgencia());
			ps.setString(2, cb.getNumConta());
			ps.setFloat(3, cb.getSaldo());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				cb.setId(rs.getInt(1));
				return cb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static boolean excluir(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TContaBancaria WHERE id = ?"
						);

			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	public static Set<ContaBancaria> obterLista(String nome){
		Set<ContaBancaria> lista = new HashSet<ContaBancaria>();
		
		lista.addAll(ContaCorrenteDao.obterLista(nome));
		lista.addAll(ContaPoupancaDao.obterLista(nome));
		lista.addAll(InvestimentoDao.obterLista(nome));

		return lista;
	}	

	public static Set<ContaBancaria> obterLista() {
		Set<ContaBancaria> lista = new HashSet<ContaBancaria>();

		lista.addAll(ContaCorrenteDao.obterLista());
		lista.addAll(ContaPoupancaDao.obterLista());
		lista.addAll(InvestimentoDao.obterLista());

		return lista;
	}
}
