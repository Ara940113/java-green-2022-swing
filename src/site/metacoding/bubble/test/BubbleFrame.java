package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
	
	/**
	 * @author �ƶ� ���� : 
	 * 1.���ȭ�鼳���ϱ�, �÷��̾� �߰��ϱ�
	 * 2. �÷��̾��� �¿��̵�
	 * 3. �ε巴�� �̵��ϱ�
	 * */
	
	private JLabel backgroundMap;
	private Player player;
	
	
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	
	// ���� ȭ�鿡 ��� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);
	}
	
	// ���� ����
	private void initSetting() {
		// �⺻ ���ȭ�� ����
		setSize(1000,640);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// �÷��̾��� �¿� �̵��� ���ؼ� Ű���带 ���Ѻ� �����ʰ� �ʿ��ϴ�
	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {	// Ű���� ������ ����
				System.out.println("Ű���� ������");
				if(e.getKeyCode() == 39) {
					player.setRight(false);
				}else if (e.getKeyCode() == 37) {
					player.setLeft(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {	// Ű���带 ������
				//��-37 ��-39 ��-38 ��-40
				//System.out.println("Ű���� ������" + e.getKeyCode()); // getkeycode : Ű������ ���� �����ش�.
				
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
