package br.com.k19.modelo;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class K19Listener {
	
	@PrePersist
	@PostPersist
	@PreRemove
	@PostRemove
	@PreUpdate
	@PostUpdate
	@PostLoad
	public void callback(){
		System.out.println("tratando todos os eventos");
	}

}
