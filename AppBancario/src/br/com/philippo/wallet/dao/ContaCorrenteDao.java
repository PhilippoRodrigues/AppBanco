package br.com.philippo.wallet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.philippo.wallet.conexao.Conexao;
import br.com.philippo.wallet.modelo.ContaBancaria;
import br.com.philippo.wallet.negocio.ContaCorrente;

public class ContaCorrenteDao {

	private static String sql = "SELECT * FROM TCONTACORRENTE CC INNER JOIN TCONTABANCARIA CB ON CB.ID = CC.IDCONTABANCARIA ";
	private static String sqlNome = "SELECT * FROM  TCONTABANCARIA CB INNER JOIN TCONTACORRENTE CC ON CB.ID = CC.IDCONTABANCARIA LEFT JOIN TTITULARCB T ON CB.ID = T.IDCONTABANCARIA ";

	public static ContaCorrente obterPorId(int id) {

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql + "WHERE CB.ID = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new ContaCorrente(
						rs.getInt("idContaBancaria"), 
						rs.getString("agencia"),
						rs.getString("numConta"),
						rs.getFloat("saldo"),
						rs.getFloat("contraCheque"),
						rs.getBoolean("chequeEspecial"),
						rs.getFloat("valorChequeEspecial"),
						rs.getBoolean("financiamento"),
						rs.getFloat("valorFinanciamento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean incluir(ContaCorrente cc) {
		try {

			ContaBancaria cb = ContaBancariaDao.incluir(cc);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TContaCorrente ("
							+ "idContaBancaria, "
							+ "contraCheque, "
							+ "chequeEspecial, "
							+ "valorChequeEspecial, "
							+ "financiamento, "
							+ "valorFinanciamento) "
							+ "values (?,?,?,?,?,?)");

			ps.setInt(1, cb.getId());
			ps.setFloat(2, cc.getContraCheque());
			ps.setBoolean(3,cc.getChequeEspecial()); 
			ps.setFloat(4, cc.getValorChequeEspecial());
			ps.setBoolean(5,cc.getFinanciamento());
			ps.setFloat(6, cc.getValorFinanciamento());

			ps.execute();

			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<ContaCorrente> obterLista(String nome) {

		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sqlNome);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) { 		// WHILE: quando quer pegar uma lista
										// IF: quando quer pegar um objeto somente
				lista.add(new ContaCorrente(
						rs.getInt("idContaBancaria"), 
						rs.getString("agencia"),
						rs.getString("numConta"), 
						rs.getFloat("saldo"), 
						rs.getFloat("contraCheque"),
						rs.getBoolean("chequeEspecial"),
						rs.getFloat("valorChequeEspecial"),
						rs.getBoolean("financiamento"),
						rs.getFloat("valorFinanciamento")

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public static List<ContaCorrente> obterLista(){
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql + "ORDER BY CB.AGENCIA");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				lista.add(
						new ContaCorrente(
								rs.getInt("idContaBancaria"), 
								rs.getString("agencia"),
								rs.getString("numConta"), 
								rs.getFloat("saldo"), 
								rs.getFloat("contraCheque"),
								rs.getBoolean("chequeEspecial"),
								rs.getFloat("valorChequeEspecial"),
								rs.getBoolean("financiamento"),
								rs.getFloat("valorFinanciamento"))
					);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	public static boolean excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("DELETE FROM TContaCorrente WHERE idContaBancaria = ?");

			ps.setInt(1, id);

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}