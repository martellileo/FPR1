package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.ServicoDAO;
import br.edu.ifsp.pep.entidade.Servico;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Servico.class)
public class ServicoConverter implements Converter<Servico>{
    
    @Override
    public Servico getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        //Obtem o DAO
        ServicoDAO servicoDAO = CDI.current().select(ServicoDAO.class).get();
        
        //Busca no BD
        return servicoDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Servico servico) {
        return servico == null ? null : servico.getId().toString();
    }
      
}
