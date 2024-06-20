package Sistematizacao.Cartoes_MGS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Sistematizacao.Cartoes_MGS.models.CartaoModel;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoModel, Integer> {
	
}

