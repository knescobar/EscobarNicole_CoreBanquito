package ec.edu.espe.arquitectura.corebanquito.dao;

import ec.edu.espe.arquitectura.corebanquito.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository  extends MongoRepository<Cliente, String> {
}
