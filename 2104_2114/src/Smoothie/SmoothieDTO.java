package Smoothie;
 
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
 
public class SmoothieDTO implements java.io.Serializable{
    private String bname;
    private int orange_d;
    private int orange_m;
    private int orange_s;
    private int kiwi_d;
    private int kiwi_m;
    private int kiwi_s;
    private int grape_d;
    private int grape_m;
    private int grape_s;
    private int straw_d;
    private int straw_m;
    private int straw_s;
    private int water_d;
    private int water_m;
    private int water_s;
    // 이러한 객체를 vo 객체라고 할 수 있다.
     
    public SmoothieDTO() {
         
    }

	public SmoothieDTO(String bname, int orange_d, int orange_m, int orange_s, int kiwi_d, int kiwi_m, int kiwi_s,
			int grape_d, int grape_m, int grape_s, int straw_d, int straw_m, int straw_s, int water_d, int water_m,
			int water_s) {
		super();
		this.bname = bname;
		this.orange_d = orange_d;
		this.orange_m = orange_m;
		this.orange_s = orange_s;
		this.kiwi_d = kiwi_d;
		this.kiwi_m = kiwi_m;
		this.kiwi_s = kiwi_s;
		this.grape_d = grape_d;
		this.grape_m = grape_m;
		this.grape_s = grape_s;
		this.straw_d = straw_d;
		this.straw_m = straw_m;
		this.straw_s = straw_s;
		this.water_d = water_d;
		this.water_m = water_m;
		this.water_s = water_s;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getOrange_d() {
		return orange_d;
	}

	public void setOrange_d(int orange_d) {
		this.orange_d = orange_d;
	}

	public int getOrange_m() {
		return orange_m;
	}

	public void setOrange_m(int orange_m) {
		this.orange_m = orange_m;
	}

	public int getOrange_s() {
		return orange_s;
	}

	public void setOrange_s(int orange_s) {
		this.orange_s = orange_s;
	}

	public int getKiwi_d() {
		return kiwi_d;
	}

	public void setKiwi_d(int kiwi_d) {
		this.kiwi_d = kiwi_d;
	}

	public int getKiwi_m() {
		return kiwi_m;
	}

	public void setKiwi_m(int kiwi_m) {
		this.kiwi_m = kiwi_m;
	}

	public int getKiwi_s() {
		return kiwi_s;
	}

	public void setKiwi_s(int kiwi_s) {
		this.kiwi_s = kiwi_s;
	}

	public int getGrape_d() {
		return grape_d;
	}

	public void setGrape_d(int grape_d) {
		this.grape_d = grape_d;
	}

	public int getGrape_m() {
		return grape_m;
	}

	public void setGrape_m(int grape_m) {
		this.grape_m = grape_m;
	}

	public int getGrape_s() {
		return grape_s;
	}

	public void setGrape_s(int grape_s) {
		this.grape_s = grape_s;
	}

	public int getStraw_d() {
		return straw_d;
	}

	public void setStraw_d(int straw_d) {
		this.straw_d = straw_d;
	}

	public int getStraw_m() {
		return straw_m;
	}

	public void setStraw_m(int straw_m) {
		this.straw_m = straw_m;
	}

	public int getStraw_s() {
		return straw_s;
	}

	public void setStraw_s(int straw_s) {
		this.straw_s = straw_s;
	}

	public int getWater_d() {
		return water_d;
	}

	public void setWater_d(int water_d) {
		this.water_d = water_d;
	}

	public int getWater_m() {
		return water_m;
	}

	public void setWater_m(int water_m) {
		this.water_m = water_m;
	}

	public int getWater_s() {
		return water_s;
	}

	public void setWater_s(int water_s) {
		this.water_s = water_s;
	}
}