
package de.csbdresden.csbdeep.network;

import de.csbdresden.csbdeep.network.model.tensorflow.TensorFlowNetwork;
import net.imagej.Dataset;
import net.imglib2.type.numeric.RealType;
import org.tensorflow.framework.TensorInfo;

public abstract class TestNetwork<T extends RealType<T>> extends
		TensorFlowNetwork<T>
{

	protected long[] inputShape;
	protected long[] outputShape;
	protected int inputCount = 1;
	protected int outputCount = 1;

	public TestNetwork()
	{
		super(null);
	}

	@Override
	public void loadInputNode(final Dataset dataset) {
		super.loadInputNode( dataset);
		if (inputCount > 0) {
			inputNode.setName("input");
			inputNode.setNodeShape(inputShape);
			inputNode.initializeNodeMapping();
		}
	}

	@Override
	public void loadOutputNode(Dataset dataset) {
		super.loadOutputNode(dataset);
		if (outputCount > 0) {
			outputNode.setName("output");
			outputNode.setNodeShape(outputShape);
			outputNode.initializeNodeMapping();
		}
	}

	@Override
	protected void logTensorShape(String title, final TensorInfo tensorInfo) {
		log("cannot log tensorinfo shape of test networks");
	}

}
