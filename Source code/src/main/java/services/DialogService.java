package services;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

@Stateless
public class DialogService{
	public Map<String, Object> createDialogOption() {
		Map<String, Object> options = new HashMap<>();
		options.put("modal", true);
		options.put("width", 600);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");
		return options;
	}
}
