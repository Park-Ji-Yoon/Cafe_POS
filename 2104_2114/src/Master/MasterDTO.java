package Master;
 
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
 
public class MasterDTO implements java.io.Serializable{
    private String s_name;
    private String s_id;
    private String s_pw;
    private String s_security;
    // �̷��� ��ü�� vo ��ü��� �� �� �ִ�.
     
    public MasterDTO(String s_name, String s_id, String s_pw, String s_security) {
        super();
        this.s_name = s_name;
        this.s_id = s_id;
        this.s_pw = s_pw;
        this.s_security = s_security;
    }

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_pw() {
		return s_pw;
	}

	public void setS_pw(String s_pw) {
		this.s_pw = s_pw;
	}

	public String getS_security() {
		return s_security;
	}

	public void setS_security(String s_security) {
		this.s_security = s_security;
	}
}