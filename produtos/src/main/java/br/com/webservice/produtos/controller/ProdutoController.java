package br.com.webservice.produtos.controller;

import java.util.List;

import javax.transaction.Transactional;

import br.com.webservice.produtos.model.Produto;
import br.com.webservice.produtos.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}
	
	@PostMapping
	public Produto postProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Produto> putProduto(@PathVariable Long id, @RequestBody Produto produto) {
		
		Produto produtoNovo = produtoRepository.getOne(id);
		produtoNovo.setNome(produto.getNome());
		produtoNovo.setQuantidade(produto.getQuantidade());
		
		return ResponseEntity.ok(produtoNovo);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return ResponseEntity.ok(true);
	}

}
