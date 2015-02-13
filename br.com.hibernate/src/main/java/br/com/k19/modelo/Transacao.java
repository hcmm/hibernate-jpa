package br.com.k19.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Transacao {
	
	/**
	 * Um entity manager comecar a ser gerenciado quando chamamos seu metodo manager e begin
	 * 
	 * Um obejto possui diversos estados:
	 * 
	 * new: Quando se usa new Objeto(), ela nao tem vinculo quando EntityManager
	 * 
	 * managed: EntityManager controla o objeto para insercao alteracao e quando houver uma sincronizacao"1 sera atualizado
	 * 	Obejtos que sao criados atrasves de consulta vem managed
	 * 
	 * removed: EntityManager controla objeto para proxima sincrozinacao ser removido
	 * 
	 * detached: Objeto possui uma identidade"2 mas nao esta managed e nao sera atualizado pela sincronizacao. 
	 * 
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		//Flush Mode - O EntityManager pode ser configurado de duas formas por FUSH AUTO ou COMMIT.
		//AUTO - relaiza sincronizacoes automaticas antes de uma consulta para garantir modificacoes;
		//COMMIT - nao especificado, pode se usar comportamento que quiser.
		// a nivel de entitnymanger
		manager.setFlushMode(FlushModeType.COMMIT);
		
		//nivel de query
		Query query = null;
		query.setFlushMode(FlushModeType.AUTO);
		
		// É a Confirmacao de transacao. Passar de new para managed. Deve ser confirmada por commit e flush
		manager.persist("exe1");
		manager.persist("exe2");
		
		// O flush os dados sao enviados para o banco mais ainda nao disponibilizados para outras transacoes.
		manager.flush();
		
		//torna o objeto nao mais gerenciado pelo em.
		Object object1 = null;
		manager.detach(object1);
		
		//Objeto um estava detached, paara propagalo para um objeto managed para que seja utlizadoa pelo banco, usa-se o merge.
		Object object2 = manager.merge(object1);
		
		//Um objeto detached nao eh excluido do banco de dados, mas quando usa-se remove eh excluido.
		manager.remove(object2);
		
		//Um objeto manager pode esta desatualizado pois outra requisicao pode ter alterado no banco, para isso usa-se o refresh.
		manager.refresh(object2);
		
		// O commit atualiza os dados no banco e finzaliza a transação.
		manager.getTransaction().commit();
		
		//Todas as chamadas ao metodo flush podem ser desfeitas quando utilizado roolback();
		manager.getTransaction().rollback();
		
		//Torna detached todos objetos utilizados
		manager.clear();
		
		//Find buscao objeto atraves de sua referencia e tem comportamento EAGER
		manager.find(Pessoa.class, 1);
		
		//Find buscao objeto atraves de sua referencia e tem comportamento EAGER
		manager.getReference(Pessoa.class, 1);
		
		//Fecha entitymanger e passa os objetos para detached;
		manager.close();
		//fecha o facotry
		factory.close();
	}
	

}
