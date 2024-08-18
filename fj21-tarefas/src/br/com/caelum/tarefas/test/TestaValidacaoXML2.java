package br.com.caelum.tarefas.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.caelum.tarefas.model.Tarefa;

public class TestaValidacaoXML2 {

	public static void main(String[] args) throws Exception {
	
        /*
         * Esta forma de ler xml é rápida para arquivos pequenos porém gasta
         * muita memoria se for arquivos grandes não é a melhor maneira de
         * manipular xml
         */
        
        //pega o xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        //pede para validar o xml
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                "http://www.w3.org/2001/XMLSchema");
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        //documento inteiro vai para memoria (arvore)
        Document document = builder.parse("src/tarefaValidadaSemBanco.xml");

        //pega produtos     
        NodeList tarefas = document.getElementsByTagName("tarefa");
        
        for(int i=0; i< tarefas.getLength(); i++){
            Element tarefa =(Element) tarefas.item(i);
            
            String descricao  = tarefa.getElementsByTagName("descricao").item(0).getFirstChild().getNodeValue();
            boolean finalizado = Boolean.parseBoolean(tarefa.getElementsByTagName("finalizado").item(0).getFirstChild().getNodeValue());
           
            Calendar dataFinalizacao = Calendar.getInstance();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
           
            String d = formatoData.format(dataFinalizacao.getTime());
            Date d2 = formatoData.parse(d);
            dataFinalizacao.setTime(d2);
            Tarefa prod = new Tarefa(descricao,finalizado,dataFinalizacao);
            System.out.println(prod);
            System.out.println(d2);
        }
        
    }
	
/*    Calendar dataFinalizacao = Calendar.getInstance();
    SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
    dataFinalizacao.setTime(formatoData.parse(tarefa.getElementsByTagName("dataFinalizacao").item(0).getFirstChild().getNodeValue()));
    String d = formatoData.format(dataFinalizacao.getTime());
    Date d2 = formatoData.parse(d);*/
	

}
