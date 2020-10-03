package Macaron;
 
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
 
public class MacaronDTO implements java.io.Serializable{
    private String bname;
    private int berry_d;
    private int berry_m;
    private int berry_s;
    private int yogurt_d;
    private int yogurt_m;
    private int yogurt_s;
    private int fruit_d;
    private int fruit_m;
    private int fruit_s;
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
    public MacaronDTO() {
         
    }

	public MacaronDTO(String bname, int berry_d, int berry_m, int berry_s, int yogurt_d, int yogurt_m, int yogurt_s,
			int fruit_d, int fruit_m, int fruit_s) {
		super();
		this.bname = bname;
		this.berry_d = berry_d;
		this.berry_m = berry_m;
		this.berry_s = berry_s;
		this.yogurt_d = yogurt_d;
		this.yogurt_m = yogurt_m;
		this.yogurt_s = yogurt_s;
		this.fruit_d = fruit_d;
		this.fruit_m = fruit_m;
		this.fruit_s = fruit_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getBerry_d() {
		return berry_d;
	}

	public void setBerry_d(int berry_d) {
		this.berry_d = berry_d;
	}

	public int getBerry_m() {
		return berry_m;
	}

	public void setBerry_m(int berry_m) {
		this.berry_m = berry_m;
	}

	public int getBerry_s() {
		return berry_s;
	}

	public void setBerry_s(int berry_s) {
		this.berry_s = berry_s;
	}

	public int getYogurt_d() {
		return yogurt_d;
	}

	public void setYogurt_d(int yogurt_d) {
		this.yogurt_d = yogurt_d;
	}

	public int getYogurt_m() {
		return yogurt_m;
	}

	public void setYogurt_m(int yogurt_m) {
		this.yogurt_m = yogurt_m;
	}

	public int getYogurt_s() {
		return yogurt_s;
	}

	public void setYogurt_s(int yogurt_s) {
		this.yogurt_s = yogurt_s;
	}

	public int getFruit_d() {
		return fruit_d;
	}

	public void setFruit_d(int fruit_d) {
		this.fruit_d = fruit_d;
	}

	public int getFruit_m() {
		return fruit_m;
	}

	public void setFruit_m(int fruit_m) {
		this.fruit_m = fruit_m;
	}

	public int getFruit_s() {
		return fruit_s;
	}

	public void setFruit_s(int fruit_s) {
		this.fruit_s = fruit_s;
	}
    

}
