package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SetOutputTimeDurationOperator extends FfmpegOperator {
	public SetOutputTimeDurationOperator(Selector selector, int length) {
		super("to", selector, ""+length, SegmentType.OUTPUT);
	}
}
