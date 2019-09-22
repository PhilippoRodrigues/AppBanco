package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Titular;

public class TitularDao {

	public static Titular incluir(Titular titular) {
		try {

			TitularDao.incluir(titular);

			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"INSERT into TTitular (id, nome, nomeBanco, " + "dataAberturaConta) VALUES (?,?,?,?)");

			ps.setInt(1, titular.getId());
			ps.setString(2, titular.getNome());
			ps.setString(3, titular.getNomeBanco());
			ps.setString(4, titular.getDataAberturaConta());

			ps.execute();

			return titular;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Titular> obterLista() {

		String sql = "SELECT * FROM TTitular  ORDER BY nome";

		List<Titular> lista = new ArrayList<Titular>();

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(
						new Titular(
								rs.getInt("id"), 
								rs.getString("nome"), 
								rs.getString("nomeBanco"),
								rs.getString("dataAberturaConta")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
