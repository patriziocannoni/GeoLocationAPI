package br.com.cannoni.geolocation.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Patrizio
 * @since 02/12/2014
 */
public class GeoLocalizacao implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -8415743965620566197L;

	/**
	 * Latitude terrestre.
	 */
	private BigDecimal latitude;

	/**
	 * Longitude terrestre.
	 */
	private BigDecimal longitude;

	/**
	 * Construtor.
	 */
	public GeoLocalizacao(final BigDecimal pLatitude, final BigDecimal pLongitude) {
		super();
		this.latitude = pLatitude;
		this.longitude = pLongitude;
	}

	/**
	 * @return the latitude
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}

}
