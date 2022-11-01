package startAtGoogle.CommonMethods.exercies;

import java.util.Objects;

public class PhoneNumber implements Comparable<PhoneNumber>  {
    String areaCode;
    int number;
    Generator g = new Generator();

    public PhoneNumber() {
        areaCode = g.getAreaCode();
        number = g.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return areaCode == phoneNumber.areaCode && Objects.equals(number, phoneNumber.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }

    @Override
    public String toString() {
        return (areaCode+"-"+number);
    }

    public PhoneNumber(PhoneNumber phoneNumber){
        String areaCode2 = "";
        int number2 = 0;
        areaCode2 = phoneNumber.areaCode;
        number2 = phoneNumber.number;
        areaCode = areaCode2;
        number = number2;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        int res = -1;
        if(this.areaCode.equals(o.areaCode)){
            if(Integer.compare(this.number,o.number) == 0){
                res = 0;
            }
        }
        return res;
    }
}
