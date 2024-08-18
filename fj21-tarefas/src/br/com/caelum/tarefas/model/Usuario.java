package br.com.caelum.tarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    
    //para colocar esse field como obrigatório no lombok
    @NonNull
    private String login;
    @NotNull
    
    //para colocar esse field como obrigatório no lombok
    @NonNull
    private String senha;
}
