package Manager;
 
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
 
public class ManagerDTO implements java.io.Serializable{
    private String g_name;
    private String g_id;
    private String g_pw;
    private String g_bname;
    private String g_bphone;
    private int g_em;
    // �̷��� ��ü�� vo ��ü��� �� �� �ִ�.
     
    public ManagerDTO() {
         
    }
     
    public ManagerDTO(String g_name, String g_id, String g_pw, String g_bname, String g_bphone, int g_em) {
        super();
        this.g_name = g_name;
        this.g_id = g_id;
        this.g_pw = g_pw;
        this.g_bname = g_bname;
        this.g_bphone = g_bphone;
        this.g_em = g_em;
    }

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getG_id() {
		return g_id;
	}

	public void setG_id(String g_id) {
		this.g_id = g_id;
	}

	public String getG_pw() {
		return g_pw;
	}

	public void setG_pw(String g_pw) {
		this.g_pw = g_pw;
	}

	public String getG_bname() {
		return g_bname;
	}

	public void setG_bname(String g_bname) {
		this.g_bname = g_bname;
	}

	public String getG_bphone() {
		return g_bphone;
	}

	public void setG_bphone(String g_bphone) {
		this.g_bphone = g_bphone;
	}

	public int getG_em() {
		return g_em;
	}

	public void setG_em(int g_em) {
		this.g_em = g_em;
	}    
}