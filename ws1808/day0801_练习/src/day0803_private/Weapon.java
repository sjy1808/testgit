package day0803_private;

public interface Weapon {
	public static final int TYPE_CLOD = 0;
	public static final int TYPE_HOT = 1;
	public static final int TYPE_NUCLEAR = 2;

	public abstract void kill();

	public abstract String getName();

	public abstract int getType();

}
