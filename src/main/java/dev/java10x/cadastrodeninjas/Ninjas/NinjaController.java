package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/adicionar")
    public String adicionarNinja(){
        return "Ninja adicionado";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("todosID")
    public String mostrarNinjaPorId(){
        return "Todos os Ninjas por id";
    }

    //Mostrar os Ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosNinjas(){
        return "Todos os Ninjas";
    }

    //Mudar os dados do Ninja (UPDATE)
    @PutMapping("/atualizar")
    public String mudarDadosDoNinjaPorId(){
        return "Dados do Ninja alterado";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinjaPorId(){
        return "Ninja deletado";
    }

}
