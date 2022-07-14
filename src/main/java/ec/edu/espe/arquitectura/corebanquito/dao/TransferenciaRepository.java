package ec.edu.espe.arquitectura.corebanquito.dao;

import ec.edu.espe.arquitectura.corebanquito.model.Transferencia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransferenciaRepository   extends MongoRepository<Transferencia, String> {
}
