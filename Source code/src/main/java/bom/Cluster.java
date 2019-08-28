package bom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cluster {
	
	private int id;
	
	private String name;
	
	private Location location;
}
