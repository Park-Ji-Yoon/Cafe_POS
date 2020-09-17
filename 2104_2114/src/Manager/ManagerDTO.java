package Manager;
 
import java.sql.Date;
 
// 보통 vo 클래스 파일의 이름을 DB의 이름과 같게한다.
 
// vo(value object) == entity == record == row
// do(domain object) == dto(data transfer object)
// DB 테이블의 한 행의 정보가 기록되는 저장용 객체
 
// 1. 반드시 캡슐화가 적용되어야 한다 : 모든 필드는 private가 된다.
// 2. 기본 생성자와 매개변수 있는 생성자를 작성해야 한다. (매개변수가 있는 생성자가 있다면 기본 생성자를 jvm에서 생성해주지 않기 때문)
// 3. 모든 필드에 대해 getter와 setter 작성해야 한다.
// 4. 직렬화 처리를 해야 한다.
// optional. toString() 오버라이딩 <- 필드값을 확인하기 위해
 
public class ManagerDTO implements java.io.Serializable{
    private String g_name;
    private String g_id;
    private String g_pw;
    private String g_bname;
    private String g_bphone;
    private int g_em;
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
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
