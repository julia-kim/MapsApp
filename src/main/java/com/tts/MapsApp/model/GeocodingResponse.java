package com.tts.MapsApp.model;

import java.util.List;

import lombok.Data;

@Data
public class GeocodingResponse {
	private List<Geocoding> results;
}
