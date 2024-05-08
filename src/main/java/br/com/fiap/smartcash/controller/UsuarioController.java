package br.com.fiap.smartcash.controller;
import java.util.List;
import br.com.fiap.smartcash.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;
import br.com.fiap.smartcash.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository repository;


    @GetMapping
    public List<Usuario> readAll(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario create(@RequestBody @Valid Usuario usuario){
        return repository.save(usuario);
    }
}
