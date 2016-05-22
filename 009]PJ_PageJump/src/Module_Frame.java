import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//import java.awt.event.ActionListener;

// 프레임
// 미션 변경. 배경 제거 -> 버튼 그래픽 입히기


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
String comp; // 제목
int time_in = 0;
int time_out;



int bt1_x_axis=0;
int bt1_y_axis=0;
int bt2_x_axis=425;
int bt2_y_axis=425;

Input_Img_Frame imp = new Input_Img_Frame();
	public void start() {

		// 최종 메소드
		this.main_frame();

	}

	private void main_frame() {
		comp = " V0.2";
		frame = new JFrame("PJ "+comp);
		frame.setFont(new Font("Comic_sence",0,12));
		frame.setSize(800, 600);
		frame.setPreferredSize(new Dimension(800,600));
		
		frame.add(new Input_Img_Frame()); // 배경이미지
		
		
		
		this.set_layout();
		frame.setVisible(true);
		this.button_frame(); //-- 씁니다 이거
		
		
		/* 사망한 코드 일람
		* this.image_upload(); <- 주김
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
		
		bt2 = new JButton("으악");
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
		bt_left.setSize(200,200); // 뭐 사이즈가 있었어? 
		bt_left.setFocusPainted(false);
		bt_left.setBorderPainted(false);
		bt_left.setContentAreaFilled(false);
		frame.add(bt_left);
		bt_left.setVisible(false);
		
		bt_right = new JButton(new ImageIcon("img\\pp4.gif"));
		bt_right.setSize(200,200); // 뭐 사이즈가 있었어? 
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
	public void button_move(){ // 현재 죽은 코드
		this.crash_check();
		bt_left.setLocation(bt1_x_axis, bt1_y_axis);//위치 설정
		System.out.println("x축:"+bt1_x_axis+" y축:"+bt1_y_axis);

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
		
		//--밑에는 충돌판정
		if(Math.abs(bt1_x_axis-bt2_x_axis)<=50&&Math.abs(bt1_y_axis-bt2_y_axis)<=50){
			System.out.println("충돌!");
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
		bt_left.setLocation(bt1_x_axis, bt1_y_axis);//위치 설정
		System.out.println("x축:"+bt1_x_axis+" y축:"+bt1_y_axis);
		
	}
	private void set_layout(){  //<-- 여기가 문제

		
		
		frame.setLayout(null); // 너는 왜
		//layout = new JLayeredPane();
		//layout.setBounds(0,0,800,600);
		//layout.setLayout(null); // 있는거니?
		//frame.add(new Input_Img_Frame()); 
		System.out.println("뭐");
		
		
		
	}
	

//-- ㅅ;ㅣ바바아아아아아아알!!!

	public void button_move(char axis, int data){ // 나중에 '캐릭터 움직임' 이 될 메소드
		int alpha;
		if (axis=='x'){
			bt1_x_axis=bt1_x_axis+data;
			this.button_move();
		}else if (axis=='y'){
			bt1_y_axis=bt1_y_axis+data;
			this.button_move();}
		else if (axis=='u'){ // 점프 구현...
			alpha=data/2;
			while(data!=0){
				if(alpha<data){
					bt1_y_axis=bt1_y_axis-5;
					data--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO 자동 생성된 catch 블록
						e.printStackTrace();
					}
					this.button_move(); // 여기서 이게 작동을 제대로 안해... 값이 정해지고 움직인다.
					System.out.println("음");
				}
				else if(alpha>=data){
					bt1_y_axis=bt1_y_axis+5;
					data--;
					this.button_move();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 자동 생성된 catch 블록
							e.printStackTrace();
						}
				}
			}
		}
		System.out.println("(2)input:"+"좌표:["+axis+"] 값:["+data+"]");
		
		
	}
	

	
}

/*
* v = 9.8m/s^2
* vs = 9.8m/s
* 
* V - 9.8m/s^2 = 초당 감소 속도.
* 10/s^2
* s^2는 어떻게?
* 
* 
* 단위 시간당 거리 = vs + v(2)s^2  == v + v(2)s
*/
