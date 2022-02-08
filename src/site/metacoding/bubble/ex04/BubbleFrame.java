package site.metacoding.bubble.ex04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	/**
	 * 
	 * @ author 메타코딩 목적: 스무스한 이동
	 */

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // 내부에 paintComponent()호출 코드가 있다.
	}

//new 하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		add(backgroundMap);
		setContentPane(backgroundMap); // 백그라운드 화면
		
		player = new Player();
		add(player);
	}

	// 각종 모든 세팅
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정 , setContentPane 주석처리 안하면 add할때어디에 줄지 위치 지정을 해야한다
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}
	
	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) { // 키보드 누른걸 떼면
				System.out.println("키보드 릴리즈");
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// isRight를 false
					player.setRight(false);
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					 player.setLeft(false);

					
				}
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) { // 키보드를 누르면
				//왼쪽 37, 오른쪽은 39, 위쪽은 38, 아래쪽은 40
			//	System.out.println("키보드 프레스 :" +e.getKeyCode());
				
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// 키보드를 누르고 있는 동안 right 메서드를 한번만 실행하고 싶다. -> 누르고 있는지 누르고 있지않은지에 대한 상태변수 필요
					if(player.isRight () == false) {
						player.right();}
					
					
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(player.isRight () == false) {
						player.left();}
					
				}
			}
		}); // 대상이 없기때문에
		
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}