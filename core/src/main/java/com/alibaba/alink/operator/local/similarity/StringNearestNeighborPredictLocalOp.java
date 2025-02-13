package com.alibaba.alink.operator.local.similarity;

import org.apache.flink.ml.api.misc.param.Params;

import com.alibaba.alink.common.annotation.InputPorts;
import com.alibaba.alink.common.annotation.NameCn;
import com.alibaba.alink.common.annotation.ParamSelectColumnSpec;
import com.alibaba.alink.common.annotation.PortDesc;
import com.alibaba.alink.common.annotation.PortSpec;
import com.alibaba.alink.common.annotation.PortType;
import com.alibaba.alink.common.annotation.TypeCollections;
import com.alibaba.alink.operator.batch.similarity.StringNearestNeighborTrainBatchOp;
import com.alibaba.alink.operator.common.similarity.NearestNeighborsMapper;
import com.alibaba.alink.operator.local.utils.ModelMapLocalOp;
import com.alibaba.alink.params.similarity.NearestNeighborPredictParams;

/**
 * Find the nearest neighbor of query string.
 */
@InputPorts(values = {
	@PortSpec(value = PortType.MODEL, desc = PortDesc.PREDICT_INPUT_MODEL,
		suggestions = StringNearestNeighborTrainBatchOp.class),
	@PortSpec(value = PortType.DATA, desc = PortDesc.PREDICT_INPUT_DATA)
})
@ParamSelectColumnSpec(name = "selectedCol", allowedTypeCollections = TypeCollections.STRING_TYPES)
@NameCn("字符串最近邻预测")
public class StringNearestNeighborPredictLocalOp extends ModelMapLocalOp <StringNearestNeighborPredictLocalOp>
	implements NearestNeighborPredictParams <StringNearestNeighborPredictLocalOp> {

	public StringNearestNeighborPredictLocalOp() {
		this(new Params());
	}

	public StringNearestNeighborPredictLocalOp(Params params) {
		super(NearestNeighborsMapper::new, params);
	}
}
