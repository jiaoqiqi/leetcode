import java.io.*;

public class WordAnalyse {
    private char[] strbuf = new char[150];
    private int keyWordIndex;
    private String[] keyWord = {"and","begin","const","div","do","else","end",
            "function","if","integer","not","or","procedure",
            "program", "read","real","then","type","var","while","write"};
    public static void main(String []args) throws IOException {
        WordAnalyse wa = new WordAnalyse();
        wa.readFile("a.txt");
        System.out.println("Pascal语言的词法分析器");
        System.out.println("******The Result:******"+"\n");
        wa.run();
        System.out.println("\n"+"******Complete !******");

    }

    private void readFile(String url) throws IOException {
        int ch;
        int i=0;
        FileReader fr = new FileReader(url);
        while ((ch = fr.read())!= -1){
            strbuf[i++] = (char)ch;
        }
    }

    private boolean isLetter(char ch){
        if('a'<=ch && 'z'>=ch || 'A'<=ch && ch<='Z'){
            return true;
        }
        return false;
    }

    private boolean isDigit(char ch){
        if('0'<=ch && ch<='9'){
            return true;
        }
        return false;
    }

    private void run(){
        StringBuffer buf = new StringBuffer();
        for (int i=0 ; i<strbuf.length ; i++){
            if(strbuf[i]==' ' || strbuf[i] == '\t' || strbuf[i] == '\n'){
                i++;
            }
            if(isLetter(strbuf[i])){
                int k;
                buf.delete(0,buf.length());
                while(isLetter(strbuf[i]) || isDigit(strbuf[i])) {
                    buf.append(strbuf[i]);
                    i++;
                }
                i--;

                for (k=0 ; k<keyWord.length ; k++){
                    if (new String(buf).equals(keyWord[k])){
                        keyWordIndex = k;
                        System.out.println(buf + "\t\t" + keyWordIndex);
                        break;
                    }
                }
                if (k>20){
                    System.out.println(buf + "\t\t" + 21);
                }
            }

            if (isDigit(strbuf[i])){
                buf.delete(0,buf.length());
                while (isDigit(strbuf[i])){
                    buf.append(strbuf[i]);
                    i++;
                }
                i--;
                System.out.println(buf + "\t\t" + 22);
            }

            switch ((char)strbuf[i]){
                case',':System.out.println(strbuf[i] + "\t\t" + 23);break;
                case';':System.out.println(strbuf[i] + "\t\t" + 24);break;
                case'.':System.out.println(strbuf[i] + "\t\t" + 26);break;
                case'(':System.out.println(strbuf[i] + "\t\t" + 27);break;
                case')':System.out.println(strbuf[i] + "\t\t" + 28);break;
                case'[':System.out.println(strbuf[i] + "\t\t" + 29);break;
                case']':System.out.println(strbuf[i] + "\t\t" + 30);break;
                case'+':System.out.println(strbuf[i] + "\t\t" + 34);break;
                case'-':System.out.println(strbuf[i] + "\t\t" + 35);break;
                case'=':System.out.println(strbuf[i] + "\t\t" + 38);break;
                case':': {
                    buf.delete(0, buf.length());
                    buf.append(strbuf[i]);
                    i++;
                    if (strbuf[i] == '=') {
                        buf.append(strbuf[i]);
                        System.out.println(buf + "\t\t" + 44);
                    } else {
                        System.out.println(buf + "\t\t" + 25);
                        i++;
                    }
                };break;
                case '>': {
                    buf.delete(0, buf.length());
                    buf.append(strbuf[i]);
                    i++;
                    if (strbuf[i] == '=') {
                        buf.append(strbuf[i]);
                        System.out.println(buf + "\t\t" + 43);
                    } else {
                        System.out.println(buf + "\t\t" + 40);
                        i--;
                    }

                };break;
                case '<':{
                    buf.delete(0, buf.length());
                    buf.append(strbuf[i]);
                    i++;
                    if (strbuf[i] == '=') {
                        buf.append(strbuf[i]);
                        System.out.println(buf + "\t\t" + 42);
                    }
                    if (strbuf[i] == '>'){
                        buf.append(strbuf[i]);
                        System.out.println(buf + "\t\t" + 41);

                    }
                    else {
                        System.out.println(buf + "\t\t" + 39);
                        i--;
                    }
                }
            }
        }
    }
}
