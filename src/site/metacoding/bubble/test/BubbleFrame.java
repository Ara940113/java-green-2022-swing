package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
	
	/**
	 * @author 아라 목적 : 
	 * 1.배경화면설정하기, 플레이어 추가하기
	 * 2. 플레이어의 좌우이동
	 * 3. 부드럽게 이동하기
	 * */
	
	private JLabel backgroundMap;
	private Player player;
	
	
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	
	// 내가 화면에 띄울 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);
	}
	
	// 각종 세팅
	private void initSetting() {
		// 기본 배경화면 세팅
		setSize(1000,640);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// 플레이어의 좌우 이동을 위해서 키보드를 지켜볼 리스너가 필요하다
	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {	// 키보드 누른걸 떼면
				System.out.println("키보드 릴리즈");
				if(e.getKeyCode() == 39) {
					player.setRight(false);
				}else if (e.getKeyCode() == 37) {
					player.setLeft(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {	// 키보드를 누르면
				//좌-37 우-39 상-38 하-40
				//System.out.println("키보드 프레스" + e.getKeyCode()); // getkeycode : 키보드의 값을 보여준다.
				
				if(e.getKeyCode() == 39) {
					player.right();
				}else if (e.getKeyCode() == 37) {
					player.left();
				}else if (e.getKeyCode() == 38) {
					player.Jump();
				
			}
		
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		new BubbleFrame();
	}

}
