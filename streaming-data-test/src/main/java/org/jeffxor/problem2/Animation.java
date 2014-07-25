package org.jeffxor.problem2;

import java.util.ArrayList;
import java.util.List;

public class Animation {
	
	public static List<String> animate(int speed, String init){
		int chamberSize = init.length();
		int time = 0;
		List<Partical> particals = intiParticals(init, speed);
		List<String> chamberOverTime = new ArrayList<String>();
				
		while(true){
			List<Integer> particalPositions = calculateParticalPositions(particals, time);
			chamberOverTime.add(drawChamber(particalPositions, chamberSize));
			if(!hasParticalsInChamber(particalPositions, chamberSize)){
				break;
			}			
			time = time + 1;			
		}
		return chamberOverTime;
	}
	
	private static boolean hasParticalsInChamber(List<Integer> postions, int chamberSize){
		for(Integer particalPosition : postions){
			if(0 <= particalPosition && particalPosition <= chamberSize){
				return true;
			}
		}
		return false;
	}
	
	private  static List<Integer> calculateParticalPositions(List<Partical> particals, int time){
		List<Integer> positions = new ArrayList<Integer>();
		for(Partical partical : particals){
			positions.add(partical.locationAfter(time));
		}		
		return positions;
	}
	
	private static String drawChamber(List<Integer> positions, int chamberSize){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < chamberSize; i ++){
			if(positions.contains(i)){
				builder.append("X");
			}
			else{
				builder.append(".");
			}
		}		
		return builder.toString();
	}
	
	

	private static List<Partical> intiParticals(String init, int speed) {
		List<Partical> particals = new ArrayList<Partical>();
		int chamberSize = init.length();
		for(int i = 0; i< chamberSize; i++){
			char current = init.charAt(i);
			if(current != '.'){
				particals.add(new Partical(current, i, speed));
			}
		}
		return particals;
				
	}

}
