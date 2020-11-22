package programacaoII.motorista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {
	
	@Autowired
	private MotoristaRepository repository;
	
	@GetMapping
    public List<Motorista> todosMotoristas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")    
    public Motorista recuperarPorId(@PathVariable String id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public String criarMotorista(@RequestBody Motorista novo) {
        if (repository.findById(novo.getId()).isPresent()) {            
            throw new ItemFoiDuplicadoException();
        }
        novo = repository.save(novo);
        return novo.getId();
    }

    @DeleteMapping("/{id}")    
    public void deletar(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void Atualizar(@PathVariable String id, @RequestBody Motorista atualizado) {
        if (!id.equals(atualizado.getId())) {
            throw new IdDiferenteException();
        }
        if (!repository.findById(atualizado.getId()).isPresent()) {            
            throw new MotoristaNaoAchadoException();

        }
        repository.save(atualizado);
    }
    
}
