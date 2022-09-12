package uz.namangan.rest.controllers;

import uz.namangan.rest.util.WindowsUtils;

public class DashboardController  extends BaseController {

    public static final String PATH_FXML = "/fxml/dashboard.fxml";
    public static final String DASHBOARD_TITLE_KEY = "dashboard.title";
    public static final String PATH_ICON = WindowsUtils.ICON_APP_PATH;

    @Override
    protected void onClose() {

    }
}
