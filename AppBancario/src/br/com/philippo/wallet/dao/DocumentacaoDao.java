package br.com.philippo.wallet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.philippo.wallet.conexao.Conexao;
import br.com.philippo.wallet.negocio.Documentacao;

public class DocumentacaoDao {
	
	public static Documentacao obterPorId(int id){
		String sql = "SELECT * FROM TDocumentacao where id = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			 
			if(rs.next()){
				return new Documentacao(
						rs.getInt("id"), 
						rs.getString("rg"), 
						rs.getString("cpf"), 
						rs.getString("endereco"), 
						rs.getString("cep"),
						rs.getString("telefone")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean incluir(Documentacao doc) {
		
		try {

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TDocumentacao (rg, cpf, endereco, cep, telefone) values (?,?,?,?,?)");

			ps.setString(1, doc.getRg());
			ps.setString(2, doc.getCpf());
			ps.setString(3, doc.getEndereco());
			ps.setString(4, doc.getCep());
			ps.setString(5, doc.getTelefone());
			

			ps.execute();

			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Documentacao> obterLista() {

		List<Documentacao> lista = new ArrayList<Documentacao>();
		
		String sql = "SELECT * FROM TDocumentacao ORDER BY cpf";

		

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
	
	public static boolean excluir(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TDocumentacao WHERE id = ?"
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