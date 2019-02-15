

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Cube implements Cloneable
{
	
	String[] cube;
	int seuil;
	int[] valH = new int[2];
	ArrayList<String> dep = new ArrayList<String>();
	
	public Cube()
	{
		cube=new String[6];
		cube[0]="wwwwwwwww"; //white
			cube[1]="ooooooooo"; //orange
				cube[2]="yyyyyyyyy"; //yellow
					cube[3]="rrrrrrrrr";  //red
						cube[4]="ggggggggg";  //green
							cube[5]="bbbbbbbbb";  //bleu
		seuil=1;
	}
	
	public void Affiche()
	{
		for(int i=0;i<cube.length;i++)
		{
			System.out.println(cube[i]);
		}
		System.out.println();
	}
	
	public Cube clone() throws CloneNotSupportedException
	{
		Cube c0= (Cube)super.clone();
		c0=new Cube();
		System.arraycopy(this.cube,0,c0.cube,0,this.cube.length);
		c0.dep=(ArrayList<String>) this.dep.clone();
		c0.seuil=this.seuil;
		return c0;
	}
	
	public String GetFullStringCube(){
			String s = "";
			for(int i=0;i<cube.length;i++)
				s=s+cube[i];
			
			return s;
		}
	
	//Une méthode qui permute les couleurs, donnez une coté et la postion à changer et la nouvelle couleur
	public String Swap(String string,int index1,char coulor){
	char[] temp=string.toCharArray();
		temp[index1]=coulor;
		return String.valueOf(temp);		
	}
	
	public static String Rot_Face_Right(String face){
		String newface ="";
		newface=newface+face.charAt(6);
		newface=newface+face.charAt(3);
		newface=newface+face.charAt(0);
		newface=newface+face.charAt(7);
		newface=newface+face.charAt(4);
		newface=newface+face.charAt(1);
		newface=newface+face.charAt(8);
		newface=newface+face.charAt(5);
		newface=newface+face.charAt(2);
		return newface;
	}
	
	public static String Rot_Face_Left(String face){
		String newface ="";
		newface=newface+face.charAt(2);
		newface=newface+face.charAt(5);
		newface=newface+face.charAt(8);
		newface=newface+face.charAt(1);
		newface=newface+face.charAt(4);
		newface=newface+face.charAt(7);
		newface=newface+face.charAt(0);
		newface=newface+face.charAt(3);
		newface=newface+face.charAt(6);
		return newface;
	}
	
	public void Move_Hori_High_Right(){
		String s=cube[0].substring(0,3);
		cube[0]=Swap(cube[0],0,cube[1].charAt(0)); cube[0]=Swap(cube[0],1,cube[1].charAt(1)); cube[0]=Swap(cube[0],2,cube[1].charAt(2));
		cube[1]=Swap(cube[1],0,cube[2].charAt(0)); cube[1]=Swap(cube[1],1,cube[2].charAt(1)); cube[1]=Swap(cube[1],2,cube[2].charAt(2));
		cube[2]=Swap(cube[2],0,cube[3].charAt(0)); cube[2]=Swap(cube[2],1,cube[3].charAt(1)); cube[2]=Swap(cube[2],2,cube[3].charAt(2));
		cube[3]=Swap(cube[3],0,s.charAt(0)); cube[3]=Swap(cube[3],1,s.charAt(1)); cube[3]=Swap(cube[3],2,s.charAt(2));
		cube[4]=Rot_Face_Right(cube[4]);
		dep.add("HHR");
		//dep.clear();
	}
	
	public void Move_Hori_High_Left(){
		String s=cube[0].substring(0,3);
		cube[0]=Swap(cube[0],0,cube[3].charAt(0)); cube[0]=Swap(cube[0],1,cube[3].charAt(1)); cube[0]=Swap(cube[0],2,cube[3].charAt(2));
		cube[3]=Swap(cube[3],0,cube[2].charAt(0)); cube[3]=Swap(cube[3],1,cube[2].charAt(1)); cube[3]=Swap(cube[3],2,cube[2].charAt(2));
		cube[2]=Swap(cube[2],0,cube[1].charAt(0)); cube[2]=Swap(cube[2],1,cube[1].charAt(1)); cube[2]=Swap(cube[2],2,cube[1].charAt(2));
		cube[1]=Swap(cube[1],0,s.charAt(0)); cube[1]=Swap(cube[1],1,s.charAt(1)); cube[1]=Swap(cube[1],2,s.charAt(2));
		cube[4]=Rot_Face_Left(cube[4]);
		dep.add("HHL");
	//	dep.clear();
	}

	public void Move_Hori_Down_Right(){
		String s=cube[0].substring(6,9);
		cube[0]=Swap(cube[0],6,cube[1].charAt(6)); cube[0]=Swap(cube[0],7,cube[1].charAt(7)); cube[0]=Swap(cube[0],8,cube[1].charAt(8));
		cube[1]=Swap(cube[1],6,cube[2].charAt(6)); cube[1]=Swap(cube[1],7,cube[2].charAt(7)); cube[1]=Swap(cube[1],8,cube[2].charAt(8));
		cube[2]=Swap(cube[2],6,cube[3].charAt(6)); cube[2]=Swap(cube[2],7,cube[3].charAt(7)); cube[2]=Swap(cube[2],8,cube[3].charAt(8));
		cube[3]=Swap(cube[3],6,s.charAt(0)); cube[3]=Swap(cube[3],7,s.charAt(1)); cube[3]=Swap(cube[3],8,s.charAt(2));
		cube[5]=Rot_Face_Right(cube[5]);
		dep.add("HDR");
	//	dep.clear();
	}
	
	public void Move_Hori_Down_Left(){
		String s=cube[0].substring(6,9);
		cube[0]=Swap(cube[0],6,cube[3].charAt(6)); cube[0]=Swap(cube[0],7,cube[3].charAt(7)); cube[0]=Swap(cube[0],8,cube[3].charAt(8));
		cube[3]=Swap(cube[3],6,cube[2].charAt(6)); cube[3]=Swap(cube[3],7,cube[2].charAt(7)); cube[3]=Swap(cube[3],8,cube[2].charAt(8));
		cube[2]=Swap(cube[2],6,cube[1].charAt(6)); cube[2]=Swap(cube[2],7,cube[1].charAt(7)); cube[2]=Swap(cube[2],8,cube[1].charAt(8));
		cube[1]=Swap(cube[1],6,s.charAt(0)); cube[1]=Swap(cube[1],7,s.charAt(1)); cube[1]=Swap(cube[1],8,s.charAt(2));
		cube[5]=Rot_Face_Left(cube[5]);
		dep.add("HDL");
		//dep.clear();
	}

	public void Move_Vert_Right_Up(){
		String s=""+cube[0].charAt(2)+cube[0].charAt(5)+cube[0].charAt(8);
		cube[0]=Swap(cube[0],2,cube[5].charAt(8)); cube[0]=Swap(cube[0],5,cube[5].charAt(5)); cube[0]=Swap(cube[0],8,cube[5].charAt(2));
		cube[5]=Swap(cube[5],2,cube[2].charAt(0)); cube[5]=Swap(cube[5],5,cube[2].charAt(5)); cube[5]=Swap(cube[5],8,cube[2].charAt(8));
		cube[2]=Swap(cube[2],0,cube[4].charAt(8)); cube[2]=Swap(cube[2],3,cube[4].charAt(5)); cube[2]=Swap(cube[2],6,cube[4].charAt(2));
		cube[4]=Swap(cube[4],2,s.charAt(0)); cube[4]=Swap(cube[4],5,s.charAt(1)); cube[4]=Swap(cube[4],8,s.charAt(2));
		cube[1]=Rot_Face_Right(cube[1]);
		dep.add("VRU");
		//dep.clear();
	}
	
	public void Move_Vert_Right_Down(){
		String s=""+cube[0].charAt(8)+cube[0].charAt(5)+cube[0].charAt(2);
		cube[0]=Swap(cube[0],2,cube[4].charAt(2)); cube[0]=Swap(cube[0],5,cube[4].charAt(5)); cube[0]=Swap(cube[0],8,cube[4].charAt(8));
		cube[4]=Swap(cube[4],2,cube[2].charAt(6)); cube[4]=Swap(cube[4],5,cube[2].charAt(3)); cube[4]=Swap(cube[4],8,cube[2].charAt(0));
		cube[2]=Swap(cube[2],0,cube[5].charAt(2)); cube[2]=Swap(cube[2],3,cube[5].charAt(5)); cube[2]=Swap(cube[2],6,cube[5].charAt(8));
		cube[5]=Swap(cube[5],2,s.charAt(0)); cube[5]=Swap(cube[5],5,s.charAt(1)); cube[5]=Swap(cube[5],8,s.charAt(2));
		cube[1]=cube[1]=Rot_Face_Left(cube[1]);
		dep.add("VRD");
		//dep.clear();
	}

	public void Move_Vert_Left_Down(){
		String s=""+cube[0].charAt(0)+cube[0].charAt(3)+cube[0].charAt(6);
		cube[0]=Swap(cube[0],0,cube[4].charAt(0)); cube[0]=Swap(cube[0],3,cube[4].charAt(3)); cube[0]=Swap(cube[0],6,cube[4].charAt(6));
		cube[4]=Swap(cube[4],0,cube[2].charAt(8)); cube[4]=Swap(cube[4],3,cube[2].charAt(5)); cube[4]=Swap(cube[4],6,cube[2].charAt(2));
		cube[2]=Swap(cube[2],2,cube[5].charAt(0)); cube[2]=Swap(cube[2],5,cube[5].charAt(3)); cube[2]=Swap(cube[2],8,cube[5].charAt(6));
		cube[5]=Swap(cube[5],0,s.charAt(2)); cube[5]=Swap(cube[5],3,s.charAt(1)); cube[5]=Swap(cube[5],6,s.charAt(0));
		cube[3]=Rot_Face_Right(cube[3]);
		dep.add("VLD");
		//dep.clear();
	}
	
	public void Move_Vert_Left_Up(){
		String s=""+cube[0].charAt(0)+cube[0].charAt(3)+cube[0].charAt(6);
		cube[0]=Swap(cube[0],0,cube[5].charAt(6)); cube[0]=Swap(cube[0],3,cube[5].charAt(3)); cube[0]=Swap(cube[0],6,cube[5].charAt(0));
		cube[5]=Swap(cube[5],0,cube[2].charAt(2)); cube[5]=Swap(cube[5],3,cube[2].charAt(5)); cube[5]=Swap(cube[5],6,cube[2].charAt(8));
		cube[2]=Swap(cube[2],2,cube[4].charAt(6)); cube[2]=Swap(cube[2],5,cube[4].charAt(3)); cube[2]=Swap(cube[2],8,cube[4].charAt(0));
		cube[4]=Swap(cube[4],0,s.charAt(0)); cube[4]=Swap(cube[4],3,s.charAt(1)); cube[4]=Swap(cube[4],6,s.charAt(2));
		cube[3]=Rot_Face_Left(cube[3]);
		dep.add("VLU");
		//dep.clear();
	}


	public void Move_Face_Right(){
		String s=""+cube[1].charAt(6)+cube[1].charAt(3)+cube[1].charAt(0);
		cube[1]=Swap(cube[1],0,cube[4].charAt(6)); cube[1]=Swap(cube[1],3,cube[4].charAt(7));  cube[1]=Swap(cube[1],6,cube[4].charAt(8));
		cube[4]=Swap(cube[4],6,cube[3].charAt(8)); cube[4]=Swap(cube[4],7,cube[3].charAt(5));  cube[4]=Swap(cube[4],8,cube[3].charAt(2));
		cube[3]=Swap(cube[3],2,cube[5].charAt(6)); cube[3]=Swap(cube[3],5,cube[5].charAt(7));  cube[3]=Swap(cube[3],8,cube[5].charAt(8));
		cube[5]=Swap(cube[5],6,s.charAt(0)); cube[5]=Swap(cube[5],7,s.charAt(1)); cube[5]=Swap(cube[5],8,s.charAt(2));
		cube[0]=Rot_Face_Right(cube[0]);
		dep.add("FR");
		//dep.clear();
	}
	
	public void Move_Face_Left(){
		String s=""+cube[1].charAt(0)+cube[1].charAt(3)+cube[1].charAt(6);
		cube[1]=Swap(cube[1],0,cube[5].charAt(8)); cube[1]=Swap(cube[1],3,cube[5].charAt(7)); cube[1]=Swap(cube[1],6,cube[5].charAt(6));
		cube[5]=Swap(cube[5],6,cube[3].charAt(2)); cube[5]=Swap(cube[5],7,cube[3].charAt(5)); cube[5]=Swap(cube[5],8,cube[3].charAt(8));
		cube[3]=Swap(cube[3],2,cube[4].charAt(8)); cube[3]=Swap(cube[3],5,cube[4].charAt(7)); cube[3]=Swap(cube[3],8,cube[4].charAt(6));
		cube[4]=Swap(cube[4],6,s.charAt(0)); cube[4]=Swap(cube[4],7,s.charAt(1)); cube[4]=Swap(cube[4],8,s.charAt(2));
		cube[0]=Rot_Face_Left(cube[0]);
		dep.add("FL");
		//dep.clear();
	}

	public void Move_Back_Right(){
		String s=""+cube[1].charAt(8)+cube[1].charAt(5)+cube[1].charAt(2);
		cube[1]=Swap(cube[1],2,cube[4].charAt(0)); cube[1]=Swap(cube[1],5,cube[4].charAt(1));  cube[1]=Swap(cube[1],8,cube[4].charAt(2));
		cube[4]=Swap(cube[4],0,cube[3].charAt(6)); cube[4]=Swap(cube[4],1,cube[3].charAt(3));  cube[4]=Swap(cube[4],2,cube[3].charAt(0));
		cube[3]=Swap(cube[3],0,cube[5].charAt(0)); cube[3]=Swap(cube[3],3,cube[5].charAt(1));  cube[3]=Swap(cube[3],6,cube[5].charAt(2));
		cube[5]=Swap(cube[5],0,s.charAt(0)); cube[5]=Swap(cube[5],1,s.charAt(1)); cube[5]=Swap(cube[5],2,s.charAt(2));
		cube[2]=Rot_Face_Left(cube[2]);
		dep.add("BR");
	//	dep.clear();
	}
	
	public void Move_Back_Left(){
		String s=""+cube[1].charAt(2)+cube[1].charAt(5)+cube[1].charAt(8);
		cube[1]=Swap(cube[1],2,cube[5].charAt(2)); cube[1]=Swap(cube[1],5,cube[5].charAt(1)); cube[1]=Swap(cube[1],8,cube[5].charAt(0));
		cube[5]=Swap(cube[5],0,cube[3].charAt(0)); cube[5]=Swap(cube[5],1,cube[3].charAt(3)); cube[5]=Swap(cube[5],2,cube[3].charAt(6));
		cube[3]=Swap(cube[3],0,cube[4].charAt(2)); cube[3]=Swap(cube[3],3,cube[4].charAt(1)); cube[3]=Swap(cube[3],6,cube[4].charAt(0));
		cube[4]=Swap(cube[4],0,s.charAt(0)); cube[4]=Swap(cube[4],1,s.charAt(1)); cube[4]=Swap(cube[4],2,s.charAt(2));
		cube[2]=Rot_Face_Right(cube[2]);
		dep.add("BL");
	//	dep.clear();
	}
}
