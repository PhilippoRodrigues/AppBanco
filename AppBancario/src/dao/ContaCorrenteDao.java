package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.ContaCorrente;

public class ContaCorrenteDao {

	public static ContaCorrente incluir(ContaCorrente cc) {
		try {

			ContaBancariaDao.incluir(cc);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TContaCorrente (idContaBancaria, contraCheque, "
							+ "chequeEspecial, financiamento) VALUES (?,?,?,?)");

			ps.setInt(1, cc.getId());
			ps.setFloat(2, cc.getContraCheque());
			ps.setBoolean(3, "Sim".equals(cc.getChequeEspecial())); //coloco getChequeEspecial() no construtor da classe Contacorrente?
			ps.setBoolean(4, "Sim".equals(cc.getFinanciamento()));
			

			ps.execute();

			return cc;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private static String sql = "SELECT * FROM TCONTACORRENTE CC INNER JOIN TCONTABANCARIA CB ON CB.ID = CC.IDCONTABANCARIA ";
	
	public static List<ContaCorrente> obterLista() {
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		
//		String sql = "SELECT cc.idContaBancaria, cc.contraCheque, cc.chequeEspecial, cc.financiamento, cb.agencia, cb.numConta, cb.saldo " 
//				+ "FROM "
//				+ " dbinfnet.tcontacorrente cc Inner join dbinfnet.tcontabancaria cb on " 
//				+ " cc.idContaBancaria = cb.id "
//				+ "ORDER BY "
//				+ " cb.agencia;";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement((sql + "ORDER BY CB.ID"));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){ 	//Quando quer pegar uma lista, usar WHILE, quando quer pegar um objeto somente, usar IF
				lista.add(
						new ContaCorrente(
								rs.getInt("idContaBancaria"),
								rs.getString("agencia"),
								rs.getString("numConta"),
								rs.getFloat("saldo"),
								rs.getFloat("contraCheque"),
								rs.getBoolean("chequeEspecial"),
								rs.getBoolean("financiamento")
								
							)
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}