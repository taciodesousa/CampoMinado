package br.ufpi.poo.campominado.tests;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.ufpi.poo.campominado.enums.Acao;
import br.ufpi.poo.campominado.exceptions.AcaoInvalidaException;
import br.ufpi.poo.campominado.exceptions.BombaExplodiuException;
import br.ufpi.poo.campominado.exceptions.PosicaoInvalidaException;
import br.ufpi.poo.campominado.model.CampoMinado;
import br.ufpi.poo.campominado.model.Coordenada;
import br.ufpi.poo.campominado.model.Jogada;

public class AulaTeste {
	@Test(expected = AcaoInvalidaException.class)
	public void coordenadaTest()throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		
		cm.reseta();
		
		Jogada nova1 = new Jogada(Acao.MARCAR, new Coordenada(0,0));
		Jogada nova2 = new Jogada(Acao.MARCAR,new Coordenada(0,0));
		
		cm.executa(nova1);
		
		cm.executa(nova2);
		
	}
	@Test(expected = PosicaoInvalidaException.class)
	public void investigadoTest() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(0,0));
		Jogada n2 = new Jogada(Acao.INVESTIGAR, new Coordenada(0,0));
		cm.executa(n1);
		cm.executa(n2);
	}
	
	@Test(expected = PosicaoInvalidaException.class)
	public void foraDosLimites() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		
		Jogada jog = new Jogada(Acao.MARCAR, new Coordenada(20,-1));
		cm.executa(jog);
	}
	@Test(expected = PosicaoInvalidaException.class)
	public void foraDosLimitesX() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		
		Jogada jog = new Jogada(Acao.MARCAR, new Coordenada(5,0));
		cm.executa(jog);
	}
	@Test(expected = PosicaoInvalidaException.class)
	public void foraDosLimitesY() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		
		Jogada jog = new Jogada(Acao.MARCAR, new Coordenada(0,5));
		cm.executa(jog);
	}
	
	@Test(expected = PosicaoInvalidaException.class)
	public void investigaForaLimitesEixoX() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(10,0));
		cm.executa(n1);
	}
	
	@Test(expected = PosicaoInvalidaException.class)
	public void investigaForaLimitesEixoY() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(0,10));
		cm.executa(n1);
	}
	
	
	@Test(expected = PosicaoInvalidaException.class)
	public void invetigaAmbosForaLimitesXY() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(15,10));
		cm.executa(n1);
	
	}
	
	@Test(expected = BombaExplodiuException.class)//teste 1
	public void bombaExplode() throws  AcaoInvalidaException, BombaExplodiuException, PosicaoInvalidaException{
		CampoMinado cm = new CampoMinado();
		
		cm.reseta();
		Jogada n1 = new Jogada(Acao.MARCAR, new Coordenada(0,0));
		Jogada n2 = new Jogada(Acao.INVESTIGAR, new Coordenada(0,0));
		
		cm.executa(n1);
		cm.executa(n2);
	
	}
	@test
	public void acaoValida() {
		Jogada um = new Jogada(Acao.INVESTIGAR, new Coordenada(0, 0));
		Jogada dois = new Jogada(Acao.INVESTIGAR, new Coordenada(0, 1));
		assertFalse("deveriam ser iguais!", um.equals(dois));
		
	
	}
	
}
