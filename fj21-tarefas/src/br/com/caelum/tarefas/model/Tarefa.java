package br.com.caelum.tarefas.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

//para colocar esse field como obrigatório no lombok
@RequiredArgsConstructor 

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull
    @Size(min = 5)
    
    //para colocar esse field como obrigatório no lombok
    @NonNull
    private String descricao;
    
    //para colocar esse field como obrigatório no lombok
    @NonNull
    private Boolean finalizado;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_finalizado", nullable = true)
    
    //para colocar esse field como obrigatório no lombok
    @NonNull
    private Calendar dataFinalizacao;

  
}
