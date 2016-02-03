package _02_memodify;

import _00_register.MemberBean;
import _99_star.Allmember;

public class MemodifyService {
	
	public MemberBean Memodify(String mail) {
		MemberBean mb = null;
		Allmember all = new Allmember();
		mb = all.Memodify(mail);
		return mb;

	}
}
