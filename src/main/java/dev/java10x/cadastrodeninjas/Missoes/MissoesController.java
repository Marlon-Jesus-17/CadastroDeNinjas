package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    }

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões listadas com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }
}
