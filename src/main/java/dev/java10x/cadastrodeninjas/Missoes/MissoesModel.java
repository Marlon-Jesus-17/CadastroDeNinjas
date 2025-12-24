package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //Uma missão para vários ninjas
    private List<NinjaModel> ninjas;

}
