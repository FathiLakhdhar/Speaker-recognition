package com.fl.weka;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


public class Prediction {
	String data = "/home/likewise-open/ACADEMIC/csstnns/Desktop/weather.nominal.arff";
	DataSource source = null;
			
	
	public void go() throws Exception{
		//load dataset
		source= new DataSource(data);
		//get instances object 
		Instances trainingData = source.getDataSet();
		//set class index .. as the last attribute
		if (trainingData.classIndex() == -1) {
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
		}
	}
}
