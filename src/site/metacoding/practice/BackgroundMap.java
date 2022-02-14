package site.metacoding.practice;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//진짜 백그라운드
public class BackgroundMap extends JLabel{
	
	private ImageIcon backgroundMap; // 눈에 보이는 용
	
	// 계산용 백그라운드
	private BufferedImage image; // 눈에 안보이는 용
	 

	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
	}


	public BackgroundMap() {
		
		try {
			// raw 하게 읽는 다는 뜻 : 낡것 그대로 읽는 것
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		backgroundMap = new ImageIcon("image/backgroundMap.png");
		setIcon(backgroundMap); // div 박스에 이미지 넣기
		
		
		
	}

}


