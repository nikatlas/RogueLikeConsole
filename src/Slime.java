
public class Slime implements ICharacter{

	private int _health = 20;
	private int timer = 0;
	private Point _position;
	private boolean _deleted = false;
	private boolean flag = false;
	private int _attack = 4;
	Slime(){
		this._health = 20;
		this._position=new Point(7,3);
	}
	@Override
	public int getHealth() {
		return this._health;
	}

	@Override
	public char move() {
		if( timer > 0 ){
			timer--;
			return ' ';
		}
		else{
			flag = !flag;
			timer = 1;
			return ((flag)?'w':'s');
		}
		
		
	}

	@Override
	public char draw() {
		return 'S';
	}

	@Override
	public Point getPosition() {
		return _position;
	}

	@Override
	public void setPosition(Point point) {
		this._position = point;
	}
	@Override
	public void takeDamage(int dmg) {
		this._health -= dmg;
		if(this._health<0){
			this._deleted = true;
		}
	}
	@Override
	public boolean isDeleted() {
		return this._deleted;
	}
	@Override
	public int attack() {
		return this._attack ;
	}

}