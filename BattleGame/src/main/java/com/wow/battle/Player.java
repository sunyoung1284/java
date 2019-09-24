package com.wow.battle;

public class Player {
	public int idx;
	public String name;
	public String attack;
	public String shield;
	public String att_prob;
	public String shld_prob;
	public String hp;
//	public int game;
//	public int win;
//	public int lose;
	
	Player() {
	}
	
	Player(String name, String attack, String shield, String att_prob, String shld_prob, String hp) {
		this.name = name;
		this.attack = attack;
		this.shield = shield;
		this.att_prob = att_prob;
		this.shld_prob = shld_prob;
		this.hp = hp;
//		this.game = game;
//		this.win = win;
//		this.lose = lose;
	}
	
	Player(int idx, String name, String attack, String shield, String att_prob, String shld_prob, String hp) {
		this.idx = idx;
		this.name = name;
		this.attack = attack;
		this.shield = shield;
		this.att_prob = att_prob;
		this.shld_prob = shld_prob;
		this.hp = hp;
//		this.game = game;
//		this.win = win;
//		this.lose = lose;
	}
	
	public String toTableTagString() {
		String tagString = "";
		tagString = tagString + "<tr>";
		tagString = tagString + "<td>";
		tagString = tagString + "<input type='checkbox' id='checked' name='chk_info' value=" + this.idx + ">";
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.idx;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.name;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.attack;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.shield;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.att_prob;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.shld_prob;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.hp;
		tagString = tagString + "</td>";
//		tagString = tagString + "<td>";
//		tagString = tagString + this.game;
//		tagString = tagString + "</td>";
//		tagString = tagString + "<td>";
//		tagString = tagString + this.win;
//		tagString = tagString + "</td>";
//		tagString = tagString + "<td>";
//		tagString = tagString + this.lose;
//		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + "<a href='modify?idx="+this.idx+"'>수정</a>";
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + "<a href='delete?idx="+this.idx+"'>삭제</a>";
		tagString = tagString + "</td>";
		tagString = tagString + "</tr>";
		return tagString;
	}
	
	public String toTableTagString2() {
		String tagString = "";
		tagString = tagString + "<tr>";
		tagString = tagString + "<td>";
		tagString = tagString + this.name;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.attack;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.shield;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.att_prob;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.shld_prob;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.hp;
		tagString = tagString + "</td>";
		tagString = tagString + "</tr>";
		tagString = tagString + "<input type='hidden' name='user' value='"+ this.idx + "'>";
		
		return tagString;
	}
	
}
