package Coffee;
 
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
 
public class CoffeeDTO implements java.io.Serializable{
    private String bname;
    private int ice_d;
    private int ice_m;
    private int ice_s;
    private int hot_d;
    private int hot_m;
    private int hot_s;
    // �̷��� ��ü�� vo ��ü��� �� �� �ִ�.
     
    public CoffeeDTO() {
         
    }

	public CoffeeDTO(String bname, int ice_d, int ice_m, int ice_s, int hot_d, int hot_m, int hot_s) {
		super();
		this.bname = bname;
		this.ice_d = ice_d;
		this.ice_m = ice_m;
		this.ice_s = ice_s;
		this.hot_d = hot_d;
		this.hot_m = hot_m;
		this.hot_s = hot_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getIce_d() {
		return ice_d;
	}

	public void setIce_d(int ice_d) {
		this.ice_d = ice_d;
	}

	public int getIce_m() {
		return ice_m;
	}

	public void setIce_m(int ice_m) {
		this.ice_m = ice_m;
	}

	public int getIce_s() {
		return ice_s;
	}

	public void setIce_s(int ice_s) {
		this.ice_s = ice_s;
	}

	public int getHot_d() {
		return hot_d;
	}

	public void setHot_d(int hot_d) {
		this.hot_d = hot_d;
	}

	public int getHot_m() {
		return hot_m;
	}

	public void setHot_m(int hot_m) {
		this.hot_m = hot_m;
	}

	public int getHot_s() {
		return hot_s;
	}

	public void setHot_s(int hot_s) {
		this.hot_s = hot_s;
	}
}