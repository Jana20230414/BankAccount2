public enum MenuActions {
    
    CREATE_ACCOUNT(1), DELETE_ACCOUNT(2), BALANCE_ACCOUNT(3), ACCEPT_MONEY(4), WITHDRAWAL(5), TRANSFER_MONEY(6), END_PROGRAM(7), Invalid(100);

    private Integer enumValue;

    private MenuActions (Integer value){
        this.enumValue = value;
    }
    
    public Integer getValue(){
        return enumValue;
    }

    public String getNameString(String actionInput){
        return name();
    }

    public static MenuActions findNameByValue(Integer actionInput) {
        MenuActions result = Invalid;
        for (MenuActions checkAction : values()) {
            if (checkAction.enumValue == actionInput) {
                result = checkAction;
                break;
            }
        }
        return result;
    }
 

}
