package com.gestaoprotese.sigpro;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestaoprotese.sigpro.domain.CentroDeSaude;
import com.gestaoprotese.sigpro.domain.Laboratorio;
import com.gestaoprotese.sigpro.domain.Movimentacao;
import com.gestaoprotese.sigpro.domain.Paciente;
import com.gestaoprotese.sigpro.domain.Protese;
import com.gestaoprotese.sigpro.domain.Usuario;
import com.gestaoprotese.sigpro.domain.enums.Situacao;
import com.gestaoprotese.sigpro.repositories.CentroDeSaudeRepository;
import com.gestaoprotese.sigpro.repositories.LaboratorioRepository;
import com.gestaoprotese.sigpro.repositories.MovimentacaoRepository;
import com.gestaoprotese.sigpro.repositories.PacienteRepository;
import com.gestaoprotese.sigpro.repositories.ProteseRepository;
import com.gestaoprotese.sigpro.repositories.UsuarioRepository;

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
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	MovimentacaoRepository movimentacaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SigproApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dataSdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dataHoraSdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		CentroDeSaude csMarcelo = new CentroDeSaude(null, "CS Marcelo Pontel");
		
		Laboratorio agape = new Laboratorio(null, "Ágape");
		
		Paciente cleunita = new Paciente(null, "Cleunita Lúcia Martins Tassara", dataSdf.parse("11/05/1962"));
		Paciente maria = new Paciente(null, "Maria Carmelita Ferreira da Rocha", dataSdf.parse("01/05/1951"));
		
		Usuario paula = new Usuario(null, "Paula Molina");
		Usuario henrique = new Usuario(null, "Henrique");
		
		Protese prot1 = new Protese(null, cleunita, agape, csMarcelo, "VKO 4632", "CPP 01.02", false, false, true, true, paula);
		Protese prot2 = new Protese(null, maria, agape, csMarcelo, "EIK 9865", "CPP 02.02", true, true, false, false, paula);

		Movimentacao mov1 = new Movimentacao(null, dataHoraSdf.parse("15/06/2019 15:30"), Situacao.MODELO_DE_GESSO, Situacao.PLANO_DE_CERA, henrique, prot1);
		
		prot1.getMovimentacoes().addAll(Arrays.asList(mov1));
		
		csMarcelo.getProteses().addAll(Arrays.asList(prot1, prot2));
		
		agape.getProteses().addAll(Arrays.asList(prot1, prot2));
		
		cleunita.getProteses().addAll(Arrays.asList(prot1));
		maria.getProteses().addAll(Arrays.asList(prot2));
		
		centroDeSaudeRepository.saveAll(Arrays.asList(csMarcelo));
		
		laboratorioRepository.saveAll(Arrays.asList(agape));
		
		pacienteRepository.saveAll(Arrays.asList(cleunita, maria));
		
		usuarioRepository.saveAll(Arrays.asList(paula, henrique));
		
		proteseRepository.saveAll(Arrays.asList(prot1, prot2));
		
		movimentacaoRepository.saveAll(Arrays.asList(mov1));
	}
}
