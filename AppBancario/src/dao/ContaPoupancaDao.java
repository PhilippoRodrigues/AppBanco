package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.ContaBancaria;
import negocio.ContaPoupanca;

public class ContaPoupancaDao {
	
	private static String sql = "SELECT * FROM TCONTAPOUPANCA CP INNER JOIN TCONTABANCARIA CB ON CB.ID = CP.IDCONTABANCARIA ";
	private static String sqlNome = "SELECT * FROM  TCONTABANCARIA CB INNER JOIN TCONTAPOUPANCA CP ON CB.ID = CP.IDCONTABANCARIA LEFT JOIN TTITULARCB T ON CB.ID = T.IDCONTABANCARIA ";


	public static ContaPoupanca obterPorId(int id) {

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql + "WHERE CB.ID = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new ContaPoupanca(
						rs.getInt("idContaBancaria"), 
						rs.getString("agencia"),
						rs.getString("numConta"),
						rs.getFloat("saldo"),
						rs.getFloat("rendimentos"),
						rs.getFloat("resgate"),
						rs.getString("depositoInicial"),
						rs.getFloat("total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static boolean incluir(ContaPoupanca cp) {
		try {

			ContaBancaria cb =ContaBancariaDao.incluir(cp);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TContaPoupanca (idContaBancaria, rendimentos, resgate, "
							+ "depositoInicial, total) values (?,?,?,?,?)");

			ps.setInt(1, cb.getId());
			ps.setFloat(2, cp.getTaxaRendimentos());
			ps.setFloat(3, cp.getResgate());
			ps.setString(4, cp.getDepositoInicial());
			ps.setFloat(5, cp.getTotal());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public static List<ContaPoupanca> obterLista(String nome) {

		List<ContaPoupanca> lista = new ArrayList<ContaPoupanca>();

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sqlNome);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) { 		// WHILE: quando quer pegar uma lista
										// IF: quando quer pegar um objeto somente
				lista.add(new ContaPoupanca(
						rs.getInt("idContaBancaria"), 
						rs.getString("agencia"),
						rs.getString("numConta"), 
						rs.getFloat("saldo"), 
						rs.getFloat("rendimentos"),
						rs.getFloat("resgate"),
						rs.getString("depositoInicial"),
						rs.getFloat("total")

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static List<ContaPoupanca> obterLista() {
		List<ContaPoupanca> lista = new ArrayList<ContaPoupanca>();
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement((sql + "ORDER BY CB.AGENCIA"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(
						new ContaPoupanca(
								rs.getInt("idContaBancaria"), 
								rs.getString("agencia"), 
								rs.getString("numConta"),
								rs.getFloat("saldo"), 
								rs.getFloat("rendimentos"),
								rs.getFloat("resgate"), 
								rs.getString("depositoInicial"),
								rs.getFloat("total")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static boolean excluir(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TContaPoupanca WHERE idContaBancaria = ?"
						);

			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
}
