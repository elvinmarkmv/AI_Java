import java.util.*;

public class Matrix
{
	double[][] data;
	int ROWS;
	int COLS;

	public Matrix()
	{
		ROWS = 0;
		COLS = 0;
		data = new double[1][1];
	}

	public Matrix(int DIM)
	{
		ROWS = DIM;
		COLS = DIM;
		data = new double[DIM][DIM];
	}

	public Matrix(int ROWS,int COLS)
	{
		this.ROWS = ROWS;
		this.COLS = COLS;
		data = new double[ROWS][COLS];
	}

	public Matrix(String data,int ROWS,int COLS)
	{
		this.ROWS = ROWS;
		this.COLS = COLS;
		this.data = new double[ROWS][COLS];
		StringTokenizer st;
		StringTokenizer st1;
		st = new StringTokenizer(data,";");
		int i,j;
		i = 0;
		while(st.hasMoreTokens())
		{
			st1 = new StringTokenizer(st.nextToken(),",");
			j = 0;
			while(st1.hasMoreTokens())
			{
				this.data[i][j] = Double.parseDouble(st1.nextToken());
				j++;
			}
			i++;
		}
	}

	public void print()
	{
		for(int i = 0;i<this.ROWS;i++)
		{
			for(int j = 0;j<this.COLS;j++)
				System.out.print(this.data[i][j] + " ");
			System.out.println("");
		}
		System.out.println("");
	}

	public void random()
	{
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				this.data[i][j] = Math.random();
	}

	public void zeros()
	{
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				this.data[i][j] = 0;
	}

	public void ones()
	{
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				this.data[i][j] = 1.;
	}

	public void eye()
	{
		for(int i = 0;i<this.ROWS;i++)
		{
			for(int j = 0;j<this.COLS;j++)
			{
				if(i==j)
					this.data[i][i] = 1.0;
				else
					this.data[i][j] = 0.0;
			}
		}
	}

	public Matrix add(Matrix M)
	{
		Matrix out = new Matrix(this.ROWS,this.COLS);
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				out.data[i][j] = this.data[i][j] + M.data[i][j];
		return out;
	}

	public Matrix add(double num)
	{
		Matrix out = new Matrix(this.ROWS,this.COLS);
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				out.data[i][j] = this.data[i][j] + num;
		return out;	
	}

	public Matrix sub(Matrix M)
	{
		Matrix out = new Matrix(this.ROWS,this.COLS);
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				out.data[i][j] = this.data[i][j] - M.data[i][j];
		return out;
	}

	public Matrix sub(double num)
	{
		Matrix out = new Matrix(this.ROWS,this.COLS);
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				out.data[i][j] = this.data[i][j] - num;
		return out;	
	}

	public Matrix dot(Matrix M)
	{
		Matrix out = new Matrix(this.ROWS, M.COLS);
		double s;
		for(int i = 0;i<this.ROWS;i++)
		{
			for(int j = 0;j<M.COLS;j++)
			{
				s = 0;
				for(int k = 0;k<this.COLS;k++)
					s = s + this.data[i][k]*M.data[k][j];
				out.data[i][j] = s;
			}
		}
		return out;
	}

	public Matrix prod(double num)
	{
		Matrix out = new Matrix(this.ROWS,this.COLS);
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				out.data[i][j] = this.data[i][j]*num;
		return out;	
	}

	public Matrix prod(Matrix M)
	{
		Matrix out = new Matrix(this.ROWS,this.COLS);
		for(int i = 0;i<this.ROWS;i++)
			for(int j = 0;j<this.COLS;j++)
				out.data[i][j] = this.data[i][j]*M.data[i][j];
		return out;	
	}

	public Matrix T()
	{
		Matrix out = new Matrix(this.COLS,this.ROWS);
		for(int i = 0;i<this.COLS;i++)
			for(int j = 0;j<this.ROWS;j++)
				out.data[i][j] = this.data[j][i];
		return out;	
	}	

	public static Matrix add(Matrix A,Matrix B)
	{
		Matrix out = new Matrix(A.ROWS,A.COLS);
		for(int i = 0;i<A.ROWS;i++)
			for(int j = 0;j<A.COLS;j++)
				out.data[i][j] = A.data[i][j] + B.data[i][j];
		return out;		
	}

	public static Matrix add(Matrix A,double num)
	{
		Matrix out = new Matrix(A.ROWS,A.COLS);
		for(int i = 0;i<A.ROWS;i++)
			for(int j = 0;j<A.COLS;j++)
				out.data[i][j] = A.data[i][j] + num;
		return out;		
	}


	public static Matrix sub(Matrix A,Matrix B)
	{
		Matrix out = new Matrix(A.ROWS,A.COLS);
		for(int i = 0;i<A.ROWS;i++)
			for(int j = 0;j<A.COLS;j++)
				out.data[i][j] = A.data[i][j] - B.data[i][j];
		return out;		
	}

	public static Matrix sub(Matrix A, double num)
	{
		Matrix out = new Matrix(A.ROWS,A.COLS);
		for(int i = 0;i<A.ROWS;i++)
			for(int j = 0;j<A.COLS;j++)
				out.data[i][j] = A.data[i][j] - num;
		return out;
	}

	public static Matrix sub(double num, Matrix A)
	{
		Matrix out = new Matrix(A.ROWS,A.COLS);
		for(int i = 0;i<A.ROWS;i++)
			for(int j = 0;j<A.COLS;j++)
				out.data[i][j] =  num - A.data[i][j];
		return out;
	}
}