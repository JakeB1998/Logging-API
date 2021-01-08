/**
 * File Name: LogHeader.java
 * Programmer: Jake Botka
 * Date Created: Jan 4, 2021
 *
 */
package main.org.botka.logger.log;

import main.org.botka.logger.log.logtype.LogType;

/**'Header of a log. Ussualy defining variables such as time.
 * @author Jake Botka
 *
 */
public class LogHeader {
	private boolean mErrors, mLogNulls;
	private String mFormattedHeader;
	private LogTime mLogTime;
	private LogType mLogType;
	private LogTag mLogTag;
	
	
	/**
	 * Default constructor.
	 */
	public LogHeader() {
		mFormattedHeader = null;
		mLogTag = null;
		mLogTime = null;
		mLogType = null;
	}
	
	/**
	 * Formats headers.
	 * @return Formatted header as a string
	 */
	private String formatHeader() {
		if (!mErrors) {
			StringBuilder strBuilder = new StringBuilder();
			boolean firstFlag = true;
			strBuilder.append("[");
			String holder = null;
			if (mLogTime != null) {
				holder = mLogTime.getTimeStamp();
				if (holder != null || mLogNulls) {
					firstFlag = handleFirstFlag(firstFlag, strBuilder);
					strBuilder.append( String.valueOf(holder));
				}
			}
			if (mLogType != null) {
				holder = mLogType.getLogTypeString();
				if (holder != null || mLogNulls) {
					firstFlag = handleFirstFlag(firstFlag, strBuilder);
					strBuilder.append( "Log Type:" + String.valueOf(holder)); 
				}
			}
			
			if (mLogTag != null) {
				holder = mLogTag.getLogTag();
				if (holder != null || mLogNulls) {
					firstFlag = handleFirstFlag(firstFlag, strBuilder);
					strBuilder.append("Log Tage: " +  String.valueOf(holder));
				}
			}
			strBuilder.append("]");
			System.out.println(strBuilder.toString());
			return strBuilder.toString();
		}
		return null;
	}
	
	private boolean handleFirstFlag(boolean firstFlag, StringBuilder strBuilder) {
		if (firstFlag) {
			firstFlag = false;
		} else {
			strBuilder.append(" ");
		}
		return firstFlag;
	}
	
	/**
	 * 
	 * @return Logtime object.
	 */
	public LogTime getLogTime() {
		return mLogTime;
	}
	
	/**
	 * 
	 * @param logTime
	 */
	public void setLogTIme(LogTime logTime) {
		if (logTime != null && mLogTime != null) {
			if (!mLogTime.equals(logTime)) {
				mFormattedHeader = formatHeader();
			}
		}
		mLogTime = logTime;
	}
	
	/**
	 * 
	 * @return Logtype object.
	 */
	public LogType getLogType() {
		return mLogType;
	}
	
	/**
	 * Gets the header as a formatted string.
	 * @return Formated header.
	 */
	public String getFormattedHeader() {
		if (mFormattedHeader == null) {
			mFormattedHeader = formatHeader();
		}
		return  mFormattedHeader;
	}
	
	/**
	 * 
	 * @param logType
	 */
	public void setLogType(LogType logType) {
		if (logType != null && mLogTime != null) {
			if (!mLogType.equals(logType)) {
				mFormattedHeader = formatHeader();
			}
		}
		mLogType = logType;
	}
	
	//Add log tag getters and setters.

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "LogHeader [mLogTime=" + mLogTime + ", mLogType=" + mLogType + "]";
	}
	
	
}
