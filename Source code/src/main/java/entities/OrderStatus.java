package entities;

public enum OrderStatus {
	IN_CREATED,
	OUT_CREATED,
	PROCESSING,
	DONE,
	FAILURE;
	
	@Override
	public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }
}
