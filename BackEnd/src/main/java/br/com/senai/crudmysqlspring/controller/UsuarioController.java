package br.com.senai.crudmysqlspring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.crudmysqlspring.model.Usuario;
import br.com.senai.crudmysqlspring.repository.UsuarioRepository;

@RestController
//schema da database
@RequestMapping({"/usuarios"})
public class UsuarioController {

  private UsuarioRepository repository;

  UsuarioController(UsuarioRepository usuarioRepository) {
      this.repository = usuarioRepository;
  }

  // metodos crud aqui
  //pega todos os usuarios do banco e retorna uma lista
  @GetMapping
public List<Usuario> findAll(){
  return repository.findAll();
}

//pega um usuario pelo seu Email
@GetMapping(path = {"/email/{email}"})
public ResponseEntity<Usuario> findByEmail(@PathVariable String email){
  return repository.findByEmail(email)
          .map(record -> ResponseEntity.ok().body(record))
          .orElse(ResponseEntity.notFound().build());
}

//método para salvar o usuario no banco
@PostMapping
public Usuario create(@RequestBody Usuario usuario){
    return repository.save(usuario);
}

//método para atualizar um usuario
@PutMapping(value="/email/{email}")
  public ResponseEntity<Usuario> update(@PathVariable("email") String email,
                                        @RequestBody Usuario usuario){
    return repository.findByEmail(email)
        .map(record -> {
            record.setNome(usuario.getNome());
            record.setEmail(usuario.getEmail());
            record.setTelefone(usuario.getTelefone());
            record.setGenero(usuario.getGenero());
            record.setSenha(usuario.getSenha());
            Usuario updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
  }

//método para deletar um usuario
@DeleteMapping(path ={"/email/{email}"})
  public ResponseEntity<?> delete(@PathVariable("email") String email) {
    return repository.findByEmail(email)
        .map(record -> {
            repository.deleteByEmail(email);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
  }

}
