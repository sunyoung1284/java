package com.sunyoung.spring5;

public class People {
	public int idx;
	public String name;
	public String favoriteColor;
	public String address;
	public String birthday;
	public String id;
	public String password;
	
	People() {
	}
	People(String name, String favoriteColor,String address, String birthday, String id, String password) {
		this.name = name;
		this.favoriteColor = favoriteColor;
		this.address=address;
		this.birthday=birthday;
		this.id=id;
		this.password=password;
	}
	
	People(String name, String favoriteColor,String address, String birthday) {
		this.name = name;
		this.favoriteColor = favoriteColor;
		this.address=address;
		this.birthday=birthday;
	}
	public String toTableTagString() {
		String tagString = "";
		tagString = tagString + "<tr>";
		tagString = tagString + "<td>";
		tagString = tagString + this.idx;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.id;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.name;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.address;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.birthday;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + this.favoriteColor;
		tagString = tagString + "</td>";
		tagString = tagString + "<td>";
		tagString = tagString + "<a href='modify?idx=" + this.idx + "'>수정하기</a>";
		tagString = tagString + "</td>";
		tagString = tagString + "</tr>";
		return tagString;
	}
}
