package dir.controller;

import java.io.File;

import dir.model.BreadCrumb;
import dir.model.FolderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class DirectoryExplorer {
	private ObservableList<String> modelDiskList = FXCollections.observableArrayList();
	private ObservableList<String> modelFolderList = FXCollections.observableArrayList();
	
	private String folderPath;
	private String selectedItem;
	
	private FolderStatus folderStatus;
	private BreadCrumb pathFolder;
	
	@FXML
	private ListView<String> breadCrumb;
	@FXML
	private ListView<String> diskList;
	@FXML
	private ListView<String> folderList;
	@FXML
	private Label statusFolder;

	@FXML
	private void initialize() {
		folderStatus = new FolderStatus();
		pathFolder = new BreadCrumb();
		
		setDiskList();		
	}

	/**
	 * Add drivers system to 'diskList'
	 */
	private void setDiskList() {
		File[] drivers = File.listRoots();
		
		for (File disk: drivers) {
			modelDiskList.add(disk.toString());
		}
		
		diskList.setItems(modelDiskList);
	}
	
	/**
	 * MouseEvent for ListView 'diskList'. Set data 'folderList'
	 */
	public void setDiskFolders(MouseEvent event) {
		ListView<String> result = (ListView<String>) event.getSource();
		
		selectedItem = result.getSelectionModel().getSelectedItem();
		folderPath = selectedItem + "\\";
		
		File folder = new File(selectedItem);
		File[] folders = folder.listFiles();
				
		folderStatus.Count(folders);
		statusFolder.setText(folderStatus.getStatus());
		
		setFoldersList(folders);
		
		pathFolder.setCrumb(folder.getAbsolutePath());
		breadCrumb.setItems(pathFolder.getCrumb());
	}
	
	/**
	 * Add folders to 'folderList'
	 * @param File[] files - list of disk folders 
	 */
	private void setFoldersList(File[] files) {
		modelFolderList.clear();
		
		for (File folder: files) {
			if (folder.isDirectory()) {
				modelFolderList.add(folder.getName());
			}
		}
		
		folderList.setItems(modelFolderList);
	}
	
	public void enterFolder(MouseEvent event) {
		if (event.getClickCount() == 2) {
			ListView<String> result = (ListView<String>) event.getSource();
			
			selectedItem = result.getSelectionModel().getSelectedItem();
			folderPath += selectedItem + "\\";
			
			File folder = new File(folderPath);
			File[] folders = folder.listFiles();
			
			folderStatus.Count(folders);
			statusFolder.setText(folderStatus.getStatus());
			
			pathFolder.setCrumb(folder.getAbsolutePath());
			breadCrumb.setItems(pathFolder.getCrumb());
			
			setFoldersList(folders);
		}		
	}
	
	public void exitFolder(MouseEvent event) {
		if (event.getClickCount() == 2) {
			ListView<String> result = (ListView<String>) event.getSource();
			int selectedCrumb = result.getSelectionModel().getSelectedIndex();
			
			pathFolder.updateCrumb(selectedCrumb);
			breadCrumb.setItems(pathFolder.getCrumb());
			
			File folder = new File(pathFolder.getBreadCrumbPath());
			File[] folders = folder.listFiles();
			
			folderStatus.Count(folders);
			statusFolder.setText(folderStatus.getStatus());
			
			setFoldersList(folders);			
		}
	}
}
