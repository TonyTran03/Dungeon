class combat{

	public static void fight(specialCharacter protagonist){
		creature opponent = new creature(); 
		
		//show mana
		String mana = "■fsa";
		String consumed = "▢";
		System.out.println("You engaged combat with a " + opponent.name);
		System.out.println(opponent.stats.get("ATTACK"));


		System.out.println("You engaged combat with a " + protagonist.getName());


		System.out.print(protagonist.stats.get("currentMP")  + "/" + protagonist.stats.get("MP") + " ");

		for(int i = 0; i<protagonist.stats.get("currentMP"); i++){
			System.out.print(mana);
		}
		for(int i = 0; i<protagonist.stats.get("MP") - protagonist.stats.get("currentMP"); i++){
			System.out.print(consumed);
		}


		System.out.println("");
	}
	public static void fight(specialCharacter protagonist, int monster){
	creature opponent = new creature(monster); 
			String mana = "■";
		String consumed = "▢";
		System.out.println("You engaged combat with a " + opponent.name);
		System.out.println(opponent.stats.get("ATTACK"));


		System.out.println("You engaged combat with a " + protagonist.getName());


		System.out.print(protagonist.stats.get("currentMP")  + "/" + protagonist.stats.get("MP") + " ");

		for(int i = 0; i<protagonist.stats.get("currentMP"); i++){
			System.out.print(mana);
		}
		for(int i = 0; i<protagonist.stats.get("MP") - protagonist.stats.get("currentMP"); i++){
			System.out.print(consumed);
		}

	}
}
