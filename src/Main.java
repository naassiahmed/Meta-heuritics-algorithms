import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;




public class Main {
	
	public static void Create_bench(int nbr) throws IOException{
		
		for(int k=0;k<10;k++)
		{
		Cube c = new Cube();
		Random rnd = new Random();
		int val;
		for(int i=0;i<nbr;i++)
		{
			val=rnd.nextInt(12);
			
			switch(val)
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
		}
		
		File Fichier = new File("F:/Benchmarks cube/bench_cube"+k+".txt");
	    BufferedWriter writer = new BufferedWriter(new FileWriter(Fichier));
	    writer.write("Fichier Benchmark :"+"\n"); 	
		writer.write(c.cube[0]+"\n");
		writer.write(c.cube[1]+"\n");
		writer.write(c.cube[2]+"\n");
		writer.write(c.cube[3]+"\n");
		writer.write(c.cube[4]+"\n");
		writer.write(c.cube[5]+"\n");
		writer.write(String.valueOf(nbr)+"\n");
		writer.write(c.dep.toString());
		writer.close();
		}
	}
	
	public static void Read_bench(Cube c, String bench) throws IOException
	{
		File file = new File(bench);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String txt;int i=-1;
		
		while ((txt = in.readLine()) != null)
		{
			if(i>6)break;
			if (i==-1 )
			{
			i++;	
			}
			else if (i<6){
				c.cube[i]=txt;
				i++;
			}
			
			else if(i==6){ c.seuil=Integer.parseInt(txt);i++;}

		}
	}
	
	
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
			Cube c=new Cube();
			Create_bench(25);
			
			for(int k=0;k<10;k++)
			{
		
			Read_bench(c, "F:/Benchmarks cube/bench_cube"+k+".txt");
		//	c.Affiche();

			LinkedList<Cube> Q = new LinkedList<Cube>();
			Stack<Cube> P = new Stack<Cube>();
			Aveugle a = new Aveugle(c);
			a.Largeur();
			System.out.println("ok");
			//a.Profondeur();
			//Astar b=new Astar(c);
			//b.Search1();
			//b.Search2();
			 
			  
			
	}
	}
}




