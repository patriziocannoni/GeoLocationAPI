package br.com.cannoni.geolocation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cannoni.geolocation.model.GeoLocalizacao;
import br.com.cannoni.geolocation.service.GeoLocationInterface;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

/**
 * Implementação da {@link GeoLocationInterface} usando a GeoLocation API do Google.
 * 
 * @author Patrizio
 * @since 02/12/2014
 */
@Service
public class GoogleGeoLocation implements GeoLocationInterface {

	private static final String GEOLOCATION_LANGUAGE = "pt";

	/**
	 * Construtor.
	 */
	private GoogleGeoLocation() {
		super();
	}

	/**
	 * Obtém uma geolocalização por meio da Google Geolocation API.
	 * 
	 * @param endereco
	 *            a String que contém o endereço para pesquisa
	 * @return {@link GeoLocalizacao}
	 */
	@Override
	public GeoLocalizacao obterGeoLocalizacaoPorEndereco(String endereco) {
		GeoLocalizacao geoLocalizacao = null;
		GeocodeResponse geoCoderResponse = null;

		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(endereco.toString())
				.setLanguage(GEOLOCATION_LANGUAGE).getGeocoderRequest();
		geoCoderResponse = geocoder.geocode(geocoderRequest);

		// O objeto geoCoderResponse que Google responde. Pode ser nulo.
		GeocoderStatus status = null;
		if (geoCoderResponse == null) {
			status = GeocoderStatus.ERROR;
		} else {
			status = geoCoderResponse.getStatus();
		}

		switch (status) {
		case OK:
			List<GeocoderResult> listaResultados = geoCoderResponse.getResults();
			GeocoderResult primeiroResultado = listaResultados.get(0);
			LatLng latLng = primeiroResultado.getGeometry().getLocation();
			geoLocalizacao = new GeoLocalizacao(latLng.getLat(), latLng.getLng());
			break;

		case ZERO_RESULTS:
			throw new RuntimeException("Endereço não encontrado na geolocalização.");

		default:
			throw new RuntimeException("Erro na geolocalização: " + status);
		}

		return geoLocalizacao;
	}

}
