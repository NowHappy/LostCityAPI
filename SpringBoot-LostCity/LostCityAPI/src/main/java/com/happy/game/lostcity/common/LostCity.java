package com.happy.game.lostcity.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LostCity {

	public List<Integer> firstUserCardsInHand;
	public List<Integer> secondUserCardsInHand;
	
	public List<Integer> firstUserCardsInPoint;
	public List<Integer> secondUserCardsInPoint;
	
	public List<Integer> stackOfCards;
	
	//버리는 곳!!
	public List<Integer> yellow;
	public List<Integer> blue;
	public List<Integer> white;
	public List<Integer> green;
	public List<Integer> red;
	
	public int firstUserScore;
	public int secondUserScore;
	
	public LostCity(List<Integer> firstUserCardsInHand, List<Integer> secondUserCardsInHand, List<Integer> stackOfCards) {
		this.firstUserCardsInHand = firstUserCardsInHand;
		this.secondUserCardsInHand = secondUserCardsInHand;
		this.stackOfCards = stackOfCards;
		this.firstUserCardsInPoint = new ArrayList<Integer>();
		this.secondUserCardsInPoint = new ArrayList<Integer>();
		this.yellow = new ArrayList<Integer>();
		this.blue = new ArrayList<Integer>();
		this.white = new ArrayList<Integer>();
		this.green = new ArrayList<Integer>();
		this.red = new ArrayList<Integer>();
	}
	
	public static LostCity startGame() {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		List<Integer> c = new ArrayList<Integer>();
		Random r = new Random(); // 객체생성
		a.add(r.nextInt(60) + 1);
		do
		{
			Integer num = r.nextInt(60) + 1;
			if (!a.contains(num)) {
				a.add(num);
			}
		}while(a.size() < 8);
		
		do
		{
			Integer num = r.nextInt(60) + 1;
			if (!a.contains(num) && !b.contains(num)) {
				b.add(num);
			}
		}while(b.size() < 8);
		
		do
		{
			Integer num = r.nextInt(60) + 1;
			if (!a.contains(num) && !b.contains(num) && !c.contains(num)) {
				c.add(num);
			}
		}while(c.size() < 44);
		
		LostCity lc = new LostCity(a, b, c);
		
		return lc;
	}
	
	public static LostCity PrintResult(LostCity lc) {
		
		System.out.print("user1 cards in hand: ");
		for(Integer i : lc.firstUserCardsInHand) {
			if (i.intValue() == lc.firstUserCardsInHand.get(lc.firstUserCardsInHand.size()-1)) {
				System.out.print(i);
			} else {
				System.out.print(i + ",");
			}
		}
		System.out.println("");
		
		System.out.print("user2 cards in hand: ");
		for(Integer i : lc.secondUserCardsInHand) {
			if (i.intValue() == lc.secondUserCardsInHand.get(lc.secondUserCardsInHand.size()-1)) {
				System.out.print(i);
			} else {
				System.out.print(i + ",");
			}
		}
		System.out.println("");
		
		System.out.print("stackOfCards: ");
		for(Integer i : lc.stackOfCards) {
			if (i.intValue() == lc.stackOfCards.get(lc.stackOfCards.size()-1)) {
				System.out.print(i);
			} else {
				System.out.print(i + ",");
			}
		}
		System.out.println("");
		
		if(lc.firstUserCardsInPoint != null) {
			System.out.print("user1 cards in point: ");
			for(Integer i : lc.firstUserCardsInPoint) {
				if (i.intValue() == lc.firstUserCardsInPoint.get(lc.firstUserCardsInPoint.size()-1)) {
					System.out.print(i);
				} else {
					System.out.print(i + ",");
				}
			}
			System.out.println("");
		}
		
		if(lc.secondUserCardsInPoint != null) {
			System.out.print("user2 cards in point: ");
			for(Integer i : lc.secondUserCardsInPoint) {
				if (i.intValue() == lc.secondUserCardsInPoint.get(lc.secondUserCardsInPoint.size()-1)) {
					System.out.print(i);
				} else {
					System.out.print(i + ",");
				}
			}
			System.out.println("");
		}
		
		if(lc.yellow != null) {
			System.out.print("yellow: ");
			for(Integer i : lc.yellow) {
				if (i.intValue() == lc.yellow.get(lc.yellow.size()-1)) {
					System.out.print(i);
				} else {
					System.out.print(i + ",");
				}
			}
			System.out.println("");
		}
		
		if(lc.blue != null) {
			System.out.print("blue: ");
			for(Integer i : lc.blue) {
				if (i.intValue() == lc.blue.get(lc.blue.size()-1)) {
					System.out.print(i);
				} else {
					System.out.print(i + ",");
				}
			}
			System.out.println("");
		}
		
		if(lc.white != null) {
			System.out.print("white: ");
			for(Integer i : lc.white) {
				if (i.intValue() == lc.white.get(lc.white.size()-1)) {
					System.out.print(i);
				} else {
					System.out.print(i + ",");
				}
			}
			System.out.println("");
		}
		
		if(lc.green != null) {
			System.out.print("green: ");
			for(Integer i : lc.green) {
				if (i.intValue() == lc.green.get(lc.green.size()-1)) {
					System.out.print(i);
				} else {
					System.out.print(i + ",");
				}
			}
			System.out.println("");
		}
		
		if(lc.red != null) {
			System.out.print("red: ");
			for(Integer i : lc.red) {
				if (i.intValue() == lc.red.get(lc.red.size()-1)) {
					System.out.print(i);
				} else {
					System.out.print(i + ",");
				}
			}
			System.out.println("");
		}
		
//		List<Integer> newList = new ArrayList<Integer>(a);
//		newList.addAll(b);
//		newList.addAll(c);
//		Collections.sort(newList);
//
//		for(Integer i : newList) {
//			System.out.print(i + " ");
//		}
		
		return lc;
	}
	
	public static LostCity PutInPoint(LostCity lc, Integer WhichUser, Integer userCard) {
	
		if(WhichUser.intValue() == 1) {
			if(lc.firstUserCardsInHand.contains(userCard)) {
				lc.firstUserCardsInHand.remove(userCard);
				lc.firstUserCardsInPoint.add(userCard);
			}else {
				System.out.println("error");
			}
		}else {
			if(lc.secondUserCardsInHand.contains(userCard)) {
				lc.secondUserCardsInHand.remove(userCard);
				lc.secondUserCardsInPoint.add(userCard);
			}else {
				System.out.println("error");
			}
		}
		
		return lc;
	}
	
	public static LostCity PutInColor(LostCity lc, Integer WhichUser, Integer userCard, String color) {
		int i = userCard;
		if(WhichUser.intValue() == 1) {
			if(lc.firstUserCardsInHand.contains(userCard)) {
				lc.firstUserCardsInHand.remove(userCard);
			}else {
				System.out.println("error");
			}
		}else {
			if(lc.secondUserCardsInHand.contains(userCard)) {
				lc.secondUserCardsInHand.remove(userCard);
			}else {
				System.out.println("error");
			}
		}
		
		if(Colors.yellow.contains(userCard)) {
			lc.yellow.add(userCard);
		}else if(Colors.blue.contains(userCard)) {
			lc.blue.add(userCard);
		}else if(Colors.white.contains(userCard)) {
			lc.white.add(userCard);
		}else if(Colors.green.contains(userCard)) {
			lc.green.add(userCard);
		}else if(Colors.red.contains(userCard)) {
			lc.red.add(userCard);
		}
		
		else if(i == 1 || i == 51 || i == 56) {
			lc.yellow.add(userCard);
		}else if(i == 11 || i == 52 || i == 57) {
			lc.yellow.add(userCard);
		}else if(i == 21 || i == 53 || i == 58) {
			lc.yellow.add(userCard);
		}else if(i == 31 || i == 54 || i == 59) {
			lc.yellow.add(userCard);
		}else if(i == 41 || i == 55 || i == 60) {
			lc.yellow.add(userCard);
		}
		
		return lc;
	}
	
	public static LostCity takeFromStack(LostCity lc, Integer WhichUser) {
		
		Integer i = lc.stackOfCards.get(0);
		lc.stackOfCards.remove(i);
		if(WhichUser.intValue() == 1) {
			lc.firstUserCardsInHand.add(i);
		}else {
			lc.secondUserCardsInHand.add(i);
		}
		
		return lc;
	}
	
	public static LostCity takeFromColor(LostCity lc, Integer WhichUser, String color) {
		
		if(color.equalsIgnoreCase("yellow")) {
			if(WhichUser.intValue() == 1) {
				lc.firstUserCardsInHand.add(lc.yellow.get(lc.yellow.size()-1));
			}else {
				lc.secondUserCardsInHand.add(lc.yellow.get(lc.yellow.size()-1));
			}
			lc.yellow.remove(lc.yellow.size()-1);
		}else if(color.equalsIgnoreCase("blue")) {
			if(WhichUser.intValue() == 1) {
				lc.firstUserCardsInHand.add(lc.blue.get(lc.blue.size()-1));
			}else {
				lc.secondUserCardsInHand.add(lc.blue.get(lc.blue.size()-1));
			}
			lc.blue.remove(lc.blue.size()-1);
		}else if(color.equalsIgnoreCase("white")) {
			if(WhichUser.intValue() == 1) {
				lc.firstUserCardsInHand.add(lc.white.get(lc.white.size()-1));
			}else {
				lc.secondUserCardsInHand.add(lc.white.get(lc.white.size()-1));
			}
			lc.white.remove(lc.white.size()-1);
		}else if(color.equalsIgnoreCase("green")) {
			if(WhichUser.intValue() == 1) {
				lc.firstUserCardsInHand.add(lc.green.get(lc.green.size()-1));
			}else {
				lc.secondUserCardsInHand.add(lc.green.get(lc.green.size()-1));
			}
			lc.green.remove(lc.green.size()-1);
		}else if(color.equalsIgnoreCase("red")) {
			if(WhichUser.intValue() == 1) {
				lc.firstUserCardsInHand.add(lc.red.get(lc.red.size()-1));
			}else {
				lc.secondUserCardsInHand.add(lc.red.get(lc.red.size()-1));
			}
			lc.red.remove(lc.red.size()-1);
		}
		
		return lc;
	}
	
	private static class Colors{
		static List<Integer> yellow = new ArrayList<Integer>();
		static List<Integer> blue = new ArrayList<Integer>();
		static List<Integer> white = new ArrayList<Integer>();
		static List<Integer> green = new ArrayList<Integer>();
		static List<Integer> red = new ArrayList<Integer>();
		
		static {
			for(int i = 2; i <= 10; i++) {
				yellow.add(i);
			}
			
			for(int i = 12; i <= 20; i++) {
				blue.add(i);
			}
			
			for(int i = 22; i <= 30; i++) {
				white.add(i);
			}
			
			for(int i = 32; i <= 40; i++) {
				green.add(i);
			}
			
			for(int i = 42; i <= 50; i++) {
				red.add(i);
			}
			
		}
	
	}
	
	public static String WhatColor(Integer userCard) {
		
		
		if(Colors.yellow.contains(userCard)) {
			return "yellow";
		}else if(Colors.blue.contains(userCard)) {
			return "blue";
		}else if(Colors.white.contains(userCard)) {
			return "white";
		}else if(Colors.green.contains(userCard)) {
			return "green";
		}else if(Colors.red.contains(userCard)) {
			return "red";
		}
		
		return "error";
	}
	
	public static Integer Score(List<Integer> cards) {
		int score = 0;
		int y = 1;
		int b = 1;
		int w = 1;
		int g = 1;
		int r = 1;
		int ySum = 0;
		int bSum = 0;
		int wSum = 0;
		int gSum = 0;
		int rSum = 0;
		boolean yFirst = true;
		boolean bFirst = true;
		boolean wFirst = true;
		boolean gFirst = true;
		boolean rFirst = true;
		for(Integer i : cards) {
			if(Colors.yellow.contains(i)) {
				if(yFirst) {
					ySum -=20;
					yFirst = false;
				}
				if(i.intValue()%10 == 0) {
					ySum += 10;
				}else {
					ySum += i.intValue()%10;
				}				
			}else if(Colors.blue.contains(i)) {
				if(bFirst) {
					bSum -=20;
					bFirst = false;
				}
				if(i.intValue()%10 == 0) {
					bSum += 10;
				}else {
					bSum += i.intValue()%10;
				}	
			}else if(Colors.white.contains(i)) {
				if(wFirst) {
					wSum -=20;
					wFirst = false;
				}
				if(i.intValue()%10 == 0) {
					wSum += 10;
				}else {
					wSum += i.intValue()%10;
				}
			}else if(Colors.green.contains(i)) {
				if(gFirst) {
					gSum -=20;
					gFirst = false;
				}
				if(i.intValue()%10 == 0) {
					gSum += 10;
				}else {
					gSum += i.intValue()%10;
				}	
			}else if(Colors.red.contains(i)) {
				if(rFirst) {
					rSum -=20;
					rFirst = false;
				}
				if(i.intValue()%10 == 0) {
					rSum += 10;
				}else {
					rSum += i.intValue()%10;
				}	
			}
		}
		
		//손바닥 있으면 곱하기!
		for(Integer i : cards) {
			if(i.intValue() == 1 || i.intValue() == 51 || i.intValue() == 56) {
				y++;
			}else if(i.intValue() == 11 || i.intValue() == 52 || i.intValue() == 57) {
				b++;
			}else if(i.intValue() == 21 || i.intValue() == 53 || i.intValue() == 58) {
				w++;
			}else if(i.intValue() == 31 || i.intValue() == 54 || i.intValue() == 59) {
				g++;
			}else if(i.intValue() == 41 || i.intValue() == 55 || i.intValue() == 60) {
				r++;
			}
		}
		
		score = (ySum*y) + (bSum*b) + (wSum*w) + (gSum*g) + (rSum*r);
		
		return score;
	}
	
}