package model;

//CLASSE DE TESTE DA CONEXÃO COM DB
public class test {

	public static void main(String[] args) {
		DBConnection.conectDB();
		DBTables.criarTabelaFuncionarios();
		DBTables.criarTabelaEstacoes();
		DBTables.criarTabelaReservas();
	}

}
