package Cake;
 
import java.sql.Date;
 
// ���� vo Ŭ���� ������ �̸��� DB�� �̸��� �����Ѵ�.
 
// vo(value object) == entity == record == row
// do(domain object) == dto(data transfer object)
// DB ���̺��� �� ���� ������ ��ϵǴ� ����� ��ü
 
// 1. �ݵ�� ĸ��ȭ�� ����Ǿ�� �Ѵ� : ��� �ʵ�� private�� �ȴ�.
// 2. �⺻ �����ڿ� �Ű����� �ִ� �����ڸ� �ۼ��ؾ� �Ѵ�. (�Ű������� �ִ� �����ڰ� �ִٸ� �⺻ �����ڸ� jvm���� ���������� �ʱ� ����)
// 3. ��� �ʵ忡 ���� getter�� setter �ۼ��ؾ� �Ѵ�.
// 4. ����ȭ ó���� �ؾ� �Ѵ�.
// optional. toString() �������̵� <- �ʵ尪�� Ȯ���ϱ� ����
 
public class CakeDTO implements java.io.Serializable{
    private String bname;
    private int cheese_d;
    private int cheese_m;
    private int cheese_s;
    private int sc_d;
    private int sc_m;
    private int sc_s;
    private int choco_d;
    private int choco_m;
    private int choco_s;
    // �̷��� ��ü�� vo ��ü��� �� �� �ִ�.
     
    public CakeDTO() {
         
    }

	public CakeDTO(String bname, int cheese_d, int cheese_m, int cheese_s, int sc_d, int sc_m, int sc_s, int choco_d,
			int choco_m, int choco_s) {
		super();
		this.bname = bname;
		this.cheese_d = cheese_d;
		this.cheese_m = cheese_m;
		this.cheese_s = cheese_s;
		this.sc_d = sc_d;
		this.sc_m = sc_m;
		this.sc_s = sc_s;
		this.choco_d = choco_d;
		this.choco_m = choco_m;
		this.choco_s = choco_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getCheese_d() {
		return cheese_d;
	}

	public void setCheese_d(int cheese_d) {
		this.cheese_d = cheese_d;
	}

	public int getCheese_m() {
		return cheese_m;
	}

	public void setCheese_m(int cheese_m) {
		this.cheese_m = cheese_m;
	}

	public int getCheese_s() {
		return cheese_s;
	}

	public void setCheese_s(int cheese_s) {
		this.cheese_s = cheese_s;
	}

	public int getSc_d() {
		return sc_d;
	}

	public void setSc_d(int sc_d) {
		this.sc_d = sc_d;
	}

	public int getSc_m() {
		return sc_m;
	}

	public void setSc_m(int sc_m) {
		this.sc_m = sc_m;
	}

	public int getSc_s() {
		return sc_s;
	}

	public void setSc_s(int sc_s) {
		this.sc_s = sc_s;
	}

	public int getChoco_d() {
		return choco_d;
	}

	public void setChoco_d(int choco_d) {
		this.choco_d = choco_d;
	}

	public int getChoco_m() {
		return choco_m;
	}

	public void setChoco_m(int choco_m) {
		this.choco_m = choco_m;
	}

	public int getChoco_s() {
		return choco_s;
	}

	public void setChoco_s(int choco_s) {
		this.choco_s = choco_s;
	}
}