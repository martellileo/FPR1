package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.DAO.CategoriaDAO;
import br.edu.ifsp.pep.entidade.Categoria;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter<Categoria>{

    @Override
    public Categoria getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null){
            return null;
        }
        CategoriaDAO categoriaDAO = CDI.current().select(CategoriaDAO.class).get();
        return categoriaDAO.buscarPeloId(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Categoria t) {
        if (t == null){
            return null;
        }
        return t.getId().toString();
    }
    
    
}
