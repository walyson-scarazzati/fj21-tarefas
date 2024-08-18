package br.com.caelum.tarefas.test;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.caelum.tarefas.model.Tarefa;



public class TarefaHandler extends DefaultHandler {

	private StringBuilder palavra;
	private final List<Tarefa> tarefas = new ArrayList<Tarefa>();
	private Tarefa tarefa;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if(qName.equals("tarefa")){
			tarefa =new Tarefa();
		}
		palavra =new StringBuilder();
	}
	
	public void character(char[] ch, int start, int lenght) throws SAXException{
		palavra = palavra.append(new String(ch, start, lenght));
	}

	public void endElement(String uri, String localName, String qName)throws SAXException{
		if(qName.equals("tarefas")){
			tarefas.add(tarefa);
		}else if(qName.equals("descricao")){
			tarefa.setDescricao(palavra.toString().trim());
		}else if(qName.equals("finalizado")){
			boolean finalizado = Boolean.parseBoolean(palavra.toString());
			tarefa.setFinalizado(finalizado);
		}
	}
	
	public List<Tarefa> getTarefas(){
		return tarefas;
	}
	
}
