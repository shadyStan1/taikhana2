package meri.padhai.basic;

class Baap{
	public Baap() {
		System.out.println("hashcode of baap : " + this.hashCode());
	}
}

class Bachcha extends Baap
{
	public Bachcha() {
		System.out.println("hashcode of bachcha : " + this.hashCode());
	}
}
public class ValidateOnlyOneObjectCreation {
	public static void main(String[] args) {
		Bachcha bachcha = new Bachcha();
		System.out.println(bachcha.hashCode());
	}
}
