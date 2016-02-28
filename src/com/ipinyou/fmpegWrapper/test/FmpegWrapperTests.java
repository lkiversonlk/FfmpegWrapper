package com.ipinyou.fmpegWrapper.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import com.ipinyou.fmpegWrapper.FfmpegCommand;
import com.ipinyou.fmpegWrapper.FfmpegResult;
import com.ipinyou.fmpegWrapper.helper.OneToOneCommandBuilder;
import com.ipinyou.fmpegWrapper.operator.FfmpegWrapperException;
import com.ipinyou.fmpegWrapper.operator.SegmentType;
import com.ipinyou.fmpegWrapper.operator.Selector;
import com.ipinyou.fmpegWrapper.operator.SingleFileHandler;
import com.ipinyou.fmpegWrapper.operator.fmpegOperators.*;

public class FmpegWrapperTests {
	
	@Test
	public void BuildCommandTest() throws FfmpegWrapperException, IOException, InterruptedException{
		FfmpegCommand command = new FfmpegCommand("/usr/local/bin/ffmpeg");
		
		//input
		SingleFileHandler inputFileHandler = new SingleFileHandler(SegmentType.INPUT, "/Users/jerry/Downloads/hangzong.flv");
		//inputFileHandler.addOperator(new SetStartPointOperator(Selector.NoneSelector, 2));
		
		//output
		SingleFileHandler outputFileHandler = new SingleFileHandler(SegmentType.OUTPUT, "/Users/jerry/Downloads/testhuang1.flv");
		
		command.addInputFileHandler(inputFileHandler);
		command.addOutputFileHandler(outputFileHandler);
		command.addOutputFileOperator(new SetOutputTimeDurationOperator(Selector.NoneSelector, 300));
		command.addOutputFileOperator(new SetFrameRateOperator(Selector.AllVideoSelector, 1));
		command.addOutputFileOperator(new ScaleVideoOperator(Selector.AllVideoSelector, 300, 300));
		command.setSilentMode();
		System.out.println(command.toCommand());
		FfmpegResult result = command.execute();
		System.out.println(result.RetCode);
		System.out.println(result.stdout);
		System.out.println(result.stderr);
	}
	
	@Test
	public void CommandBuilderTest() throws IOException, InterruptedException{
		OneToOneCommandBuilder builder = new OneToOneCommandBuilder("/usr/local/bin/ffmpeg");
		
		builder.setInputFilePath("/Users/jerry/Downloads/hangzong.flv");
		builder.setOutputFilePath("/Users/jerry/Downloads/hangzongTest.flv");
		
		builder.cutAudio(0, 300);
		builder.cutVideo(300, 600);
		
		//builder.SetOutputVideoCodech264();
		builder.setWidthHeight(400, 400);
		builder.setAspect(1, 1);
		builder.setSilentMode();
		System.out.println(builder.generateCommand());
		FfmpegResult result = builder.execute();
		System.out.println(result.RetCode);
	}
	
	@Test
	public void AspectTest() throws IOException, InterruptedException{
		OneToOneCommandBuilder builder = new OneToOneCommandBuilder("/usr/local/bin/ffmpeg");
		builder.setInputFilePath("/Users/jerry/Downloads/hangzong.flv");
		builder.setOutputFilePath("/Users/jerry/Downloads/hangzongAspectTest.flv");
		builder.setSilentMode();
		
		builder.cutAudio(20, 100);
		builder.cutVideo(100, 200);
		builder.setWidthHeight(1024, 768);
		builder.setAspect(1, 1);
		
		FfmpegResult result = builder.execute();
		System.out.println(builder.generateCommand());
		System.out.println(result.RetCode);
	}
	
	@Test
	public void Codecx264Test() throws IOException, InterruptedException{
		OneToOneCommandBuilder builder = new OneToOneCommandBuilder("/usr/local/bin/ffmpeg");
		builder.setInputFilePath("/Users/jerry/Downloads/hangzong.flv");
		builder.setOutputFilePath("/Users/jerry/Downloads/hangzongCodecTest.flv");
		
		//builder.SetSilentMode();
		builder.setOutputVideoCodech264();
		
		FfmpegResult result = builder.execute();
		System.out.println(builder.generateCommand());
		System.out.println(builder.execute().RetCode);
	}
	
	@Test
	public void CompressUsingBitRateTest() throws IOException, InterruptedException{
		OneToOneCommandBuilder builder = new OneToOneCommandBuilder("/usr/local/bin/ffmpeg");
		builder.setInputFilePath("/Users/jerry/Downloads/hangzong.flv");
		builder.setOutputFilePath("/Users/jerry/Downloads/hangzongCompress3.flv");
		
		builder.setVideoBitRate("2k");
		
		System.out.println(builder.generateCommand());
		FfmpegResult result = builder.execute();
		System.out.println(result.RetCode);
		
	}
}
