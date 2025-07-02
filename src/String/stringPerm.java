package String;

public class stringPerm {

    public static void main(String[] args) {
        String s="aba";

        System.out.println(help(s,"",s.length()));;
    }

    private static int help(String s, String ans,int n) {
       if (s.isEmpty()){
           System.out.println(ans+" ");
           return 1;
       }
       int a=0;
        for (int i = 0; i <s.length() ; i++) {
            boolean check=false;
            for (int j = i+1; j <s.length() ; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    check=true;
                }
            }
            if (!check){
                a+=help(s.substring(0,i)+s.substring(i+1),ans+s.charAt(i),n);

            }
        }
        return a;
    }
}
