package com.ipinyou.fmpegWrapper.operator.fmpegOperators;

import com.ipinyou.fmpegWrapper.operator.FfmpegOperator;
import com.ipinyou.fmpegWrapper.operator.FfmpegWrapperException;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;

public class FfmpegAudioOperator extends FfmpegOperator {

	public FfmpegAudioOperator(String flag, Selector selector, String parameter, SegmentType[] forSegs) {
		super(flag, selector, parameter, forSegs);
		if(selector.getType() != Selector.AudioVideo.AUDIO){
			throw new FfmpegWrapperException("AudioOperator should only have audio selector");
		}
	}

}
