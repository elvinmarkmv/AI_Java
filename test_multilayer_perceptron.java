import java.awt.image.*;
import java.io.*;	
import javax.imageio.*;

public class test
{

	public static void main(String args[])
	{
		int[] li ={3,4,1};
		Matrix in = new Matrix("1;1;1",3,1);
		ANN ann = new ANN(li);
		ann.print();
		ann.getOutput(in).print();
		Matrix in_ds = new Matrix("1,1,1;1,0,1;0,1,1;0,0,1",4,3);
		Matrix o_ds = new Matrix("1,0.5,0,1",1,4);
		ann.trainUntilConvergence(in_ds.T(),o_ds,1,0.01);
		ann.getOutput(in_ds.T()).print();
	}
}