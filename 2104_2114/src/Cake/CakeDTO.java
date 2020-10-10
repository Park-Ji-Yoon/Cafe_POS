package Cake;
 
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
 
public class CakeDTO implements java.io.Serializable{
    private String bname;
    private int cheese_d;
    private int cheese_m;
    private int cheese_s;
    private int sc_d;
    private int sc_m;
    private int sc_s;
    private int choco_d;
    private int choco_m;
    private int choco_s;
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
    public CakeDTO() {
         
    }

	public CakeDTO(String bname, int cheese_d, int cheese_m, int cheese_s, int sc_d, int sc_m, int sc_s, int choco_d,
			int choco_m, int choco_s) {
		super();
		this.bname = bname;
		this.cheese_d = cheese_d;
		this.cheese_m = cheese_m;
		this.cheese_s = cheese_s;
		this.sc_d = sc_d;
		this.sc_m = sc_m;
		this.sc_s = sc_s;
		this.choco_d = choco_d;
		this.choco_m = choco_m;
		this.choco_s = choco_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getCheese_d() {
		return cheese_d;
	}

	public void setCheese_d(int cheese_d) {
		this.cheese_d = cheese_d;
	}

	public int getCheese_m() {
		return cheese_m;
	}

	public void setCheese_m(int cheese_m) {
		this.cheese_m = cheese_m;
	}

	public int getCheese_s() {
		return cheese_s;
	}

	public void setCheese_s(int cheese_s) {
		this.cheese_s = cheese_s;
	}

	public int getSc_d() {
		return sc_d;
	}

	public void setSc_d(int sc_d) {
		this.sc_d = sc_d;
	}

	public int getSc_m() {
		return sc_m;
	}

	public void setSc_m(int sc_m) {
		this.sc_m = sc_m;
	}

	public int getSc_s() {
		return sc_s;
	}

	public void setSc_s(int sc_s) {
		this.sc_s = sc_s;
	}

	public int getChoco_d() {
		return choco_d;
	}

	public void setChoco_d(int choco_d) {
		this.choco_d = choco_d;
	}

	public int getChoco_m() {
		return choco_m;
	}

	public void setChoco_m(int choco_m) {
		this.choco_m = choco_m;
	}

	public int getChoco_s() {
		return choco_s;
	}

	public void setChoco_s(int choco_s) {
		this.choco_s = choco_s;
	}
}