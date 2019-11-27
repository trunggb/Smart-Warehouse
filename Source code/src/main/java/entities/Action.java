package entities;

public enum Action {
	UPDATE,
	DELETE;
	@Override
	public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }
}
