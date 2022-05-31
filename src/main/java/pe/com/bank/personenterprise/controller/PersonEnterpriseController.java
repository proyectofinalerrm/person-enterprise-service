package pe.com.bank.personenterprise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.bank.personenterprise.entity.PersonEnterprise;
import pe.com.bank.personenterprise.service.PersonEnterpriseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
public class PersonEnterpriseController {
	
	 PersonEnterpriseService personEnterpriseService;
	    
	    private static final Logger log = LoggerFactory.getLogger(PersonEnterpriseController.class);
	    
	    @PostMapping
	    public Mono<PersonEnterprise> addPersonEnterprise(@RequestBody PersonEnterprise personEnterprise){
	    	log.info("addPersonEnterprise");
	    	return personEnterpriseService.addPersonEnterprise(personEnterprise);
	    }
	    
	    @GetMapping
	    public Flux<PersonEnterprise> getPersonEnterprises() {
	    	log.info("getPersonEnterprises");
	        return personEnterpriseService.getPersonEnterprises();
	    }
	    
	    @GetMapping("/{id}")
	    public Mono<PersonEnterprise> getPersonEnterpriseById(@PathVariable String id){
	    	log.info("getPersonEnterpriseById");
	    	return personEnterpriseService.getPersonEnterpriseById(id);
	    }
	    
	    @PutMapping("/{id}")
	    public Mono<PersonEnterprise> updatePersonEnterprise(@RequestBody PersonEnterprise personEnterpriseUpdate, @PathVariable String id){
	    	log.info("updatePersonEnterprise");
	    	return personEnterpriseService.updatePersonEnterprise(personEnterpriseUpdate, id);
	    }
	    
	    @DeleteMapping("/{id}")
	    public Mono<Void> deleteByPersonEnterpriseId(@PathVariable String id){
	    	log.info("deleteByPersonEnterpriseId");
	    	return personEnterpriseService.deletePersonEnterpriseById(id);
	    }

}
