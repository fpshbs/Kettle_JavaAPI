package com.scheduler.trans;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class TransExecutor {
	
	public void runTrans(String fileName){
		
	    try {
			KettleEnvironment.init();
			
		    TransMeta transMeta = new TransMeta(fileName);
		    Trans trans = new Trans(transMeta);
		    trans.prepareExecution(null);
		    
		    trans.startThreads();
		    
		    trans.waitUntilFinished();
		    
		    if (trans.getErrors()!=0) {
		      System.out.println("Error");
		    }else {
		    	System.out.println("-------it has been done !----");
		    }
		    
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String []args){
		String fileName = "_hello.ktr"; 
		new TransExecutor().runTrans(fileName);
	}

}
