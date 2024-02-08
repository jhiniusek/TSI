public class Main {

    public enum score {WICKED, ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX;}

    public static int score(){
	int bat = (int) (Math.random() * 9 - 2);
	return bat;
    }

    public static score scoreenum(){
	int bat = (int) (Math.random() * 9 - 2);
	switch (bat){
	    case -1: {
		return score.WICKED;
	    }
	    case 0: {
		return score.ZERO;
	    }
	    case 1: {
		return score.ONE;
	    }
	    case 2: {
		return score.TWO;
	    }
	    case 3: {
		return score.THREE;
	    }
	    case 4: {
		return score.FOUR;
	    }
	    case 5: {
		return score.FIVE;
	    }
	    case 6: {
		return score.SIX;
	    }
            default: {
		return score.ZERO;
	    }
	}
    }

    public static void main(String[] args) {
	int bat = score();        
	System.out.println(bat);

	score myScore = scoreenum();
	System.out.println(myScore);
    }
}