package dir.model;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Drivers {
	private ObservableList<String> modelDiskList = FXCollections.observableArrayList();
	
	public Drivers() {
		
	}
	
	/**
	 * Set 'modelDiskList' data
	 */
	public void setDriversModel() {
		File[] drivers = File.listRoots();
		
		for (File disk: drivers) {
			modelDiskList.add(disk.toString());
		}
	}
	
	/**
	 * Return model 'modelDiskList'
	 * @return ObservableList<String> modelDiskList
	 */
	public ObservableList<String> getDriversModel() {
		return this.modelDiskList;
	}
}
