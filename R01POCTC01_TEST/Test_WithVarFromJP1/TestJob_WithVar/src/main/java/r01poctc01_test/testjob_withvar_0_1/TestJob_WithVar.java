
package r01poctc01_test.testjob_withvar_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.MDM;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: TestJob_WithVar Purpose: Used for on-boarding presentation<br>
 * Description: A simple row generation job <br>
 * @author suzuki, toshihiro
 * @version 8.0.1.20240524_0800-patch
 * @status DEV
 */
public class TestJob_WithVar implements TalendJob {
	static {System.setProperty("TalendJob.log", "TestJob_WithVar.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(TestJob_WithVar.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	

	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
		

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(zipcode != null){
				
					this.setProperty("zipcode", zipcode.toString());
				
			}
			
			if(compcode != null){
				
					this.setProperty("compcode", compcode.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String zipcode;
public String getZipcode(){
	return this.zipcode;
}
public String compcode;
public String getCompcode(){
	return this.compcode;
}
	}
			
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}

	protected java.util.Map<String, String> defaultProperties = new java.util.HashMap<String, String>();
	protected java.util.Map<String, String> additionalProperties = new java.util.HashMap<String, String>();

	public java.util.Map<String, String> getDefaultProperties() {
	    return this.defaultProperties;
	}

	public java.util.Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

	private final String jobVersion = "0.1";
	private final String jobName = "TestJob_WithVar";
	private final String projectName = "R01POCTC01_TEST";
	public Integer errorCode = null;
	private String currentComponent = "";
	public static boolean isStandaloneMS = Boolean.valueOf("false");
	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_crVFcNJKEe-Pn5qOoIUlKQ", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	
	private String currentComponent = null;
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				TestJob_WithVar.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(TestJob_WithVar.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
			talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
			talendJobLogProcess(globalMap);
		}
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tFileInputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSetGlobalVar_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tHttpRequest_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	



public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_R01POCTC01_TEST_TestJob_WithVar = new byte[0];
    static byte[] commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[0];

	
			    public String zipcode;

				public String getZipcode () {
					return this.zipcode;
				}

				public Boolean zipcodeIsNullable(){
				    return true;
				}
				public Boolean zipcodeIsKey(){
				    return false;
				}
				public Integer zipcodeLength(){
				    return null;
				}
				public Integer zipcodePrecision(){
				    return null;
				}
				public String zipcodeDefault(){
				
					return null;
				
				}
				public String zipcodeComment(){
				
				    return "";
				
				}
				public String zipcodePattern(){
				
					return "";
				
				}
				public String zipcodeOriginalDbColumnName(){
				
					return "zipcode";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length) {
				if(length < 1024 && commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length == 0) {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[1024];
				} else {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length);
			strReturn = new String(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length) {
				if(length < 1024 && commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length == 0) {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[1024];
				} else {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length);
			strReturn = new String(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_R01POCTC01_TEST_TestJob_WithVar) {

        	try {

        		int length = 0;
		
					this.zipcode = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_R01POCTC01_TEST_TestJob_WithVar) {

        	try {

        		int length = 0;
		
					this.zipcode = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.zipcode,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.zipcode,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("zipcode="+zipcode);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(zipcode == null){
        					sb.append("<null>");
        				}else{
            				sb.append(zipcode);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_R01POCTC01_TEST_TestJob_WithVar = new byte[0];
    static byte[] commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[0];

	
			    public String zipcode;

				public String getZipcode () {
					return this.zipcode;
				}

				public Boolean zipcodeIsNullable(){
				    return true;
				}
				public Boolean zipcodeIsKey(){
				    return false;
				}
				public Integer zipcodeLength(){
				    return null;
				}
				public Integer zipcodePrecision(){
				    return null;
				}
				public String zipcodeDefault(){
				
					return null;
				
				}
				public String zipcodeComment(){
				
				    return "";
				
				}
				public String zipcodePattern(){
				
					return "";
				
				}
				public String zipcodeOriginalDbColumnName(){
				
					return "zipcode";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length) {
				if(length < 1024 && commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length == 0) {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[1024];
				} else {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length);
			strReturn = new String(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length) {
				if(length < 1024 && commonByteArray_R01POCTC01_TEST_TestJob_WithVar.length == 0) {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[1024];
				} else {
   					commonByteArray_R01POCTC01_TEST_TestJob_WithVar = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length);
			strReturn = new String(commonByteArray_R01POCTC01_TEST_TestJob_WithVar, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_R01POCTC01_TEST_TestJob_WithVar) {

        	try {

        		int length = 0;
		
					this.zipcode = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_R01POCTC01_TEST_TestJob_WithVar) {

        	try {

        		int length = 0;
		
					this.zipcode = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.zipcode,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.zipcode,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("zipcode="+zipcode);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(zipcode == null){
        					sb.append("<null>");
        				}else{
            				sb.append(zipcode);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tFileInputDelimited_1");
		org.slf4j.MDC.put("_subJobPid", "OBTa20_" + subJobPidCounter.getAndIncrement());

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
row1Struct row2 = row1;





	
	/**
	 * [tHttpRequest_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tHttpRequest_1", false);
		start_Hash.put("tHttpRequest_1", System.currentTimeMillis());
		
	
	currentComponent="tHttpRequest_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tHttpRequest_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tHttpRequest_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tHttpRequest_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tHttpRequest_1 = new StringBuilder();
                    log4jParamters_tHttpRequest_1.append("Parameters:");
                            log4jParamters_tHttpRequest_1.append("URI" + " = " + "\"https://zipcloud.ibsnet.co.jp/api/search?zipcode=\"+((String)globalMap.get(\"csvZipcode\"))");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("METHOD_CHOSED" + " = " + "GET");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("OUT_TO_FILE" + " = " + "true");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("OUT_FILE_NAME" + " = " + "\"C:/Users/R01POCTC01ADMIN2/Desktop/work/after/In/R01_\"+context.compcode+\"_MMF0100_\"+TalendDate.getDate(\"CCYYMMDDhhmmss\")+\".csv\"");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("CREATE_DIRS" + " = " + "false");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("HEADERS" + " = " + "[]");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("NEED_AUTHENTICATION" + " = " + "false");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("DIE_ON_ERROR" + " = " + "true");
                        log4jParamters_tHttpRequest_1.append(" | ");
                            log4jParamters_tHttpRequest_1.append("TIMEOUT_SETTING" + " = " + "false");
                        log4jParamters_tHttpRequest_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tHttpRequest_1 - "  + (log4jParamters_tHttpRequest_1) );
                    } 
                } 
            new BytesLimit65535_tHttpRequest_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tHttpRequest_1", "tHttpRequest_1", "tHttpRequest");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tHttpRequest_1 begin ] stop
 */



	
	/**
	 * [tSetGlobalVar_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tSetGlobalVar_1", false);
		start_Hash.put("tSetGlobalVar_1", System.currentTimeMillis());
		
	
	currentComponent="tSetGlobalVar_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1");
			
		int tos_count_tSetGlobalVar_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tSetGlobalVar_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tSetGlobalVar_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tSetGlobalVar_1 = new StringBuilder();
                    log4jParamters_tSetGlobalVar_1.append("Parameters:");
                            log4jParamters_tSetGlobalVar_1.append("VARIABLES" + " = " + "[{VALUE="+("row1.zipcode")+", KEY="+("\"csvZipcode\"")+"}]");
                        log4jParamters_tSetGlobalVar_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tSetGlobalVar_1 - "  + (log4jParamters_tSetGlobalVar_1) );
                    } 
                } 
            new BytesLimit65535_tSetGlobalVar_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tSetGlobalVar_1", "tSetGlobalVar_1", "tSetGlobalVar");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tSetGlobalVar_1 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_1", false);
		start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_1";
	
	
		int tos_count_tFileInputDelimited_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileInputDelimited_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFileInputDelimited_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFileInputDelimited_1 = new StringBuilder();
                    log4jParamters_tFileInputDelimited_1.append("Parameters:");
                            log4jParamters_tFileInputDelimited_1.append("USE_EXISTING_DYNAMIC" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("FILENAME" + " = " + "\"C:/Users/R01POCTC01ADMIN2/Desktop/work/before/In/R01_1000_MMF0100_20250114143000.csv\"");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("CSV_OPTION" + " = " + "true");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("CSVROWSEPARATOR" + " = " + "\"\\n\"");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("FIELDSEPARATOR" + " = " + "\",\"");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("ESCAPE_CHAR" + " = " + "\"\"\"");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("TEXT_ENCLOSURE" + " = " + "\"\"\"");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("HEADER" + " = " + "0");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("FOOTER" + " = " + "0");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("LIMIT" + " = " + "");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("REMOVE_EMPTY_ROW" + " = " + "true");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("UNCOMPRESS" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("DIE_ON_ERROR" + " = " + "true");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("TRIMALL" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("TRIMSELECT" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("zipcode")+"}]");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("CHECK_FIELDS_NUM" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("CHECK_DATE" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("ENABLE_DECODE" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                            log4jParamters_tFileInputDelimited_1.append("USE_HEADER_AS_IS" + " = " + "false");
                        log4jParamters_tFileInputDelimited_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileInputDelimited_1 - "  + (log4jParamters_tFileInputDelimited_1) );
                    } 
                } 
            new BytesLimit65535_tFileInputDelimited_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tFileInputDelimited_1", "tFileInputDelimited_1", "tFileInputDelimited");
				talendJobLogProcess(globalMap);
			}
			
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_1 = 0;
				int footer_tFileInputDelimited_1 = 0;
				int totalLinetFileInputDelimited_1 = 0;
				int limittFileInputDelimited_1 = -1;
				int lastLinetFileInputDelimited_1 = -1;	
				
				char fieldSeparator_tFileInputDelimited_1[] = null;
				
				//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get("fs")'. 
				if ( ((String)",").length() > 0 ){
					fieldSeparator_tFileInputDelimited_1 = ((String)",").toCharArray();
				}else {			
					throw new IllegalArgumentException("Field Separator must be assigned a char."); 
				}
			
				char rowSeparator_tFileInputDelimited_1[] = null;
			
				//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get("rs")'. 
				if ( ((String)"\n").length() > 0 ){
					rowSeparator_tFileInputDelimited_1 = ((String)"\n").toCharArray();
				}else {
					throw new IllegalArgumentException("Row Separator must be assigned a char."); 
				}
			
				Object filename_tFileInputDelimited_1 = /** Start field tFileInputDelimited_1:FILENAME */"C:/Users/R01POCTC01ADMIN2/Desktop/work/before/In/R01_1000_MMF0100_20250114143000.csv"/** End field tFileInputDelimited_1:FILENAME */;		
				com.talend.csv.CSVReader csvReadertFileInputDelimited_1 = null;
	
				try{
					
						String[] rowtFileInputDelimited_1=null;
						int currentLinetFileInputDelimited_1 = 0;
	        			int outputLinetFileInputDelimited_1 = 0;
						try {//TD110 begin
							if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0;
			if(footer_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer shouldn't be bigger than 0.");
			}
		
								csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader((java.io.InputStream)filename_tFileInputDelimited_1, fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
							}else{
								csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader(String.valueOf(filename_tFileInputDelimited_1),fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
		        			}
					
					
					csvReadertFileInputDelimited_1.setTrimWhitespace(false);
					if ( (rowSeparator_tFileInputDelimited_1[0] != '\n') && (rowSeparator_tFileInputDelimited_1[0] != '\r') )
	        			csvReadertFileInputDelimited_1.setLineEnd(""+rowSeparator_tFileInputDelimited_1[0]);
						
	        				csvReadertFileInputDelimited_1.setQuoteChar('"');
						
	            				csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());
							      
		
			
						if(footer_tFileInputDelimited_1 > 0){
						for(totalLinetFileInputDelimited_1=0;totalLinetFileInputDelimited_1 < 0; totalLinetFileInputDelimited_1++){
							csvReadertFileInputDelimited_1.readNext();
						}
						csvReadertFileInputDelimited_1.setSkipEmptyRecords(true);
			            while (csvReadertFileInputDelimited_1.readNext()) {
							
								rowtFileInputDelimited_1=csvReadertFileInputDelimited_1.getValues();
								if(!(rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0]))){//empty line when row separator is '\n'
							
	                
	                		totalLinetFileInputDelimited_1++;
	                
							
								}
							
	                
			            }
	            		int lastLineTemptFileInputDelimited_1 = totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1   < 0? 0 : totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1 ;
	            		if(lastLinetFileInputDelimited_1 > 0){
	                		lastLinetFileInputDelimited_1 = lastLinetFileInputDelimited_1 < lastLineTemptFileInputDelimited_1 ? lastLinetFileInputDelimited_1 : lastLineTemptFileInputDelimited_1; 
	            		}else {
	                		lastLinetFileInputDelimited_1 = lastLineTemptFileInputDelimited_1;
	            		}
	         
			          	csvReadertFileInputDelimited_1.close();
				        if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
				 			csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader((java.io.InputStream)filename_tFileInputDelimited_1, fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
		        		}else{
							csvReadertFileInputDelimited_1=new com.talend.csv.CSVReader(String.valueOf(filename_tFileInputDelimited_1),fieldSeparator_tFileInputDelimited_1[0], "ISO-8859-15");
						}
						csvReadertFileInputDelimited_1.setTrimWhitespace(false);
						if ( (rowSeparator_tFileInputDelimited_1[0] != '\n') && (rowSeparator_tFileInputDelimited_1[0] != '\r') )	
	        				csvReadertFileInputDelimited_1.setLineEnd(""+rowSeparator_tFileInputDelimited_1[0]);
						
							csvReadertFileInputDelimited_1.setQuoteChar('"');
						
	        				csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());
							  
	        		}
	        
			        if(limittFileInputDelimited_1 != 0){
			        	for(currentLinetFileInputDelimited_1=0;currentLinetFileInputDelimited_1 < 0;currentLinetFileInputDelimited_1++){
			        		csvReadertFileInputDelimited_1.readNext();
			        	}
			        }
			        csvReadertFileInputDelimited_1.setSkipEmptyRecords(true);
	        
	    		} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
					
						throw e;
					
	    		}//TD110 end
	        
			    
			    	log.info("tFileInputDelimited_1 - Retrieving records from the datasource.");
			    
	        	while ( limittFileInputDelimited_1 != 0 && csvReadertFileInputDelimited_1!=null && csvReadertFileInputDelimited_1.readNext() ) { 
	        		rowstate_tFileInputDelimited_1.reset();
	        
		        	rowtFileInputDelimited_1=csvReadertFileInputDelimited_1.getValues();
		        	
					
	        			if(rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])){//empty line when row separator is '\n'
	        				continue;
	        			}
					
	        	
	        	
	        		currentLinetFileInputDelimited_1++;
	            
		            if(lastLinetFileInputDelimited_1 > -1 && currentLinetFileInputDelimited_1 > lastLinetFileInputDelimited_1) {
		                break;
	    	        }
	        	    outputLinetFileInputDelimited_1++;
	            	if (limittFileInputDelimited_1 > 0 && outputLinetFileInputDelimited_1 > limittFileInputDelimited_1) {
	                	break;
	            	}  
	                                                                      
					
	    							row1 = null;			
								
								boolean whetherReject_tFileInputDelimited_1 = false;
								row1 = new row1Struct();
								try {			
									
				char fieldSeparator_tFileInputDelimited_1_ListType[] = null;
				//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get("fs")'. 
				if ( ((String)",").length() > 0 ){
					fieldSeparator_tFileInputDelimited_1_ListType = ((String)",").toCharArray();
				}else {			
					throw new IllegalArgumentException("Field Separator must be assigned a char."); 
				}
				if(rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])){//empty line when row separator is '\n'
					
							row1.zipcode = null;
					
				}else{
					
	                int columnIndexWithD_tFileInputDelimited_1 = 0; //Column Index 
	                
						columnIndexWithD_tFileInputDelimited_1 = 0;
						
						
						
						if(columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length){
						
						
							
									row1.zipcode = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];
									
							
						
						}else{
						
							
								row1.zipcode = null;
							
						
						}
						
						
					
				}
				
									
									if(rowstate_tFileInputDelimited_1.getException()!=null) {
										throw rowstate_tFileInputDelimited_1.getException();
									}
									
									
	    						} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
							        whetherReject_tFileInputDelimited_1 = true;
        							
            							throw(e);
            						
	    						}
	
							
			log.debug("tFileInputDelimited_1 - Retrieving the record " + (nb_line_tFileInputDelimited_1+1) + ".");
		

 



/**
 * [tFileInputDelimited_1 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";
	
	

 


	tos_count_tFileInputDelimited_1++;

/**
 * [tFileInputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";
	
	

 



/**
 * [tFileInputDelimited_1 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tSetGlobalVar_1 main ] start
	 */

	

	
	
	currentComponent="tSetGlobalVar_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tFileInputDelimited_1","tFileInputDelimited_1","tFileInputDelimited","tSetGlobalVar_1","tSetGlobalVar_1","tSetGlobalVar"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

globalMap.put("csvZipcode", row1.zipcode);

 
     row2 = row1;


	tos_count_tSetGlobalVar_1++;

/**
 * [tSetGlobalVar_1 main ] stop
 */
	
	/**
	 * [tSetGlobalVar_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSetGlobalVar_1";
	
	

 



/**
 * [tSetGlobalVar_1 process_data_begin ] stop
 */

	
	/**
	 * [tHttpRequest_1 main ] start
	 */

	

	
	
	currentComponent="tHttpRequest_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tSetGlobalVar_1","tSetGlobalVar_1","tSetGlobalVar","tHttpRequest_1","tHttpRequest_1","tHttpRequest"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		


int connectTimeOut_tHttpRequest_1 = Integer.valueOf(30)*1000;
int readTimeOut_tHttpRequest_1 = Integer.valueOf(0)*1000;

java.net.URL url_tHttpRequest_1 = new java.net.URL("https://zipcloud.ibsnet.co.jp/api/search?zipcode="+((String)globalMap.get("csvZipcode")));

        log.info("tHttpRequest_1 - Connection attempt to '" + "https://zipcloud.ibsnet.co.jp/api/search?zipcode="+((String)globalMap.get("csvZipcode")));
java.net.HttpURLConnection urlConn_tHttpRequest_1 = null;

if ("local".equals(System.getProperty("http.proxySet"))) {
    java.net.Proxy proxyToUse = org.talend.proxy.TalendProxySelector.getInstance().getProxyForUriString("https://zipcloud.ibsnet.co.jp/api/search?zipcode="+((String)globalMap.get("csvZipcode")));
        log.info("tHttpRequest_1 - Using proxy '" + proxyToUse);
    urlConn_tHttpRequest_1 = (java.net.HttpURLConnection) url_tHttpRequest_1.openConnection(proxyToUse); 
} else {
    urlConn_tHttpRequest_1 = (java.net.HttpURLConnection) url_tHttpRequest_1.openConnection();
}
        log.info("tHttpRequest_1 - Connection to '" +  "https://zipcloud.ibsnet.co.jp/api/search?zipcode="+((String)globalMap.get("csvZipcode")) + "' has succeeded.");
urlConn_tHttpRequest_1.setRequestMethod("GET");
urlConn_tHttpRequest_1.setDoOutput(true);
urlConn_tHttpRequest_1.setDoInput(true);
urlConn_tHttpRequest_1.setUseCaches(false);

boolean connected_tHttpRequest_1 = false;
int responseCode_tHttpRequest_1 = 0;
globalMap.put("tHttpRequest_1_CONNECTED", false);
try{
    urlConn_tHttpRequest_1.connect();
    connected_tHttpRequest_1 = true;
    globalMap.put("tHttpRequest_1_CONNECTED", true);

    byte[] buffer_tHttpRequest_1 = new byte[1024];
    int bos_buffer_tHttpRequest_1 = 0;

    responseCode_tHttpRequest_1 = urlConn_tHttpRequest_1.getResponseCode();
    globalMap.put("tHttpRequest_1_RESPONSE_CODE", responseCode_tHttpRequest_1);

    if ( responseCode_tHttpRequest_1 >= 200 && responseCode_tHttpRequest_1 < 300) { //Status code 2XX indicates success
        java.io.InputStream bis_tHttpRequest_1 = new java.io.BufferedInputStream(urlConn_tHttpRequest_1.getInputStream());
            java.io.OutputStream bosContent_tHttpRequest_1 = new java.io.BufferedOutputStream(new java.io.FileOutputStream("C:/Users/R01POCTC01ADMIN2/Desktop/work/after/In/R01_"+context.compcode+"_MMF0100_"+TalendDate.getDate("CCYYMMDDhhmmss")+".csv"));
        while ((bos_buffer_tHttpRequest_1 = bis_tHttpRequest_1.read(buffer_tHttpRequest_1)) != -1) {bosContent_tHttpRequest_1.write(buffer_tHttpRequest_1,0,bos_buffer_tHttpRequest_1); 
        }
            bosContent_tHttpRequest_1.flush();
            bosContent_tHttpRequest_1.close();
        bis_tHttpRequest_1.close();
    } else {
    	String responseMessage_tHttpRequest_1 = urlConn_tHttpRequest_1.getResponseMessage();
    
        //get details response information which will be used when error appear
        java.io.InputStream err_stream_tHttpRequest_1 = urlConn_tHttpRequest_1.getErrorStream();
        if(err_stream_tHttpRequest_1!=null) {
            java.io.InputStream es_tHttpRequest_1 = new java.io.BufferedInputStream(err_stream_tHttpRequest_1);
        	java.io.ByteArrayOutputStream baos_tHttpRequest_1 = new java.io.ByteArrayOutputStream();
        	
        	byte[] buf_tHttpRequest_1 = new byte[1024];
            int read_tHttpRequest_1 = -1;
        	try {
            	while ((read_tHttpRequest_1 = es_tHttpRequest_1.read(buf_tHttpRequest_1)) > 0) {
            		baos_tHttpRequest_1.write(buf_tHttpRequest_1, 0, read_tHttpRequest_1);
            	}
        	} finally {
        		es_tHttpRequest_1.close();
        	}
        
        	responseMessage_tHttpRequest_1 += ("\n" + new String(baos_tHttpRequest_1.toByteArray()));
        }
    	
            throw new RuntimeException("Request failed:" + responseCode_tHttpRequest_1 + " " + responseMessage_tHttpRequest_1);
    }

    log.info("tHttpRequest_1 - Closing the connection to the server.");
    urlConn_tHttpRequest_1.disconnect();
    log.info("tHttpRequest_1 - Connection to the server closed.");
}catch(Exception e){
globalMap.put("tHttpRequest_1_ERROR_MESSAGE",e.getMessage());
        throw e;
}

 


	tos_count_tHttpRequest_1++;

/**
 * [tHttpRequest_1 main ] stop
 */
	
	/**
	 * [tHttpRequest_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tHttpRequest_1";
	
	

 



/**
 * [tHttpRequest_1 process_data_begin ] stop
 */
	
	/**
	 * [tHttpRequest_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tHttpRequest_1";
	
	

 



/**
 * [tHttpRequest_1 process_data_end ] stop
 */



	
	/**
	 * [tSetGlobalVar_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tSetGlobalVar_1";
	
	

 



/**
 * [tSetGlobalVar_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";
	
	

 



/**
 * [tFileInputDelimited_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";
	
	


				nb_line_tFileInputDelimited_1++;
			}
			
			}finally{
    			if(!(filename_tFileInputDelimited_1 instanceof java.io.InputStream)){
    				if(csvReadertFileInputDelimited_1!=null){
    					csvReadertFileInputDelimited_1.close();
    				}
    			}
    			if(csvReadertFileInputDelimited_1!=null){
    				globalMap.put("tFileInputDelimited_1_NB_LINE",nb_line_tFileInputDelimited_1);
    			}
				
					log.info("tFileInputDelimited_1 - Retrieved records count: "+ nb_line_tFileInputDelimited_1 + ".");
				
			}
						  

 
                if(log.isDebugEnabled())
            log.debug("tFileInputDelimited_1 - "  + ("Done.") );

ok_Hash.put("tFileInputDelimited_1", true);
end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());




/**
 * [tFileInputDelimited_1 end ] stop
 */

	
	/**
	 * [tSetGlobalVar_1 end ] start
	 */

	

	
	
	currentComponent="tSetGlobalVar_1";
	
	

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tFileInputDelimited_1","tFileInputDelimited_1","tFileInputDelimited","tSetGlobalVar_1","tSetGlobalVar_1","tSetGlobalVar","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tSetGlobalVar_1 - "  + ("Done.") );

ok_Hash.put("tSetGlobalVar_1", true);
end_Hash.put("tSetGlobalVar_1", System.currentTimeMillis());




/**
 * [tSetGlobalVar_1 end ] stop
 */

	
	/**
	 * [tHttpRequest_1 end ] start
	 */

	

	
	
	currentComponent="tHttpRequest_1";
	
	

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tSetGlobalVar_1","tSetGlobalVar_1","tSetGlobalVar","tHttpRequest_1","tHttpRequest_1","tHttpRequest","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tHttpRequest_1 - "  + ("Done.") );

ok_Hash.put("tHttpRequest_1", true);
end_Hash.put("tHttpRequest_1", System.currentTimeMillis());




/**
 * [tHttpRequest_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";
	
	

 



/**
 * [tFileInputDelimited_1 finally ] stop
 */

	
	/**
	 * [tSetGlobalVar_1 finally ] start
	 */

	

	
	
	currentComponent="tSetGlobalVar_1";
	
	

 



/**
 * [tSetGlobalVar_1 finally ] stop
 */

	
	/**
	 * [tHttpRequest_1 finally ] start
	 */

	

	
	
	currentComponent="tHttpRequest_1";
	
	

 



/**
 * [tHttpRequest_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}
	


public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;


	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";
	
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final TestJob_WithVar TestJob_WithVarClass = new TestJob_WithVar();

        int exitCode = TestJob_WithVarClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'TestJob_WithVar' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
            	jobInfo.load(is);
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20240524_0800-patch"));
		
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'TestJob_WithVar' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_crVFcNJKEe-Pn5qOoIUlKQ");
                org.slf4j.MDC.put("_compiledAtTimestamp","2025-01-16T07:33:51.628369Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }
            org.slf4j.MDC.put("_fatherPid", fatherPid);

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }
            }

            // first load default key-value pairs from application.properties
            if(isStandaloneMS) {
                context.putAll(this.getDefaultProperties());
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = TestJob_WithVar.class.getClassLoader().getResourceAsStream("r01poctc01_test/testjob_withvar_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = TestJob_WithVar.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
    	                defaultProps.load(inContext);
    	                if (inOSGi && jobProperties != null) {
                             java.util.Enumeration<String> keys = jobProperties.keys();
                             while (keys.hasMoreElements()) {
                                 String propKey = keys.nextElement();
                                 if (defaultProps.containsKey(propKey)) {
                                     defaultProps.put(propKey, (String) jobProperties.get(propKey));
                                 }
                             }
    	                }
    	                context = new ContextProperties(defaultProps);
                    }
                    if(isStandaloneMS) {
                        // override context key-value pairs if provided using --context=contextName
                        defaultProps.load(inContext);
                        context.putAll(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }
            // override key-value pairs if provided via --config.location=file1.file2 OR --config.additional-location=file1,file2
            if(isStandaloneMS) {
                context.putAll(this.getAdditionalProperties());
            }
            
            // override key-value pairs if provide via command line like --key1=value1,--key2=value2
            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("zipcode", "id_String");
                        if(context.getStringValue("zipcode") == null) {
                            context.zipcode = null;
                        } else {
                            context.zipcode=(String) context.getProperty("zipcode");
                        }
                        context.setContextType("compcode", "id_String");
                        if(context.getStringValue("compcode") == null) {
                            context.compcode = null;
                        } else {
                            context.compcode=(String) context.getProperty("compcode");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("zipcode")) {
                context.zipcode = (String) parentContextMap.get("zipcode");
            }if (parentContextMap.containsKey("compcode")) {
                context.compcode = (String) parentContextMap.get("compcode");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'TestJob_WithVar' - Started.");
            java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFileInputDelimited_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : TestJob_WithVar");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'TestJob_WithVar' - Finished - status: " + status + " returnCode: " + returnCode );

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--context_file")) {
        	String keyValue = arg.substring(15);
        	String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
        	java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
            try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int index = -1;
                    if ( (index = line.indexOf('=')) > -1) {
							if (line.startsWith("--context_param")) {
								if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
									context_param.put(line.substring(16, index), routines.system.PasswordEncryptUtil.decryptPassword(
											line.substring(index + 1)));
								} else {
									context_param.put(line.substring(16, index), line.substring(index + 1));
								}
							}else {//--context_type
								context_param.setContextType(line.substring(15, index), line.substring(index + 1));
							}
                    }
                }
            } catch (java.io.IOException e) {
            	System.err.println("Could not load the context file: " + filePath);
                e.printStackTrace();
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     85735 characters generated by Talend Cloud Data Fabric 
 *     on the 2025年1月16日 16:33:51 JST
 ************************************************************************************************/