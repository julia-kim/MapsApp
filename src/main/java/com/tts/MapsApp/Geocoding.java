package com.tts.MapsApp;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Geocoding {
	private Geometry geometry;
	private List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
}
