package br.com.cannoni.geolocation.teste;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cannoni.geolocation.model.GeoLocalizacao;
import br.com.cannoni.geolocation.service.GeoLocationInterface;

/**
 * @author patrizio
 * @since 28/02/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class GeoLocationTeste {

	@Autowired
	private GeoLocationInterface geoLocationInterface;

	@Test
	public void test() {
		GeoLocalizacao localizacao = geoLocationInterface.obterGeoLocalizacaoPorEndereco("Avenida dos Carvalhos Carapicuíba");
		
		Assert.assertNotNull(localizacao);
		Assert.assertEquals(BigDecimal.valueOf(-23.563468), localizacao.getLatitude());
		Assert.assertEquals(BigDecimal.valueOf(-46.8687953), localizacao.getLongitude());
	}

}
