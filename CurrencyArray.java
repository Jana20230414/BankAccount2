public enum CurrencyArray {
    
    Invalid(0.0), CZK(1.0),EUR(25.0), USD(22.2), GBP(26.9), PLN(5.2);
    
    private Double enumValue;
    
    private CurrencyArray (Double value){
        this.enumValue = value;
    }
    
    public Double getValue(){
        return enumValue;
    }
  
    public static CurrencyArray findByName(String nameOfCurrency) {
        CurrencyArray result = Invalid;
        nameOfCurrency = nameOfCurrency.toUpperCase();
        for (CurrencyArray checkCurrency : values()) {
            if (checkCurrency.name().equalsIgnoreCase(nameOfCurrency)) {
                result = checkCurrency;
                break;
            }
        }
        return result;
    }
 
}

