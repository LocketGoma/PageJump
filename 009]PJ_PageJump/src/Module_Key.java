/* 키 세팅용
 * 
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Module_Key implements KeyListener {
	/* 조작 ::
	 * 십자키 - 이동
	 * 스페이스바 - 점프
	 * 
	 * 값 적용 ::
	 * UP : + 1
	 * down : - 1
	 * left : -1
	 * right : +1
	 * 근데 업다운을 쓸 일이 있나?
	 * SP : (대충 키 높이만큼 점프) 
	 * 
	 * 저게 픽셀 단위던가? 그럼 +1이 대충 10픽셀정도 줘야겠네
	 */
	char axis;
	int data;
	Module_Frame control_frame;
	Movement_control mov; 
	Movement_control mov2; //멀티 쓰레딩테스트용
	
	Module_Key (){
		;
	}
	Module_Key (Module_Frame fr){
		this.control_frame = fr;
	}
	
	
	@Override
	
	public void keyPressed(KeyEvent ev) { // 누를때지?
		// TODO 자동 생성된 메소드 스텁
		
		switch (ev.getKeyCode()) {
			case KeyEvent.VK_UP : {
				axis='y';
				data=-5;
			//System.out.println("input:"+"좌표:["+axis+"] 값:["+data+"]");
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
	public void keyReleased(KeyEvent ev) { // 릴리즈는 땔때고...
		// TODO 자동 생성된 메소드 스텁
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
	public void keyTyped(KeyEvent ev) { // 이건 연타용
		// TODO 자동 생성된 메소드 스텁
		
		
	}
	
}
/*
 * 구조 :: 모듈  프레임 (키 인풋) -> 모듈 키 (키 입력) -> 무브 컨트롤 (키 판정, 데이터값 출력) -> 모듈 프레임 (좌표값 인풋)  
 */

class Movement_control extends Thread { // 값 연산용. Module_key 의 Add-on 코드
	Module_Frame control_frame; // 리턴용
	//--점프 구현용
	float velo=100; // 점프 높이	
	int distance=0; // 이동 거리
	int distance_all=0;
	float count_time=(float)0.01; // '초당'
	//--점프 구현용 끝
	//-일반 사용
	int axis_x=0;
	int axis_y=0;
	int data;
	char axis;
	//-일반 사용 끝
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

	System.out.println(axis +"하고" + data);
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
				//this.jump(data); -- 점프 코드 막습니다.
			}
			default : {
				;
			break;
			}
		}
	control_frame.button_move2(axis_x, axis_y);	
	
	axis_x=0;
	axis_y=0;
		
	} // 메소드 끝
	
	private void jump(int data){
		
	
			while(distance_all>=0){
				distance=(int)((velo - ((10.0)*count_time/2)*count_time));
				distance_all=distance_all+distance;
				if(distance_all<0){
				control_frame.button_move2(0,-(distance-distance_all));}
				else{		
				control_frame.button_move2(0,-distance);}
				count_time++;
				System.out.println("거리값 : " + distance + ", 최종값 :  "+ distance_all);	
			}
		velo=50;
		distance=0;
		distance_all=0;
		count_time=0;
	
	}
	
}
