package party;

public class CircularPathValidator {
	char[] directions = {'N','E','S','W'};
	
	private char getDirection(int index) {
		int arrayIndex = index%4;
		if(arrayIndex < 0)
			arrayIndex+=4;
		return directions[arrayIndex];
	}
	
	private boolean isCircular(String inputs) {
		int x=0,y=0;
		int currentDirectionIndex = 0;
		for(char c:inputs.toCharArray()) {
			if(c == 'L' ) {
				currentDirectionIndex--;
			}else if (c == 'R') {
				currentDirectionIndex++;
			}else {
				switch (getDirection(currentDirectionIndex)) {
				case 'N':
					y++;
					break;
				case 'E':
					x++;
					break;
				case 'S':
					y--;
					break;
				default:
					x--;
				}
			}
		}
		return x==0 && y==0;
	}

	public static void main(String[] args) {
		CircularPathValidator app = new CircularPathValidator();
		System.out.println(app.isCircular("GGGGR"));
	}
}
