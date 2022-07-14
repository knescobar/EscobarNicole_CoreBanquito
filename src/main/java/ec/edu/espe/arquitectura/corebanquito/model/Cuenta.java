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
@Document(collation = "cuentas")
@TypeAlias("cuentas")
public class Cuenta {

    @Id
    private String id;

    private String idCliente;

    @Indexed(name = "idx_cuenta_codigoInterno", unique = true)
    private String codigoInterno;

    private BigDecimal saldo;

    private Date fechaUltimoMovimiento;

    @Indexed(name = "idx_cuenta_estado", unique = false)
    private String  estado;
}
