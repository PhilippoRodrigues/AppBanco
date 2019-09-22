package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.ContaPoupanca;

public class ContaPoupancaDao {

	public static ContaPoupanca incluir(ContaPoupanca cp) {
		try {

			ContaBancariaDao.incluir(cp);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TContaPoupanca (idContaBancaria, rendimentos, resgate, "
							+ "depositoInicial) values (?,?,?,?)");

			ps.setInt(1, cp.getId());
			ps.setFloat(2, cp.getRendimentos());
			ps.setFloat(3, cp.getResgate());
			ps.setString(4, cp.getDepositoInicial());

			ps.execute();

			return cp;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String sql = "SELECT * FROM TCONTAPOUPANCA CP INNER JOIN TCONTABANCARIA CB ON CB.ID = CP.IDCONTABANCARIA ";
	
	public static List<ContaPoupanca> obterLista() {
		List<ContaPoupanca> lista = new ArrayList<ContaPoupanca>();
		
//		String sql = "SELECT cp.idContaBancaria, cp.rendimentos, cp.resgate, cp.depositoInicial, cb.agencia, cb.numConta, cb.saldo " 
//				+ "FROM "
//				+ " dbinfnet.tcontapoupanca cp Inner join dbinfnet.tcontabancaria cb on "
//				+ " cp.idContaBancaria = cb.id " 
//				+ "ORDER BY "
//				+ " cb.agencia;";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement((sql + "ORDER BY CB.ID"));
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
								rs.getString("depositoInicial")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
