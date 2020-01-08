package entities;

public enum OrderStatus {
	INITIAL,
	PROCESSING,
	COMPLETE,
	FAILURE;
	
	@Override
	public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }
}
