package br.com.caelum.tarefas.test;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.caelum.tarefas.model.Tarefa;

public class TestaPesquisaXMLXPath5 {

	public static void main(String[] args) throws Exception{
	    
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/tarefa.xml");

        /*
         * XPath realiza consultas(com filtros ou nao, sem o uso de ifs) no
         * documento como se fosse dom
         */

        String exp = "tarefa[contains(descricao,'h')]";
        XPath path = XPathFactory.newInstance().newXPath();
        XPathExpression expression = path.compile(exp);

        NodeList elementos = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        // NodeList elementos = document.getElementsByTagName("produto");

        for (int i = 0; i < elementos.getLength(); i++) {
            Element tarefa = (Element) elementos.item(i);

            String descricao  = tarefa.getElementsByTagName("descricao").item(0).getFirstChild().getNodeValue();
            boolean finalizado = Boolean.parseBoolean(tarefa.getElementsByTagName("finalizado").item(0).getFirstChild().getNodeValue());
           
            Calendar dataFinalizacao = Calendar.getInstance();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
           
            String d = formatoData.format(dataFinalizacao.getTime());
            Date d2 = formatoData.parse(d);
            dataFinalizacao.setTime(d2);
            Tarefa prod = new Tarefa(descricao,finalizado,dataFinalizacao);
            System.out.println(prod);
	    }
		
	}

}
