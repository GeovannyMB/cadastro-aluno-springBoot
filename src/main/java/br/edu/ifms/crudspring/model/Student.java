package br.edu.ifms.crudspring.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // chama o lombok para criar automaticamente os getters e setters
@AllArgsConstructor // toda vez que instanciar, cria um objeto do tipo Student e chama todos os
                    // parametros
@NoArgsConstructor
@Entity // criar os campos da classe no BD
public class Student {

    @Id // aponta pra quem é o id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    // @NotBlank(message = "Nome não pode estar em branco")
    String name;

    String email;

    String password;
}
