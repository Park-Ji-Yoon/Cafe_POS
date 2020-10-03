package Tea;
 
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
 
public class TeaDTO implements java.io.Serializable{
    private String bname;
    private int green_d;
    private int green_m;
    private int green_s;
    private int black_d;
    private int black_m;
    private int black_s;
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
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
