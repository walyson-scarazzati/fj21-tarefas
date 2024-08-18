package br.com.caelum.tarefas.test;

import java.io.File;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.caelum.tarefas.model.Tarefa;

public class TestaMapeamentoJAXB7 {

    public static void main(String[] args) throws Exception {

        /*
         * Especificação do java para construção do xml: jax-b. java for xml
         * building. Forma mais fácil de mapear o xml (ao inves de cria uma
         * classe, lista...). Associa direto o xml a uma classe sem necessidade
         * de criar uma classe para fazer mapeamento.
         */

        // especifica qual classe será mapeada
        JAXBContext jaxbContext = JAXBContext.newInstance(Tarefa.class);

        // xmlParaObjeto(jaxbContext); //xml -> objeto
        objetoParaXml(jaxbContext); // objeto -> xml

    }

    private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
        // classe responsável por mapear(transformar) o xml para a classe
        // nela há uma marcação
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // precisa especificar que a classe venda representa um xml por isso
        // nela há marcação
        Tarefa venda = (Tarefa) unmarshaller.unmarshal(new File(
                "scr/tarefaSemBanco.xml"));

        System.out.println(venda);
    }

    private static void objetoParaXml(JAXBContext jaxbContext) throws Exception {
        // classe responsavel por cria(transformar) o objeto para tag xml
        Marshaller marshaller = jaxbContext.createMarshaller();

        // cria objeto venda
        Tarefa venda = new Tarefa();
        venda.setDescricao("tarefa 1");
        venda.setFinalizado(true);
        venda.setDataFinalizacao(Calendar.getInstance());

        File file = new File("src/criadoSemBanco.xml");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // precisa especificar o objeto que será convertido e para onde vai ser
        // enviado o resultado
        marshaller.marshal(venda, file);
        marshaller.marshal(venda, System.out);
    }

}
