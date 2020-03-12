package br.com.webservice.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.webservice.produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
