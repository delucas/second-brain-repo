package delucas.utils;

import java.util.Objects;

public class Pair {
	
	public int x;
	public int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
