package dir.model;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Folders {
	private ObservableList<String> modelFolderList = FXCollections.observableArrayList();
	
	public Folders() {
		
	}

	/**
	 * Set 'modelFolderList' data
	 */
	public void setFoldersModel(File[] files) {
		modelFolderList.clear();
		
		for (File folder: files) {
			if (folder.isDirectory()) {
				modelFolderList.add(folder.getName());
			}
		}
	}
	
	/**
	 * Return model 'modelFolderList'
	 * @return ObservableList<String> modelFolderList
	 */
	public ObservableList<String> getFoldersModel() {
		return this.modelFolderList;
	}
}
