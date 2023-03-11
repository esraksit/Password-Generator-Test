



public interface GeneratorInterface {

    public void mainLoop(String userOption);
  //  public Password GeneratePassword(int length);
    public void printUsefulInfo() ;
    public void requestPassword() ;
    public boolean isInclude(String Input);
    public String PasswordRequestError();
    public String checkPassword(String input);
    public void printMenu();
    public String printQuitMessage();
}
