class AddNumbers{
	public static void main(String[] args){
		int c=0;
		for(int i=0;i<args.length;i++){
			c+=Integer.parseInt(args[i]);
		}
		System.out.println("Length is :"+args.length);
		System.out.println("Addition is :"+c);
		
	}
}