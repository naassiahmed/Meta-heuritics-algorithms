###Comment
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;


public class Astar {
	
	Cube init;
	Cube but;
	int seuil;
	public static LinkedHashMap<String, Integer> history=new LinkedHashMap<String, Integer>();
	
	public Astar(Cube c) throws CloneNotSupportedException
	{
		init=new Cube();
		init=c.clone();
		this.seuil=init.seuil;
		but = new Cube();
	}
	
	public void Apply_Rule1(Cube c, LinkedList<Cube> L, int rule) throws CloneNotSupportedException
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
		h1(c);
		this.Insert1(c, L);
		}
	}
	
	public void rules1(Cube c, LinkedList<Cube> L) throws CloneNotSupportedException
	{
		Cube c0 = new Cube();
		
		for(int i=0;i<12;i++)
		{
			c0=c.clone();
			Apply_Rule1(c0,L,i);
		}
	}
	
	public void h1(Cube c)
	{
	
		c.valH[0]=0;
		c.valH[1]=10;
		int temp=0;
		for (int i=0;i<6;i++)
		{
			for(int j=0;j<c.cube[i].length();j++)
			{
				
				if(c.cube[i].charAt(j)!= c.cube[i].charAt(4)) { c.valH[0]++; temp++;}
			}
			if (temp < c.valH[1]) c.valH[1]=temp;
			temp =0;
		}		
		c.valH[0] = (this.seuil-c.seuil)+c.valH[0];	
	}
	
	public void Insert1(Cube c ,LinkedList<Cube> L){
		if (L.size()==0) L.add(c);
		else
		{
			int i=0;
			while (i<L.size() && c.valH[0]>L.get(i).valH[0]) i++;
			if (i>=L.size()) L.add(c);
			else
			{
				while (i<L.size() && c.valH[0]==L.get(i).valH[0] && c.valH[1]>=L.get(i).valH[1]) i++;
				if (i>=L.size()) L.add(c); else L.add(i,c);
			}
		}
	}	
	
	public void Search1() throws CloneNotSupportedException
	{
		LinkedList<Cube> L = new LinkedList<Cube>();
		Cube node=new Cube();
		L.add(init);
		while (L.size()!=0)
		{
			
			node=L.removeFirst().clone();
			node.seuil--;
			if(node.GetFullStringCube().hashCode()==but.GetFullStringCube().hashCode())
				{
				System.out.println("Solution trouvée, le chemin est : ");
				System.out.println(node.dep);
				break;
				}				
			if (node.seuil>=0) {rules1(node,L);}		
		}
	}
	
	public void Apply_Rule2(Cube c, LinkedList<Cube> L, int rule) throws CloneNotSupportedException
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
		h2(c);
		this.Insert2(c, L);
		}
	}
	
	public void rules2(Cube c, LinkedList<Cube> L) throws CloneNotSupportedException
	{
		Cube c0 = new Cube();
		
		for(int i=0;i<12;i++)
		{
			c0=c.clone();
			Apply_Rule2(c0,L,i);
		}
	}
	
	public void h2(Cube c)
	{
		c.valH[0]=0;
		c.valH[1]=0;
		if (c.cube[0].charAt(0)!='w' || c.cube[3].charAt(2)!='r' || c.cube[4].charAt(6)!='g') c.valH[0]++;
		if (c.cube[0].charAt(2)!='w' || c.cube[1].charAt(0)!='o' || c.cube[4].charAt(8)!='g') c.valH[0]++;
		if (c.cube[0].charAt(6)!='w' || c.cube[3].charAt(8)!='r' || c.cube[5].charAt(6)!='b') c.valH[0]++;
		if (c.cube[0].charAt(8)!='w' || c.cube[1].charAt(6)!='o' || c.cube[5].charAt(8)!='b') c.valH[0]++;
		if (c.cube[1].charAt(2)!='o' || c.cube[2].charAt(0)!='y' || c.cube[4].charAt(2)!='g') c.valH[0]++;
		if (c.cube[1].charAt(8)!='o' || c.cube[2].charAt(6)!='y' || c.cube[5].charAt(2)!='b') c.valH[0]++;
		if (c.cube[2].charAt(2)!='y' || c.cube[3].charAt(0)!='r' || c.cube[4].charAt(0)!='g') c.valH[0]++;
		if (c.cube[2].charAt(8)!='y' || c.cube[3].charAt(6)!='r' || c.cube[5].charAt(0)!='b') c.valH[0]++;
		if (c.cube[0].charAt(5)!='w' || c.cube[1].charAt(3)!='o') c.valH[0]++;
		if (c.cube[0].charAt(3)!='w' || c.cube[3].charAt(5)!='r') c.valH[0]++;
		if (c.cube[0].charAt(1)!='w' || c.cube[4].charAt(7)!='g') c.valH[0]++;
		if (c.cube[0].charAt(7)!='w' || c.cube[5].charAt(7)!='b') c.valH[0]++;
		if (c.cube[1].charAt(5)!='o' || c.cube[2].charAt(3)!='y') c.valH[0]++;
		if (c.cube[1].charAt(1)!='o' || c.cube[4].charAt(5)!='g') c.valH[0]++;
		if (c.cube[1].charAt(7)!='o' || c.cube[5].charAt(5)!='b') c.valH[0]++;
		if (c.cube[2].charAt(5)!='y' || c.cube[3].charAt(3)!='r') c.valH[0]++;
		if (c.cube[2].charAt(1)!='y' || c.cube[4].charAt(1)!='g') c.valH[0]++;
		if (c.cube[2].charAt(7)!='y' || c.cube[5].charAt(1)!='b') c.valH[0]++;
		if (c.cube[3].charAt(1)!='r' || c.cube[4].charAt(3)!='g') c.valH[0]++;
		if (c.cube[3].charAt(7)!='r' || c.cube[5].charAt(3)!='b') c.valH[0]++;
		c.valH[0] = (this.seuil-c.seuil)+c.valH[0];	
	}
	
	public void Insert2(Cube c ,LinkedList<Cube> L){
		if (L.size()==0) L.add(c);
		else
		{
			int i=0;
			while (i<L.size() && c.valH[0]>=L.get(i).valH[0]) i++;
			if (i>=L.size()) L.add(c);
			else L.add(i,c);
		}
	}	
	
	public void Search2() throws CloneNotSupportedException
	{
		LinkedList<Cube> L = new LinkedList<Cube>();
		Cube node=new Cube();
		L.add(init);
		while (L.size()!=0)
		{
			
			node=L.removeFirst().clone();
			node.seuil--;
			if(node.GetFullStringCube().hashCode()==but.GetFullStringCube().hashCode())
				{
				System.out.println("Solution trouvée, le chemin est : ");
				System.out.println(node.dep);
				break;
				}				
			if (node.seuil>=0) {rules2(node,L);}		
		}
	}

}
