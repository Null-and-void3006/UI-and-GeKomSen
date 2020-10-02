package controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.LogicalCircuitObject;
import model.LogicalWire;
import model.Selectable;
import view.ElementLogicalCircuitView;

public class MouseListenerLCPanel extends MouseAdapter{
	
	private int x, y;
	private ArrayList<Point> pu;
	private ArrayList<Point> pr;
	private LogicalWire wire;
	private boolean flag;
	private boolean flagInput;
	private Rectangle selection;
	private Point selectionStart;
	private ArrayList<Selectable> selectedItems;
	private boolean selectionState;
	
	private ElementLogicalCircuitView elcv;
	public MouseListenerLCPanel(ElementLogicalCircuitView elcv) {
		this.elcv=elcv;
		selectedItems= new ArrayList<>();
		wire=new LogicalWire(new ArrayList<>(), null, null);
		flagInput=false;
		selectionState=false;
		pu=new ArrayList<>();
		pr=new ArrayList<>();
		x = -1;
		y = -1;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(elcv.getSelection().equals("and")) elcv.drawAND(e.getX(), e.getY());
		if(elcv.getSelection().equals("or")) elcv.drawOR(e.getX(), e.getY());
		if(elcv.getSelection().equals("not")) elcv.drawNOT(e.getX(), e.getY());
		
		if(elcv.getSelection().equals("wire")){
			flag = false;
			if(x == -1 && y == -1){
				elcv.getLCElement().getWires().add(wire);
				x = e.getX();
				y = e.getY();
				for(LogicalCircuitObject lco: elcv.getLCElement().getObjects()){
					if(lco.getInputHitbox().contains(e.getPoint()) && lco.getInput()!=0){
						flagInput=true;
						x=lco.getInputPoint().x;
						y=lco.getInputPoint().y;
						wire.getPoints().add(new Point(lco.getInputPoint().x,lco.getInputPoint().y));
						wire.setInput(lco);
						lco.useInput();
					}
				}
			}
			else{
				for(LogicalCircuitObject lco: elcv.getLCElement().getObjects()){
					if(lco.getInputHitbox().contains(e.getPoint()) && lco.getInput()!=0 && !flagInput){
						flag = true;
						wire.getPoints().add(new Point(lco.getInputPoint().x, lco.getInputPoint().y));
						elcv.drawWIRE(x, y, lco.getInputPoint().x, lco.getInputPoint().y);
						wire.setInput(lco);
						elcv.finishWire(wire);
						wire.setPoints(new ArrayList<Point>());
						x = -1;
						y = -1;
						lco.useInput();
					}
					if(lco.getOutputHitbox().contains(e.getPoint()) && !lco.isFull()){
						flag = true;
						wire.getPoints().add(new Point(lco.getOutputPoint().x, lco.getOutputPoint().y));
						elcv.drawWIRE(x, y, lco.getOutputPoint().x, lco.getOutputPoint().y);
						wire.setOutput(lco);
						elcv.finishWire(wire);
						wire.setPoints(new ArrayList<Point>());
						x = -1;
						y = -1;
						lco.setFull(true);
						flagInput=false;
					}
					
				}
				if(!flag){
					wire.getPoints().add(new Point(e.getPoint()));
					elcv.drawWIRE(x, y, e.getX(), e.getY());
					pu.add(new Point(x, y));
					x = e.getX();
					y = e.getY();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(selectionState){
			selectionState=false;
			if(selection.contains(e.getX(),e.getY())){
				elcv.getLCElement().getObjects().removeAll(selectedItems);
				elcv.getLCElement().getWires().removeAll(selectedItems);
				
				
			}
			
		}
		selectionStart= new Point(e.getX(),e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		try{
		selection= new Rectangle(selectionStart.x, selectionStart.y, Math.abs(selectionStart.x-e.getX()), Math.abs(selectionStart.y-e.getY()));
		for(LogicalCircuitObject lco:elcv.getLCElement().getObjects()){
			if(selection.contains(lco.getPoint().x, lco.getPoint().y)) selectedItems.add(lco);
		}
		for(LogicalWire lw:elcv.getLCElement().getWires()){
			if(selection.contains(lw.getPoints().get(0).x, lw.getPoints().get(0).y)) selectedItems.add(lw);
		}
		selectionState=true;
		System.out.println(selection);
		selectionStart.setLocation(-1,-1);
		}
		catch(Exception ZULUL){
			
		}
	}
	public ArrayList<Selectable> getSelectedItems(){
		return selectedItems;
	}
	public void undoWire(){
		try{
		x=pu.get(pu.size()-1).x;
		y=pu.get(pu.size()-1).y;
		pr.add(pu.get(pu.size()-1));
		pu.remove(pu.size()-1);
		}
		catch (Exception e) {
			// TODO: Don't handle exception
		}
	}
	public void redoWire(){
		x=pr.get(pr.size()-1).x;
		y=pr.get(pr.size()-1).y;
		pu.add(pr.get(pr.size()-1));
		pr.remove(pr.size()-1);
	}
	
	
}
