package site.metacoding.bubble.test;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author 아라 1. 플레이어 좌우 이동 2. 점프 3. 방을발사(이건 나중!)
 */

public class Player extends JLabel {

	private ImageIcon PlayerR, PlayerL;
	private int x;
	private int y;

	public static final int SPEED = 2; // 나중에 스피드를 하나하나 다 수정해야하면 번거로우니까 띄워놓기
	public static final int JUMPSPEED = 2;
	
	// 위치 확인을 위한 boolean 생성
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		PlayerR = new ImageIcon("image/playerR.png");
		PlayerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535; // 플레이어가 처음 띄워질 위치
		setIcon(PlayerR);
		setSize(50, 50); // 아이콘 크기
		setLocation(x, y);

		isRight = false; // 기본 상태값 설정 : 어느쪽으로도 움직이는 상태가 아니니까
		isLeft = false;
		isJump = false;

	}

	// 오른쪽 왼쪽 키 생성

	public void left() {
		isLeft = true;
		setIcon(PlayerL); // 왼쪽으로 갈땐 왼쪽 바라보는 사진
		System.out.println("왼쪽 이동");
		new Thread(() -> { // 새로운 스레드를 만들어 메인스레드가 일하는걸 돕자
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // x,y 좌표를 새로 그린다.
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	public void right() {
		isRight = true;
		setIcon(PlayerR); // 왼쪽에서 오른쪽으로 갈 때 바뀌어야 하니까
		System.out.println("오른쪽 이동");

		// 부드럽게 이동하기 위해 while, 키보드에서 손을 뗐다는 걸 인식할 틈을 주기 위한 스레드 이용

		new Thread(() -> { // 새로운 스레드를 만들어 메인스레드가 일하는걸 돕자
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // x,y 좌표를 새로 그린다.
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	// 점프하기
	public void Jump() {
		isJump = true;
		System.out.println("점프");
		
		// 점프는 for문 
		
		new Thread(() -> { // 새로운 스레드를 만들어 메인스레드가 일하는걸 돕자
			// up
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y=y-JUMPSPEED;
				setLocation(x, y);
				
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//down
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y=y+JUMPSPEED;
				setLocation(x, y);
				
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}).start();

	}

}
