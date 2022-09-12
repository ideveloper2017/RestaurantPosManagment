package uz.namangan.rest.controllers;


import javafx.stage.Stage;
import uz.namangan.rest.MainApplication;
import uz.namangan.rest.util.I18N;

import java.util.HashMap;

public abstract class BaseController {
	
	protected Stage stage;
	protected I18N i18N;
	
	public <T> void init(Stage stage, HashMap<String, T> parameters) {
		this.stage = stage;
		this.i18N = MainApplication.i18n;
		
		this.stage.setOnHiding(e -> { onClose(); });
		this.stage.setOnHidden(e -> { onClose(); });
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public I18N getI18N() {
		return i18N;
	}
	
	public String getWindowTitle(String titleKey) {
		return MainApplication.i18n.getString(titleKey);
	}
	
	protected abstract void onClose();
}
