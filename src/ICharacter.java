
public interface ICharacter {
	public int getHealth();
	public char move();
	public char draw();
	public Point getPosition();
	public void setPosition(Point point);
	public void takeDamage(int dmg);
	public boolean isDeleted();
	public int attack();
}
