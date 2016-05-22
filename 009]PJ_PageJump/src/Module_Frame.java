import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//import java.awt.event.ActionListener;

// ������
// �̼� ����. ��� ���� -> ��ư �׷��� ������


public class Module_Frame extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
JFrame frame;
JPanel panel;
JButton bt, bt_left, bt_right, bt2;
JButton bt_time;
JLayeredPane layout;
String comp; // ����
int time_in = 0;
int time_out;



int bt1_x_axis=0;
int bt1_y_axis=0;
int bt2_x_axis=425;
int bt2_y_axis=425;

Input_Img_Frame imp = new Input_Img_Frame();
	public void start() {

		// ���� �޼ҵ�
		this.main_frame();

	}

	private void main_frame() {
		comp = " V0.2";
		frame = new JFrame("PJ "+comp);
		frame.setFont(new Font("Comic_sence",0,12));
		frame.setSize(800, 600);
		frame.setPreferredSize(new Dimension(800,600));
		
		frame.add(new Input_Img_Frame()); // ����̹���
		
		
		
		this.set_layout();
		frame.setVisible(true);
		this.button_frame(); //-- ���ϴ� �̰�
		
		
		/* ����� �ڵ� �϶�
		* this.image_upload(); <- �ֱ�
		*
		*/
	}
	private void button_frame() {
		button_UI();
		button_images();
		
		
		bt = new JButton();
		bt.setSize(10, 10);
		//bt.setFocusPainted(false);
		//bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		//bt.setLocation(0,0);
		bt.addKeyListener(new Module_Key(this));
		
		JButton bt_all = new JButton(new ImageIcon("img\\bg.png"));
		bt_all.setSize(800,600);
		bt_all.setFocusPainted(false);
		bt_all.setBorderPainted(false);
		bt_all.setContentAreaFilled(false);

		
		//bt_left.addKeyListener(new Module_Key(this));
		

		frame.add(bt);
		//bt_left.setLocation(bt1_x_axis, bt1_y_axis);
		
		bt2 = new JButton("����");
		bt2.setSize(50,50);
		//bt2.setLocation(bt2_x_axis,bt2_y_axis);
		frame.add(bt2);
		frame.add(bt_all);
		//int out_of_sight=0;
		while(true){
			bt_left.setLocation(bt1_x_axis, bt1_y_axis);
			bt_right.setLocation(bt1_x_axis, bt1_y_axis);
			bt2.setLocation(bt2_x_axis, bt2_y_axis);
			//System.out.println("["+out_of_sight+"]");
			//out_of_sight++;
			try {
				Thread.sleep(40);
					if(bt1_y_axis > 360 || this.crash_check()){
						;
						//bt1_y_axis=510;
					}
					else
						bt1_y_axis++;
			}
			catch (Exception e){
				;
			}
			this.crash_check();
			bt_time.setText(time_in+" / "+time_out);
			time_out++;
		}
		
		
	}
	private void button_images(){
		bt_left = new JButton(new ImageIcon("img\\pp3.gif"));
		bt_left.setSize(200,200); // �� ����� �־���? 
		bt_left.setFocusPainted(false);
		bt_left.setBorderPainted(false);
		bt_left.setContentAreaFilled(false);
		frame.add(bt_left);
		bt_left.setVisible(false);
		
		bt_right = new JButton(new ImageIcon("img\\pp4.gif"));
		bt_right.setSize(200,200); // �� ����� �־���? 
		bt_right.setFocusPainted(false);
		bt_right.setBorderPainted(false);
		bt_right.setContentAreaFilled(false);
		frame.add(bt_right);
		
	}
	private void button_UI(){
		bt_time = new JButton(time_in+" / "+time_out);
		bt_time.setSize(100,50);
		bt_time.setLocation(680,0);
		bt_time.setFont(new Font("Comic_sans",1,20));
		bt_time.setFocusPainted(false);
		bt_time.setBorderPainted(true);
		bt_time.setContentAreaFilled(false);
		frame.add(bt_time);
	}
	public void button_move(){ // ���� ���� �ڵ�
		this.crash_check();
		bt_left.setLocation(bt1_x_axis, bt1_y_axis);//��ġ ����
		System.out.println("x��:"+bt1_x_axis+" y��:"+bt1_y_axis);

	}
	private boolean crash_check(){
		if(bt1_x_axis > 735)
			bt1_x_axis=735;
		else if (bt1_x_axis<0)
			bt1_x_axis=0;
		
		if(bt1_y_axis > 370)
			bt1_y_axis=370;
		else if (bt1_y_axis < 0)
			bt1_y_axis=0;
		
		//--�ؿ��� �浹����
		if(Math.abs(bt1_x_axis-bt2_x_axis)<=50&&Math.abs(bt1_y_axis-bt2_y_axis)<=50){
			System.out.println("�浹!");
			if(bt1_x_axis-bt2_x_axis>0){
				bt1_x_axis=bt1_x_axis+5;
				}
			else if(bt1_x_axis-bt2_x_axis<0){
				bt1_x_axis=bt1_x_axis-5;
				}
			
			if(bt1_y_axis-bt2_y_axis>0){
				bt1_y_axis=bt1_y_axis+5;
			}
			else if(bt1_y_axis-bt2_y_axis<0){
				bt1_y_axis=bt1_y_axis-5;
				}
			//JButton.dispose
			return true;
			}
		return false;
		}
	public void button_move2(int axis_x, int axis_y){
		if (axis_x<0){
			bt_left.setVisible(true);
			bt_right.setVisible(false);
		}
		else if (axis_x>0){
			bt_left.setVisible(false);
			bt_right.setVisible(true);
		}
		else if (axis_x==0){
			
		}
		bt1_x_axis=bt1_x_axis+axis_x;
		bt1_y_axis=bt1_y_axis+axis_y;
		this.crash_check();
		bt_left.setLocation(bt1_x_axis, bt1_y_axis);//��ġ ����
		System.out.println("x��:"+bt1_x_axis+" y��:"+bt1_y_axis);
		
	}
	private void set_layout(){  //<-- ���Ⱑ ����

		
		
		frame.setLayout(null); // �ʴ� ��
		//layout = new JLayeredPane();
		//layout.setBounds(0,0,800,600);
		//layout.setLayout(null); // �ִ°Ŵ�?
		//frame.add(new Input_Img_Frame()); 
		System.out.println("��");
		
		
		
	}
	

//-- ��;�ӹٹپƾƾƾƾƾƾ�!!!

	public void button_move(char axis, int data){ // ���߿� 'ĳ���� ������' �� �� �޼ҵ�
		int alpha;
		if (axis=='x'){
			bt1_x_axis=bt1_x_axis+data;
			this.button_move();
		}else if (axis=='y'){
			bt1_y_axis=bt1_y_axis+data;
			this.button_move();}
		else if (axis=='u'){ // ���� ����...
			alpha=data/2;
			while(data!=0){
				if(alpha<data){
					bt1_y_axis=bt1_y_axis-5;
					data--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO �ڵ� ������ catch ���
						e.printStackTrace();
					}
					this.button_move(); // ���⼭ �̰� �۵��� ����� ����... ���� �������� �����δ�.
					System.out.println("��");
				}
				else if(alpha>=data){
					bt1_y_axis=bt1_y_axis+5;
					data--;
					this.button_move();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO �ڵ� ������ catch ���
							e.printStackTrace();
						}
				}
			}
		}
		System.out.println("(2)input:"+"��ǥ:["+axis+"] ��:["+data+"]");
		
		
	}
	

	
}

/*
* v = 9.8m/s^2
* vs = 9.8m/s
* 
* V - 9.8m/s^2 = �ʴ� ���� �ӵ�.
* 10/s^2
* s^2�� ���?
* 
* 
* ���� �ð��� �Ÿ� = vs + v(2)s^2  == v + v(2)s
*/
