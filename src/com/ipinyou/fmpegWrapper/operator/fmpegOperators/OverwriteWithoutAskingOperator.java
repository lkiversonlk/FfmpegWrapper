package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class OverwriteWithoutAskingOperator extends FfmpegOperator {

	public OverwriteWithoutAskingOperator() {
		super("y", Selector.NoneSelector, null, SegmentType.GLOBAL);
	}

}
