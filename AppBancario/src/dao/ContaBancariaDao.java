package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.ContaBancaria;

public class ContaBancariaDao {
	
	public static ContaBancaria incluir(ContaBancaria cb) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
					"INSERT into TContaBancaria (agencia, numConta, saldo) values (?,?,?)",
					Statement.RETURN_GENERATED_KEYS
					);

			ps.setString(1, cb.getAgencia());
			ps.setString(2, cb.getNumConta());
			ps.setFloat(3, cb.getSaldo());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				cb.setId(rs.getInt(1));
			}
			
			return cb;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<ContaBancaria> obterLista(){
		List<ContaBancaria> lista = new ArrayList<ContaBancaria>();
		
		lista.addAll(ContaCorrenteDao.obterLista());
		lista.addAll(ContaPoupancaDao.obterLista());
		lista.addAll(InvestimentoDao.obterLista());
		
		return lista;
	}
}
