import com.foodiecliapp.repository.CustomerRepository;
import com.foodiecliapp.ui.Menu;
import com.foodiecliapp.util.CsvReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*CustomerRepository customerRepository = new CustomerRepository();
        System.out.println(customerRepository.getAllCustomers());*/
        Menu menu = new Menu();
        menu.displayMainMenu();
    }
}