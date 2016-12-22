package br.com.cannoni.geolocation.service;

import br.com.cannoni.geolocation.model.GeoLocalizacao;

/**
 * @author Patrizio
 * @since 02/12/2014
 */
public interface GeoLocationInterface {

	GeoLocalizacao obterGeoLocalizacaoPorEndereco(String endereco);

}
