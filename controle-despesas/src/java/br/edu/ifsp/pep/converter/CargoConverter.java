package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.entidade.Cargo;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Cargo.class)
public class CargoConverter implements Converter<Cargo>{
    
    @Override
    public Cargo getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        //Obtem o DAO
        CargoDAO cargoDAO = CDI.current().select(CargoDAO.class).get();
        
        //Busca no BD
        return cargoDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cargo cargo) {
        return cargo == null ? null : cargo.getId().toString();
    }
      
}
