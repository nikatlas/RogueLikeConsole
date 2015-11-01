
public class Choice {
	public short move,attack,idle,delay;
	public boolean IsMoving(){
		return move !=0;
	}
	public boolean IsAttacking(){
		return attack!=0;
	}
	public boolean IsIdling(){
		return idle!=0;
	}
	public boolean IsDelaying(){
		return delay!=0;
	}
	
}
