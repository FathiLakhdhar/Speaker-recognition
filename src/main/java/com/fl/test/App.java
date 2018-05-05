package com.fl.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.bitsinharmony.recognito.MatchResult;
import com.bitsinharmony.recognito.Recognito;
import com.bitsinharmony.recognito.VoicePrint;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)
			throws UnsupportedAudioFileException, IOException {

		File Obama0 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "Barack_Obama0.wav");
		File Obama1 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "Barack_Obama1.wav");
		File Obama2 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "Barack_Obama2.wav");
		
		
		File Jimmy0 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "jimmy-carter0.wav");
		File Jimmy1 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "jimmy-carter1.wav");
		File Jimmy2 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "jimmy-carter2.wav");
		
		File Ronald0 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "Ronald_Reagan0.wav");
		File Ronald1 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "Ronald_Reagan1.wav");
		
		
		File William0 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "William_J_Clinton0.wav");
		File William1 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "William_J_Clinton1.wav");
		File William2 = new File(System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "William_J_Clinton2.wav");
		

		AudioInputStream sample = AudioSystem.getAudioInputStream(Obama0);
		AudioFormat format = sample.getFormat();
		
		
		//System.out.println("voice Obama : " + ObamaPrintVoice);
		//System.out.println("voice Jimmy : " + JimmyPrintVoice);

		
		Recognito<String> recognito = new Recognito<>(format.getSampleRate());

		VoicePrint ObamaPrintVoice = recognito.createVoicePrint("Barack Obama", Obama0);
		ObamaPrintVoice = recognito.mergeVoiceSample("Barack Obama", Obama1);
		VoicePrint JimmyPrintVoice = recognito.createVoicePrint("Jimmy Carter", Jimmy0);
		JimmyPrintVoice = recognito.mergeVoiceSample("Jimmy Carter", Jimmy1);
		VoicePrint RonaldPrintVoice = recognito.createVoicePrint("Ronald Reagan", Ronald0);
		RonaldPrintVoice = recognito.mergeVoiceSample("Ronald Reagan", Ronald1);

		VoicePrint WilliamPrintVoice = recognito.createVoicePrint("William Clinton", William0);

		// handle persistence the way you want, e.g.:
		// myUser.setVocalPrint(print);
		// userDao.saveOrUpdate(myUser);

		// Now check if the King is back
		List<MatchResult<String>> matches;
		matches = recognito.identify(William1);
		
		for(MatchResult<String> match : matches){
			System.out.println(match.getKey()+" !!! "+ match.getLikelihoodRatio() + "% positive about it...");			
		}
		
	

	}
}
