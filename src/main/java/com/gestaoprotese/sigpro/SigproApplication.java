package com.gestaoprotese.sigpro;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestaoprotese.sigpro.domain.Instituicao;
import com.gestaoprotese.sigpro.domain.Movimentacao;
import com.gestaoprotese.sigpro.domain.Paciente;
import com.gestaoprotese.sigpro.domain.Protese;
import com.gestaoprotese.sigpro.domain.Usuario;
import com.gestaoprotese.sigpro.domain.enums.Situacao;
import com.gestaoprotese.sigpro.domain.enums.TipoInstituicao;
import com.gestaoprotese.sigpro.repositories.InstituicaoRepository;
import com.gestaoprotese.sigpro.repositories.MovimentacaoRepository;
import com.gestaoprotese.sigpro.repositories.PacienteRepository;
import com.gestaoprotese.sigpro.repositories.ProteseRepository;
import com.gestaoprotese.sigpro.repositories.UsuarioRepository;

@SpringBootApplication
public class SigproApplication implements CommandLineRunner{
	
	@Autowired
	InstituicaoRepository InstituicaoRepository;
	
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
		
		Instituicao csMarcelo = new Instituicao(null, "CS Marcelo Pontel", TipoInstituicao.CENTRO_DE_SAUDE);
		Instituicao agape = new Instituicao(null, "Laboratório Ágape", TipoInstituicao.LABORATORIO);
		Instituicao regional = new Instituicao(null, "Regional Nordeste", TipoInstituicao.REGIONAL);
		
		Usuario paula = new Usuario(null, "Paula Molina", csMarcelo);
		Usuario henrique = new Usuario(null, "Henrique Fernandes", agape);
		Usuario regNordeste = new Usuario(null, "Regional Nordeste", regional);
		
		Paciente cleunita = new Paciente(null, "Cleunita Lúcia Martins Tassara", dataSdf.parse("11/05/1962"));
		
		Protese prot1 = new Protese(null, cleunita, "VKO 4632", "CPP 01.02", false, false, true, true, paula, agape);
		
		Movimentacao mov01 = new Movimentacao(null, dataHoraSdf.parse("22/08/2019 09:00"), Situacao.MODELO_DE_GESSO, csMarcelo, regional, prot1);
		Movimentacao mov02 = new Movimentacao(null, dataHoraSdf.parse("23/08/2019 09:00"), Situacao.MODELO_DE_GESSO, regional, agape, prot1);
		Movimentacao mov03 = new Movimentacao(null, dataHoraSdf.parse("01/10/2019 09:00"), Situacao.PLANO_DE_CERA, agape, regional, prot1);
		Movimentacao mov04 = new Movimentacao(null, dataHoraSdf.parse("02/10/2019 09:00"), Situacao.PLANO_DE_CERA, regional, csMarcelo, prot1);
		Movimentacao mov05 = new Movimentacao(null, dataHoraSdf.parse("01/11/2019 09:00"), Situacao.PLANO_DE_CERA, csMarcelo, regional, prot1);
		Movimentacao mov06 = new Movimentacao(null, dataHoraSdf.parse("02/11/2019 09:00"), Situacao.PLANO_DE_CERA, regional, agape, prot1);
		Movimentacao mov07 = new Movimentacao(null, dataHoraSdf.parse("09/12/2019 09:00"), Situacao.MONTAGEM_DOS_DENTES, agape, regional, prot1);
		Movimentacao mov08 = new Movimentacao(null, dataHoraSdf.parse("10/12/2019 09:00"), Situacao.MONTAGEM_DOS_DENTES, regional, csMarcelo, prot1);
		Movimentacao mov09 = new Movimentacao(null, dataHoraSdf.parse("02/01/2019 09:00"), Situacao.MONTAGEM_DOS_DENTES, csMarcelo, regional, prot1);
		Movimentacao mov10 = new Movimentacao(null, dataHoraSdf.parse("03/01/2019 09:00"), Situacao.MONTAGEM_DOS_DENTES, regional, agape, prot1);
		Movimentacao mov11 = new Movimentacao(null, dataHoraSdf.parse("01/02/2019 09:00"), Situacao.PROTESE_PRENSADA, agape, regional, prot1);
		Movimentacao mov12 = new Movimentacao(null, dataHoraSdf.parse("02/02/2019 09:00"), Situacao.PROTESE_PRENSADA, regional, csMarcelo, prot1);
		Movimentacao mov13 = new Movimentacao(null, dataHoraSdf.parse("04/02/2019 09:00"), Situacao.ATESTAMENTO, agape, regional, prot1);
		Movimentacao mov14 = new Movimentacao(null, dataHoraSdf.parse("05/02/2019 09:00"), Situacao.ATESTAMENTO, regional, csMarcelo, prot1);
		Movimentacao mov15 = new Movimentacao(null, dataHoraSdf.parse("07/02/2019 09:00"), Situacao.ATESTAMENTO, csMarcelo, regional, prot1);
		Movimentacao mov16 = new Movimentacao(null, dataHoraSdf.parse("08/02/2019 09:00"), Situacao.ATESTAMENTO, regional, agape, prot1);
		
		InstituicaoRepository.saveAll(Arrays.asList(csMarcelo, agape, regional));
		usuarioRepository.saveAll(Arrays.asList(paula, henrique, regNordeste));
		pacienteRepository.saveAll(Arrays.asList(cleunita));
		prot1.getMovimentacoes().addAll(Arrays.asList(mov01, mov02, mov03, mov04, mov05, mov06, mov07, mov08, mov09, mov10, mov11, mov12, mov13, mov14, mov15, mov16));
		proteseRepository.saveAll(Arrays.asList(prot1));
		movimentacaoRepository.saveAll(Arrays.asList(mov01, mov02, mov03, mov04, mov05, mov06, mov07, mov08, mov09, mov10, mov11, mov12, mov13, mov14, mov15, mov16));
	}
}
