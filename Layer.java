public class Layer
{
	Matrix W;
	int INPUTS;
	int OUTPUTS;

	public Layer()
	{
		INPUTS = 1;
		OUTPUTS = 1;
		W = new Matrix(1,1);
		W.random();
	}

	public Layer(int INPUTS,int OUTPUTS)
	{
		this.INPUTS = INPUTS;
		this.OUTPUTS = OUTPUTS;
		this.W = new Matrix(OUTPUTS,INPUTS);
		this.W.random();
	}

	public void print()
	{
		this.W.print();
		System.out.println("INPUTS: " + INPUTS + "\t" + "OUTPUTS: " + OUTPUTS);
		System.out.println("");
	}

	public Matrix getOutput(Matrix input)
	{
		return sigmoid(this.W.dot(input));
	}

	public double sigmoid(double x)
	{
		return 1.0/(1  + Math.exp(-x));
	}

	public Matrix sigmoid(Matrix M)
	{
		Matrix out = new Matrix(M.ROWS,M.COLS);
		for(int i = 0;i<M.ROWS;i++)
			for(int j = 0;j<M.COLS;j++)
				out.data[i][j] = sigmoid(M.data[i][j]);
		return out;
	}
}