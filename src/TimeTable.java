import java.awt.*;
import javax.swing.*;

public class TimeTable extends JFrame {
	private Dimension frameSize, screenSize;
	private JPanel panel = new JPanel();
	private int width;
	private int height;
	private String formatedNow;
	
	private JLabel todayLabel;

	// 생성자. n은 해당 날짜를 나타내기 위해 추가.(now + n)
	public TimeTable(int width, int height, int n, String formatter) {
		setTitle("예약페이지");
		this.width = width;
		this.height = height;

		setSize(this.width, this.height); // 가로 세로 1000 560 크기 - 이미지 크기에 맞춤
		setContentPane(panel);
		screenSizeLocation(); // 창 화면 중앙에 위치
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null); // 절대좌표 사용하기 위해 레이아웃 null

		addTodayLabel(n);
	}

	public void addTodayLabel(int n) {
		
		//오늘 날짜	
		todayLabel = new JLabel(formatedNow+n); //formatedNow가 안넘어옴
		todayLabel.setOpaque(true);
		todayLabel.setBounds(20,0,150,30);
		todayLabel.setBackground(Color.LIGHT_GRAY);
		panel.add(todayLabel);
	}

	// 창 화면 중앙에 위치
	private void screenSizeLocation() {
		frameSize = getSize();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	/*
	 * public static void main(String[] args) { new TimeTable(200, 350, 0); }
	 */
}
