package dev.java10x.cadastrodeninjas.Ninjas;

import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity //Entity transforma uma classe em uma entidade do banco de dados
@Table(name = "tb_cadastro")    //Passar um nome pra tabela
@NoArgsConstructor //Cria um contrutor vazio automaticamente
@AllArgsConstructor //Cria um contrutor com todos os argumentos automaticament
@Data //Cria todos os getters e setters automaticamente
@ToString(exclude = "missoes") //cria o ToString para toda a entidade exceto as missoes
public class NinjaModel {

    @Id //Para trasformar a variavel logo abaixo em um Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Maneira na qual o Id vai ser implementado
    @Column(name="id")
    private long id;

    @Column(name="nome")
    private String nome;

    @Column(name="idade")
    private int idade;

    @Column(unique = true) //Não permite valores repetidos nessa coluna do banco de dados
    private String email;

    @Column(name="img_url")
    private String imgUrl;

    @Column(name="rank")
    private String rank;

    @ManyToOne //Varios ninjas para uma missão
    @JoinColumn(name = "missoes_id") //foreing key ou chave estrangeira
    private MissoesModel missoes;

}
