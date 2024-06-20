package Sistematizacao.Cartoes_MGS.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Sistematizacao.Cartoes_MGS.dtos.CartaoDto;
import Sistematizacao.Cartoes_MGS.models.CartaoModel;
import Sistematizacao.Cartoes_MGS.repositories.CartaoRepository;

import jakarta.validation.Valid;


@RestController
public class CartoesController {

	@Autowired
	CartaoRepository cartaoRepository;
	
	
	@GetMapping("/cartoes")
	public ResponseEntity<List<CartaoModel>> listar() {
		
		List<CartaoModel> cartaoList = cartaoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(cartaoList);
	}
	
	@PostMapping("/cartoes")
	public ResponseEntity<CartaoModel> salvar(@RequestBody @Valid CartaoDto cartaoDto) {
		var cartaoModel = new CartaoModel();
		BeanUtils.copyProperties(cartaoDto, cartaoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(cartaoRepository.save(cartaoModel));
	}
	
	
	@GetMapping("/cartoes/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id) {
		Optional<CartaoModel> cartao = cartaoRepository.findById(id);
		if(cartao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cartao.get());
	}
	
	
	@PutMapping("/cartoes/{id}")
	public ResponseEntity<Object> atualizarCartao(@PathVariable(value="id") Integer id, @RequestBody @Valid CartaoDto cartaoDto) {
		Optional<CartaoModel> cartao = cartaoRepository.findById(id);
		if(cartao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
		}
		var cartaoModel = cartao.get();
		BeanUtils.copyProperties(cartaoDto,  cartaoModel);
		return ResponseEntity.status(HttpStatus.OK).body(cartaoRepository.save(cartaoModel));
	}
	
	
	@DeleteMapping("/cartoes/{id}")
	public ResponseEntity<Object> deleteCartao(@PathVariable(value="id") Integer id, @RequestBody @Valid CartaoDto cartaoDto) {
		Optional<CartaoModel> cartao = cartaoRepository.findById(id);
		if(cartao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
		}
		cartaoRepository.delete(cartao.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cartão excluído");
	}
	
	
	
}
