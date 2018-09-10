package cn.onlyfm.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haoliang on 2018/7/27.
 */
public class Bigram {
	private final char first;
	private final char second;

	public Bigram(char first, char second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bigram)) {
			return false;
		}
		Bigram b = (Bigram) obj;
		// return b.first == first && b.second == second;
		return b.hashCode() == hashCode();
	}

	// public boolean equals(Bigram b) {
	// 	return b.first == first && b.second == second;
	// }

	@Override
	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<Bigram> s = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			for (char c = 'a'; c <='z' ; c++) {
				s.add(new Bigram(c, c));
			}
		}
		System.out.println(s.size());
	}
}
