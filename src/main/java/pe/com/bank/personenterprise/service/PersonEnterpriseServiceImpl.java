package pe.com.bank.personenterprise.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.bank.personenterprise.entity.PersonEnterprise;
import pe.com.bank.personenterprise.repository.PersonEnterpriseRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PersonEnterpriseServiceImpl implements PersonEnterpriseService{
	
	PersonEnterpriseRepository personEnterpriseRepository;
    
    private static final Logger log = LoggerFactory.getLogger(PersonEnterpriseServiceImpl.class);

    public Mono<PersonEnterprise> addPersonEnterprise(PersonEnterprise personEnterprise){
    	log.info("addPersonEnterprise");    	
    	return personEnterpriseRepository.save(personEnterprise).doOnNext(personEnterpriseSaved -> log.info("PersonEnterprise id :"+personEnterpriseSaved.getId()+" Saved"));
    }
    
    public Flux<PersonEnterprise> getPersonEnterprises(){
    	log.info("getPersonEnterprises");  
       return personEnterpriseRepository.findAll().doOnNext(personEnterprise -> log.info("PersonEnterprise id :"+personEnterprise.getId()));
    }
    
    public Mono<PersonEnterprise> getPersonEnterpriseById(String id){
    	log.info("getPersonEnterpriseById");  
    	return personEnterpriseRepository.findById(id).doOnNext(personEnterprise -> log.info("PersonEnterprise id :"+personEnterprise.getId()));
    }
    
    public Mono<PersonEnterprise> updatePersonEnterprise(PersonEnterprise personEnterpriseUpdate, String id){
    	log.info("updatePersonEnterprise"); 
    	return personEnterpriseRepository.findById(id).flatMap(personEnterprise -> {
    			
    		personEnterprise.setRol(personEnterpriseUpdate.getRol() != null ? personEnterpriseUpdate.getRol():personEnterprise.getRol());
    		personEnterprise.setPersonId(personEnterpriseUpdate.getPersonId()!= null ? personEnterpriseUpdate.getPersonId():personEnterprise.getPersonId());
    		personEnterprise.setEnterpriseId(personEnterpriseUpdate.getEnterpriseId()!= null ? personEnterpriseUpdate.getEnterpriseId():personEnterprise.getEnterpriseId());
    		return personEnterpriseRepository.save(personEnterprise);
 
    	}).doOnNext(person -> log.info("PersonEnterprise id :"+person.getId()+" Updated"));
    }
    
    public Mono<Void> deletePersonEnterpriseById(String id){
    	log.info("deletePersonEnterpriseById"); 
    	return personEnterpriseRepository.deleteById(id);
    }


	

}
