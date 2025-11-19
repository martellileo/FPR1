package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.entidade.Veiculo;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Veiculo.class)
public class VeiculoConverter implements Converter<Veiculo>{
    
    @Override
    public Veiculo getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("getAsObject: " + string);
        if (string == null) {
            return null;
        }
        //Obtem o DAO
        VeiculoDAO veiculoDAO = CDI.current().select(VeiculoDAO.class).get();
        
        //Busca no BD
        return veiculoDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Veiculo veiculo) {
        System.out.println("getAsString: " + veiculo);
        return veiculo == null ? null : veiculo.getId().toString();
    }
      
}
