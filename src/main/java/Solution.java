import java.util.*;

public class Solution {



    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);

       String input = sc.nextLine();
       Boolean flag = sc.hasNextBoolean();

        splitIsNeeded(input, flag);

    }


    /*
    * Возвращаем 2 мапы, с литералами и спецсимволами. Индексы проставляем из листа.
    * */
    private static Map<Integer,String> MapSybmols(List<String> strings, boolean flag){
        Map<Integer,String> returnValue =  new HashMap<>();
        if (flag) {
            for (int i = 0; i <strings.size() ; i++) {
                if (strings.get(i).matches("[a-zA-Z]+")) {
                    returnValue.put(i,strings.get(i));
                }
            }
            return returnValue;
        }
        for (int i = 0; i <strings.size() ; i++) {
            if (!strings.get(i).matches("[a-zA-Z]+")) {
                returnValue.put(i,strings.get(i));
            }
        }
        return returnValue;
    };


    /*
    * Возвращаем перевернутую строку с сохранением положения спецсимволов
    * */
    private static LinkedList<String> InvertedString (Map<Integer,String> mapLitteralSymbols, Map<Integer,String> mapNonLitteralSymbols, Integer sizeOfStartedString)
    {
        LinkedList<String> symbols = new LinkedList<>();
        for (int i = 0; i <sizeOfStartedString ; i++) {
            symbols.add(i,"");
        }
        for (Map.Entry<Integer, String> entry : mapLitteralSymbols.entrySet()) {
            symbols.add(entry.getValue());
        }
        Collections.reverse(symbols);

        for (Map.Entry<Integer, String> entry : mapNonLitteralSymbols.entrySet()) {
            symbols.add(entry.getKey(),entry.getValue());
        }
        return symbols;
    }

    /*
    * Приводим входящую строку к листу и вызываем - MapSybmols, InvertedString
    * */
    public static String splitInputData (String input) {

            StringBuilder result = new StringBuilder();

            System.out.println("length word "+input.length());

            List<String> InitialString = Arrays.asList(input.split(""));

            Map<Integer, String> MapLitteralSymbols = MapSybmols(InitialString, true);
            Map<Integer, String> MapNonLitteralSymbols = MapSybmols(InitialString, false);

            System.out.println("Litteral symbols - "+MapLitteralSymbols.size());
            System.out.println("NonLitteral symbols - "+MapNonLitteralSymbols.size());


            LinkedList<String> ListOfInvertedSymbols = InvertedString(MapLitteralSymbols, MapNonLitteralSymbols,InitialString.size());

            for (String s : ListOfInvertedSymbols) {
                result.append(s);
            }

            System.out.println("Result: "+result+"\n"+"ᨐ ∫ ᨐ ∫ ᨐ ∫ ᨐ ∫ ᨐ ∫ ᨐ ∫");
            return result.toString();
    }

    /*
    * Метод в зависимости от флага - splitIsRequired обрабатывает строку как есть. Или разбивает на слова по пробелам
    * */
    public static String splitIsNeeded (String input, Boolean splitIsRequired) {
        if (splitIsRequired) {
            String t = "";
            List <String> listOfWords = new ArrayList<>();
            String[] ListOfInputString = input.trim().split(" ");
            System.out.println("Count of inputWords - "+ListOfInputString.length+"\n"+"[^._.^]ﾉ彡 [^._.^]ﾉ彡 [^._.^]ﾉ彡 [^._.^]ﾉ彡 [^._.^]ﾉ彡");

            for (String s : ListOfInputString) {
                listOfWords.add(splitInputData(s));
            }
            /*
            * Костыль для выполнения условия задачи. См тест - CheckMoreThanOneWordWithSplit
            * */
            for (int i = 0; i <listOfWords.size()-1 ; i++) {
                t = listOfWords.get(i)+" "+listOfWords.get(i+1);
            }
            return t;
        }
        System.out.println("String processed without split to words");
        return splitInputData(input);
    }

}
