import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level {
	
		
	private String[] array;
	private ArrayList<ICharacter> characters;

	
	private void parseLine(String line,int index){
		this.array[index] = line;
	}
	
	private void importFile(String filename){
		File file = new File(filename);
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    int i = 0;
		    while ((text = reader.readLine()) != null) {
		        this.parseLine(text,i);
		        i++;
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}	
	}
	
	Level(String file){
		this.array = new String[7];
		this.characters = new ArrayList<ICharacter>();
		this.importFile(file);
	}
	
	public int getHeight(){
		return this.array.length;
	}
	
	public int getWidth(){
		return this.array[0].length();		
	}
	
	public char charAt(int x,int y){
		return this.array[y].charAt(x);		
	}
	
	public void draw(){
		for(int i=0;i<this.getHeight();i++){
			for(int z=0;z<this.getWidth();z++){
				System.out.print(this.array[i].charAt(z));
			}
			System.out.println("");
		}
	}
	
	public void addChar(ICharacter character){
		this.characters.add(character);
	}
	
	private ICharacter get(int x, int y){
		for(ICharacter character : this.characters)
			if(character.getPosition().x == x && character.getPosition().y == y )
				return character;
		return null;
	}
	
	public void run(){
		String[] local = new String[this.getHeight()];
		for(int i=0;i<this.array.length;i++){
			local[i] = this.array[i];
		}
		
		for(ICharacter character : this.characters){
			 	
			char move = character.move();
			Point position = character.getPosition();
			int valid;
			switch(move){
				case 'w':
					if( this.isValid(position.x, position.y - 1) ){
						ICharacter tmp = this.get(position.x,position.y-1);
						if( tmp != null ){
							tmp.takeDamage(character.attack());
						}
						else{
							character.setPosition(new Point(position.x,position.y-1));
						}
					}
					break;
				case 'a':
					if( this.isValid(position.x-1, position.y) ){
						ICharacter tmp = this.get(position.x-1,position.y);
						if( tmp != null ){
							tmp.takeDamage(character.attack());
						}
						else{
							character.setPosition(new Point(position.x-1,position.y));
						}
					}
					break;
				case 's':
					if( this.isValid(position.x, position.y + 1) ){
						ICharacter tmp = this.get(position.x,position.y + 1);
						if( tmp != null ){
							tmp.takeDamage(character.attack());
						}
						else{
							character.setPosition(new Point(position.x,position.y + 1));
						}
					}
					break;
				case 'd':
					if( this.isValid(position.x+1, position.y) ){
						ICharacter tmp = this.get(position.x+1,position.y);
						if( tmp != null ){
							tmp.takeDamage(character.attack());
						}
						else{
							character.setPosition(new Point(position.x+1,position.y));
						}
					}
					break;
			}

			StringBuilder builder = new StringBuilder(local[character.getPosition().y]);
			builder.setCharAt(character.getPosition().x, character.draw());
			local[character.getPosition().y] = builder.toString();
			
			
		}

		this.cleanup();
		
		for(int i=0;i<this.getHeight();i++){
			for(int z=0;z<this.getWidth();z++){
				System.out.print(local[i].charAt(z));
			}
			System.out.println("");
		}
		
	} 

	private void cleanup(){
		for(int i=0;i<this.characters.size();i++){
			if( this.characters.get(i).isDeleted() ){
				this.characters.remove(this.characters.get(i));
			}
		}
	}
	private boolean isValid(int x, int i) {
		if(this.array[i].charAt(x) == '.')
			return true;
		return false;
	}
}
