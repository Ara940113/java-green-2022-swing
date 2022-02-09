package site.metacoding.bubble.test;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author �ƶ� 1. �÷��̾� �¿� �̵� 2. ���� 3. �����߻�(�̰� ����!)
 */

public class Player extends JLabel {

	private ImageIcon PlayerR, PlayerL;
	private int x;
	private int y;

	public static final int SPEED = 2; // ���߿� ���ǵ带 �ϳ��ϳ� �� �����ؾ��ϸ� ���ŷο�ϱ� �������
	public static final int JUMPSPEED = 2;
	
	// ��ġ Ȯ���� ���� boolean ����
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
		y = 535; // �÷��̾ ó�� ����� ��ġ
		setIcon(PlayerR);
		setSize(50, 50); // ������ ũ��
		setLocation(x, y);

		isRight = false; // �⺻ ���°� ���� : ��������ε� �����̴� ���°� �ƴϴϱ�
		isLeft = false;
		isJump = false;

	}

	// ������ ���� Ű ����

	public void left() {
		isLeft = true;
		setIcon(PlayerL); // �������� ���� ���� �ٶ󺸴� ����
		System.out.println("���� �̵�");
		new Thread(() -> { // ���ο� �����带 ����� ���ν����尡 ���ϴ°� ����
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // x,y ��ǥ�� ���� �׸���.
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
		setIcon(PlayerR); // ���ʿ��� ���������� �� �� �ٲ��� �ϴϱ�
		System.out.println("������ �̵�");

		// �ε巴�� �̵��ϱ� ���� while, Ű���忡�� ���� �ôٴ� �� �ν��� ƴ�� �ֱ� ���� ������ �̿�

		new Thread(() -> { // ���ο� �����带 ����� ���ν����尡 ���ϴ°� ����
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // x,y ��ǥ�� ���� �׸���.
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	// �����ϱ�
	public void Jump() {
		isJump = true;
		System.out.println("����");
		
		// ������ for�� 
		
		new Thread(() -> { // ���ο� �����带 ����� ���ν����尡 ���ϴ°� ����
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
