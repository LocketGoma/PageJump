import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class Module_Input {

}
// ��� �Ⱦ����..
class Input_Img_Frame extends Component { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// �ϴ���, ������ ��׶��� �̹���.
	 
	    //���۸� Ȱ���� �̹��� Ŭ����
	 BufferedImage img;
	  //String st1="C:\\Users\\LocketGoma\\Desktop\\1.png";
	  //String st2="C:\\Users\\LocketGoma\\Desktop\\2.png";
	  String st3="img\\bg.png";
	  String st4="C:\\Users\\ResetFrame\\Desktop\\cap.png";
	    public void paint(Graphics g) {
	        g.drawImage(img, 0, 0, null); //�׸��� �׸��� �޼ҵ�
	    }
	    //����Ʈ ������
	 Input_Img_Frame() {
	   	try {
	        String filename=st4; // ������ ���  <<----- Ư�� ��Ȳ���� �ٲٴ°� ��������.
	           img = ImageIO.read(new File(filename));   //�̹��� ������ �ҷ����� IO �޼ҵ�
	                                //���ϰ���� �̹��� ������ �д´�.
	           System.out.println("�ҷ��Դ�");
	       } catch (IOException e) {
	    	   System.out.println("���������!");
	        e.printStackTrace();
	       }
	    }

	   
	   /* public Dimension getPreferredSize() {
	        if (img == null) {
	             return new Dimension(800,600); //�׸� ������ ���� ��� �������� ũ�� ���� �Ҵ�
	        } else {
	           return new Dimension(img.getWidth(null), img.getHeight(null)); //�׸��� ũ�⿡ ���� ȭ���� ũ�⸦ �����Ѵ�.
	       }
	    } */
} 