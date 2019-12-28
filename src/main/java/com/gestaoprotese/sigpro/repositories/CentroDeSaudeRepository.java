package com.gestaoprotese.sigpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaoprotese.sigpro.domain.CentroDeSaude;

@Repository
public interface CentroDeSaudeRepository extends JpaRepository<CentroDeSaude, Integer>{

}
