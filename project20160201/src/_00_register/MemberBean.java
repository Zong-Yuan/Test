package _00_register;



public class MemberBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int mem_id;
	private String pwd;
	private String mem_name;
	private String identification;
	private String mail;
	private String gender;
	private java.util.Date bdate;
	private int point;
	private java.util.Date join_date;
	
	@Override
	public String toString() {
		return "MemberBean [mem_id=" + mem_id + ", pwd=" + pwd + ", mem_name="
				+ mem_name + ", identification=" + identification + ", mail="
				+ mail + ", gender=" + gender + ", bdate=" + bdate + ", point="
				+ point + ", join_date=" + join_date + "]";
	}
	public  MemberBean(){
		
	}
	public  MemberBean(String mail, String pwd, String mem_name, String identification,
			 String gender, java.util.Date bdate){
		this.pwd = pwd;
		this.mem_name = mem_name;
		this.identification = identification;
		this.mail = mail;
		this.gender = gender;
		this.bdate = bdate;
		
	}
	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.util.Date getBdate() {
		return bdate;
	}
	public void setBdate(java.util.Date bdate) {
		this.bdate = bdate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public java.util.Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(java.util.Date join_date) {
		this.join_date = join_date;
	}
	
	

}
