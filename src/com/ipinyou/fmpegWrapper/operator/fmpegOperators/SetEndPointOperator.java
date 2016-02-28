package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SetEndPointOperator extends FfmpegOperator {

	public SetEndPointOperator(Selector selector, int endTime) {
		super("t", selector, "" + endTime, SegmentType.INPUT, SegmentType.OUTPUT);
	}

}
