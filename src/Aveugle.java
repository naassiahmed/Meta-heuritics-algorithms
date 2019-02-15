

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Aveugle {
	Cube init;
	Cube but;
	public static LinkedHashMap<String, Integer> history=new LinkedHashMap<String, Integer>();
	
	
	
	public Aveugle (Cube c) throws CloneNotSupportedException
	{
		init=new Cube();
		init=c.clone();
		but = new Cube();
	}
	
	public int keyHash(String key)
	 {
	      int k = (int)key.length();
	      int u = 0,n = 0;

	     for (int i=0; i<k; i++)
	     {
	         n = (int)key.toCharArray()[i];
	         
	         u += i*n%31;
	     }
	     return u%200000;
	 }
	
	public void Larg_Apply_Rule(Cube c, LinkedList<Cube> Q, int rule) throws CloneNotSupportedException
	{
		switch(rule)
		{
		case 0 : c.Move_Back_Left();break;
		case 1 : c.Move_Back_Right();break;
		case 2 : c.Move_Face_Left();break;
		case 3 : c.Move_Face_Right();break;
		case 4 : c.Move_Hori_Down_Left();break;
		case 5 : c.Move_Hori_Down_Right();break;
		case 6 : c.Move_Hori_High_Left();break;
		case 7 : c.Move_Hori_High_Right();break;
		case 8 : c.Move_Vert_Left_Down();break;
		case 9 : c.Move_Vert_Left_Up();break;
		case 10 : c.Move_Vert_Right_Down();break;
		case 11 : c.Move_Vert_Right_Up();break;
		}
		
		if(history.put(c.GetFullStringCube(), 1)==null){
		history.put(c.GetFullStringCube(), 1);
		Q.add(c.clone());}
	}
	
	public void Prof_Apply_Rule(Cube c, Stack<Cube> P, int rule) throws CloneNotSupportedException
	{
		switch(rule)
		{
		case 0 : c.Move_Back_Left();break;
		case 1 : c.Move_Back_Right();break;
		case 2 : c.Move_Face_Left();break;
		case 3 : c.Move_Face_Right();break;
		case 4 : c.Move_Hori_Down_Left();break;
		case 5 : c.Move_Hori_Down_Right();break;
		case 6 : c.Move_Hori_High_Left();break;
		case 7 : c.Move_Hori_High_Right();break;
		case 8 : c.Move_Vert_Left_Down();break;
		case 9 : c.Move_Vert_Left_Up();break;
		case 10 : c.Move_Vert_Right_Down();break;
		case 11 : c.Move_Vert_Right_Up();break;
		}		
		
		if(history.put(c.GetFullStringCube(), 1)==null && !P.contains(c)){
			
			P.push(c);}
	}
	
	public void Larg_rules(Cube c, LinkedList<Cube> Q) throws CloneNotSupportedException
	{
		Cube c0 = new Cube();
		
		for(int i=0;i<12;i++)
		{
			c0=c.clone();
			Larg_Apply_Rule(c0,Q,i);
		}
	}
	
	public void Prof_rules(Cube c, Stack<Cube> P) throws CloneNotSupportedException
	{
		Cube c0= new Cube();
		for(int i=0;i<12;i++)
		{
			c0=c.clone();
			Prof_Apply_Rule(c0,P,i);
		}
	}
	
	public void Largeur() throws CloneNotSupportedException
	{
		LinkedList<Cube> Q = new LinkedList<Cube>();
		Cube node=new Cube();
		Q.add(init);
		while (Q.size()!=0)
		{
			
			node=Q.removeFirst().clone();
			if(node.GetFullStringCube().hashCode()==but.GetFullStringCube().hashCode())
				{
				System.out.println("Solution trouvée, le chemin est : ");
				System.out.println(node.dep);
				break;
				}				
			Larg_rules(node,Q);		}
	}
	
	public void Profondeur() throws CloneNotSupportedException
	{
		Stack<Cube> P = new Stack<Cube>();
		Cube node = new Cube();
		int s=1;
		P.push(init);
		while (!P.empty())
		{
		
			node=P.pop().clone();
			node.seuil--;
			
			if(node.GetFullStringCube().hashCode()==but.GetFullStringCube().hashCode())
			{
				System.out.println("Solution trouvée, le chemin est : ");
				System.out.println(node.dep);
			break;
			}
			if (node.seuil>=0) {Prof_rules(node,P);}		
		}
		
		
	}
}
