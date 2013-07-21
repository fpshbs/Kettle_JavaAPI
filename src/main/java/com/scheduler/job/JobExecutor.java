package com.scheduler.job;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;

public class JobExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String filename = args[0];
		String fileName = "_hello.kjb";
		
		try {
			KettleEnvironment.init();
			
			JobMeta jobMeta = new JobMeta(fileName, null);
			Job job = new Job(null, jobMeta);
			job.start();
			job.waitUntilFinished();
			if (job.getErrors()!=0) {
				System.err.println("Error encountered!");
			}
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
