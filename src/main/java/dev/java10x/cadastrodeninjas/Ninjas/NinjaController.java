package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String adicionarNinja(){
        return "Ninja adicionado";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("listarID")
    public String mostrarNinjaPorId(){
        return "Todos os Ninjas por id";
    }

    //Mostrar os Ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosNinjas(){
        return "Todos os Ninjas";
    }

    //Mudar os dados do Ninja (UPDATE)
    @PutMapping("/alterar")
    public String mudarDadosDoNinjaPorId(){
        return "Dados do Ninja alterado";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinjaPorId(){
        return "Ninja deletado";
    }

}
