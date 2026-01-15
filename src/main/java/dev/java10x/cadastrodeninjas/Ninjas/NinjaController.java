package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel adicionarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.cadastrarNinja(ninja);
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("listar/{id}")
    public NinjaModel mostrarNinjaPorId(@PathVariable Long id){ return ninjaService.listarNinjasPorId(id); }

    //Mostrar os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
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
