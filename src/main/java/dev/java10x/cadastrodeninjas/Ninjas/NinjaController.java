package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar Ninja (CREATE)
    //@RequestBody converte o JSON enviado pelo usuário para um objeto JAVA
    @PostMapping("/criar")
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.cadastrarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("listar/{id}")
    public ResponseEntity<?> mostrarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjasPorId(id);
        if(ninjaEncontrado != null){
            return ResponseEntity.ok(ninjaEncontrado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não encontrado!");
        }
    }

    //Mostrar os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mudar os dados do Ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if(ninjaAlterado != null){
            return ResponseEntity.ok(ninjaAlterado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não encontrado!");
        }
    }

    //Deletar Ninja (DELETE)
    //@PathVariable para passar o parâmetro inserido pelo usuário para a URL
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletraNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não encontrado!");
        }
    }

}
