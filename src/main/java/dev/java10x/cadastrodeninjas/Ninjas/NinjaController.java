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

    //Adicionar Ninja (CREATE)
    //@RequestBody converte o JSON enviado pelo usuário para um objeto JAVA
    @PostMapping("/criar")
    public NinjaDTO adicionarNinja(@RequestBody NinjaDTO ninja){
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
    @PutMapping("/alterar/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja (DELETE)
    //@PathVariable para passar o parâmetro inserido pelo usuário para a URL
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletraNinjaPorId(id);
    }

}
