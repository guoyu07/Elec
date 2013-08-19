/**
 * 
 */
package com.gs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;
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
		return ServletActionContext.getRequest().getRealPath("\\save");
		//return "/save";
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		try {
			String fileName = getSavaPath()+"\\"+getUploadFileName();
			FileOutputStream fos = new FileOutputStream(fileName);
			FileInputStream fis = new FileInputStream(getUpload());
			byte[] b = new byte[1024];
			int len = 0;
			while((len=fis.read(b))>0){
				fos.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
