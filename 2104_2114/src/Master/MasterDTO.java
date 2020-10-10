package Master;
 
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
 
public class MasterDTO implements java.io.Serializable{
    private String s_name;
    private String s_id;
    private String s_pw;
    private String s_security;
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
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