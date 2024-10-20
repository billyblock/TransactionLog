import banking.Account;
import banking.Transaction;
import javafx.application.Application;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private ListView<Transaction> listView;
    private Text text;
    private Account checkingAccount;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

        public void start(Stage aStage) throws Exception{
            checkingAccount = new Account("checking_transactions.csv");
            HBox parent = new HBox();
            Scene aScene = new Scene(parent, 300, 400);
            buildExploreView(parent);
            aStage.setScene(aScene);
            aStage.setTitle("Checkbook");
            aStage.show();
        }
        public void buildExploreView(HBox parent){
            VBox column = new VBox();
            buildListView(column);
            buildText(column);
            parent.getChildren().add(column);
        }
        public void buildListView(VBox root){
            listView = new ListView<Transaction>(checkingAccount.getTransactions());
            SelectionModel<Transaction> selectionModel = listView.getSelectionModel();
            selectionModel.selectedItemProperty().addListener((newValue)->showDescription());
            root.getChildren().add(listView);
        }
        public void buildText(VBox root){
            VBox column = new VBox();
            text = new Text();
            column.getChildren().add(text);
            root.getChildren().add(column);
        }
        public void showDescription(){
            SelectionModel<Transaction> selectionModel = listView.getSelectionModel();
            Transaction aTransaction = selectionModel.getSelectedItem();
            text.setText(aTransaction.detailString());
        }
    } 

