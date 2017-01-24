package com.betaben.inventory;

import java.util.ArrayList;

public class Library {

	public static ArrayList<Item> items;
	public static ArrayList<ItemPanel> panels;
	
	public Library(){
		items = new ArrayList<Item>();
		panels = new ArrayList<ItemPanel>();
	}
	
	public void addItem(Item item){
		items.add(item);
	}
	
	public void addItem(ItemPanel panel){
		panels.add(panel);
	}
	
	public void removeItem(Item item){
		items.remove(item);
	}
	
	public void removeItem(ItemPanel panel){
		panels.remove(panel);
	}

	public ArrayList<Item> getItems(){
		return items;
	}
	
	public ArrayList<ItemPanel> getPanels(){
		return panels;
	}
	
//	public void setItems(ArrayList<Item> items){
//		this.items = items;
//	}
	
}
