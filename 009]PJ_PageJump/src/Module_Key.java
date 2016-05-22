/* Ű ���ÿ�
 * 
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Module_Key implements KeyListener {
	/* ���� ::
	 * ����Ű - �̵�
	 * �����̽��� - ����
	 * 
	 * �� ���� ::
	 * UP : + 1
	 * down : - 1
	 * left : -1
	 * right : +1
	 * �ٵ� ���ٿ��� �� ���� �ֳ�?
	 * SP : (���� Ű ���̸�ŭ ����) 
	 * 
	 * ���� �ȼ� ��������? �׷� +1�� ���� 10�ȼ����� ��߰ڳ�
	 */
	char axis;
	int data;
	Module_Frame control_frame;
	Movement_control mov; 
	Movement_control mov2; //��Ƽ �������׽�Ʈ��
	
	Module_Key (){
		;
	}
	Module_Key (Module_Frame fr){
		this.control_frame = fr;
	}
	
	
	@Override
	
	public void keyPressed(KeyEvent ev) { // ��������?
		// TODO �ڵ� ������ �޼ҵ� ����
		
		switch (ev.getKeyCode()) {
			case KeyEvent.VK_UP : {
				axis='y';
				data=-5;
			//System.out.println("input:"+"��ǥ:["+axis+"] ��:["+data+"]");
			break;	
			}
			
			case KeyEvent.VK_DOWN : {
				axis='y';
				data=+5;
			break;
			}
			
			case KeyEvent.VK_LEFT :{
				axis='x';
				data=-5;
			break;
			}
			
			case KeyEvent.VK_RIGHT : {
				axis='x';
				data=+5;
			break;
			}
			
			case KeyEvent.VK_SPACE : {
				axis='u';
				data=+10;
			}
			default :{
			;
			break; }
		}
		//control_frame.button_move(axis, data);
		mov = new Movement_control(control_frame,axis,data);
		//mov2 = new Movement_control(control_frame,axis,data);
		//mov.button_move(axis,data);
		mov.run();
	}

	@Override
	public void keyReleased(KeyEvent ev) { // ������� ������...
		// TODO �ڵ� ������ �޼ҵ� ����
		switch (ev.getKeyCode()) {
			case KeyEvent.VK_SPACE : {
				;
			break;	
			}
			
			default : {
				;
			break;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent ev) { // �̰� ��Ÿ��
		// TODO �ڵ� ������ �޼ҵ� ����
		
		
	}
	
}
/*
 * ���� :: ���  ������ (Ű ��ǲ) -> ��� Ű (Ű �Է�) -> ���� ��Ʈ�� (Ű ����, �����Ͱ� ���) -> ��� ������ (��ǥ�� ��ǲ)  
 */

class Movement_control extends Thread { // �� �����. Module_key �� Add-on �ڵ�
	Module_Frame control_frame; // ���Ͽ�
	//--���� ������
	float velo=100; // ���� ����	
	int distance=0; // �̵� �Ÿ�
	int distance_all=0;
	float count_time=(float)0.01; // '�ʴ�'
	//--���� ������ ��
	//-�Ϲ� ���
	int axis_x=0;
	int axis_y=0;
	int data;
	char axis;
	//-�Ϲ� ��� ��
	Movement_control (){
		;
	}
	Movement_control (Module_Frame fr){
		this.control_frame = fr;		
	}
	Movement_control (char axis,int data){
		this.axis=axis;
		this.data=data;
	}	
	Movement_control (Module_Frame fr, char axis,int data){
		this.control_frame = fr;	
		this.axis=axis;
		this.data=data;
	}
	public void run(){
		this.button_move();		
	}
	
	private void button_move(){

	System.out.println(axis +"�ϰ�" + data);
		switch (axis){
			case 'x' : {
				axis_x=data;
			break;	
			}
			case 'y' : {
				axis_y=data;
			break;
			}
			case 'u' : {
				//this.jump(data); -- ���� �ڵ� �����ϴ�.
			}
			default : {
				;
			break;
			}
		}
	control_frame.button_move2(axis_x, axis_y);	
	
	axis_x=0;
	axis_y=0;
		
	} // �޼ҵ� ��
	
	private void jump(int data){
		
	
			while(distance_all>=0){
				distance=(int)((velo - ((10.0)*count_time/2)*count_time));
				distance_all=distance_all+distance;
				if(distance_all<0){
				control_frame.button_move2(0,-(distance-distance_all));}
				else{		
				control_frame.button_move2(0,-distance);}
				count_time++;
				System.out.println("�Ÿ��� : " + distance + ", ������ :  "+ distance_all);	
			}
		velo=50;
		distance=0;
		distance_all=0;
		count_time=0;
	
	}
	
}
