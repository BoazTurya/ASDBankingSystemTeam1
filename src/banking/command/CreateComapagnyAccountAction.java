package banking.command;

import miu.edu.cs.cs525.final_project.framework.command.CreateAccountTemplate;
import miu.edu.cs.cs525.final_project.framework.model.Address;

public class CreateComapagnyAccountAction extends CreateAccountTemplate {

    @Override
    public void createPersoanlAccount() {



    }

    @Override
    public void createCompagnyAccount() {
        //Todo

    }

    @Override
    public Address createAddress(String state, String city, String zip) {
        return null;
    }
}
