package dev.java10x.cadastrodeninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria um nivo ninja", description = "A rota cria um novo ninja e insere no banco de dados") //Serve para documentar a rota, dando um resumo(summary) e uma descrição(description)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar ninja")
    }) //Respostas esperadas pela API e suas descrições
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.cadastrarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("listar/{id}")
    @Operation(summary = "Busca um ninja por ID", description = "Recebe um ID do usuário e busca um ninja correspondente no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
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
    @Operation(summary = "Altera um ninja por ID", description = "Recebe um ID do usuário e busca um ninja correspondente no banco de dados para alterar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> atualizarNinja(
            @Parameter(description = "Usuário  mando o ID no caminho da requisição") @PathVariable Long id, //@Parameter é usado para documentar os parâmetros
            @Parameter(description = "Usuário passa os dados do ninja a ser atualizado no caminho da requisição") @RequestBody NinjaDTO ninjaAtualizado){
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
