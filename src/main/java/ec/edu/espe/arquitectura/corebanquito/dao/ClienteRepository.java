package ec.edu.espe.arquitectura.corebanquito.dao;

import ec.edu.espe.arquitectura.corebanquito.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository  extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByNombreCompleto(String completo);
}
