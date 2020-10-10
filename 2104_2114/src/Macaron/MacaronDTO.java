package Macaron;
 
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
 
public class MacaronDTO implements java.io.Serializable{
    private String bname;
    private int berry_d;
    private int berry_m;
    private int berry_s;
    private int yogurt_d;
    private int yogurt_m;
    private int yogurt_s;
    private int fruit_d;
    private int fruit_m;
    private int fruit_s;
    // �̷��� ��ü�� vo ��ü��� �� �� �ִ�.
     
    public MacaronDTO() {
         
    }

	public MacaronDTO(String bname, int berry_d, int berry_m, int berry_s, int yogurt_d, int yogurt_m, int yogurt_s,
			int fruit_d, int fruit_m, int fruit_s) {
		super();
		this.bname = bname;
		this.berry_d = berry_d;
		this.berry_m = berry_m;
		this.berry_s = berry_s;
		this.yogurt_d = yogurt_d;
		this.yogurt_m = yogurt_m;
		this.yogurt_s = yogurt_s;
		this.fruit_d = fruit_d;
		this.fruit_m = fruit_m;
		this.fruit_s = fruit_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getBerry_d() {
		return berry_d;
	}

	public void setBerry_d(int berry_d) {
		this.berry_d = berry_d;
	}

	public int getBerry_m() {
		return berry_m;
	}

	public void setBerry_m(int berry_m) {
		this.berry_m = berry_m;
	}

	public int getBerry_s() {
		return berry_s;
	}

	public void setBerry_s(int berry_s) {
		this.berry_s = berry_s;
	}

	public int getYogurt_d() {
		return yogurt_d;
	}

	public void setYogurt_d(int yogurt_d) {
		this.yogurt_d = yogurt_d;
	}

	public int getYogurt_m() {
		return yogurt_m;
	}

	public void setYogurt_m(int yogurt_m) {
		this.yogurt_m = yogurt_m;
	}

	public int getYogurt_s() {
		return yogurt_s;
	}

	public void setYogurt_s(int yogurt_s) {
		this.yogurt_s = yogurt_s;
	}

	public int getFruit_d() {
		return fruit_d;
	}

	public void setFruit_d(int fruit_d) {
		this.fruit_d = fruit_d;
	}

	public int getFruit_m() {
		return fruit_m;
	}

	public void setFruit_m(int fruit_m) {
		this.fruit_m = fruit_m;
	}

	public int getFruit_s() {
		return fruit_s;
	}

	public void setFruit_s(int fruit_s) {
		this.fruit_s = fruit_s;
	}
}