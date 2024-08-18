package br.com.caelum.tarefas.test;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.caelum.tarefas.model.Tarefa;

public class TestaXml1 {

	public static void main(String[] args) throws Exception {
	    /*
         * Especificação do Java para processamento/manipulação do xml: jaxp.
         * Java for xml processing. Carrega o doc todo na memória
         */
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //fabrica
        DocumentBuilder builder = factory.newDocumentBuilder(); //construtor
        Document document = builder.parse("src/tarefa.xml");
    
        // NodeList elementos =
        // document.getElementsByTagName("formaDePagamento");
        // Element item = (Element) elementos.item(0); //tem metodos melhores
        // String texto = item.getTextContent(); //pega conteúdo
        

        
        NodeList elementos = document.getElementsByTagName("tarefa");
        for(int i=0; i<elementos.getLength(); i++){
            Element tarefa =(Element) elementos.item(i);
            
            String descricao  = tarefa.getElementsByTagName("descricao").item(0).getFirstChild().getNodeValue();
            boolean finalizado = Boolean.parseBoolean(tarefa.getElementsByTagName("finalizado").item(0).getFirstChild().getNodeValue());
           
            Calendar dataFinalizacao = Calendar.getInstance();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
           
            String d = formatoData.format(dataFinalizacao.getTime());
            Date d2 = formatoData.parse(d);
            dataFinalizacao.setTime(d2);
            Tarefa prod = new Tarefa(descricao, finalizado, dataFinalizacao);
            System.out.println(prod);
        }
		
	}

}
