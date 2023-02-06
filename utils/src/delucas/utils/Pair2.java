package delucas.utils;

import java.util.Objects;

public class Pair2<X, Y> {
	
	X x;
	Y y;

	public Pair2(X x, Y y) {
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
		@SuppressWarnings("unchecked")
		Pair2<X, Y> other = (Pair2<X, Y>) obj;
		return x.equals(other.x) && y.equals(other.y);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
