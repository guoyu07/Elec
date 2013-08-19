/**
 * 
 */
package com.gs.action;

import java.io.File;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author GaoShen
 * @packageName com.gs.action
 */
@Component("uploadAction")
@Scope("prototype")
public class UploadAction extends ActionSupport {
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savaPath;
	/**
	 * @return the savaPath
	 */
	public String getSavaPath() {
		return savaPath;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		
		return SUCCESS;
	}

	/**
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadContentType
	 */
	public String getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @param savaPath the savaPath to set
	 */
	public void setSavaPath(String savaPath) {
		this.savaPath = savaPath;
	}
}
