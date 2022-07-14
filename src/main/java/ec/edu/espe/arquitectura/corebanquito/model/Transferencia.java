package ec.edu.espe.arquitectura.corebanquito.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Document(collation = "transferencias")
@TypeAlias("transferencias")
public class Transferencia {
    @Id
    private String id;

    @Indexed(name = "idx_transferencia_codigoint", unique = true)
    private String codigoInterno;

    private Date fecha;

    private String  cuentaOrigen;

    private  String cuentaDestino;

    private BigDecimal valor;

    @Indexed(name = "idx_tnasferencia_estado", unique = false)
    private String estado;

}
