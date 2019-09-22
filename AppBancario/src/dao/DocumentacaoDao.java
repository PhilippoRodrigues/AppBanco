package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Documentacao;

public class DocumentacaoDao {

	public static Documentacao incluir(Documentacao doc) {
		try {

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TDocumentacao (rg, cpf, endereco, cep, telefone) values (?,?,?,?,?)");

			ps.setString(1, doc.getRg());
			ps.setString(2, doc.getCpf());
			ps.setString(3, doc.getEndereco());
			ps.setString(4, doc.getCep());
			ps.setString(5, doc.getTelefone());
			

			ps.execute();

			return doc;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Documentacao> obterLista() {
		
		String sql = "SELECT * FROM TDocumentacao ORDER BY id";

		List<Documentacao> lista = new ArrayList<Documentacao>();
		

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				lista.add(
						new Documentacao(
								rs.getInt("id"),
								rs.getString("rg"),
								rs.getString("cpf"),
								rs.getString("endereco"),
								rs.getString("cep"),
								rs.getString("telefone")
							)
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}