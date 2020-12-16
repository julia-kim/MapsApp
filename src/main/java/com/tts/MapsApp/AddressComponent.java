package com.tts.MapsApp;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AddressComponent {
	private String longName;
	private String shortName;
	private List<String> types = new ArrayList<String>();
}
