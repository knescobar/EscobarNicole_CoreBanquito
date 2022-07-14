package ec.edu.espe.arquitectura.corebanquito.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collation = "clientes")
@TypeAlias("clientes")
public class Cliente {

    @Id
    private String id;

    @Indexed(name = "idx_cliente_cedula", unique = true)
    private String cedula;

    private String nombreCompleto;

    @Indexed(name = "idx_cliente_estado", unique = false)
    private String estado;


}
