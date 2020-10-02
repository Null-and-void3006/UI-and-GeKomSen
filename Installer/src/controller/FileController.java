package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Moduo;
import model.Parametar;
import model.Softver;

public class FileController {
	public static void saveSoftware(Softver s){
		JSONObject o=new JSONObject();
		ArrayList<String> children=new ArrayList<>();
		for(Moduo m:s.getModuli()){
			children.add(m.toString());
		}
		o.put("NAME", s.toString());
		o.put("CHILDREN", children);
		try {
			PrintWriter pw=new PrintWriter(new File(s.toString()+".json"));
			o.write(pw);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveModuo(Moduo m){
		JSONObject o=new JSONObject();
		ArrayList<String> children= new ArrayList<>();
		for(Parametar p:m.getParametri()){
			children.add(p.toString());
		}
		o.put("NAME", m.toString());
		o.put("CHILDREN", children);
		try {
			PrintWriter pw= new PrintWriter(new File(m.getParent().toString()+"_"+m.toString()+".json"));
			o.write(pw);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void saveParametar(Parametar p){
		JSONObject o=new JSONObject();
		o.put("NAME", p.toString());
		try {
			PrintWriter pw= new PrintWriter(new File(p.getParent().getParent()+"_"+p.getParent()+"_"+p.toString()+".json"));
			o.write(pw);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Softver loadSoftware(String path){
		String s="{}";
		try {
			Scanner sc=new Scanner(new File(path+".json"));
			if(sc.hasNextLine()){
				s=sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject o=new JSONObject(s);
		Softver a=new Softver(o.getString("NAME"));
		JSONArray children=new JSONArray("CHILDREN");
		for(int i=0;i<children.length();i++){
			a.addModul(loadModuo(path+"_"+children.getString(i).toString()));
		}
		return a;
	}
	public static Parametar loadParametar(String path){
		String s="{}";
		try {
			Scanner sc= new Scanner(new File(path+".json"));
			if(sc.hasNextLine()){
				s=sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject o=new JSONObject(s);
		Parametar p=new Parametar(o.getString("NAME"));
		return p;
	}
	public static Moduo loadModuo(String path){
		String s="{}";
		try {
			Scanner sc= new Scanner(new File(path+".json"));
			if(sc.hasNextLine()){
				s=sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject o=new JSONObject(s);
		Moduo m=new Moduo(o.getString("NAME"));
		JSONArray children=o.getJSONArray("CHILDREN");
		for(int i=0;i<children.length();i++){
			m.addParametar(loadParametar(path+"_"+children.getString(i).toString()));
		}
		return m;
	}
	
	
	
}
