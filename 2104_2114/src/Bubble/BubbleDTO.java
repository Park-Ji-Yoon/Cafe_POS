package Bubble;
 
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
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
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