package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class SetAspectOperator extends FfmpegOperator {

	public SetAspectOperator(Selector selector, int w, int h) {
		super("aspect", selector, w+":"+h, SegmentType.OUTPUT);
	}

}
