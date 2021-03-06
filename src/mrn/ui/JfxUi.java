package mrn.ui;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mrn.data.Model;
import mrn.ui.base.Window;

import mrn.ui.controlbar.ViewControlBar;
import mrn.ui.graphstatuspanel.ViewGraphStatus;
import mrn.ui.graphvisual.ViewGraphVisual;
import mrn.ui.menubar.ViewMenubar;
import mrn.ui.spantree.ViewSpanTree;

public class JfxUi {
    public JfxUi(Stage mainstage) {
        /* Init your model(s) */
        Model data = new Model();


        /* Init a window */
        Window<GridPane> mainwindow = new Window<>(mainstage);
        mainwindow.setLayout(new GridPane());
        mainstage.setTitle("Depth First Search Visualization");
        GridPane wndw_layout = mainwindow.getLayout();
        wndw_layout.setGridLinesVisible(false);
        wndw_layout.setHgap(5);
        wndw_layout.setVgap(5);

        /* Init Views and add them to the window layout */
        ViewMenubar menu = new ViewMenubar(data);
        wndw_layout.add(menu.getRoot(), 0, 0, 3, 1);
        menu.getRoot().prefWidthProperty().bind(mainstage.widthProperty());

        ViewControlBar ctrlBar = new ViewControlBar(data);
        wndw_layout.add(ctrlBar.getRoot(), 0, 1, 2, 1);
      //  ctrlBar.getRoot().prefWidthProperty().bind(mainstage.widthProperty());

        ViewGraphStatus graphStatus = new ViewGraphStatus(data);
        wndw_layout.add(graphStatus.getRoot(), 0, 2);

        ViewGraphVisual graphVisual = new ViewGraphVisual(data);
        wndw_layout.add(graphVisual.getRoot(), 1, 2);

        ViewSpanTree spanTree = new ViewSpanTree(data);
        wndw_layout.add(spanTree.getRoot(), 2, 2);

        /* add the window to the stage */
        mainwindow.getStage().setScene(new Scene(mainwindow.getLayout(), 1400, 900));
        mainwindow.getStage().show();

    }
}
