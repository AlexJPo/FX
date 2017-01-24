package dir.model;

import java.io.File;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BreadCrumb {
	private ObservableList<String> modelBreadCrumbList;
	private String folderPath;
	private final String separator = Pattern.quote(File.separator);
	
	public BreadCrumb() {
		folderPath = "";
		modelBreadCrumbList = FXCollections.observableArrayList();
	}
	
	/**
	 * Set data for 'modelBreadCrumbList'
	 * @param String folderPath 
	 */
	public void setCrumb(String folderPath) {
		if (modelBreadCrumbList.size() > 0) { modelBreadCrumbList.clear(); }
				
		this.folderPath = folderPath;
		
		for (String item: folderPath.split(separator)) {
			this.modelBreadCrumbList.add(item + "   >");
		}
	}
	
	/**
	 * Return model 'modelBreadCrumbList'
	 * @return ObservableList<String> 'modelBreadCrumbList'
	 */
	public ObservableList<String> getCrumb() {
		return this.modelBreadCrumbList;
	}
	
	/**
	 * Update 'modelBreadCrumbList'
	 * @param int selectedIndex
	 */
	public void updateCrumb(int selectedIndex) {
		if (this.modelBreadCrumbList.size() > 0) {
			this.modelBreadCrumbList.remove(selectedIndex+1, modelBreadCrumbList.size());
			updatePathFolder();
		}
	}
	
	/**
	 * Update 'folderPath' after backward to parent directory
	 */
	private void updatePathFolder() {
		this.folderPath = "";
		
		for (int i = 0; i < modelBreadCrumbList.size(); i++) {
			this.folderPath += modelBreadCrumbList.get(i).replace("   >", "\\").trim();
		}
	}
	
	/**
	 * Return bread crumb folder path for current directory
	 * @return String 'folderPath'
	 */
	public String getBreadCrumbPath() {
		return this.folderPath;
	}
}
