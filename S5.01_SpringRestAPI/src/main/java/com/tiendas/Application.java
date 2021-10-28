package com.tiendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// // PARA USAR LA BD H2, DESCOMENTAR
//		template.execute("DROP TABLE IF EXISTS COLLARES;");
//		template.execute("DROP TABLE IF EXISTS TIENDAS;");
//			
//		template.execute("CREATE TABLE TIENDAS (id INTEGER(11) PRIMARY KEY auto_increment, name VARCHAR(255), capacidadMaxima INTEGER(11)) ");
//		template.execute("CREATE TABLE COLLARES (collar_id INTEGER(11) PRIMARY KEY auto_increment, name VARCHAR(255), author VARCHAR(255), price DOUBLE(20), arrival DATETIME not null default(current_timestamp), tienda_id INTEGER(11), FOREIGN KEY (tienda_id) REFERENCES TIENDAS(id) ON DELETE CASCADE) ");
//		
		
		
//		for(int i=1;i<9;i++) {
//			template.update("INSERT INTO TIENDAS (name, capacidadMaxima) VALUES ('Tienda"+i+"', 350) ");
//		}
//		
//		template.update("INSERT INTO COLLARES(name, author, price, arrival, tienda_id) \n"
//				+ "VALUES ( \'Soledad\', null, 2005.3, (CURRENT_TIMESTAMP), 1),\n"
//				+ "( \'Soledad\', null, 2005.3, (CURRENT_TIMESTAMP), 1),\n"
//				+ "( \'Soledad\', \'Picasso\', 1205.2, (CURRENT_TIMESTAMP), 1),\n"
//				+ "( \'Soledad\', \'Van Gogh\', 34005.3, (CURRENT_TIMESTAMP), 1),\n"
//				+ "( \'Reflejos\', null, 5505,(CURRENT_TIMESTAMP), 2),\n"
//				+ "( \'Noche estrellada\', \'Coronado\', 7705, (CURRENT_TIMESTAMP), 2),\n"
//				+ "( \'Los jugadores de cartas\', \'PAUL CÉZANNE\', 10543, (CURRENT_TIMESTAMP), 2),\n"
//				+ "( \'Autorretrato\', \'REMBRANDT VAN RIJN\', 25233, (CURRENT_TIMESTAMP), 3),\n"
//				+ "( \'Soledad\', null, 78675, (CURRENT_TIMESTAMP), 3),\n"
//				+ "( \'Autorretrato con boina\', \'CLAUDE MONET\', 974564, (CURRENT_TIMESTAMP), 3),\n"
//				+ "( \'ASDADWAD\', null, 4534534, (CURRENT_TIMESTAMP), 4),\n"
//				+ "( \'awiodjawoid\', \'WASSILY KANDINSKY\', 346346,(CURRENT_TIMESTAMP), 4),\n"
//				+ "( \'Las Meninas\', \'DIEGO VELÁZQUEZ\', 123144, (CURRENT_TIMESTAMP), 4),\n"
//				+ "( \'iqweiqw\', null, 234234, (CURRENT_TIMESTAMP), 5),\n"
//				+ "( \'Gioconda\', \'Leonardo da Vinci\', 765756, (CURRENT_TIMESTAMP), 5),\n"
//				+ "( \'AWDADOI\', null, 12342, (CURRENT_TIMESTAMP), 5),\n"
//				+ "(\'Soledad\', null, 236544, (CURRENT_TIMESTAMP), 6),\n"
//				+ "( \'Soledad\', \'GIOTTO DI BONDONE\', 657556, (CURRENT_TIMESTAMP), 6),\n"
//				+ "( \'Soledad\', null, 34234, (CURRENT_TIMESTAMP), 6),\n"
//				+ "( \'Soledad\', null, 453534, (CURRENT_TIMESTAMP), 7),\n"
//				+ "( \'qpwioeqp\', \'TURNER\', 23434.3, (CURRENT_TIMESTAMP), 7),\n"
//				+ "( \'piqowepqw\', \'CARAVAGGIO\', 11111, (CURRENT_TIMESTAMP), 7),\n"
//				+ "( \'Alegría\', null, 43534.4, (CURRENT_TIMESTAMP), 8),\n"
//				+ "( \'Tristeza\', \'VAN EYCK\', 234324, (CURRENT_TIMESTAMP), 8),\n"
//				+ "( \'awiduaw\', null, 345345.3, (CURRENT_TIMESTAMP), 8)");
	}

}
