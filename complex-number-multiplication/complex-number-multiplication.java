class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNum n1 = toComplex(num1);
        ComplexNum n2 = toComplex(num2);
        
        int real = 0, imag = 0;
        real+=n1.real*n2.real;
        real-=n1.imag*n2.imag;
        imag+=n1.real*n2.imag+n1.imag*n2.real;
        
        StringBuilder sb = new StringBuilder();
        sb.append(real+"+");
        sb.append(imag+"i");
        
        return sb.toString();
        
    }
    
    private ComplexNum toComplex(String num) {
        num = num.replaceAll("i","");
        String[] tmp = num.split("\\+");
        
        return new ComplexNum(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
    }
    
    public class ComplexNum {
        int real;
        int imag;
        
        public ComplexNum(int real, int imag) {
            this.real = real;
            this.imag = imag;
        }
    }
}