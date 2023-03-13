package br.com.senai.crudmysqlspring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senai.crudmysqlspring.model.Usuario;
import br.com.senai.crudmysqlspring.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
        return repository.findByEmail(email)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<Usuario> update(@PathVariable String email, @RequestBody Usuario usuario) {
        return repository.findByEmail(email)
                .map(record -> {
                    record.setNome(usuario.getNome());
                    record.setEmail(usuario.getEmail());
                    record.setTelefone(usuario.getTelefone());
                    record.setGenero(usuario.getGenero());
                    record.setSenha(usuario.getSenha());
                    record.setVerificado(usuario.getVerificado());
                    Usuario updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<?> delete(@PathVariable String email) {
        return repository.findByEmail(email)
                .map(record -> {
                    repository.deleteByEmail(email);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
