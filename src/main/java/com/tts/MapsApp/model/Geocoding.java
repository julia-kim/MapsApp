package com.tts.MapsApp.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Geocoding {
	private Geometry geometry;
	
	@JsonProperty("address_components")
	private List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
}
