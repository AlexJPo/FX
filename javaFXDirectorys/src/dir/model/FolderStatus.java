package dir.model;

import java.io.File;

public class FolderStatus {
	private int foldersCount, filesCount;
	
	public FolderStatus() {
		this.foldersCount = 0;
		this.filesCount = 0;
	}
	
	/**
	 * Count files and folder in current directory
	 * @param File[] files
	 */
	public void Count(File[] files) {
		foldersCount = 0;
		filesCount = 0;
		
		for (File file: files) {
			if (file.isDirectory()) {
				foldersCount++;
			} else {
				filesCount++;				
			}
		}
	}

	/**
	 * Get 'status' text
	 * @return String 'status' 
	 */
	public String getStatus() {
		return "Total folders: " + foldersCount + ", Total files: " + filesCount;
	}
}
