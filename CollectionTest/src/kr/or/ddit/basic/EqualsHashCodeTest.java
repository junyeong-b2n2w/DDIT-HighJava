package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person();
		
		p1.setId(1);
		p1.setName("심밍구");
		
		Person p2 = new Person();
		
		p2.setId(1);
		p2.setName("심밍구");
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		HashSet<Person> perSet = new HashSet<>();
		perSet.add(p1);
		perSet.add(p2);
		
		System.out.println(perSet.size());
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}

}

class Person{
	private int id;
	private String name;
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
//	@Override
//	public boolean equals(Object obj) {
//		if(obj == null) return false;
//		
//		if(this.getClass() != obj.getClass()) return false;
//		
//		if(this == obj) return true;
//		
//		Person myPerson = (Person)obj;
//		
//		if(this.name == null && myPerson.getName() != null){
//			return false;
//		}
//		if(this.id == myPerson.getId() && this.name == myPerson.getName()){
//			return true;
//		}
//		if(this.id == myPerson.getId() && this.name.equals(myPerson.getName())){
//			return true;
//		}
//		
//		
//		return false;
//		
//	}
//	
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return super.hashCode();
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}