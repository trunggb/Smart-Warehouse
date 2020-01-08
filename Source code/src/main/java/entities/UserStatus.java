package entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
	ACTIVE,
	INACTIVE,
	BLOCKED;
	
	@Override
	public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }
}
