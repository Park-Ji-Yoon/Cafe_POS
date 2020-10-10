package Tea;
 
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
 
public class TeaDTO implements java.io.Serializable{
    private String bname;
    private int green_d;
    private int green_m;
    private int green_s;
    private int black_d;
    private int black_m;
    private int black_s;
    // �̷��� ��ü�� vo ��ü��� �� �� �ִ�.
     
    public TeaDTO() {
         
    }

	public TeaDTO(String bname, int green_d, int green_m, int green_s, int black_d, int black_m, int black_s) {
		super();
		this.bname = bname;
		this.green_d = green_d;
		this.green_m = green_m;
		this.green_s = green_s;
		this.black_d = black_d;
		this.black_m = black_m;
		this.black_s = black_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getGreen_d() {
		return green_d;
	}

	public void setGreen_d(int green_d) {
		this.green_d = green_d;
	}

	public int getGreen_m() {
		return green_m;
	}

	public void setGreen_m(int green_m) {
		this.green_m = green_m;
	}

	public int getGreen_s() {
		return green_s;
	}

	public void setGreen_s(int green_s) {
		this.green_s = green_s;
	}

	public int getBlack_d() {
		return black_d;
	}

	public void setBlack_d(int black_d) {
		this.black_d = black_d;
	}

	public int getBlack_m() {
		return black_m;
	}

	public void setBlack_m(int black_m) {
		this.black_m = black_m;
	}

	public int getBlack_s() {
		return black_s;
	}

	public void setBlack_s(int black_s) {
		this.black_s = black_s;
	}
}