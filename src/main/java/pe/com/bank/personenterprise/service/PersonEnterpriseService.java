package pe.com.bank.personenterprise.service;

import pe.com.bank.personenterprise.entity.PersonEnterprise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonEnterpriseService {
	
	 public Mono<PersonEnterprise> addPersonEnterprise(PersonEnterprise personEnterprise);
	 public Flux<PersonEnterprise> getPersonEnterprises();
	 public Mono<PersonEnterprise> getPersonEnterpriseById(String id);
	 public Mono<PersonEnterprise> updatePersonEnterprise(PersonEnterprise personEnterprise, String id);
	 public Mono<Void> deletePersonEnterpriseById(String id);

}
