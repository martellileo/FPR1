package br.edu.ifsp.pep.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.primefaces.model.DefaultStreamedContent;

public class Relatorio {
    
    public static DefaultStreamedContent gerar(
            InputStream jasper, Map<String, Object> parametros, List dados) {
        
        
        try {
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);
            
            JasperPrint jp = JasperFillManager.fillReport(jasper, parametros, dataSource);
            
            JRPdfExporter export = new JRPdfExporter();
            export.setExporterInput(new SimpleExporterInput(jp));
            
            ByteArrayOutputStream saida = new ByteArrayOutputStream();
            export.setExporterOutput(new SimpleOutputStreamExporterOutput(saida));
            
            export.exportReport();
            
           
            return DefaultStreamedContent.builder()
                .name("relatorio.pdf")
                .contentType("application/pdf")
                .stream(() -> new ByteArrayInputStream(saida.toByteArray()))
                .build();
            
            
            
        } catch (JRException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao gerar o relatório.");
        }
        return null;
        
    }
    
}
