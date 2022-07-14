package ec.edu.espe.arquitectura.corebanquito.service;

import ec.edu.espe.arquitectura.corebanquito.dao.ClienteRepository;
import ec.edu.espe.arquitectura.corebanquito.exception.EntityNotFoundException;
import ec.edu.espe.arquitectura.corebanquito.model.Cliente;

import java.util.Optional;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public Cliente buscarPorNombre(String nombre){
        Optional<Cliente> clietOpt = this.clienteRepository.findByNombreCompleto(nombre);

        return clietOpt.orElseThrow(
                () -> new EntityNotFoundException("Cliente no existe"));
    }
}
