package com.gestaoprotese.sigpro;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestaoprotese.sigpro.domain.CentroDeSaude;
import com.gestaoprotese.sigpro.domain.Laboratorio;
import com.gestaoprotese.sigpro.domain.Paciente;
import com.gestaoprotese.sigpro.domain.Protese;
import com.gestaoprotese.sigpro.domain.enums.Situacao;
import com.gestaoprotese.sigpro.repositories.CentroDeSaudeRepository;
import com.gestaoprotese.sigpro.repositories.LaboratorioRepository;
import com.gestaoprotese.sigpro.repositories.PacienteRepository;
import com.gestaoprotese.sigpro.repositories.ProteseRepository;

@SpringBootApplication
public class SigproApplication implements CommandLineRunner{
	
	@Autowired
	CentroDeSaudeRepository centroDeSaudeRepository;
	
	@Autowired
	LaboratorioRepository laboratorioRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	ProteseRepository proteseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SigproApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat datasdf = new SimpleDateFormat("dd/MM/yyyy");
		
		CentroDeSaude csMarcelo = new CentroDeSaude(null, "CS Marcelo Pontel");
		
		Laboratorio agape = new Laboratorio(null, "Ágape");
		
		Paciente cleunita = new Paciente(null, "Cleunita Lúcia Martins Tassara", datasdf.parse("11/05/1962"));
		Paciente maria = new Paciente(null, "Maria Carmelita Ferreira da Rocha", datasdf.parse("01/05/1951"));
		
		Protese prot1 = new Protese(null, Situacao.MODELO_DE_GESSO, cleunita, agape, csMarcelo, "VKO 4632", "CPP 01.02", false, false, true, true);
		Protese prot2 = new Protese(null, Situacao.CHAPA_DE_PROVA, maria, agape, csMarcelo, "EIK 9865", "CPP 02.02", true, true, false, false);
		
		csMarcelo.getProteses().addAll(Arrays.asList(prot1, prot2));
		
		agape.getProteses().addAll(Arrays.asList(prot1, prot2));
		
		cleunita.getProteses().addAll(Arrays.asList(prot1));
		maria.getProteses().addAll(Arrays.asList(prot2));
		
		
		centroDeSaudeRepository.saveAll(Arrays.asList(csMarcelo));
		
		laboratorioRepository.saveAll(Arrays.asList(agape));
		
		pacienteRepository.saveAll(Arrays.asList(cleunita, maria));
		
		proteseRepository.saveAll(Arrays.asList(prot1, prot2));
	}
}
