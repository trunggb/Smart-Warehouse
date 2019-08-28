package bom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bot {
	
	private int id;
	
	private String name;
	
	private Location currentLocation;
	
	private Location initLocation;
}
