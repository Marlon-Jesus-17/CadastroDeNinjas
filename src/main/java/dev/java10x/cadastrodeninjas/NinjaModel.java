package dev.java10x.cadastrodeninjas;

import jakarta.persistence.*;

@Entity //Entity transforma uma classe em uma entidade do banco de dados
@Table(name = "tb_cadastro")    //Passar um nome pra tabela
public class NinjaModel {

    @Id //Para trasformar a variavel logo abaixo em um Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Maneira na qual o Id vai ser implementado
    private long id;
    private String nome;
    private int idade;
    private String email;

    public NinjaModel() {}

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
