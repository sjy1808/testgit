package cn.tedu;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TUser implements Serializable {

	private int id;
	private String name;
	private Set<TBook> books=new HashSet<TBook>();
	public TUser() {}
	
	public Set<TBook> getBooks() {
		return books;
	}

	public void setBooks(Set<TBook> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TUser other = (TUser) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TUser [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
}
