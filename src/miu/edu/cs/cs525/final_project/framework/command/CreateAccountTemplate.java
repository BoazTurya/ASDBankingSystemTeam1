package miu.edu.cs.cs525.final_project.framework.command;

import miu.edu.cs.cs525.final_project.framework.command.Command;
import miu.edu.cs.cs525.final_project.framework.model.Address;

public   abstract  class CreateAccountTemplate implements Command {
    String  zip;
    String state;
    String city;

    public abstract void createPersoanlAccount();
    public abstract void createCompagnyAccount();
    public abstract Address createAddress(String state ,String city,String zip);




    @Override
    public void execute() {
       Address address= createAddress(state,city,zip);

        if (isCompagny()){
            createCompagnyAccount();
        }
        else {
            createPersoanlAccount();
        }

    }

    @Override
    public void unexecute() {

    }
    //hook method
    public boolean isCompagny(){
        return true;
    }
}
