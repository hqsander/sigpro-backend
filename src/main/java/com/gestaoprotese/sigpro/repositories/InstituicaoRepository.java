package com.gestaoprotese.sigpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaoprotese.sigpro.domain.Instituicao;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer>{

}
