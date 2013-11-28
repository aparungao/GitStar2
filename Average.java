package q1;

public class Average {

	public static void main(String[] args) {
		
        double average = 0;

        if(args.length == 0) {
            System.out.println("No argument");
            
        } else {
        	
            for(int i=0; i<args.length; i++){
                average += Integer.parseInt(args[i]);
            }

            System.out.println(average / args.length);
        }

	}

}
