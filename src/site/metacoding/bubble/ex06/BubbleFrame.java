package site.metacoding.bubble.ex06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
   /**
    * 
    * @ author 메타코딩 목적: 색상감지
    * 맵 서비스 - 충돌감지
    * 서비스 -> 항상백그라운드에서 계속 돌면서
    */

   private JLabel backgroundMap;
   private Player player;
   
   int count = 0;

   public BubbleFrame() {
      initObject();
      initSetting();
      initListener();
      initService();
      setVisible(true); // 내부에 paintComponent()호출 코드가 있다.
      
   }

   private void initService() {
	   new Thread(()->{
		   new Thread(new BackgroundMapService(player));
	   }).start();
   }
//new 하는 것
   private void initObject() {
      backgroundMap = new JLabel(new ImageIcon("image/test.png"));
      add(backgroundMap);
      setContentPane(backgroundMap); // 백그라운드 화면

      player = new Player();
      add(player);
      
      
   }

   // 각종 모든 세팅
   private void initSetting() {
      setSize(1000, 640);
      getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정 , setContentPane 주석처리 안하면 add할때어디에 줄지 위치 지정을
                                 // 해야한다
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
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
               // isRight를 false
               player.setRight(false);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
               player.setLeft(false);

            }

         }

         @Override
         public void keyPressed(KeyEvent e) { // 키보드를 누르면
            // 왼쪽 37, 오른쪽은 39, 위쪽은 38, 아래쪽은 40
            // System.out.println("키보드 프레스 :" +e.getKeyCode());

            if (e.getKeyCode() == 39) {
               if (!player.isRight()) {
                  // 키보드를 누르고 있는 동안 right 메서드를 한번만 실행하고 싶다. -> 누르고 있는지 누르고 있지않은지에 대한 상태변수 필요

                  player.right();

               }
            } else if (e.getKeyCode() == 37) {
               if (!player.isLeft()) {
                  player.left();

               }
            } else if (e.getKeyCode() == 38) { // 이걸 막으면 이벤트 루프 등록을 안하는것 => 키프레스 메서드를 타기 때문에 안된다
            	if(!player.isJUmp()) {
            		System.out.println("카운트");
            		count ++;
            		player.Jump(); // 메서드 내부에 if 분기 처리는 이벵트 루프에 등록은 되는데 실행이 안되는 것
            	}
            }
      
         }

      }); // 대상이 없기때문에

   }

   public static void main(String[] args) {
      new BubbleFrame();
   }

}