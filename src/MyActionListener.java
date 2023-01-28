import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//버튼 이벤트 처리를 위한 클래스
public class MyActionListener implements ActionListener {

	private int n; //오늘 날짜+n 으로 해당 날짜 표시
	private String dayString[] = { "일", "월", "화", "수", "목", "금", "토" };
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private LocalDate now = LocalDate.now();
	private String formatedNow = now.format(formatter);
	private int dayOfWeekValue = now.getDayOfWeek().getValue();
	
	//생성자
	MyActionListener(int n){
		this.n=n;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new TimeTable(200,350,n, formatedNow); //예약 타임 테이블
		System.out.println(formatedNow);
		//지금은 버튼 누를때 마다 새 TimeTable 클래스가 생성되니
		//미리 클래스를 만들어 놓고 버튼을 누르면 해당 날짜의 클래스를 불러오는 식으로 변경
	}

}
