package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.ContaBancaria;
import negocio.Investimento;

public class InvestimentoDao {
	
	private static String sql = "SELECT * FROM TINVESTIMENTO INV INNER JOIN TCONTABANCARIA CB ON CB.ID = INV.IDCONTABANCARIA ";
	private static String sqlNome = "SELECT * FROM  TCONTABANCARIA CB INNER JOIN TINVESTIMENTO INV ON CB.ID = INV.IDCONTABANCARIA LEFT JOIN TTITULARCB T ON CB.ID = T.IDCONTABANCARIA ";

	
	public static Investimento obterPorId(int id) {

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql + "WHERE CB.ID = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Investimento(
						rs.getInt("idContaBancaria"), 
						rs.getString("agencia"),
						rs.getString("numConta"),
						rs.getFloat("saldo"),
						rs.getString("tipo"),
						rs.getFloat("resgateInv"),
						rs.getFloat("quantiaInicialInv"),
						rs.getFloat("impostoResgateInv"),
						rs.getFloat("taxaRendimentoInv"),
						rs.getFloat("rendimentosInv"),
						rs.getFloat("quantiaFinalInv")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean incluir(Investimento inv) {
		try {

			ContaBancaria cb = ContaBancariaDao.incluir(inv);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TInvestimento ("
							+ "idContaBancaria, "
							+ "tipo, "
							+ "resgateInv, "
							+ "quantiaInicialInv, "
							+ "impostoResgateInv, "
							+ "taxaRendimentoInv, "
							+ "rendimentosInv, "
							+ "quantiaFinalInv)"
							+ "values (?,?,?,?,?,?,?,?)");

			ps.setInt(1, cb.getId());
			ps.setString(2, inv.getTipo());
			ps.setFloat(3, inv.getResgateInv());
			ps.setFloat(4, inv.getQuantiaInicialInv());
			ps.setFloat(5, inv.getImpostoResgateInv());
			ps.setFloat(6, inv.getTaxaRendimentoInv());
			ps.setFloat(7, inv.getRendimentosInv());
			ps.setFloat(8,  inv.getQuantiaFinalInv());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
public static List<Investimento> obterLista(String nome) {
		
		List<Investimento> lista = new ArrayList<Investimento>();

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sqlNome);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(
						new Investimento(
								rs.getInt("idContaBancaria"), 
								rs.getString("agencia"),
								rs.getString("numConta"), 
								rs.getFloat("saldo"), 
								rs.getString("tipo"), 
								rs.getFloat("resgateInv"),
								rs.getFloat("quantiaInicialInv"), 
								rs.getFloat("impostoResgateInv"),
								rs.getFloat("taxaRendimentoInv"), 
								rs.getFloat("rendimentosInv"),
								rs.getFloat("quantiaFinalInv")

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public static List<Investimento> obterLista() {
		
		List<Investimento> lista = new ArrayList<Investimento>();

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement((sql + "ORDER BY CB.AGENCIA"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(
						new Investimento(
								rs.getInt("idContaBancaria"), 
								rs.getString("agencia"),
								rs.getString("numConta"), 
								rs.getFloat("saldo"), 
								rs.getString("tipo"), 
								rs.getFloat("resgateInv"),
								rs.getFloat("quantiaInicialInv"), 
								rs.getFloat("impostoResgateInv"),
								rs.getFloat("taxaRendimentoInv"), 
								rs.getFloat("rendimentosInv"),
								rs.getFloat("quantiaFinalInv")

				));
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
							"DELETE FROM TInvestimento WHERE idContaBancaria = ?"
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