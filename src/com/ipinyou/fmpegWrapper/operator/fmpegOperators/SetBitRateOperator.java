package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SetBitRateOperator extends FfmpegOperator {

	public SetBitRateOperator(Selector selector, String parameter) {
		super("b", selector, parameter, SegmentType.OUTPUT);
	}

}
