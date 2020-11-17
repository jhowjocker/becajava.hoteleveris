package hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hoteleveris.app.request.ComodidadeIdRequest;
import hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class ComodidadeTest {
	
	@Autowired
	private ComodidadeService service;
	
	@Test
	public void criarcomodidade() {
		ComodidadeIdRequest comodidade = new ComodidadeIdRequest();
		
		comodidade.setNome("Cama Box");
		
		BaseResponse base  = service.criar(comodidade);
		
		Assertions.assertEquals(201, base.getStatusCode());
		Assertions.assertEquals("Comodidade criada com sucesso.", base.getMessage());
	}
	
	@Test
	public void criarComodidadeVazio() {
		ComodidadeIdRequest comodidade = new ComodidadeIdRequest();
		
		comodidade.setNome("");
		
		BaseResponse base  = service.criar(comodidade);
		
		Assertions.assertEquals(400, base.getStatusCode());
	}
	
	@Test
	public void obterComodidade() {
		
		
		BaseResponse base  = service.obter(1L);
		
		Assertions.assertEquals(200, base.getStatusCode());
	}
	
	@Test
	public void obterComodidadeZero() {
				
		BaseResponse base  = service.obter(0L);
		
		Assertions.assertEquals(400, base.getStatusCode());
	}
	
	@Test
	public void obterComodidadeSemId() {
				
		BaseResponse base  = service.obter(9999999999999L);
		
		Assertions.assertEquals(400, base.getStatusCode());
	}
	

	
}










