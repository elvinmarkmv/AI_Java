public class ANN
{
	Layer[] layers;
	int NUM_LAYERS;
	int[] layers_info;

	public ANN(int[] layers_info)
	{
		NUM_LAYERS = layers_info.length - 1;
		this.layers_info = layers_info;
		layers = new Layer[NUM_LAYERS];
		for(int i = 0;i<NUM_LAYERS;i++)
			layers[i] = new Layer(layers_info[i],layers_info[i+1]);
	}

	public void print()
	{
		for(int i = 0;i<NUM_LAYERS;i++)
			layers[i].print();
	}

	public Matrix getOutput(Matrix input)
	{
		Matrix output;
		output = layers[0].getOutput(input);
		for(int i = 1;i<NUM_LAYERS;i++)
			output = layers[i].getOutput(output);
		return output;
	}

	public void trainOnce(Matrix inputDataSet,Matrix targetDataSet,double alpha,double tol)
	{
		Matrix[] l = new Matrix[NUM_LAYERS];
		Matrix[] l_delta = new Matrix[NUM_LAYERS];

		l[0] = layers[0].getOutput(inputDataSet);
		for(int i = 1;i<NUM_LAYERS;i++)
			l[i] = layers[i].getOutput(l[0]);

		l_delta[NUM_LAYERS-1] = targetDataSet.sub(l[NUM_LAYERS - 1]).prod(l[NUM_LAYERS - 1]).prod(Matrix.sub(1,l[NUM_LAYERS - 1]));
		for(int i = NUM_LAYERS-2;i>=0;i--)
			l_delta[i] = layers[i+1].W.T().dot(l_delta[i+1]).prod(l[i]).prod(Matrix.sub(1,l[i]));

		layers[0].W = layers[0].W.add(l_delta[0].dot(inputDataSet.T()));
		for(int i = 1;i<NUM_LAYERS;i++)
			layers[i].W = layers[i].W.add(l_delta[i].dot(l[i-1].T()));
	}

	public void trainUntilConvergence(Matrix inputDataSet,Matrix targetDataSet,double alpha,double tol)
	{
		for(int i = 0;i<800;i++)
			trainOnce(inputDataSet,targetDataSet,alpha,tol);
	}
}