import java.io.IOException;

public class Player implements ICharacter {
	private final int MAX_HEALTH = 100;
	private int _health;
	private Point _position;
	private boolean _deleted = false;
	private int _attack = 10;
	
	Player(){
		this._health = MAX_HEALTH;
		this._position = new Point(3,3);
	}
	@Override
	public int getHealth() {
		return this._health;
	}

	@Override
	public char move() {
		System.out.print("Whats your next move : ");
		char tmp = ' ';
		try {
			tmp = (char) System.in.read();
	        System.in.skip(System.in.available());			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	@Override
	public char draw() {
		return 'P';
	}
	@Override
	public Point getPosition() {
		return this._position;
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
