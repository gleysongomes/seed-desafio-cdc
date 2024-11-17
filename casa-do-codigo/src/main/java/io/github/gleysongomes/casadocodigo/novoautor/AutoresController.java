package io.github.gleysongomes.casadocodigo.novoautor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;

// 3 pontos

@RestController
public class AutoresController {

	@PersistenceContext
	private EntityManager entityManager;

	// 2 pontos
	@Transactional
	@PostMapping(value = "/autores")
	public ResponseEntity<AutorResponse> save(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
		// 1 ponto
		Autor autor = novoAutorRequest.toEntity();

		entityManager.persist(autor);

		return ResponseEntity.status(HttpStatus.CREATED).body(new AutorResponse(autor));
	}
}
