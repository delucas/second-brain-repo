package delucas.dp;

public class Box implements Comparable<Box>{

	int l;
	int w;
	int h;

	public Box(int l, int w, int h) {
		super();
		this.l = l;
		this.w = w;
		this.h = h;
	}
	
	public boolean canBeStackedOn(Box other) {
		return this.l < other.l && this.w < other.w;
	}
	
	public static Box infinityBox() {
		return new Box(Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
	}

	@Override
	public int compareTo(Box other) {
		return Integer.compare(this.l, other.l);
	}

	@Override
	public String toString() {
		return "["+ l + "x" + w + "x" + h + "]";
	}
	
	
}
