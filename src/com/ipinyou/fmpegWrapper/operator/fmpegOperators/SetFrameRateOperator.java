package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SetFrameRateOperator extends FfmpegVideoOperator {

	public SetFrameRateOperator(Selector selector, int rate) {
		super("r", selector, ""+rate, SegmentType.INPUT, SegmentType.OUTPUT);
	}
	
}
