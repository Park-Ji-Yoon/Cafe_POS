package Bubble;
 
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
 
public class BubbleDTO implements java.io.Serializable{
    private String bname;
    private int bs_d;
    private int bs_m;
    private int bs_s;
    private int taro_d;
    private int taro_m;
    private int taro_s;
    private int gb_d;
    private int gb_m;
    private int gb_s;
    // �̷��� ��ü�� vo ��ü��� �� �� �ִ�.
     
    public BubbleDTO() {
         
    }

	public BubbleDTO(String bname, int bs_d, int bs_m, int bs_s, int taro_d, int taro_m, int taro_s, int gb_d, int gb_m,
			int gb_s) {
		super();
		this.bname = bname;
		this.bs_d = bs_d;
		this.bs_m = bs_m;
		this.bs_s = bs_s;
		this.taro_d = taro_d;
		this.taro_m = taro_m;
		this.taro_s = taro_s;
		this.gb_d = gb_d;
		this.gb_m = gb_m;
		this.gb_s = gb_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getBs_d() {
		return bs_d;
	}

	public void setBs_d(int bs_d) {
		this.bs_d = bs_d;
	}

	public int getBs_m() {
		return bs_m;
	}

	public void setBs_m(int bs_m) {
		this.bs_m = bs_m;
	}

	public int getBs_s() {
		return bs_s;
	}

	public void setBs_s(int bs_s) {
		this.bs_s = bs_s;
	}

	public int getTaro_d() {
		return taro_d;
	}

	public void setTaro_d(int taro_d) {
		this.taro_d = taro_d;
	}

	public int getTaro_m() {
		return taro_m;
	}

	public void setTaro_m(int taro_m) {
		this.taro_m = taro_m;
	}

	public int getTaro_s() {
		return taro_s;
	}

	public void setTaro_s(int taro_s) {
		this.taro_s = taro_s;
	}

	public int getGb_d() {
		return gb_d;
	}

	public void setGb_d(int gb_d) {
		this.gb_d = gb_d;
	}

	public int getGb_m() {
		return gb_m;
	}

	public void setGb_m(int gb_m) {
		this.gb_m = gb_m;
	}

	public int getGb_s() {
		return gb_s;
	}

	public void setGb_s(int gb_s) {
		this.gb_s = gb_s;
	}
  

}