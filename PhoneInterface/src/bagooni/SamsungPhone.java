package bagooni;

interface PhoneInterface {
	final int TIMEOUT = 10000;

	void sendCall();

	void receiveCall();

	default void printLogo() {
		System.out.println("** phone **");
	}
}

interface AIInterface{
	void recognizeSpeech();
	void synthesizeSpeech();
}
interface MobilePhoneInterface extends PhoneInterface{
	
}

class PDA{
	
}
public class SamsungPhone extends PDA implements PhoneInterface, AIInterface {
	@Override
	public void sendCall() {
		System.out.println("띠리리리");

	}

	@Override
	public void receiveCall() {
		System.out.println("전화가 왔습니다");
	}
	
	public void recognizeSpeech() {}
	public void synthesizeSpeech() {}
	
	public static void main(String[] args) {
		SamsungPhone phone = new SamsungPhone();
		phone.sendCall();
	}

}
