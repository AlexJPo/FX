package dir.controller;

import java.io.File;

import dir.model.BreadCrumb;
import dir.model.Drivers;
import dir.model.FolderStatus;
import dir.model.Folders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class DirectoryExplorer {
		
	private String folderPath;
	private String selectedItem;
	
	private FolderStatus folderStatus;
	private BreadCrumb breadcrumb;
	private Drivers drivers;
	private Folders foldersModel;
	
	private File folder;
	private File[] folders;
	
	@FXML
	private ListView<String> breadCrumbList;
	@FXML
	private ListView<String> diskList;
	@FXML
	private ListView<String> folderList;
	@FXML
	private Label statusFolderLabel;

	@FXML
	private void initialize() {
		drivers = new Drivers();
		breadcrumb = new BreadCrumb();
		foldersModel = new Folders();
		folderStatus = new FolderStatus();
		
		setDriversList();		
	}

	/**
	 * Add drivers system to 'diskList'
	 */
	private void setDriversList() {
		drivers.setDriversModel();
		diskList.setItems(drivers.getDriversModel());
	}
	
	/**
	 * MouseEvent for ListView 'diskList'. Set data 'folderList'
	 */
	public void setDiskFolders(MouseEvent event) {
		ListView<String> result = (ListView<String>) event.getSource();		
		selectedItem = result.getSelectionModel().getSelectedItem();
		
		if (selectedItem != null) {			
			folderPath = selectedItem + File.separator;
			
			folder = new File(selectedItem);
			folders = folder.listFiles();
					
			folderStatus.Count(folders);
			statusFolderLabel.setText(folderStatus.getStatus());
				
			setFoldersList(folders);
				
			breadcrumb.setCrumb(folder.getAbsolutePath());
			breadCrumbList.setItems(breadcrumb.getCrumb());
		}
	}
	
	/**
	 * Add folders to 'folderList'
	 * @param File[] files - list of disk folders 
	 */
	private void setFoldersList(File[] files) {
		foldersModel.setFoldersModel(files);
		folderList.setItems(foldersModel.getFoldersModel());
	}
	
	/**
	 * Open children folder in current parent directory
	 */
	public void enterFolder(MouseEvent event) {
		if (event.getClickCount() == 2) {
			ListView<String> result = (ListView<String>) event.getSource();
			selectedItem = result.getSelectionModel().getSelectedItem();
			
			if (selectedItem != null) {
				folderPath = breadcrumb.getBreadCrumbPath() + File.separator + selectedItem + File.separator;
				
				folder = new File(folderPath);
				folders = folder.listFiles();
				
				if (folders != null) {
					folderStatus.Count(folders);
					statusFolderLabel.setText(folderStatus.getStatus());
					
					breadcrumb.setCrumb(folder.getAbsolutePath());
					breadCrumbList.setItems(breadcrumb.getCrumb());
					
					setFoldersList(folders);
				}
			}
		}		
	}
	
	/**
	 * Exit children folder by click on bread crumb item
	 */
	public void exitFolder(MouseEvent event) {
		if (event.getClickCount() == 2) {
			ListView<String> result = (ListView<String>) event.getSource();
			int selectedCrumb = result.getSelectionModel().getSelectedIndex();
			
			if (selectedCrumb != -1) {
				breadcrumb.updateCrumb(selectedCrumb);
				breadCrumbList.setItems(breadcrumb.getCrumb());
				
				folder = new File(breadcrumb.getBreadCrumbPath());
				folders = folder.listFiles();
				
				folderStatus.Count(folders);
				statusFolderLabel.setText(folderStatus.getStatus());
				
				setFoldersList(folders);
			}			
		}
	}
}
