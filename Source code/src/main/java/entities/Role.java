package entities;

public enum Role {
	ADMIN, USER, GUEST;

	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
	}
}
