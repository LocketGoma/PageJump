import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class Module_Input {

}
// 잠시 안쓰기로..
class Input_Img_Frame extends Component { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// 일단은, 프레임 백그라운드 이미지.
	 
	    //버퍼를 활용한 이미지 클래스
	 BufferedImage img;
	  //String st1="C:\\Users\\LocketGoma\\Desktop\\1.png";
	  //String st2="C:\\Users\\LocketGoma\\Desktop\\2.png";
	  String st3="img\\bg.png";
	  String st4="C:\\Users\\ResetFrame\\Desktop\\cap.png";
	    public void paint(Graphics g) {
	        g.drawImage(img, 0, 0, null); //그림을 그리는 메소드
	    }
	    //디폴트 생성자
	 Input_Img_Frame() {
	   	try {
	        String filename=st4; // 파일의 경로  <<----- 특정 상황에서 바꾸는거 구현하자.
	           img = ImageIO.read(new File(filename));   //이미지 파일을 불러오는 IO 메소드
	                                //파일경로의 이미지 파일을 읽는다.
	           System.out.println("불러왔니");
	       } catch (IOException e) {
	    	   System.out.println("형편없었어!");
	        e.printStackTrace();
	       }
	    }

	   
	   /* public Dimension getPreferredSize() {
	        if (img == null) {
	             return new Dimension(800,600); //그림 파일이 없을 경우 프레임의 크기 강제 할당
	        } else {
	           return new Dimension(img.getWidth(null), img.getHeight(null)); //그림의 크기에 따라 화면의 크기를 변경한다.
	       }
	    } */
} 