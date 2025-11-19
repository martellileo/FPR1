package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.entidade.Cargo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CargoController {
        
    @Inject
    private CargoDAO cargoDAO;

    public List<Cargo> getCargos() {
        return this.cargoDAO.buscarTodos();
    }

}
