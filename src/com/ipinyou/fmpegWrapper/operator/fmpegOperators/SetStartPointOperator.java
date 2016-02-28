package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SetStartPointOperator extends FfmpegOperator {
	public SetStartPointOperator(Selector selector, int parameter) {
		super("ss", selector, ""+ parameter, SegmentType.INPUT, SegmentType.OUTPUT);
	}

}
