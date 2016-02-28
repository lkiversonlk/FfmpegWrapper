package com.ipinyou.fmpegWrapper.operator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jerry
 *
 */
public class MultipleFilesHandler extends CommandSegment {

	private List<CommandSegment> fileHandlers = new ArrayList<CommandSegment>();
	
	public MultipleFilesHandler(SegmentType segmentType) {
		this.segmentType = segmentType;
	}
	
	
	@Override
	public String toCommand() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.composeOperator());
		
		sb.append(" ");
		
		for(CommandSegment fileHandler : this.fileHandlers){
			sb.append(fileHandler.toCommand());
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	public void addFileHandler(CommandSegment fileHandler) throws FfmpegWrapperException{
		if(fileHandler.getInputOutput() != this.segmentType){
			throw new FfmpegWrapperException("MultipleFilesHandler accepts only input or only output handlers");
		}
		this.fileHandlers.add(fileHandler);
	}


	public List<CommandSegment> getFileHandlers() {
		return fileHandlers;
	}
}
