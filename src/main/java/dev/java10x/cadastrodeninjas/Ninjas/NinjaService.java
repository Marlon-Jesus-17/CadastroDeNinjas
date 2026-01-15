package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar ninjas por ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Cadastrar ninjas
    public NinjaModel cadastrarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar ninjas
    public void deletraNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

}
