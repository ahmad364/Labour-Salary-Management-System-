package controler;
// this is an interface class
public interface ask_about_worker_information_from_user
{
    // the method of interface class which will be called in the mainclass
    public String ask_name_from_user();  // will ask the name and the return
    public String ask_father_name_from_user();  // will ask the father name and the return 
    public String ask_phone_number_from_user();  // will ask the phone number and then return it
    public int ask_waging_of_worker_from_user();  // will ask the waging and then return it
}