package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Investimento;

public class InvestimentoDao {

	public static Investimento incluir(Investimento inv) {
		try {

			ContaBancariaDao.incluir(inv);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TInvestimento (idContaBancaria, tipo, resgateInv, "
							+ "quantiaInicialInv, impostoResgateInv, "
							+ "taxaRendimentoInv, rendimentosInv) values (?,?,?,?,?,?,?)");

			ps.setInt(1, inv.getId());
			ps.setString(2, inv.getTipo());
			ps.setFloat(3, inv.getResgateInv());
			ps.setFloat(4, inv.getQuantiaInicialInv());
			ps.setFloat(5, inv.getImpostoResgateInv());
			ps.setFloat(6, inv.getTaxaRendimentoInv());
			ps.setFloat(7, inv.getRendimentosInv());

			ps.execute();

			return inv;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private static String sql = "SELECT * FROM TINVESTIMENTO INV INNER JOIN TCONTABANCARIA CB ON CB.ID = INV.IDCONTABANCARIA ";

	public static List<Investimento> obterLista() {
		List<Investimento> lista = new ArrayList<Investimento>();

//		String sql = "SELECT inv.idContaBancaria, inv.tipo, inv.resgateInv, inv.quantiaInicialInv, inv.impostoResgateInv, "
//				+ "inv.taxaRendimentoInv, inv.rendimentosInv, cb.agencia, cb.numConta, cb.saldo " + "FROM "
//				+ " dbinfnet.tinvestimento inv Inner join dbinfnet.tcontabancaria cb on "
//				+ " inv.idContaBancaria = cb.id " + "ORDER BY " + " cb.agencia;";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement((sql + "ORDER BY CB.ID"));
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
								rs.getFloat("rendimentosInv")

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}