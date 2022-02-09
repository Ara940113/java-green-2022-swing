package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * @author ��Ÿ�ڵ�
 * �÷��̾�� �¿� �̵��� �����ϴ�.
 * ������ �����ϴ�
 * ��� �߻� (���߿� ��������)*/

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	private boolean isRight; // ���������� �����ִ�?
	private boolean isLeft;
	private boolean isJUmp; // ��������(up,down)

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 2;

	public boolean isJUmp() {
		return isJUmp;
	}

	public void setJUmp(boolean isJUmp) {
		this.isJUmp = isJUmp;
	}

	public boolean isRight() { // is�� get�� �ȶ�!
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
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ������

		isRight = false; // ���������� �����̴� ���µ� �������� �����̴� ���µ� �ƴϱ� ������ false
		isLeft = false;
		isJUmp = false;

	}

	public void left() {
		setIcon(playerL);
		isLeft = true;
		System.out.println("���� �̵�");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y);
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
		setIcon(playerR);
		System.out.println("������ �̵�");

		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();

	}

	// Ű���� ������Ű
	public void Jump() {
		System.out.println("����");
		isJUmp = true;
		
		// ������ for���� ������ �ǿ�.->0~130
		// up �϶��� sleep(5)
		
		new Thread(()->{
			//up
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y=y-JUMPSPEED;
				setLocation(x,y);
				
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
			// down
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y=y+JUMPSPEED;
				setLocation(x,y);
				
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			isJUmp = false;
		}).start();
		
			
		
		
	

		// down �϶��� sleep(3)

		
		

	}

}
