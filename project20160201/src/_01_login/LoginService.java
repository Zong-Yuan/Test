package _01_login;


import _99_star.Allmember;

public class LoginService {
	public Object cheakID(String mail, String pwd){
		Object ch = "";
		Allmember cheak = new Allmember();
		ch = cheak.checkID(mail, pwd);
		//System.out.println("ch2=" + ch);
		return ch;
	}
}
