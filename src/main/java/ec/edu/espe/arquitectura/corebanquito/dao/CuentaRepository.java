package ec.edu.espe.arquitectura.corebanquito.dao;

import ec.edu.espe.arquitectura.corebanquito.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CuentaRepository  extends MongoRepository<Cuenta, String> {

    Optional<Cuenta> findByCodigoInterno(String codigo);
}
