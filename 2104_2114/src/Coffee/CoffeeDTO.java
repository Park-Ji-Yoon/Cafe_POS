package Coffee;
 
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
 
public class CoffeeDTO implements java.io.Serializable{
    private String bname;
    private int ice_d;
    private int ice_m;
    private int ice_s;
    private int hot_d;
    private int hot_m;
    private int hot_s;
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
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