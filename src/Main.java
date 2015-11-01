
public class Main {

	public static void main(String[] args) {
		
		boolean play = true;
		
		Level level = new Level("map.txt");
		level.draw();
		
		Player player = new Player();
		level.addChar(player);
				
		Slime slime = new Slime();
		level.addChar(slime);
		
		while(play){
			level.run();
			System.out.println("HP : " + player.getHealth());
		}
	}

}
