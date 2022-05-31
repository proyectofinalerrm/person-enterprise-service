package pe.com.bank.personenterprise.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.bank.personenterprise.entity.PersonEnterprise;

@Repository
public interface PersonEnterpriseRepository extends ReactiveMongoRepository<PersonEnterprise,String>{

}
