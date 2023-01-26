import javax.swing.*;
import java.awt.*;
import java.time.*;

public class AIinterview extends JFrame {
	private Dimension frameSize, screenSize;
	private int width;
	private int height;
	
	private int btnWidth = 120;
	private int btnHeight = 120;
	
	private JPanel panel = new JPanel();
	
	private JButton btnArray[] = new JButton[14];
	private int btnStartX = 45;
	private int btnStartY = 170;
	
	private LocalDate now = LocalDate.now();
	private int dayOfWeekValue = now.getDayOfWeek().getValue();

	public AIinterview(int width, int height) {
		setTitle("AI면접실");
		this.width = width;
		this.height = height;

		setSize(this.width, this.height); // 가로 세로 1000 560 크기 - 이미지 크기에 맞춤
		
		setContentPane(panel);
		panel.setBackground(Color.WHITE);

		screenSizeLocation(); // 창 화면 중앙에 위치
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null); // 절대좌표 사용하기 위해 레이아웃 null

		addButton(); //버튼 삽입
	}
	
	//버튼 삽입
	public void addButton() {
		
		JLabel label = new JLabel("AI 면접실~");
		label.setOpaque(true);
		label.setBounds(45,20,100,30);
		label.setBackground(Color.LIGHT_GRAY);
		this.add(label);

		//버튼 생성
		for(int i=0; i<14; i++) {
			btnArray[i] = new JButton();
			if(i>6)	btnStartY = 300; //두번째 줄 y값
			btnArray[i].setBounds(btnStartX+(130*(i%7)),btnStartY,btnWidth,btnHeight); //버튼 위치, 크기 설정
			btnArray[i].setBackground(Color.LIGHT_GRAY); //버튼 색 설정
			this.add(btnArray[i]); //버튼 화면에 추가
		}
		
		//오늘부터 일주일 뒤 까지 해당 날짜 버튼 색 변경
		for(int i=dayOfWeekValue; i<dayOfWeekValue+7; i++) {
			btnArray[i].setBackground(Color.BLUE);
		}
		
	}

	// 창 화면 중앙에 위치
	private void screenSizeLocation() {
		frameSize = getSize();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	public static void main(String[] args) {
		new AIinterview(1000, 560);
	}

}