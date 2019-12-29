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
		
		Protese prot1 = new Protese(null, cleunita, "VKO 4632", "CPP 01.02", false, false, true, true, paula);
		
		Movimentacao mov1 = new Movimentacao(null, dataHoraSdf.parse("22/08/19 09:00"), Situacao.MODELO_DE_GESSO, csMarcelo, regional, prot1);
		
		InstituicaoRepository.saveAll(Arrays.asList(csMarcelo, agape, regional));
		usuarioRepository.saveAll(Arrays.asList(paula, henrique, regNordeste));
		cleunita.getProteses().addAll(Arrays.asList(prot1));
		pacienteRepository.saveAll(Arrays.asList(cleunita));
		prot1.getMovimentacoes().addAll(Arrays.asList(mov1));
		proteseRepository.saveAll(Arrays.asList(prot1));
		movimentacaoRepository.saveAll(Arrays.asList(mov1));
		
//		Instituicao csMarcelo = new Instituicao(null, "CS Marcelo Pontel", TipoInstituicao.CENTRO_DE_SAUDE);
//		Instituicao agape = new Instituicao(null, "Laboratório Ágape", TipoInstituicao.LABORATORIO);
//		
//		Paciente cleunita = new Paciente(null, "Cleunita Lúcia Martins Tassara", dataSdf.parse("11/05/1962"));
//		Paciente maria = new Paciente(null, "Maria Carmelita Ferreira da Rocha", dataSdf.parse("01/05/1951"));
//		
//		Usuario paula = new Usuario(null, "Paula Molina", csMarcelo);
//		Usuario henrique = new Usuario(null, "Henrique Fernandes", agape);
//		
//		Protese prot1 = new Protese(null, cleunita, "VKO 4632", "CPP 01.02", false, false, true, true, paula);
//		Protese prot2 = new Protese(null, maria, "EIK 9865", "CPP 02.02", true, true, false, false, paula);
//
//		Movimentacao mov1 = new Movimentacao(null, dataHoraSdf.parse("15/06/2019 15:30"), Situacao.MODELO_DE_GESSO, Situacao.PLANO_DE_CERA, henrique, prot1);
//		
//		prot1.getMovimentacoes().addAll(Arrays.asList(mov1));
//		
//		cleunita.getProteses().addAll(Arrays.asList(prot1));
//		maria.getProteses().addAll(Arrays.asList(prot2));
//		
//		InstituicaoRepository.saveAll(Arrays.asList(csMarcelo, agape));
//		
//		pacienteRepository.saveAll(Arrays.asList(cleunita, maria));
//		
//		usuarioRepository.saveAll(Arrays.asList(paula, henrique));
//		
//		proteseRepository.saveAll(Arrays.asList(prot1, prot2));
//		
//		movimentacaoRepository.saveAll(Arrays.asList(mov1));
		/*
			cleunita

			paula envia modelo de gesso para regional 22/08
			regional recebe modelo de gesso 23/08
			laboratório recebe modelo de gesso 24/08
			
			laboratorio envia plano de cera para regional 01/10
			regional recebe 02/10
			paula recebe 03/10
			
			paula envia plano de cera para regional 01/11
			regional recebe 02/11
			laboratório recebe 03/11
			
			laboratorio envia montagem dos dentes para regional 09/12
			regional recebe montagem dos dentes 10/12
			paula recebe montagem dos dentes 11/12
			
			paula envia montagem dos dentes para regional 02/01
			regional recebe 03/01
			lab recebe 04/01
			
			lab envia protese prensada 01/02
			regional recebe 02/02
			paula recebe 03/02
			
			lab envia atestamento 04/02
			regional recebe 05/02
			paula recebe 06/02
			
			paula envia atestamento 07/02
			reg recebe 08/02
			lab recebe 09/02
		 */
	}
}
