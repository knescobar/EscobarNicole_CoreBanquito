package ec.edu.espe.arquitectura.corebanquito.service;

import ec.edu.espe.arquitectura.corebanquito.dao.CuentaRepository;
import ec.edu.espe.arquitectura.corebanquito.dao.TransferenciaRepository;
import ec.edu.espe.arquitectura.corebanquito.exception.EntityNotFoundException;
import ec.edu.espe.arquitectura.corebanquito.model.Cuenta;
import ec.edu.espe.arquitectura.corebanquito.model.Transferencia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class TransferenciaService {

    private TransferenciaRepository transferenciaRepository;
    private CuentaRepository cuentaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public void   transferir(Transferencia transferencia){

       Cuenta cuentaOrigen  =validarCuenta(transferencia.getCuentaOrigen());
        Cuenta cuentaDestino= validarCuenta(transferencia.getCuentaDestino());

        if(cuentaOrigen.getSaldo().compareTo(transferencia.getValor())< 0){
            throw new EntityNotFoundException(
                    "Saldo insuficenteen la cuenta origen ");
        }
        BigDecimal adicionarCuDestino =  cuentaDestino.getSaldo().add(transferencia.getValor());
        cuentaDestino.setSaldo(adicionarCuDestino);
        transferencia.setFecha(new Date());
        this.transferenciaRepository.save(transferencia);
    }


    public Cuenta validarCuenta(String codigo) {
        Optional<Cuenta> groupOpt = this.cuentaRepository.findByCodigoInterno(codigo);
        return groupOpt.orElseThrow(
                () -> new EntityNotFoundException("La cuenta no  existe"));
    }


}
