package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesSRepository) {
        this.missoesRepository = missoesSRepository;
    }

    //Listar missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Buscar por ID
    public MissoesModel listarMissaoPorID(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);


    }

    //Cadastrar missão
    public MissoesModel cadastrarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Atualizar missão
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }

    //Deletar missão
    public void DeletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

}
