package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다)
public class BackgroundMapService implements Runnable{

	// 의존해야 될 애들을 컴포지션(결합)
	// 컴포지션
	private Player player;
	private BufferedImage image; // 용량의 크기르 모르니까 buffered

	// 컴포지션을 위한 = 의존성 주입(생성자를 통해서 주입) = DI(Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw하게 읽는다는 뜻 : 날 것 그대로 읽는다
			image = ImageIO.read(new File("image/test.png")); // JLabel 은 이미지가 붙는거라서 안된다.
			// System.out.println(image);
			// System.out.println(image.getRGB(10,10));
		} catch (Exception e) {
	            e.printStackTrace();
	         }
	}
			@Override
			   public void run() {
			      // 색상계산(while)
			      while (true) {
			         try {
			            Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
			            System.out.println(color.getRed());
			            System.out.println(color.getGreen());
			            System.out.println(color.getBlue());
			            System.out.println("=================");
			            Thread.sleep(10); // 충돌감지를 미세하게 하는 조절법
			         } catch (Exception e) {
			            e.printStackTrace();
			         }
			      }
			   }
			}